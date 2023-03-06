package org.advanced.HW2_JDBC.dao;

import org.advanced.HW2_JDBC.gym.Client;
import org.advanced.HW2_JDBC.util.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao extends AbstractDao {
    private static final String READ_ALL = "SELECT * FROM client";
    private static final String READ_BY_ID = "SELECT * FROM client WHERE id = ?";
    private static final String READ_BY_NAME = "SELECT * FROM client WHERE first_name = ? AND last_name = ?";
    private static final String CREATE = "INSERT INTO client(first_name, last_name) VALUES (?, ?)";
    private static final String UPDATE_BY_ID = "UPDATE client SET first_name = ?, last_name = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM client WHERE id = ?";


    public ClientDao(Connection connection) {
        super(connection);
    }

    public static List<Client> readAll() throws SQLException {
        List<Client> resultList = new ArrayList<>();
        init(READ_ALL);
        ResultSet result = prStat.executeQuery();

        while (result.next()) {
            resultList.add(Mapper.mapClient(result));
        }
        return resultList;
    }

    public static Client readById(int id) throws SQLException {
        init(READ_BY_ID);
        prStat.setInt(1, id);
        ResultSet result = prStat.executeQuery();
        result.next();
        return Mapper.mapClient(result);
    }

    public static Client readByName(String firstName, String lastName) throws SQLException {
        init(READ_BY_NAME);
        prStat.setString(1, firstName);
        prStat.setString(2, lastName);
        ResultSet result = prStat.executeQuery();
        result.next();
        return Mapper.mapClient(result);
    }

    public static void create(Client client) throws SQLException {
        init(CREATE);
        prStat.setString(1, client.getFirstName());
        prStat.setString(2, client.getLastName());
        prStat.executeUpdate();
    }

    public static void update(Client client) throws SQLException {
        init(UPDATE_BY_ID);
        prStat.setString(1, client.getFirstName());
        prStat.setString(2, client.getLastName());
        prStat.setInt(3, client.getId());
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
