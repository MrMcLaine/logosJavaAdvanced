package org.advanced.HW2_JDBC;

import org.advanced.HW2_JDBC.dao.ExerciseMachineDao;
import org.advanced.HW2_JDBC.gym.ExerciseMachine;
import org.advanced.HW2_JDBC.util.ConnectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class ApplicationExerciseMachine {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        new ExerciseMachineDao(ConnectionUtil.openConnection());
        ExerciseMachine createdEM = new ExerciseMachine("TestName", 99);
        ExerciseMachine updatedEM = new ExerciseMachine(4, "UpdatedName", 88, 2);

//readAll
        readAllAndPrintln();

//readById
        System.out.println(ExerciseMachineDao.readById(2));
        System.out.println("*************************************************\n");

//readByName
        System.out.println(ExerciseMachineDao.readByName("Smith"));
        System.out.println("*************************************************\n");

//create
        ExerciseMachineDao.create(createdEM);
        readAllAndPrintln();

//update
        ExerciseMachineDao.update(updatedEM);
        readAllAndPrintln();

//delete
        ExerciseMachineDao.delete(3);
        readAllAndPrintln();
    }

    private static void readAllAndPrintln() throws SQLException {
        ExerciseMachineDao.readAll()
                .forEach(System.out::println);
        System.out.println("*************************************************\n");
    }
}

