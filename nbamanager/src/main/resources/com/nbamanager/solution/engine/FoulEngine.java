package com.nbamanager.solution.engine;

import com.nbamanager.solution.dto.PlayerWidthDTO;
import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.enums.Action;
import static com.nbamanager.solution.enums.Action.DREBOUND;
import static com.nbamanager.solution.enums.Action.OFREBOUND;
import com.nbamanager.solution.utils.WidthComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Artem
 */
public class FoulEngine {

    private final int START_FIND = 0;
    private final int END_FIND_BIG = 9;

    private static final int[] _FOULS = new int[]{4, 3, 3, 4, 2, 1, 2, 0, 4, 4};

    // generated for deff foul
    public Player rebound4Player(List<Player> players) {
        List<PlayerWidthDTO> listPlayers = new ArrayList<PlayerWidthDTO>();

        for (Player pl : players) {
            listPlayers.add(new PlayerWidthDTO(pl, pl.getGameSkills().getDefenseonball() + pl.getGameSkills().getTotalrank()));
        }
        Collections.sort(listPlayers, new WidthComparator());
        int indexWinAss = _FOULS[RandomEngine.randomIntegerIndex(START_FIND, END_FIND_BIG)];
        return listPlayers.get(indexWinAss).getPlayer();
    }
}
