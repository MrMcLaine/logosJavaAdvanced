package org.advanced.cinema;

import java.util.Set;
import java.util.TreeSet;

import static org.advanced.cinema.util.ScheduleUtil.findSeance;
import static org.advanced.cinema.util.ScheduleUtil.setWithoutDeletedElement;

public class Schedule {
    private Set<Seance> seances = new TreeSet<>();

    public Schedule() {
    }

    public Schedule(Seance seance) {
        this.seances.add(seance);
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    public void setSeances(Set<Seance> seances) {
        this.seances = seances;
    }

    public void addSeance(Seance seance) {
        this.seances.add(seance);
    }

    public void removeSeance(Seance seance) {
        if (findSeance(seances, seance)) {
            Set<Seance> tempSet = setWithoutDeletedElement(seances, seance);
            seances.clear();
            setSeances(tempSet);
        }
    }

    public void removeSeanceWithMovie(Movie movie) {
        Set<Seance> tempSet = setWithoutDeletedElement(seances, movie);
        seances.clear();
        setSeances(tempSet);
    }

    @Override
    public String toString() {
        return "Schedule{" +
               "seances=" + seances +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule schedule)) return false;

        return getSeances() != null ? getSeances().equals(schedule.getSeances()) : schedule.getSeances() == null;
    }

    @Override
    public int hashCode() {
        return getSeances() != null ? getSeances().hashCode() : 0;
    }
}
