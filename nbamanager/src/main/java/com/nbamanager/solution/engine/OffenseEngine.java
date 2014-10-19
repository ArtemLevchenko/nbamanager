package com.nbamanager.solution.engine;

import com.nbamanager.solution.dto.PlayerWidthDTO;
import com.nbamanager.solution.entity.Coach;
import com.nbamanager.solution.entity.CoachMental;
import com.nbamanager.solution.entity.GameSkills;
import com.nbamanager.solution.entity.MentalSkills;
import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.enums.Level;
import com.nbamanager.solution.enums.TypeSchemaAttack;
import com.nbamanager.solution.utils.WidthComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Artem
 */
public class OffenseEngine {

    private final int START_FIND = 0;
    private final int END_FIND = 4;
    private final int END_FIND_BIG = 9;
    private final int PLAYER_SIZE_ATTACK = 3;
    private final static TypeSchemaAttack[] _INSIDE_DOMINATE
            = new TypeSchemaAttack[]{TypeSchemaAttack.INSIDE, TypeSchemaAttack.INSIDE, TypeSchemaAttack.MID, TypeSchemaAttack.INSIDE, TypeSchemaAttack.MID};
    private final static TypeSchemaAttack[] _MID_DOMINATE
            = new TypeSchemaAttack[]{TypeSchemaAttack.MID, TypeSchemaAttack.INSIDE, TypeSchemaAttack.MID, TypeSchemaAttack.MID, TypeSchemaAttack.THREEPT};
    private final static TypeSchemaAttack[] _THREEPT_DOMINATE
            = new TypeSchemaAttack[]{TypeSchemaAttack.THREEPT, TypeSchemaAttack.THREEPT, TypeSchemaAttack.MID, TypeSchemaAttack.THREEPT, TypeSchemaAttack.MID};

    private final static int[] INSIDE_ATTACK = new int[]{80, 50, 10};
    private final static int[] MID_ATTACK = new int[]{25, 80, 30};
    private final static int[] OUTSIDE_ATTACK = new int[]{10, 50, 80};
    private final static int[] OFFENSE_DEFFENSE = new int[]{100, 50, 0};
    private final static int[] SCREEN_DOMINATE = new int[]{100, 50, 0};
    private final static int[] OPENING_DOMINATE = new int[]{0, 50, 100};
    private final static int[] SCREEN_OPENING_BALANCE = new int[]{0, 50, 0};
    private final static int[] COACH_OFFENSE_DEFFENSE = new int[]{50, 25, 0};
    
    // 0 - first plyaer (max width) ...1 - second... 2-third
    // 2 - 20% 1 - 30 % 0 - 50%
    private final static int[] PERCENT_TO_WIN = new int[]{0, 1, 0, 1, 2, 0, 1, 0, 0, 2}; 

    public TypeSchemaAttack generateTypeSchemaAttack(Coach attackCoach) {
        TypeSchemaAttack[] chanseCoachSchemas = null;
        CoachMental mental = attackCoach.getCoachmental();
        switch (mental.getInsideoutside()) {
            case LEFT_0:
                chanseCoachSchemas = _INSIDE_DOMINATE;
                break;
            case BALANCE_50:
                chanseCoachSchemas = _MID_DOMINATE;
                break;
            case RIGHT_100:
                chanseCoachSchemas = _THREEPT_DOMINATE;
                break;
            default:
                chanseCoachSchemas = _MID_DOMINATE;
                break;
        }
        return chanseCoachSchemas[RandomEngine.randomIntegerIndex(START_FIND, END_FIND)];
    }

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

    // 2 STEP. ATTACK

    public List<PlayerWidthDTO> calculateMatrixAttack(TypeSchemaAttack attackSchema,
            List<Player> attackPlayers, Coach attackCoach) {
        List<PlayerWidthDTO> listWidthPlayers = new ArrayList<PlayerWidthDTO>();

        CoachMental mental = attackCoach.getCoachmental();
        int coachWidth = getWidthBySkills(mental.getOffensedeffense(), COACH_OFFENSE_DEFFENSE);

        for (Player player : attackPlayers) {
            int totalWidthPl = 0;
            GameSkills skills = player.getGameSkills();
            MentalSkills mentalSkills = player.getMentalSkills();
            // in schema
            switch (attackSchema) {
                case INSIDE:
                    totalWidthPl += getWidthBySkills(mentalSkills.getInsideoutside(), INSIDE_ATTACK);
                    totalWidthPl += getWidthBySkills(mentalSkills.getScreenopening(), SCREEN_DOMINATE);
                    totalWidthPl += skills.getInscore();
                    break;
                case MID:
                    totalWidthPl += getWidthBySkills(mentalSkills.getInsideoutside(), MID_ATTACK);
                    totalWidthPl += getWidthBySkills(mentalSkills.getScreenopening(), SCREEN_OPENING_BALANCE);
                    totalWidthPl += skills.getMediumshoot();
                    break;
                case THREEPT:
                    totalWidthPl += getWidthBySkills(mentalSkills.getInsideoutside(), OUTSIDE_ATTACK);
                    totalWidthPl += getWidthBySkills(mentalSkills.getScreenopening(), OPENING_DOMINATE);
                    totalWidthPl += skills.getThreeshoot();
                    break;
                default:
                    totalWidthPl += getWidthBySkills(mentalSkills.getInsideoutside(), MID_ATTACK);
                    totalWidthPl += getWidthBySkills(mentalSkills.getScreenopening(), SCREEN_OPENING_BALANCE);
                    totalWidthPl += skills.getMediumshoot();
                    break;
            }
            // individual characteristics
            totalWidthPl += getWidthBySkills(mentalSkills.getOffensedeffense(), OFFENSE_DEFFENSE);
            totalWidthPl += ((skills.getBallsecuirity() + skills.getTotalrank() + coachWidth) / 2);
            listWidthPlayers.add(new PlayerWidthDTO(player, totalWidthPl));
        }
        return listWidthPlayers;
    }

    public PlayerWidthDTO getAttackPlayer(List<PlayerWidthDTO> listPlayerWidth) {
        Collections.sort(listPlayerWidth, new WidthComparator());
        List<PlayerWidthDTO> lastStepWidth = new ArrayList<PlayerWidthDTO>();
        //TODO: get 3 best player
        for (int i = 0; i < PLAYER_SIZE_ATTACK; i++) {
            lastStepWidth.add(listPlayerWidth.get(i));
        }
        int winAttackIndex = PERCENT_TO_WIN[RandomEngine.randomIntegerIndex(START_FIND, END_FIND_BIG)];

        return lastStepWidth.get(winAttackIndex);
    }

}
