package org.advanced.cinema;

import static org.advanced.cinema.util.Validate.hourIsValid;
import static org.advanced.cinema.util.Validate.minIsValid;

public class Time {
    private int min;
    private int hour;

    public Time(int min, int hour) {
        if (minIsValid(min) && hourIsValid(hour)) {
            this.min = min;
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("Wrong time`s data");
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        if (minIsValid(min)) {
            this.min = min;
        } else {
            throw new IllegalArgumentException("Wrong min`s data");
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hourIsValid(hour)) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("Wrong hour`s data");
        }
    }

    @Override
    public String toString() {
        return "Time{" +
                "min=" + min +
                ", hour=" + hour +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time time)) return false;

        if (getMin() != time.getMin()) return false;
        return getHour() == time.getHour();
    }

    @Override
    public int hashCode() {
        int result = getMin();
        result = 31 * result + getHour();
        return result;
    }
}
