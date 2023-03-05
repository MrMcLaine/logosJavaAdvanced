package org.advanced;

import org.advanced.cinema.*;

import java.util.*;

import static org.advanced.cinema.util.TimeCounter.durationTimeCounter;

public class CinemaTestData {

    public static final String MONDAY_FOR_MOVIE = "monday";
    public static final String TITLE_SPIDER_MAN = "SpiderMan";
    public static final Movie SPIDER_MAN = new Movie(TITLE_SPIDER_MAN, durationTimeCounter(93));
    public static final Movie AVATAR = new Movie("Avatar", durationTimeCounter(127));
    public static final Movie TITANIC = new Movie("Titanic", durationTimeCounter(105));
    public static final Movie IRON_MAN = new Movie("IronMan", durationTimeCounter(87));
    public static final Movie SOME_COMEDY = new Movie("Some Comedy", durationTimeCounter(81));

    public static final Time TIM_FOR_SEANCE_1 = new Time(0, 9);
    public static final Time TIM_FOR_SEANCE_2 = new Time(30, 12);
    public static final Time TIM_FOR_SEANCE_3 = new Time(0, 15);
    public static final Time TIM_FOR_SEANCE_4 = new Time(15, 17);
    public static final Time TIM_FOR_SEANCE_5 = new Time(0, 19);
    public static final Seance SEANCE_WITH_SPIDERMAN = new Seance(SPIDER_MAN, TIM_FOR_SEANCE_1);
    public static Schedule scheduleWithSpiderman = new Schedule(SEANCE_WITH_SPIDERMAN);


    //Monday
    public static final Set<Seance> SEANCES_MONDAY = Set.of(
            new Seance(SPIDER_MAN, TIM_FOR_SEANCE_1),
            new Seance(AVATAR, TIM_FOR_SEANCE_2),
            new Seance(TITANIC, TIM_FOR_SEANCE_3),
            new Seance(IRON_MAN, TIM_FOR_SEANCE_4),
            new Seance(SOME_COMEDY, TIM_FOR_SEANCE_5)
    );

    //Tuesday
    public static final Set<Seance> SEANCES_TUESDAY = Set.of(
            new Seance(TITANIC, TIM_FOR_SEANCE_1),
            new Seance(IRON_MAN, TIM_FOR_SEANCE_2),
            new Seance(SPIDER_MAN, TIM_FOR_SEANCE_3),
            new Seance(AVATAR, TIM_FOR_SEANCE_4),
            new Seance(SOME_COMEDY, TIM_FOR_SEANCE_5)
    );
}
