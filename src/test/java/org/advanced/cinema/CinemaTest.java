package org.advanced.cinema;

import org.junit.*;

import static org.advanced.CinemaTestData.*;
import static org.advanced.cinema.util.CinemaUtil.*;
import static org.advanced.cinema.util.CinemaUtil.findSeanceWithCinema;
import static org.advanced.cinema.util.TimeCounter.durationTimeCounter;

public class CinemaTest extends AbstractCinemaTest {

    @Test
    public void addMovie() {
        cinema.addMovie(new Movie("SpiderMan", durationTimeCounter(93)));
        Assert.assertEquals(cinema.getMoviesLibrary().get(0), SPIDER_MAN);
    }

    @Test
    public void addSeance() {
        cinema.addSeance(new Seance(SPIDER_MAN, TIM_FOR_SEANCE_1), MONDAY_FOR_MOVIE);
        Assert.assertEquals(cinema.getSchedules().get(Days.MONDAY), scheduleWithSpiderman);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeMovie() {
        cinema.addMovie(SPIDER_MAN);
        int indexMovies = findMoviesIndexInCinema(TITLE_SPIDER_MAN, cinema);
        cinema.removeMovie(cinema.getMoviesLibrary().get(indexMovies));
        Assert.assertNull(cinema.getMoviesLibrary().get(indexMovies));
    }

    @Test(expected = NullPointerException.class)
    public void removeSeance() {
        cinema.addSeance(new Seance(SPIDER_MAN, TIM_FOR_SEANCE_1), MONDAY_FOR_MOVIE);
        cinema.removeSeance(
                findSeanceWithCinema(TITLE_SPIDER_MAN, MONDAY_FOR_MOVIE, cinema),
                MONDAY_FOR_MOVIE);
        Assert.assertNull(findSeanceWithCinema(TITLE_SPIDER_MAN, MONDAY_FOR_MOVIE, cinema));
    }
}