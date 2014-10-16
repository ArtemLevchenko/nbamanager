/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbamanager.solution.engine;

/**
 *
 * @author Artem
 */
public class TimeEngine {
     // |TODO: new algorithm
    public static GameTime getNewTime(GameTime gameTime) {
        if(gameTime.getCurrentTime() > 0.0) {
            gameTime.setCurrentTime(gameTime.getCurrentTime() - 0.5);
        }
        return gameTime;
    }
}
