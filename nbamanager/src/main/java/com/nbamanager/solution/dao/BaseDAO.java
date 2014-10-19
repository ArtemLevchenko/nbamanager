package com.nbamanager.solution.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Artem
 */
public interface BaseDAO<T> {
  public void addData(T data) throws SQLException;
  public void updateData(T data) throws SQLException;
  public T getDataById(int id) throws SQLException;
  public List<T> getAllData() throws SQLException;
  public void deleteData(T data) throws SQLException;
  public List<T> getDataByTeam(String name) throws SQLException;
}
