package org.advanced.cinema.util;

import org.advanced.cinema.AbstractCinemaTest;
import org.advanced.cinema.Days;
import org.advanced.cinema.Movie;
import org.advanced.cinema.Schedule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.advanced.CinemaTestData.*;

public class CinemaUtilTest extends AbstractCinemaTest {

    @Override
    public void beforeTest() {
        super.beforeTest();
        addTestData();
    }

    @Test
    public void printAllSchedulesForDay() {
        Schedule mondaySchedule = new Schedule();
        mondaySchedule.setSeances(SEANCES_MONDAY);

        Assert.assertEquals(cinema.getSchedules().get(Days.MONDAY), mondaySchedule);
    }

    @Test
    public void printAllSchedules() {
        Schedule mondaySchedule = new Schedule();
        Schedule tuesdaySchedule = new Schedule();
        mondaySchedule.setSeances(SEANCES_MONDAY);
        tuesdaySchedule.setSeances(SEANCES_TUESDAY);
        TreeMap<Days, Schedule> schedules = new TreeMap<>();
        schedules.put(Days.MONDAY, mondaySchedule);
        schedules.put(Days.TUESDAY, tuesdaySchedule);
        Assert.assertEquals(cinema.getSchedules(), schedules);
    }

    @Test
    public void printMoviesList() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(SPIDER_MAN);
        movies.add(TITANIC);
        movies.add(IRON_MAN);
        movies.add(SOME_COMEDY);
        cinema.setMoviesLibrary(movies);
        Assert.assertEquals(cinema.getMoviesLibrary(), movies);
    }

    private void addTestData() {
        Schedule mondaySchedule = new Schedule();
        Schedule tuesdaySchedule = new Schedule();
        mondaySchedule.setSeances(SEANCES_MONDAY);
        tuesdaySchedule.setSeances(SEANCES_TUESDAY);

        TreeMap<Days, Schedule> schedules = new TreeMap<>();
        schedules.put(Days.MONDAY, mondaySchedule);
        schedules.put(Days.TUESDAY, tuesdaySchedule);

        cinema.setSchedules(schedules);
    }
}