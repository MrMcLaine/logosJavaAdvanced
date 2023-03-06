package org.advanced.HW2_JDBC.util;

import org.advanced.HW2_JDBC.gym.Client;
import org.advanced.HW2_JDBC.gym.Coach;
import org.advanced.HW2_JDBC.gym.ExerciseMachine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {

    public static Client mapClient(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");

        return new Client(id, firstName, lastName);
    }

    public static Coach mapCoach(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");

        return new Coach(id, firstName, lastName);
    }

    public static ExerciseMachine mapEM(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String name = result.getString("name");
        int weight = result.getInt("weight");
        int number = result.getInt("number");

        return new ExerciseMachine(id, name, weight, number);
    }
}
