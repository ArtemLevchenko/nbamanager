package com.nbamanager.solution.client.beans;

import com.nbamanager.solution.client.game.GameContext;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Artem
 */
@ManagedBean(name = "gameBean")
@SessionScoped
public class GameBean implements Serializable {

    private String matchMessage;
    private GameContext gameContext;

    public String getMatchMessage() {
        return matchMessage;
    }

    public void setMatchMessage(String matchMessage) {
        this.matchMessage = matchMessage;
    }

    public GameContext getGameContext() {
        return gameContext;
    }

    public void setGameContext(GameContext gameContext) {
        this.gameContext = gameContext;
    }
    
    
    public void goStep(ActionEvent actionEvent) {
        this.setMatchMessage("хреяе!!!");
    }
}
