package com.nbamanager.solution.utils;

import com.nbamanager.solution.dto.PlayerWidthDTO;
import java.util.Comparator;

/**
 *
 * @author Artem
 */
public class WidthComparator implements Comparator<PlayerWidthDTO> {

    @Override
    public int compare(PlayerWidthDTO o1, PlayerWidthDTO o2) {
        int returnValue = 0;
        if (o1.getWidthAction() > o2.getWidthAction()) {
            returnValue = 1;
        } else if (o1.getWidthAction() < o2.getWidthAction()) {
            returnValue = -1;
        }
        return returnValue;
    }
}
