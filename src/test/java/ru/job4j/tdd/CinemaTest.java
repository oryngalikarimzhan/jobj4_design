package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date, session);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test(expected = Exception.class)
    public void cantBuySameSeat() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket1 = cinema.buy(account, 1, 1, date, session);
        Ticket ticket2 = cinema.buy(account, 1, 1, date, session);
    }

    @Test(expected = Exception.class)
    public void cantBuyNotExistingSeat() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1000, 1, date, session);
    }

    @Test(expected = Exception.class)
    public void cantBuyNotExistingSession() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date, new Session3D());
    }
}