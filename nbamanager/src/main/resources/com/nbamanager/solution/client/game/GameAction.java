/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbamanager.solution.client.game;

import com.nbamanager.solution.entity.Coach;
import com.nbamanager.solution.enums.Onball;

/**
 *
 * @author Artem
 */
public class GameAction {

    private GameContext globalGameContext;

    public void run(String onBall) {
        Coach onBallCoach = Onball.valueOf(onBall) == Onball.HOME
                ? globalGameContext.getCoachDTO().getHomeCoach()
                : globalGameContext.getCoachDTO().getAwayCoach();

    }
}
