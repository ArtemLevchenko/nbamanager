package com.nbamanager.solution.client.beans;

import com.nbamanager.solution.client.game.GameAction;
import com.nbamanager.solution.client.game.GameContext;
import com.nbamanager.solution.client.loaders.CoachLoader;
import com.nbamanager.solution.client.loaders.PlayersLoader;
import com.nbamanager.solution.dto.CoachDTO;
import com.nbamanager.solution.dto.CortInfoDTO;
import com.nbamanager.solution.dto.GameHistoryDTO;
import com.nbamanager.solution.dto.PlayersAllDTO;
import com.nbamanager.solution.engine.GameTime;
import com.nbamanager.solution.enums.Onball;
import com.nbamanager.solution.history.GameHistory;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Artem
 */
@ManagedBean(name = "gameBean")
@SessionScoped
public class GameSimulationBean implements Serializable {

    private String matchMessage;
    private GameContext gameContext;
    
    public GameSimulationBean(){
        gameContext = new GameContext();
    }
    
    @PostConstruct
    public void initGameData(){
        // coach
        CoachLoader coachLoader = new CoachLoader();
        gameContext.setCoachDTO(new CoachDTO()); 
        gameContext.getCoachDTO().setHomeCoach(coachLoader.getPlayersByTeam("Miami"));
        gameContext.getCoachDTO().setAwayCoach(coachLoader.getPlayersByTeam("Lakers"));
        //player
        PlayersLoader playerLoader = new PlayersLoader();
        PlayersAllDTO plDTO = new PlayersAllDTO();
        plDTO.setHomePlayers(playerLoader.getPlayersByTeam("Miami"));
        plDTO.setAwayPlayers(playerLoader.getPlayersByTeam("Lakers"));
        gameContext.setPlayersDTO(plDTO);
        // history
        GameHistoryDTO historyDTO = new GameHistoryDTO();
        historyDTO.setMatchHistory(new ArrayList<GameHistory>());
        gameContext.setGameHistoryDTO(historyDTO);
        // game info
        CortInfoDTO gameCortInfoDTO = new CortInfoDTO();
        gameCortInfoDTO.setOnBall(Onball.HOME);
        gameCortInfoDTO.setCurrentResultMessage("");
        GameTime gameTime = new GameTime();
        gameTime.setCurrentTime(12.0);
        gameTime.setPeriod(1);
        gameCortInfoDTO.setGameTime(gameTime);
        gameContext.setGameCortInfoDTO(gameCortInfoDTO);
    }
    
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
        //this.setMatchMessage("START!!!");
        GameAction newStep = new GameAction();
        newStep.setGlobalGameContext(gameContext);
        // START STEP
        newStep.runStepExecute();
        // GET RESULT
        gameContext = newStep.getGlobalGameContext();

        matchMessage += gameContext.getGameCortInfoDTO().getCurrentResultMessage();
    }
}
