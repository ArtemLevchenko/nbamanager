package com.nbamanager.solution.engine;

import com.nbamanager.solution.dto.PlayerWidthDTO;
import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.enums.Action;
import static com.nbamanager.solution.enums.Action.BLOCK;
import static com.nbamanager.solution.enums.Action.FREETHROW;
import static com.nbamanager.solution.enums.Action.MISS;
import static com.nbamanager.solution.enums.Action.OTHER;
import static com.nbamanager.solution.enums.Action.SCORE;
import static com.nbamanager.solution.enums.Action.SLAMDUNK;
import static com.nbamanager.solution.enums.Action.STEAL;
import static com.nbamanager.solution.enums.Action.TURNOVER;

/**
 *
 * @author arle0814
 */
public class ShootEngine {

    private final int _START = 0;
    private final int _END = 9;
    private final int _END_SHORT = 4;
    // 70 / 30
    private final static Action[] OFF_DOMINATE_PERCENT_TO_SCORE = new Action[]{SCORE, SCORE, MISS, SCORE, SCORE, MISS, SCORE, MISS, SCORE, SCORE};
    // 40 / 60
    private final static Action[] DEF_DOMINATE_PERCENT_TO_SCORE = new Action[]{MISS, SCORE, MISS, MISS, SCORE, MISS, SCORE, MISS, SCORE, MISS};
    // 70 / 30
    private final static Action[] IS_FREETHR_ATTEMPT = new Action[]{SCORE, SCORE, FREETHROW, SCORE, SCORE, FREETHROW, SCORE, FREETHROW, SCORE, SCORE};

    // 60 / 40
    private final static Action[] IS_MISS_OR_OTHER = new Action[]{MISS, OTHER, MISS, OTHER, MISS, MISS, OTHER, MISS, OTHER, MISS};
    private final static Action[] MISS_OTHER_BLOCK = new Action[]{TURNOVER, BLOCK, TURNOVER, BLOCK, STEAL};
    private final static Action[] MISS_OTHER_STEAL = new Action[]{TURNOVER, STEAL, TURNOVER, STEAL, BLOCK};

    private final static Action[] SCORE_IS_DUNK = new Action[]{SCORE, SCORE, SCORE, SLAMDUNK, SCORE};

    // TODO: ADD NEW ALGORITHM (include different offense and deffense)
    public Action getShootProcess(PlayerWidthDTO offensePlayer, PlayerWidthDTO deffPlayer) {
        // 70% Percent Success - 30 % MISS OR STEAL OR BLOCK OR TURNOVER
        //see mass
        Action result = null;
        if (offensePlayer.getWidthAction() > deffPlayer.getWidthAction()) {
            result = OFF_DOMINATE_PERCENT_TO_SCORE[RandomEngine.randomIntegerIndex(_START, _END)];
        } // 40% Percent SUccess - 60 % MISS OR STEAL OR BLOCK OR TURNOVER
        else {
            result = DEF_DOMINATE_PERCENT_TO_SCORE[RandomEngine.randomIntegerIndex(_START, _END)];
        }
        result = this.getCorrectShootProcess(result, deffPlayer.getPlayer());
        return result;
    }

    private Action getCorrectShootProcess(Action status, Player deffensePlayer) {
        Action result = null;
        if (status == SCORE) {
            result = IS_FREETHR_ATTEMPT[RandomEngine.randomIntegerIndex(_START, _END)];
            if (result == SCORE) {
                result = SCORE_IS_DUNK[RandomEngine.randomIntegerIndex(_START, _END_SHORT)];
            }
        } else {
            result = IS_MISS_OR_OTHER[RandomEngine.randomIntegerIndex(_START, _END)];
            // 6 % - блокшот(1),  12 % - перехват(2), 20%-потеря(3)
            if (result == OTHER) {
                int block = deffensePlayer.getGameSkills().getBlock();
                int steal = deffensePlayer.getGameSkills().getSteal();
                if (block > steal) {
                    result = MISS_OTHER_BLOCK[RandomEngine.randomIntegerIndex(_START, _END_SHORT)];
                } else {
                    result = MISS_OTHER_STEAL[RandomEngine.randomIntegerIndex(_START, _END_SHORT)];
                }
            }
        }
        return result;
    }
}
