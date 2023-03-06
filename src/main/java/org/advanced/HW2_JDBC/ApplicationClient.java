package org.advanced.HW2_JDBC;

import org.advanced.HW2_JDBC.dao.ClientDao;
import org.advanced.HW2_JDBC.gym.Client;
import org.advanced.HW2_JDBC.util.ConnectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class ApplicationClient {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        new ClientDao(ConnectionUtil.openConnection());
        Client createdClient = new Client("TestFirstName", "TestLastName");
        Client updatedClient = new Client(3, "UpdatedFirstName", "UpdatedLastName");

//readAll
        readAllAndPrintln();

//readById
        System.out.println(ClientDao.readById(2));
        System.out.println("*************************************************\n");

//readByName
        System.out.println(ClientDao.readByName("Dima", "Monatik"));
        System.out.println("*************************************************\n");

//create
        ClientDao.create(createdClient);
        readAllAndPrintln();

//update
        ClientDao.update(updatedClient);
        readAllAndPrintln();

//delete
        ClientDao.delete(3);
        readAllAndPrintln();
    }

    private static void readAllAndPrintln() throws SQLException {
        ClientDao.readAll()
                .forEach(System.out::println);
        System.out.println("*************************************************\n");
    }
}

