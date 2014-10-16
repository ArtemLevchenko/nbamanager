package com.nbamanager.solution.entity;

import com.nbamanager.solution.enums.GamePosition;

/**
 *
 * @author Artem
 */
public class PlayerInfo {
    private int id;
    // позиция игровая
    private GamePosition inGammePosition;

    public PlayerInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GamePosition getInGammePosition() {
        return inGammePosition;
    }

    public void setInGammePosition(GamePosition inGammePosition) {
        this.inGammePosition = inGammePosition;
    }
    
    
}
