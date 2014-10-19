package com.nbamanager.solution.engine;

import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.enums.Action;
import static com.nbamanager.solution.enums.Action.MISS;
import static com.nbamanager.solution.enums.Action.SCORE;

/**
 *
 * @author Artem
 */
public class FreethrowEngine {

    private final int _START = 0;
    private final int _END = 9;
    // PERCENT PROCESS
    private final static Action[] _90_PERCENT = new Action[]{SCORE, SCORE, MISS, SCORE, SCORE, SCORE, SCORE, SCORE, SCORE, SCORE};
    private final static Action[] _80_PERCENT = new Action[]{SCORE, SCORE, MISS, SCORE, SCORE, MISS, SCORE, SCORE, SCORE, SCORE};
    private final static Action[] _70_PERCENT = new Action[]{SCORE, SCORE, MISS, SCORE, SCORE, MISS, SCORE, SCORE, MISS, SCORE};
    private final static Action[] _60_PERCENT = new Action[]{SCORE, SCORE, MISS, SCORE, SCORE, MISS, SCORE, MISS, MISS, SCORE};
    private final static Action[] _50_PERCENT = new Action[]{SCORE, SCORE, MISS, MISS, SCORE, MISS, SCORE, MISS, MISS, SCORE};

    public int getScoresByFreethrow(Player attack) {
        int result = 0;
        //round percent
        int freeThrow = attack.getGameSkills().getFreethrow() / 10;
        //2 attempt
        for (int i = 0; i < 2; i++) {
            switch (freeThrow) {
                case 9:
                    result += _90_PERCENT[RandomEngine.randomIntegerIndex(_START, _END)] == SCORE ? 1 : 0;
                    break;
                case 8:
                    result += _80_PERCENT[RandomEngine.randomIntegerIndex(_START, _END)] == SCORE ? 1 : 0;
                    break;
                case 7:
                    result += _70_PERCENT[RandomEngine.randomIntegerIndex(_START, _END)] == SCORE ? 1 : 0;
                    break;
                case 6:
                    result += _60_PERCENT[RandomEngine.randomIntegerIndex(_START, _END)] == SCORE ? 1 : 0;
                    break;
                case 5:
                    result += _50_PERCENT[RandomEngine.randomIntegerIndex(_START, _END)] == SCORE ? 1 : 0;
                    break;
                default:
                    result += _50_PERCENT[RandomEngine.randomIntegerIndex(_START, _END)] == SCORE ? 1 : 0;
                    break;
            }
        }
        return result;
    }
}
