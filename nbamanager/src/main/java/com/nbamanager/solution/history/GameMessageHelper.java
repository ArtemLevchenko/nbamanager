package com.nbamanager.solution.history;

import com.nbamanager.solution.engine.GameTime;
import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.enums.Action;
import com.nbamanager.solution.enums.TypeSchemaAttack;

/**
 *
 * @author Artem Levchenko
 */
public class GameMessageHelper {

    public static String addMessage(Action shootProcess, Player playerAttack, Player playerDeffense, int score, TypeSchemaAttack schemaAttack) {
        String result = null;
        // TODO: PLEASE ADD GENERATE ALGORITHM
        switch (shootProcess) {
            case SCORE:
                result = "Атаку завершает: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "В защите находился: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case FREETHROW:
                result = "Штрафные пробивал: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "Фол получил: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case SLAMDUNK:
                result = "Атаку завершает слэмом: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "В защите находился: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case MISS:
                result = "Промах от игрока: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "В защите находился: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case TURNOVER:
                result = "Потеря игрока: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "В защите находился: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case BLOCK:
                result = "Блок игрока: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                result += "В атаке был: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                break;
            case STEAL:
                result = "Перехват игрока: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                result += "В атаке был: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                break;
            case OFREBOUND:
                result = "Промах и атакующий подбор игрока: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "В защите находился: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case DREBOUND:
                result = "Промах и подбор защитный за игроком: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                result += "В атаке был: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                break;
            default:
                result = "NOT FOUND COMMAND!";
        }
        result += "Очков набрано: " + score + "\n";
        result += "Cхема атаки: " + schemaAttack + "\n";
        return result;
    }

    public static GameHistory addToHistory(Action shootProcess, Player playerAttack, Player playerDeffense, String resultMessage, GameTime timeAction) {
        GameHistory historyLine = new GameHistory();
        historyLine.setCurrentCommand(shootProcess);
        historyLine.setMessage(resultMessage);
        historyLine.setPlayerAtt(playerAttack);
        historyLine.setPlayerDeff(playerDeffense);
        historyLine.setTime(timeAction.getPeriod() + " Q " + timeAction.getCurrentTime());
        return historyLine;
    }
}
