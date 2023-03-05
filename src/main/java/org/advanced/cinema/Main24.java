package org.advanced.cinema;

import java.util.Scanner;

import static java.lang.System.exit;
import static org.advanced.cinema.util.CinemaUtil.*;

public class Main24 {
    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    private static final String[] options = {
            "1 - to add a movie.",
            "2 - to add a seance.",
            "3 - to remove movie",
            "4 - to remove seance",
            "5 - to print all schedules for day",
            "6 - to print all schedules ",
            "7 - to print movies list",
            "0 - to exit."
    };

    public static void main(String[] args) {

        addTestSchedules();

        Scanner console = new Scanner(System.in);

        int option = 1;
        while (option != 0) {
            printMenu(options);
            try {
                option = console.nextInt();
                switch (option) {
                    case 1 -> addMovie();
                    case 2 -> addSeance();
                    case 3 -> removeMovie();
                    case 4 -> removeSeance();
                    case 5 -> printAllSchedulesForDay();
                    case 6 -> printAllSchedules();
                    case 7 -> printMoviesList();
                    case 0 -> exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                console.next();
            }
        }
    }
}
