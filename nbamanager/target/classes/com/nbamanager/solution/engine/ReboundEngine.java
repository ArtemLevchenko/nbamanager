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
public class ReboundEngine {

    private final int START_FIND = 0;
    private final int END_FIND_BIG = 9;

    private static final Action[] _HAS_OFFENSE_REBOUND = new Action[]{OFREBOUND, DREBOUND, DREBOUND, DREBOUND, DREBOUND, OFREBOUND, DREBOUND, DREBOUND, DREBOUND, OFREBOUND};
    private static final int[] _REBOUND = new int[]{0, 1, 0, 2, 1, 1, 0, 2, 3, 0};
    
    public Action grabRebound() {
        return _HAS_OFFENSE_REBOUND[RandomEngine.randomIntegerIndex(START_FIND, END_FIND_BIG)];
    }

    // deffense or offense
    public Player rebound4Player(Action action, List<Player> players) {
        List<PlayerWidthDTO> listPlayers = new ArrayList<PlayerWidthDTO>();

        if (action == OFREBOUND) {
            for (Player pl : players) {
                listPlayers.add(new PlayerWidthDTO(pl, pl.getGameSkills().getOfrebound()));
            }
        } else {
            for (Player pl : players) {
                listPlayers.add(new PlayerWidthDTO(pl, pl.getGameSkills().getDefrebound()));
            }
        }
        Collections.sort(listPlayers, new WidthComparator());
        int indexWinAss = _REBOUND[RandomEngine.randomIntegerIndex(START_FIND, END_FIND_BIG)];
        return listPlayers.get(indexWinAss).getPlayer();
    }
}
