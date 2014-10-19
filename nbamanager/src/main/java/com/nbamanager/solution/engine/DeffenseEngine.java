package com.nbamanager.solution.engine;

import com.nbamanager.solution.dto.PlayerWidthDTO;
import com.nbamanager.solution.entity.Coach;
import com.nbamanager.solution.entity.CoachMental;
import com.nbamanager.solution.entity.GameSkills;
import com.nbamanager.solution.entity.MentalSkills;
import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.enums.GamePosition;
import com.nbamanager.solution.enums.Level;
import com.nbamanager.solution.enums.TypeSchemaAttack;
import com.nbamanager.solution.utils.WidthComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author arle0814
 */
public class DeffenseEngine {

    private final int START_FIND = 0;
    private final int END_FIND_BIG = 9;
    private final int PLAYER_SIZE_DEFF = 3;

    private final static int[] INSIDE_DEFF = new int[]{80, 50, 10};
    private final static int[] MID_DEFF = new int[]{25, 80, 30};
    private final static int[] OUTSIDE_DEFF = new int[]{10, 50, 80};
    private final static int[] OFFENSE_DEFF = new int[]{0, 50, 100};
    private final static int POSITION_EQUALS = 120;
    private final static int POSITION_NOT_EQUALS = 0;
    private final static int[] COACH_OFFENSE_DEFFENSE = new int[]{0, 85, 130};

    // 0 - first plyaer (max width) ...1 - second... 2-third
    // 2 - 20% 1 - 30 % 0 - 50%
    private final static int[] PERCENT_TO_WIN = new int[]{0, 1, 0, 1, 2, 0, 1, 0, 0, 2};

    // GET Width
    private int getWidthBySkills(Level levelSkills, int[] result) {
        int resultParam = 0;
        switch (levelSkills) {
            case LEFT_0:
                resultParam = result[0];
                break;
            case BALANCE_50:
                resultParam = result[1];
                break;
            case RIGHT_100:
                resultParam = result[2];
                break;
            default:
                break;
        }
        return resultParam;
    }

    // Schema atack + List + Coach
    public List<PlayerWidthDTO> calculateMatrixAttack(TypeSchemaAttack attackSchema, List<Player> deffensePlayers, Coach deffCoach, GamePosition opponentPosition) {
        List<PlayerWidthDTO> listWidthPlayers = new ArrayList<PlayerWidthDTO>();

        CoachMental mental = deffCoach.getCoachmental();
        int coachWidth = getWidthBySkills(mental.getOffensedeffense(), COACH_OFFENSE_DEFFENSE);

        for (Player player : deffensePlayers) {
            int totalWidthPl = 0;
            GameSkills skills = player.getGameSkills();
            MentalSkills mentalSkills = player.getMentalSkills();
            // в зависимости от схемы разные плюшки
            switch (attackSchema) {
                case INSIDE:
                    totalWidthPl += getWidthBySkills(mentalSkills.getDeffenseInsideOutside(), INSIDE_DEFF);
                    break;
                case MID:
                    totalWidthPl += getWidthBySkills(mentalSkills.getDeffenseInsideOutside(), MID_DEFF);
                    break;
                case THREEPT:
                    totalWidthPl += getWidthBySkills(mentalSkills.getDeffenseInsideOutside(), OUTSIDE_DEFF);
                    break;
                default:
                    totalWidthPl += getWidthBySkills(mentalSkills.getDeffenseInsideOutside(), MID_DEFF);
                    break;
            }

            totalWidthPl += opponentPosition == player.getPlayerInfo().getInGammePosition() ? POSITION_EQUALS : POSITION_NOT_EQUALS;
            // индивидуальные характеристики не зависят от схемы
            totalWidthPl += getWidthBySkills(mentalSkills.getOffensedeffense(), OFFENSE_DEFF);

            totalWidthPl += ((skills.getDefenseonball() + skills.getTotalrank() + coachWidth) / 2);
            listWidthPlayers.add(new PlayerWidthDTO(player, totalWidthPl));
        }
        return listWidthPlayers;
    }

    public PlayerWidthDTO getDeffensePlayer(List<PlayerWidthDTO> listPlayerWidth) {
        Collections.sort(listPlayerWidth, new WidthComparator());
        List<PlayerWidthDTO> lastStepWidth = new ArrayList<PlayerWidthDTO>();
        //Get first 3 Players
        for (int i = 0; i < PLAYER_SIZE_DEFF; i++) {
            lastStepWidth.add(listPlayerWidth.get(i));
        }
        int winDeffIndex = PERCENT_TO_WIN[RandomEngine.randomIntegerIndex(START_FIND, END_FIND_BIG)];

        return lastStepWidth.get(winDeffIndex);
    }
}
