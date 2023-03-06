package org.advanced.HW2_JDBC;

import org.advanced.HW2_JDBC.dao.CoachDao;
import org.advanced.HW2_JDBC.gym.Coach;
import org.advanced.HW2_JDBC.util.ConnectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class ApplicationCoach {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        new CoachDao(ConnectionUtil.openConnection());
        Coach createdCoach = new Coach("TestFirstName", "TestLastName");
        Coach updatedCoach = new Coach(3, "UpdatedFirstName", "UpdatedLastName");

//readAll
        readAllAndPrintln();

//readById
        System.out.println(CoachDao.readById(2));
        System.out.println("*************************************************\n");

//readByName
        System.out.println(CoachDao.readByName("Will", "Smith"));
        System.out.println("*************************************************\n");

//create
        CoachDao.create(createdCoach);
        readAllAndPrintln();

//update
        CoachDao.update(updatedCoach);
        readAllAndPrintln();

//delete
        CoachDao.delete(3);
        readAllAndPrintln();
    }

    private static void readAllAndPrintln() throws SQLException {
        CoachDao.readAll()
                .forEach(System.out::println);
        System.out.println("*************************************************\n");
    }
}

