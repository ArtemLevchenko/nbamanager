package com.nbamanager.solution.engine;

import com.nbamanager.solution.dto.PlayerWidthDTO;
import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.utils.WidthComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Artem
 */
public class AssistEngine {

    private final int START_FIND = 0;
    private final int END_FIND_BIG = 9;

    private static final int[] _ASSIST = new int[]{0, 1, 0, 2, 1, 1, 0, 2, 3, 0};
    private static final int[] _HAS_ASSIST = new int[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 0};

    public boolean checkHasAssist() {
        return _HAS_ASSIST[RandomEngine.randomIntegerIndex(START_FIND, END_FIND_BIG)] == 1;
    }

    public Player getAssistPlayer(List<Player> players, Player attackPlayer) {
        // remove ATTACK
        players.remove(attackPlayer);
        List<PlayerWidthDTO> listPlayers = new ArrayList<PlayerWidthDTO>();
        for (Player pl : players) {
            listPlayers.add(new PlayerWidthDTO(pl, pl.getGameSkills().getPass()));
        }
        Collections.sort(listPlayers, new WidthComparator());

        int indexWinAss = _ASSIST[RandomEngine.randomIntegerIndex(START_FIND, END_FIND_BIG)];
        return listPlayers.get(indexWinAss).getPlayer();
    }
}
