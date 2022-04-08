package org.hyperskill.cinemarestservice;

public class Ticket {
    private Seat seat;

    public Ticket(Seat seat) {
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }
}