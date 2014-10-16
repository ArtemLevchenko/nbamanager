/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbamanager.solution.dto;

import com.nbamanager.solution.entity.Player;

/**
 *
 * @author Artem
 */
public class PlayerWidthDTO {
    private int widthAction;
    private Player player;

    public PlayerWidthDTO() {
    }

    public PlayerWidthDTO(Player player, int widthAction) {
        this.widthAction = widthAction;
        this.player = player;
    }


    public int getWidthAction() {
        return widthAction;
    }

    public void setWidthAction(int widthAction) {
        this.widthAction = widthAction;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
}
