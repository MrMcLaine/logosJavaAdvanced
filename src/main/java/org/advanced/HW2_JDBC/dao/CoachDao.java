package org.advanced.HW2_JDBC.dao;

import org.advanced.HW2_JDBC.gym.Client;
import org.advanced.HW2_JDBC.gym.Coach;
import org.advanced.HW2_JDBC.util.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachDao extends AbstractDao {
    private static final String READ_ALL = "SELECT * FROM coach";
    private static final String READ_BY_ID = "SELECT * FROM coach WHERE id = ?";
    private static final String READ_BY_NAME = "SELECT * FROM coach WHERE first_name = ? AND last_name = ?";
    private static final String CREATE = "INSERT INTO coach(first_name, last_name) VALUES (?, ?)";
    private static final String UPDATE_BY_ID = "UPDATE coach SET first_name = ?, last_name = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM coach WHERE id = ?";


    public CoachDao(Connection connection) {
        super(connection);
    }

    public static List<Coach> readAll() throws SQLException {
        List<Coach> resultList = new ArrayList<>();
        init(READ_ALL);
        ResultSet result = prStat.executeQuery();

        while (result.next()) {
            resultList.add(Mapper.mapCoach(result));
        }
        return resultList;
    }

    public static Coach readById(int id) throws SQLException {
        init(READ_BY_ID);
        prStat.setInt(1, id);
        ResultSet result = prStat.executeQuery();
        result.next();
        return Mapper.mapCoach(result);
    }

    public static Client readByName(String firstName, String lastName) throws SQLException {
        init(READ_BY_NAME);
        prStat.setString(1, firstName);
        prStat.setString(2, lastName);
        ResultSet result = prStat.executeQuery();
        result.next();
        return Mapper.mapClient(result);
    }

    public static void create(Coach coach) throws SQLException {
        init(CREATE);
        prStat.setString(1, coach.getFirstName());
        prStat.setString(2, coach.getLastName());
        prStat.executeUpdate();
    }

    public static void update(Coach coach) throws SQLException {
        init(UPDATE_BY_ID);
        prStat.setString(1, coach.getFirstName());
        prStat.setString(2, coach.getLastName());
        prStat.setInt(3, coach.getId());
        prStat.executeUpdate();
    }

    public static void delete(int id) throws SQLException {
        init(DELETE_BY_ID);
        prStat.setInt(1, id);
        prStat.executeUpdate();
    }

    private static void init(String sqlMessage) throws SQLException {
        prStat = connection.prepareStatement(sqlMessage);
    }
}
