package com.nbamanager.solution.dto;

import com.nbamanager.solution.engine.GameTime;
import com.nbamanager.solution.enums.Onball;

/**
 *
 * @author Artem
 */
public class GameCortInfoDTO {
    private Onball onBall;
    private GameTime gameTime;
    private String currentResultMessage;
    // by one step!!! NOT ALL!
    private int score;

    public GameCortInfoDTO() {
    }

    public Onball getOnBall() {
        return onBall;
    }

    public void setOnBall(Onball onBall) {
        this.onBall = onBall;
    }

    public GameTime getGameTime() {
        return gameTime;
    }

    public void setGameTime(GameTime gameTime) {
        this.gameTime = gameTime;
    }

    public String getCurrentResultMessage() {
        return currentResultMessage;
    }

    public void setCurrentResultMessage(String currentResultMessage) {
        this.currentResultMessage = currentResultMessage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
