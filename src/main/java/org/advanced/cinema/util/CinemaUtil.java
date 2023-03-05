package org.advanced.cinema.util;

import org.advanced.cinema.*;

import java.util.*;

import static org.advanced.cinema.util.TimeCounter.durationTimeCounter;

public class CinemaUtil {
    private static Cinema cinema = new Cinema();

    public static void addTestSchedules() {
        TreeMap<Days, Schedule> schedules = new TreeMap<>();

        Movie spiderMan = new Movie("SpiderMan", durationTimeCounter(93));
        Movie avatar = new Movie("Avatar", durationTimeCounter(127));
        Movie titanic = new Movie("Titanic", durationTimeCounter(105));
        Movie ironMan = new Movie("IronMan", durationTimeCounter(87));
        Movie someComedy = new Movie("Some Comedy", durationTimeCounter(81));
        Movie test = new Movie("TEST", durationTimeCounter(1));

        cinema.getMoviesLibrary().add(spiderMan);
        cinema.getMoviesLibrary().add(avatar);
        cinema.getMoviesLibrary().add(titanic);
        cinema.getMoviesLibrary().add(ironMan);
        cinema.getMoviesLibrary().add(someComedy);
        cinema.getMoviesLibrary().add(test);

        Time timForSeance1 = new Time(0, 9);
        Time timForSeance2 = new Time(30, 12);
        Time timForSeance3 = new Time(0, 15);
        Time timForSeance4 = new Time(15, 17);
        Time timForSeance5 = new Time(0, 19);

        //Monday
        Schedule scheduleMonday = new Schedule();
        Set<Seance> seancesMonday = new TreeSet<>();
        seancesMonday.add(new Seance(spiderMan, timForSeance1));
        seancesMonday.add(new Seance(avatar, timForSeance2));
        seancesMonday.add(new Seance(titanic, timForSeance3));
        seancesMonday.add(new Seance(ironMan, timForSeance4));
        seancesMonday.add(new Seance(someComedy, timForSeance5));

        scheduleMonday.setSeances(seancesMonday);
        schedules.put(Days.MONDAY, scheduleMonday);

        //Tuesday
        Schedule scheduleTuesday = new Schedule();
        Set<Seance> seancesTuesday = new TreeSet<>();
        seancesTuesday.add(new Seance(titanic, timForSeance1));
        seancesTuesday.add(new Seance(ironMan, timForSeance2));
        seancesTuesday.add(new Seance(spiderMan, timForSeance3));
        seancesTuesday.add(new Seance(avatar, timForSeance4));
        seancesTuesday.add(new Seance(someComedy, timForSeance5));

        scheduleTuesday.setSeances(seancesTuesday);
        schedules.put(Days.TUESDAY, scheduleTuesday);

        //Wednesday
        Schedule scheduleWednesday = new Schedule();
        Set<Seance> seancesWednesday = new TreeSet<>();
        seancesWednesday.add(new Seance(someComedy, timForSeance1));
        seancesWednesday.add(new Seance(avatar, timForSeance2));
        seancesWednesday.add(new Seance(titanic, timForSeance3));
        seancesWednesday.add(new Seance(ironMan, timForSeance4));
        seancesWednesday.add(new Seance(spiderMan, timForSeance5));

        scheduleWednesday.setSeances(seancesWednesday);
        schedules.put(Days.WEDNESDAY, scheduleWednesday);

        cinema.setSchedules(schedules);
    }

    public static void addMovie() {
        System.out.println("Enter movie`s title");

        Scanner console = new Scanner(System.in);
        String title = console.nextLine();

        System.out.println("Enter movie`s duration in minutes");
        Time durationTime = durationTimeCounter(console.nextInt());

        cinema.addMovie(new Movie(title, durationTime));
    }

    public static void addSeance() {
        System.out.println("Enter movie`s title for new seance.");

        Scanner console = new Scanner(System.in);
        String title = console.nextLine();

        Scanner console2 = new Scanner(System.in);
        System.out.println("Enter hour for start seance");
        int startHour = console2.nextInt();


        System.out.println("Enter min for start seance");
        int startMin = console2.nextInt();

        Scanner console3 = new Scanner(System.in);
        System.out.println("Enter day`s name when new seance will start.");
        String day = console3.nextLine();

        cinema.addSeance(
                new Seance(
                        cinema.getMoviesLibrary().get(findMoviesIndex(title)),
                        new Time(startMin, startHour)),
                day);
    }

    public static void removeMovie() {
        System.out.println("Enter movie`s title you want to remove.");

        Scanner console = new Scanner(System.in);
        String title = console.nextLine();

        cinema.removeMovie(cinema.getMoviesLibrary().get(findMoviesIndex(title)));
    }

    public static void  removeSeance() {
        System.out.println("Enter movie`s title for seance you want to remove.");

        Scanner console = new Scanner(System.in);
        String title = console.nextLine();

        System.out.println("Enter day`s name when seance will start.");
        String day = console.nextLine();

        cinema.removeSeance(
                findSeance(title, day),
                day);
    }

    public static void printAllSchedulesForDay() {
        System.out.println("Enter schedules day.");

        Scanner console = new Scanner(System.in);
        String day = console.nextLine();

        Days daySchedules = Days.valueOf(day.toUpperCase());
        cinema.getSchedules().get(daySchedules).getSeances()
                .forEach(System.out::println);
    }

    public static void printAllSchedules() {
        System.out.println(cinema.getSchedules().get(Days.MONDAY));
        System.out.println(cinema.getSchedules().get(Days.TUESDAY));
        System.out.println(cinema.getSchedules().get(Days.WEDNESDAY));
        System.out.println(cinema.getSchedules().get(Days.THURSDAY));
        System.out.println(cinema.getSchedules().get(Days.FRIDAY));
        System.out.println(cinema.getSchedules().get(Days.SATURDAY));
        System.out.println(cinema.getSchedules().get(Days.SUNDAY));
    }

    public static void printMoviesList() {
        cinema.getMoviesLibrary()
                .forEach(System.out::println);
    }

    public static int findMoviesIndex(String movieTitle) {
        for (int i = 0; i < cinema.getMoviesLibrary().size(); i++) {
            String currentTitle = cinema.getMoviesLibrary().get(i).getTitle();
            if (currentTitle.equalsIgnoreCase(movieTitle)) {
                return i;
            }
        }
        throw new IllegalArgumentException("The movie not found");
    }

    public static int findMoviesIndexInCinema(String movieTitle, Cinema cinema) {
        for (int i = 0; i < cinema.getMoviesLibrary().size(); i++) {
            String currentTitle = cinema.getMoviesLibrary().get(i).getTitle();
            if (currentTitle.equalsIgnoreCase(movieTitle)) {
                return i;
            }
        }
        throw new IllegalArgumentException("The movie not found");
    }

    private static Seance findSeance(String movieTitle, String day) {
        Days dayForSeance = Days.valueOf(day.toUpperCase());
        Set<Seance> seances = cinema.getSchedules().get(dayForSeance).getSeances();
        Iterator<Seance> iterator = seances.iterator();
        while (iterator.hasNext()) {
            Seance seanceCurrent = iterator.next();
            if (seanceCurrent.getMovie().getTitle().equalsIgnoreCase(movieTitle)) {
                return seanceCurrent;
            }
        }
        throw new NullPointerException();
    }

    public static Seance findSeanceWithCinema(String movieTitle, String day, Cinema cinema) {
        Days dayForSeance = Days.valueOf(day.toUpperCase());
        Set<Seance> seances = cinema.getSchedules().get(dayForSeance).getSeances();
        Iterator<Seance> iterator = seances.iterator();
        while (iterator.hasNext()) {
            Seance seanceCurrent = iterator.next();
            if (seanceCurrent.getMovie().getTitle().equalsIgnoreCase(movieTitle)) {
                return seanceCurrent;
            }
        }
        throw new NullPointerException();
    }
}
