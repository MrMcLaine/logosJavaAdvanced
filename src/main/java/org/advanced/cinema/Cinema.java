package org.advanced.cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import static org.advanced.cinema.util.ScheduleUtil.findSeanceWithMovie;


public class Cinema {
    private TreeMap<Days, Schedule> schedules;

    private ArrayList<Movie> moviesLibrary = new ArrayList<>();

    private Time open;
    private Time close;

    public Cinema() {
    }

    public TreeMap<Days, Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(TreeMap<Days, Schedule> schedules) {
        this.schedules = schedules;
    }

    public ArrayList<Movie> getMoviesLibrary() {
        return moviesLibrary;
    }

    public void setMoviesLibrary(ArrayList<Movie> moviesLibrary) {
        this.moviesLibrary = moviesLibrary;
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public void addMovie(Movie movie) {
        moviesLibrary.add(movie);
    }

    public void addSeance(Seance seance, String day) {
        Days dayForSeance = Days.valueOf(day.toUpperCase());
        if(schedules.get(dayForSeance) == null) {
            schedules.put(dayForSeance, new Schedule());
        }
        schedules.get(dayForSeance).addSeance(seance);
    }

    public void removeMovie(Movie movie) {

        //remove from schedules

        List<Days> daysWithThisMovie = new ArrayList<>();
        Set<Days> days = schedules.keySet();
        for (Days day : days) {
            if (findSeanceWithMovie(schedules.get(day).getSeances(), movie)) {
                daysWithThisMovie.add(day);
            }
        }

        for (Days day : daysWithThisMovie) {
            schedules.get(day).removeSeanceWithMovie(movie);
        }

        //remove from moviesLibrary

        moviesLibrary.remove(movie);
    }

    public void removeSeance(Seance seance, String day) {
        Days dayForSeance = Days.valueOf(day.toUpperCase());
        schedules.get(dayForSeance).removeSeance(seance);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "schedules=" + schedules +
                ", moviesLibrary=" + moviesLibrary +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}
