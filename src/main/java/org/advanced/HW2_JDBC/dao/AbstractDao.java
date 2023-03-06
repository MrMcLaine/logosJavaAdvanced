package org.advanced.HW2_JDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AbstractDao {
    protected static Connection connection;
    protected static PreparedStatement prStat;

    public AbstractDao(Connection connection) {
        AbstractDao.connection = connection;
    }
}
