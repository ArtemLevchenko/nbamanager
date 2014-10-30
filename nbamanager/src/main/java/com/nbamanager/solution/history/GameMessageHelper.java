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
                result = "����� ���������: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "� ������ ���������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case FREETHROW:
                result = "�������� ��������: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "��� �������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case SLAMDUNK:
                result = "����� ��������� ������: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "� ������ ���������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case MISS:
                result = "������ �� ������: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "� ������ ���������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case TURNOVER:
                result = "������ ������: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "� ������ ���������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case BLOCK:
                result = "���� ������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                result += "� ����� ���: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                break;
            case STEAL:
                result = "�������� ������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                result += "� ����� ���: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                break;
            case OFREBOUND:
                result = "������ � ��������� ������ ������: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                result += "� ������ ���������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                break;
            case DREBOUND:
                result = "������ � ������ �������� �� �������: " + playerDeffense.getFname() + playerDeffense.getSname() + "\n";
                result += "� ����� ���: " + playerAttack.getFname() + playerAttack.getSname() + "\n";
                break;
            default:
                result = "NOT FOUND COMMAND!";
        }
        result += "����� �������: " + score + "\n";
        result += "C���� �����: " + schemaAttack + "\n";
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
