package com.nbamanager.solution.engine;

import com.nbamanager.solution.enums.TypeSchemaAttack;

/**
 *
 * @author Artem
 */
public class ScoresEngine {

    public int getScoresBySchema(TypeSchemaAttack schema) {
        int result = 0;
        switch (schema) {
            case INSIDE:
            case MID:
                result = 2;
                break;
            case THREEPT:
                result = 3;
                break;
            default:
                result = 2;
                break;
        }
        return result;
    }
}
