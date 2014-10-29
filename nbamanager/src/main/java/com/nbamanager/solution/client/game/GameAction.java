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
import com.nbamanager.solution.history.GameMessageHelper;
import java.util.List;

/**
 *
 * @author Artem
 */
public class GameAction {

    private GameContext globalGameContext;
    private ActiveTeamDTO offenseDTO;
    private ActiveTeamDTO deffenseDTO;

    public GameContext getGlobalGameContext() {
        return globalGameContext;
    }

    public void setGlobalGameContext(GameContext globalGameContext) {
        this.globalGameContext = globalGameContext;
    }
    
    

    private void initData() {
        Onball onBall = globalGameContext.getGameCortInfoDTO().getOnBall();
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
    
    private Onball checkOnBallAndNextStep(Onball onBall, boolean nextTeam){
        Onball result = null;
        if(onBall == Onball.HOME && nextTeam){
            result = Onball.AWAY;
        } else if(onBall == Onball.HOME && !nextTeam){
            result = Onball.HOME;
        } else if(onBall == Onball.AWAY && nextTeam){
            result = Onball.HOME;
        } else {
            result = Onball.AWAY;
        }
        return result;
    }

    public void runStepExecute() {
        this.initData();
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
        //check next team
        boolean checkNextTeam = true;
        // WARNING FORMER FOR STATS!!!
        switch (shootProcess) {
            case SCORE:
                globalGameContext.getGameCortInfoDTO().setScore(new ScoresEngine().getScoresBySchema(schemaAttack));
                break;
            case FREETHROW:
                Player foul4Player = new FoulEngine().rebound4Player(deffenseDTO.getActivePlayers());
                globalGameContext.getGameCortInfoDTO().setScore(new FreethrowEngine().getScoresByFreethrow(playerAttack.getPlayer()));
                playerDeffense.setPlayer(foul4Player);
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
                    // BALL ON THIS TEAM BECAUSE OFFENSE REBOUND 
                    checkNextTeam = false;
                    playerAttack.setPlayer(rebound4Player);
                } else {
                    rebound4Player = reboundEngine.rebound4Player(rebound, deffenseDTO.getActivePlayers());
                    playerDeffense.setPlayer(rebound4Player);
                }
                shootProcess = rebound;
                break;
            case TURNOVER:
                globalGameContext.getGameCortInfoDTO().setScore(0);                
                break;
            case BLOCK:
                globalGameContext.getGameCortInfoDTO().setScore(0);
                break;
            case STEAL:
                globalGameContext.getGameCortInfoDTO().setScore(0);
                break;
        }
        // ADD MESSAGE
         globalGameContext.getGameCortInfoDTO().
                        setCurrentResultMessage(
                                GameMessageHelper.addMessage(
                                        shootProcess, playerAttack.getPlayer(), playerDeffense.getPlayer(), 
                                        globalGameContext.getGameCortInfoDTO().getScore(), schemaAttack));
        // CHECK NEXT TEAM
        globalGameContext.getGameCortInfoDTO().setOnBall(this.checkOnBallAndNextStep(globalGameContext.getGameCortInfoDTO().getOnBall(),checkNextTeam));
        this.setGlobalGameContext(globalGameContext);
    }
}
