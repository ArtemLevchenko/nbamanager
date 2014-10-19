package com.nbamanager.solution.dao;

/**
 *
 * @author Artem
 */
public class FactoryDB {

    private static BaseDAO basePlayerDAO = null;
    private static BaseDAO baseCoachDAO = null;
    private static FactoryDB instance = null;

    public static synchronized FactoryDB getInstance() {
        if (instance == null) {
            instance = new FactoryDB();
        }
        return instance;
    }

    public BaseDAO getPlayerDAO() {
        if (basePlayerDAO == null) {
            basePlayerDAO = new PlayerDAOImpl();
        }
        return basePlayerDAO;
    }
    
    public BaseDAO getCoachDAO() {
        if (baseCoachDAO == null) {
            baseCoachDAO = new CoachDAOImpl();
        }
        return baseCoachDAO;
    }
}
