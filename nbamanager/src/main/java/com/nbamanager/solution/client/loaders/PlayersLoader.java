package com.nbamanager.solution.client.loaders;

import com.nbamanager.solution.dao.FactoryDB;
import com.nbamanager.solution.entity.Player;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artem
 */
public class PlayersLoader {
    // TODO: add new algorithm for get data by team!!!
    public List<Player> getPlayersByTeam(String team){
        List<Player> allPlayers;
        List<Player> teamPlayers = new ArrayList<Player>();
        try {
            allPlayers = FactoryDB.getInstance().getPlayerDAO().getAllData();
            for (Player pl : allPlayers) {
                if(pl.getTeam().getName().equalsIgnoreCase(team)){
                    teamPlayers.add(pl);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayersLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teamPlayers;
    }
}
