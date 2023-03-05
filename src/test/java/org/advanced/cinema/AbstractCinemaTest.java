package org.advanced.cinema;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;

import java.util.TreeMap;

public abstract class AbstractCinemaTest {
    protected Cinema cinema;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        protected void failed(Throwable e, org.junit.runner.Description description) {
            System.out.println("FAILED ---> " + description.getMethodName());
        }

        protected void succeeded(org.junit.runner.Description description) {
            System.out.println("SUCCEED ---> " + description.getMethodName());

        }
    };

    @Before
    public void beforeTest() {
        cinema = new Cinema();
        cinema.setSchedules(new TreeMap<>());
    }

    @After
    public void afterTest() {
        cinema = null;
    }
}
