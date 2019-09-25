package com.mdolat.gameoflife.board;

public class Symbols {
    private final String deathCell;
    private final String liveCell;

    public Symbols(String liveCell, String deathCell) {
        this.deathCell = deathCell;
        this.liveCell = liveCell;
    }

    public String getDeathCell() {
        return deathCell;
    }

    public String getLiveCell() {
        return liveCell;
    }
}
