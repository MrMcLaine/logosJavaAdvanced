package org.advanced.HW2_JDBC.dao;

import org.advanced.HW2_JDBC.gym.ExerciseMachine;
import org.advanced.HW2_JDBC.util.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseMachineDao extends AbstractDao {
    private static final String READ_ALL = "SELECT * FROM exercise_machine";
    private static final String READ_BY_ID = "SELECT * FROM exercise_machine WHERE id = ?";
    private static final String READ_BY_NAME = "SELECT * FROM exercise_machine WHERE name = ?";
    private static final String CREATE = "INSERT INTO exercise_machine(name, weight) VALUES (?, ?)";
    private static final String UPDATE_BY_ID = "UPDATE exercise_machine SET " + "name = ?, weight = ?, number = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM exercise_machine WHERE id = ?";


    public ExerciseMachineDao(Connection connection) {
        super(connection);
    }

    public static List<ExerciseMachine> readAll() throws SQLException {
        List<ExerciseMachine> resultList = new ArrayList<>();
        init(READ_ALL);
        ResultSet result = prStat.executeQuery();

        while (result.next()) {
            resultList.add(Mapper.mapEM(result));
        }
        return resultList;
    }

    public static ExerciseMachine readById(int id) throws SQLException {
        init(READ_BY_ID);
        prStat.setInt(1, id);
        ResultSet result = prStat.executeQuery();
        result.next();
        return Mapper.mapEM(result);
    }

    public static ExerciseMachine readByName(String name) throws SQLException {
        init(READ_BY_NAME);
        prStat.setString(1, name);
        ResultSet result = prStat.executeQuery();
        result.next();
        return Mapper.mapEM(result);
    }

    public static void create(ExerciseMachine em) throws SQLException {
        init(CREATE);
        prStat.setString(1, em.getName());
        prStat.setInt(2, em.getWeight());
        prStat.executeUpdate();
    }

    public static void update(ExerciseMachine em) throws SQLException {
        init(UPDATE_BY_ID);
        prStat.setString(1, em.getName());
        prStat.setInt(2, em.getWeight());
        prStat.setInt(3, em.getNumber());
        prStat.setInt(4, em.getId());
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
