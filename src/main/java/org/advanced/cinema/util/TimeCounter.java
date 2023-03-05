package org.advanced.cinema.util;

import org.advanced.cinema.Time;

public class TimeCounter {
    public static Time timeCounter(Time start, Time duration) {
        int sumOfMinToStart = start.getHour() * 60 + start.getMin();
        int sumOfMinForMovie = duration.getHour() * 60 + duration.getMin();
        int sumOfMin = sumOfMinToStart + sumOfMinForMovie;

        if (sumOfMin <= 1440) {
            int hour = sumOfMin / 60;
            int min = sumOfMin - (hour * 60);
            return new Time(min, hour);
        } else {
            sumOfMin -= 1440;
            int hour = sumOfMin / 60;
            int min = sumOfMin - (hour * 60);
            return new Time(min, hour);
        }
    }

    public static Time durationTimeCounter(int minutes) {
        int hours = minutes / 60;
        int min = minutes - (hours * 60);
        return new Time(min, hours);
    }
}
