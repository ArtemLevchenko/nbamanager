package com.nbamanager.solution.client.game;

import com.nbamanager.solution.dto.ActiveTeamDTO;
import com.nbamanager.solution.dto.PlayerWidthDTO;
import com.nbamanager.solution.engine.DeffenseEngine;
import com.nbamanager.solution.engine.FoulEngine;
import com.nbamanager.solution.engine.FreethrowEngine;
import com.nbamanager.solution.engine.OffenseEngine;
import com.nbamanager.solution.engine.ReboundEngine;
import com.nbamanager.solution.engine.ScoresEngine;
import com.nbamanager.solution.engine.ShootEngine;
import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.enums.Action;
import static com.nbamanager.solution.enums.Action.BLOCK;
import static com.nbamanager.solution.enums.Action.STEAL;
import static com.nbamanager.solution.enums.Action.TURNOVER;
import com.nbamanager.solution.enums.Onball;
import static com.nbamanager.solution.enums.Onball.HOME;
import com.nbamanager.solution.enums.TypeSchemaAttack;
import java.util.List;

/**
 *
 * @author Artem
 */
public class GameAction {

    private GameContext globalGameContext;
    private ActiveTeamDTO offenseDTO;
    private ActiveTeamDTO deffenseDTO;

    public void initData(Onball onBall) {
        globalGameContext.getGameCortInfoDTO().setOnBall(onBall);
        globalGameContext.getGameCortInfoDTO().setScore(0);
        globalGameContext.getGameCortInfoDTO().getGameTime();
        
        offenseDTO = new ActiveTeamDTO();
        deffenseDTO = new ActiveTeamDTO();
        if (onBall == HOME) {
            offenseDTO.setActiveCoach(globalGameContext.getCoachDTO().getHomeCoach());
            offenseDTO.setActivePlayers(globalGameContext.getPlayersDTO().getHomePlayers());

            deffenseDTO.setActiveCoach(globalGameContext.getCoachDTO().getAwayCoach());
            deffenseDTO.setActivePlayers(globalGameContext.getPlayersDTO().getAwayPlayers());
        } else {
            offenseDTO.setActiveCoach(globalGameContext.getCoachDTO().getAwayCoach());
            offenseDTO.setActivePlayers(globalGameContext.getPlayersDTO().getAwayPlayers());

            deffenseDTO.setActiveCoach(globalGameContext.getCoachDTO().getHomeCoach());
            deffenseDTO.setActivePlayers(globalGameContext.getPlayersDTO().getHomePlayers());
        }
    }

    public void oneRunStep(Onball onBall) {
        this.initData(onBall);
        /*
         INIT data
         1) GET SCHEMA
         2) OFFENSE PLAYER
         3) GET DEFF PLAYER
         4) SHOOTENGINE
         5) RESULT
         */
        //// OFFEN STACK
        OffenseEngine offenseEngine = new OffenseEngine();
        // GET SCHEMA
        TypeSchemaAttack schemaAttack = offenseEngine.generateTypeSchemaAttack(offenseDTO.getActiveCoach());
        // GET DTO ATTACK
        List<PlayerWidthDTO> listOffensePlayers = offenseEngine.calculateMatrixAttack(schemaAttack, offenseDTO.getActivePlayers(), offenseDTO.getActiveCoach());
        // GET PLAYER ATTACK DTO
        PlayerWidthDTO playerAttack = offenseEngine.getAttackPlayer(listOffensePlayers);
        ////DEF STACK
        DeffenseEngine deffenseEngine = new DeffenseEngine();
        // GET DTO DEFF
        List<PlayerWidthDTO> listDeffensePlayers = deffenseEngine.calculateMatrixAttack(schemaAttack, deffenseDTO.getActivePlayers(), deffenseDTO.getActiveCoach(), playerAttack.getPlayer().getPlayerInfo().getInGammePosition());
        // GET PLAYER DEFF DTO
        PlayerWidthDTO playerDeffense = deffenseEngine.getDeffensePlayer(listDeffensePlayers);
        // SHOOT ENGINE
        ShootEngine shootEngine = new ShootEngine();
        Action shootProcess = shootEngine.getShootProcess(playerAttack, playerDeffense);
        switch (shootProcess) {
            case SCORE:
                globalGameContext.getGameCortInfoDTO().setScore(new ScoresEngine().getScoresBySchema(schemaAttack));
                globalGameContext.getGameCortInfoDTO().
                        setCurrentResultMessage("Атаку завершает " + playerAttack.getPlayer().getFname() + playerAttack.getPlayer().getSname());
                break;
            case FREETHROW:
                Player foul4Player = new FoulEngine().rebound4Player(deffenseDTO.getActivePlayers());
                globalGameContext.getGameCortInfoDTO().setScore(new FreethrowEngine().getScoresByFreethrow(playerAttack.getPlayer()));
                break;
            case SLAMDUNK:
                globalGameContext.getGameCortInfoDTO().setScore(2);
                break;
            case MISS:
                globalGameContext.getGameCortInfoDTO().setScore(0);
                ReboundEngine reboundEngine = new ReboundEngine();
                Action rebound = reboundEngine.grabRebound();
                Player rebound4Player = null;
                if (rebound == Action.OFREBOUND) {
                    rebound4Player = reboundEngine.rebound4Player(rebound, offenseDTO.getActivePlayers());
                } else {
                    rebound4Player = reboundEngine.rebound4Player(rebound, deffenseDTO.getActivePlayers());
                }
                break;
            case TURNOVER:
                globalGameContext.getGameCortInfoDTO().setScore(0);
                // ADD TURNOVER.
                Player player4Turnover = playerAttack.getPlayer();
                break;
            case BLOCK:
                globalGameContext.getGameCortInfoDTO().setScore(0);
                // ADD BLOCK.
                Player player4Block = playerDeffense.getPlayer();
                break;
            case STEAL:
                globalGameContext.getGameCortInfoDTO().setScore(0);
                // ADD STEAL.
                Player player4Steal = playerDeffense.getPlayer();
                break;
        }
    }
}
