package com.NPCOverheadDialogue;

import net.runelite.api.Actor;
import net.runelite.api.NPC;

public class NPCWithTicks {
    private Actor NPCWithTicksActor;
    private NPC NPCWithTicksNPC;
    private String NPCName;
    private String NPCDialog;
    private int NPCID;
    private int npcStartingTick;
    private  int npcTicksWithoutMoving = 2;
    private int npcTicksSinceDialogStart = 10;
    private int lastXCoordinate;
    private int lastYCoordinate;
    private boolean inCombat = false;
    //private boolean hasDialog;
    public NPCWithTicks(String name, int id, Actor npcActor, NPC npc, int startingTick, int x, int y){
        NPCWithTicksActor = npcActor;
        NPCWithTicksNPC = npc;
        NPCName = name;
        NPCID = id;
        npcStartingTick = startingTick;
        lastXCoordinate = x;
        lastYCoordinate = y;
    }
    public Actor getNPCWithTicksActor(){return NPCWithTicksActor;}

    public NPC getNPCWithTicksNPC(){return NPCWithTicksNPC;}

    public String getNPCName(){return NPCName;}

    public int getNPCID(){return NPCID;}

    public int getNPCStartingTick(){return npcStartingTick;}

    public int getNPCTicksWithoutMoving(){return npcTicksWithoutMoving;}

    public int getNpcTicksSinceDialogStart(){return npcTicksSinceDialogStart;}

    public int getLastXCoordinate(){return lastXCoordinate;}

    public int getLastYCoordinate(){return lastYCoordinate;}

    //public boolean getHasDialog(){return hasDialog;}

    public String getNPCDialog(){return NPCDialog;}

    public boolean getInCombat(){return inCombat;}


    public void setNPCName(String name){NPCName = name;}

    public void setNPCStartingTick(int startingTick){npcStartingTick = startingTick;}

    public void setNPCTicksWithoutMoving(int ticksWithoutMoving){npcTicksWithoutMoving = ticksWithoutMoving;}

    public void setNPCTicksSinceDialogStart(int ticksSinceDialogStart){npcTicksSinceDialogStart = ticksSinceDialogStart;}

    public void setLastXCoordinate(int x){lastXCoordinate = x;}

    public void setLastYCoordinate(int y){lastYCoordinate = y;}

    //public void setHasDialog(boolean dialog){hasDialog = dialog;}

    public void setNPCDialog(String d){NPCDialog = d;}

    public void setNPCID(int id){NPCID = id;}

    public void incrementNPCTicksWithoutMoving(){npcTicksWithoutMoving++;}

    public void incrementNPCTicksSinceDialogStart(){npcTicksSinceDialogStart++;}

    public void setInCombat(boolean ic){inCombat = ic;}
}
