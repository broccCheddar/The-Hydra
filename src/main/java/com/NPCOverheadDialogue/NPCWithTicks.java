package com.NPCOverheadDialogue;

public class NPCWithTicks {
    private String NPCName;
    private int NPCID;
    private int npcStartingTick;
    private  int npcTicksWithoutMoving = 2;
    private int npcTicksSinceDialogStart = 10;
    private int lastXCoordinate;
    private int lastYCoordinate;
    private boolean movedLastGameTick;
    public NPCWithTicks(String name, int id, int startingTick, int x, int y){
        NPCName = name;
        NPCID = id;
        npcStartingTick = startingTick;
        lastXCoordinate = x;
        lastYCoordinate = y;
    }
    public String getNPCName(){return NPCName;}

    public int getNPCID(){return NPCID;}

    public int getNPCStartingTick(){return npcStartingTick;}

    public int getNPCTicksWithoutMoving(){return npcTicksWithoutMoving;}

    public int getNpcTicksSinceDialogStart(){return npcTicksSinceDialogStart;}

    public int getLastXCoordinate(){return lastXCoordinate;}

    public int getLastYCoordinate(){return lastYCoordinate;}

    public boolean getMovedLastGameTick(){return movedLastGameTick;}

    public void setNPCName(String name){NPCName = name;}

    public void setNPCStartingTick(int startingTick){npcStartingTick = startingTick;}

    public void setNPCTicksWithoutMoving(int ticksWithoutMoving){npcTicksWithoutMoving = ticksWithoutMoving;}

    public void setNPCTicksSinceDialogStart(int ticksSinceDialogStart){npcTicksSinceDialogStart = ticksSinceDialogStart;}

    public void setLastXCoordinate(int x){lastXCoordinate = x;}

    public void setLastYCoordinate(int y){lastYCoordinate = y;}

    public void setMovedLastGameTick(boolean moving){movedLastGameTick = moving;}

    public void incrementNPCTicksWithoutMoving(){npcTicksWithoutMoving++;}

    public void incrementNPCTicksSinceDialogStart(){npcTicksSinceDialogStart++;}
}
