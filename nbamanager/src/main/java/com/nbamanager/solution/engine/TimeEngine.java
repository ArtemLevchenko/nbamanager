package com.nbamanager.solution.engine;

/**
 *
 * @author Artem
 */
public class TimeEngine {
     // |TODO: new algorithm
    public static GameTime getNewTime(GameTime gameTime) {
        if(gameTime.getCurrentTime() > 0.0) {
            gameTime.setCurrentTime(gameTime.getCurrentTime() - 0.24);
        }
        return gameTime;
    }
}
