package com.NPCOverheadDialogue;

import com.google.inject.Provides;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@PluginDescriptor(
        name = "NPC Overhead Dialog"
)
public class NPCOverheadDialoguePlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private NPCOverheadDialogueConfig config;

    private Actor actor;
    private String lastNPCText = "";
    private String lastPlayerText = "";
    private ArrayList<NPCWithTicks> NPCList = new ArrayList<>();


    @Override
    protected void startUp() throws Exception {
        log.info("Example started!");
    }

    @Override
    protected void shutDown() throws Exception {
        log.info("Example stopped!");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
        }

    }

    @Provides
    NPCOverheadDialogueConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(NPCOverheadDialogueConfig.class);
    }

    @Subscribe
    public void onHitsplatApplied(HitsplatApplied event) {
        System.out.println(event.getActor().getName());
        ambientNPCText(event.getActor(), "Rat", "hiss");
        ambientNPCText(event.getActor(), "Giant rat", "I am a giant rat");
    }

    /*
    @Subscribe
    public void onAnimationChanged(AnimationChanged animationChanged) {
    	log.info("animation changed for: " + animationChanged.getActor().getName());
        if (animationChanged!= null && animationChanged.getActor().getName().equals("Reldo")) {
            ambientNPCText(animationChanged.getActor(), "Reldo", "I am a librarian look at me walk");
        }
    }
     */

    //for ambient text or hitsplat text
    public void ambientNPCText(Actor actor, String npcName, String dialogue) {
        if (actor != null && Objects.equals(actor.getName(), npcName)) {
            actor.setOverheadText(dialogue);
            log.info(dialogue);
        }
    }

    public void npcWalkingTextInvoker(){
        //For when NPCs are moving
        List<NPC> localNPCs = client.getNpcs();
        for (NPC localNPC : localNPCs)
        {
            npcWalkingText(localNPC, "Reldo", "I am a librarian");
            npcWalkingText(localNPC, "Cleaner", "*Sweep* *Sweep*");
        }
    }

    //for walking text
    public void npcWalkingText(NPC npc, String npcName, String dialogue){
        if (npc != null && Objects.equals(npc.getName(), npcName)) {
            WorldPoint npcPos = npc.getWorldLocation();
            boolean npcExists = false;
            int npcIndex = 0;
            int currentTick = client.getTickCount();
            if (NPCList.size() > 0) {
                for (NPCWithTicks n : NPCList) {
                    if (n.getNPCName().equals(npc.getName())) {
                        npcExists = true;
                        break;
                    }
                    npcIndex++;
                }
            }

            if (!npcExists) {
                NPCList.add(new NPCWithTicks(npc.getName(), currentTick, npcPos.getX(), npcPos.getY(), false));
            }

            if (npcPos.getX() != NPCList.get(npcIndex).getLastXCoordinate() || npcPos.getY() != NPCList.get(npcIndex).getLastYCoordinate() && NPCList.get(npcIndex).getNPCTicksWithoutMoving() >= 2/*!NPCList.get(npcIndex).getMovedLastGameTick()*/) {
                log.info("Game tick: " + currentTick + " : " + npc.getName() + " moved: " + npcPos.getX() + " " + npcPos.getY());
                //NPCList.get(npcIndex).setMovedLastGameTick(true);
                NPCList.get(npcIndex).setNPCTicksWithoutMoving(0);
                npcOverheadText(npc, dialogue);
                //NPCList.get(npcIndex).setNPCStartingTick(client.getTickCount());
            } else {
                log.info("Game tick: " + currentTick + " : " + npc.getName() + " has stopped moving");
                //NPCList.get(npcIndex).setMovedLastGameTick(false);
                NPCList.get(npcIndex).incrementNPCTicksWithoutMoving();
            }
            NPCList.get(npcIndex).setLastXCoordinate(npcPos.getX());
            NPCList.get(npcIndex).setLastYCoordinate(npcPos.getY());
        }
    }

    //sets the overhead text
    public void npcOverheadText(Actor a, String dialogue) {
        int startingTick = client.getTickCount();
        /*a.setOverheadText(dialogue);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        // your code here
                        a.setOverheadText("");
                    }
                },
                3000
        );*/
        while(client.getTickCount() >= startingTick + 5){
            a.setOverheadText(dialogue);
        }
        a.setOverheadText("");

    }

    @Subscribe
    public void onInteractingChanged(InteractingChanged event) {
        if (event.getTarget() != null && event.getSource() == client.getLocalPlayer()) {
            lastNPCText = "";
            lastPlayerText = "";
            actor = event.getTarget();
        }
    }

    public void npcDialog(){
        if (client.getWidget(WidgetInfo.DIALOG_NPC_TEXT) != null && !lastNPCText.equals(Text.sanitizeMultilineText((client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).getText()))) {
            Widget npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
            if (npcDialog != null) {
                String npcText = Text.sanitizeMultilineText(npcDialog.getText());
                lastNPCText = npcText;
                log.info(npcText);
                npcOverheadText(actor, npcText);
            }
        }
        //For when your player has dialogue
        if (client.getWidget(WidgetID.DIALOG_PLAYER_GROUP_ID, 4) != null && !lastPlayerText.equals(Text.sanitizeMultilineText((client.getWidget(WidgetID.DIALOG_PLAYER_GROUP_ID, 4)).getText()))) {
            Widget playerDialog = client.getWidget(WidgetID.DIALOG_PLAYER_GROUP_ID, 4);
            if (playerDialog != null) {
                String playerText = Text.sanitizeMultilineText(playerDialog.getText());
                lastPlayerText = playerText;
                log.info(playerText);
                npcOverheadText(Objects.requireNonNull(client.getLocalPlayer()), playerText);
            }
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {
    	npcDialog();
    	npcWalkingTextInvoker();
    }
}