package com.NPCOverheadDialogue;

public class NPCWithTicks {
    private String NPCName;
    private int npcStartingTick;
    //private  int npcLastMovingTick;
    private int lastXCoordinate;
    private int lastYCoordinate;
    private boolean movedLastGameTick;
    public NPCWithTicks(String name, int startingTick, int x, int y, boolean moved){
        NPCName = name;
        npcStartingTick = startingTick;
        lastXCoordinate = x;
        lastYCoordinate = y;
        movedLastGameTick = moved;
    }
    public String getNPCName(){return NPCName;}

    public int getNPCStartingTick(){return npcStartingTick;}

    //public int getNPCLastMovingTick(){return npcLastMovingTick;}

    public int getLastXCoordinate(){return lastXCoordinate;}

    public int getLastYCoordinate(){return lastYCoordinate;}

    public boolean getMovedLastGameTick(){return movedLastGameTick;}

    public void setNPCName(String name){NPCName = name;}

    public void setNPCStartingTick(int startingTick){npcStartingTick = startingTick;}

    //public void setNPCLastMovingTick(int lastMovingTick){npcLastMovingTick = lastMovingTick;}

    public void setLastXCoordinate(int x){lastXCoordinate = x;}

    public void setLastYCoordinate(int y){lastYCoordinate = y;}

    public void setMovedLastGameTick(boolean moving){movedLastGameTick = moving;}
}
