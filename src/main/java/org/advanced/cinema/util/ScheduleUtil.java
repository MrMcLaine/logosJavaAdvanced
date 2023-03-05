package org.advanced.cinema.util;

import org.advanced.cinema.Movie;
import org.advanced.cinema.Seance;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ScheduleUtil {
    public static boolean findSeance(Set<Seance> treeSet, Seance seance) {
        boolean findResult = false;
        Iterator<Seance> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Seance seanceCurrent = iterator.next();
            if (seanceCurrent == seance) {
                findResult = true;
            }
        }
        return findResult;
    }

    public static Set<Seance> setWithoutDeletedElement(Set<Seance> seances, Seance seance) {
        Set<Seance> seancesResult = new TreeSet<>();
        Iterator<Seance> iterator = seances.iterator();
        while (iterator.hasNext()) {
            Seance seanceCurrent = iterator.next();
            if (seanceCurrent != seance) {
                seancesResult.add(seanceCurrent);
            }
        }
        return seancesResult;
    }

    public static Set<Seance> setWithoutDeletedElement(Set<Seance> seances, Movie movie) {
        Set<Seance> seancesResult = new TreeSet<>();
        Iterator<Seance> iterator = seances.iterator();
        while (iterator.hasNext()) {
            Seance seanceCurrent = iterator.next();
            if (seanceCurrent.getMovie() != movie) {
                seancesResult.add(seanceCurrent);
            }
        }
        return seancesResult;
    }

    public static boolean findSeanceWithMovie(Set<Seance> seances, Movie movie) {
        boolean findResult = false;
        Iterator<Seance> iterator = seances.iterator();
        while (iterator.hasNext()) {
            Seance seanceCurrent = iterator.next();
            if (seanceCurrent.getMovie().equals(movie)) {
                findResult = true;
            }
        }
        return findResult;
    }

}
