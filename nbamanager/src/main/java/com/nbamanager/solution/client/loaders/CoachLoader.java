package com.nbamanager.solution.client.loaders;

import com.nbamanager.solution.dao.FactoryDB;
import com.nbamanager.solution.entity.Coach;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artem
 */
public class CoachLoader {
    // TODO: add new algorithm for get data by team!!!
    public Coach getPlayersByTeam(String team){
        List<Coach> allCoachs;
        Coach result = new Coach();
        try {
            allCoachs = FactoryDB.getInstance().getCoachDAO().getAllData();
            for (Coach ch : allCoachs) {
                if(ch.getTeam().getName().equalsIgnoreCase(team)){
                    result = ch;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoachLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
