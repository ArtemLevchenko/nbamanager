package com.nbamanager.solution.dao;

import com.nbamanager.solution.entity.Player;
import com.nbamanager.solution.utils.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Artem
 */
public class PlayerDAOImpl implements BaseDAO<Player> {

    public void addData(Player data) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(data);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateData(Player data) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(data);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Player getDataById(int id) throws SQLException {
        Session session = null;
        Player player = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            player = (Player) session.load(Player.class, id);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return player;
    }

    public List<Player> getAllData() throws SQLException {
        Session session = null;
        List<Player> players = new ArrayList<Player>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            players = session.createCriteria(Player.class).list();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return players;
    }

    public void deleteData(Player data) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(data);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Player> getDataByTeam(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
