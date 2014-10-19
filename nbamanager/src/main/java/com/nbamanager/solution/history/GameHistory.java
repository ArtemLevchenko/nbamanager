package com.nbamanager.solution.history;

import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.enums.Action;

/**
 *
 * @author Artem
 */
public class GameHistory {

    private String time;
    private Player playerAtt;
    private Player playerDeff;
    private Action currentCommand;
    private String message;

    public GameHistory() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Player getPlayerAtt() {
        return playerAtt;
    }

    public void setPlayerAtt(Player playerAtt) {
        this.playerAtt = playerAtt;
    }

    public Player getPlayerDeff() {
        return playerDeff;
    }

    public void setPlayerDeff(Player playerDeff) {
        this.playerDeff = playerDeff;
    }

    public Action getCurrentCommand() {
        return currentCommand;
    }

    public void setCurrentCommand(Action currentCommand) {
        this.currentCommand = currentCommand;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
