package com.nbamanager.solution.dao;

import com.nbamanager.solution.entity.Coach;
import com.nbamanager.solution.utils.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Artem
 */
public class CoachDAOImpl implements BaseDAO<Coach>{

   public void addData(Coach data) throws SQLException {
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

    public void updateData(Coach data) throws SQLException {
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

    public Coach getDataById(int id) throws SQLException {
        Session session = null;
        Coach coach = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            coach = (Coach) session.load(Coach.class, id);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return coach;
    }

    public List<Coach> getAllData() throws SQLException {
        Session session = null;
        List<Coach> players = new ArrayList<Coach>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            players = session.createCriteria(Coach.class).list();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return players;
    }

    public void deleteData(Coach data) throws SQLException {
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

    public List<Coach> getDataByTeam(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
