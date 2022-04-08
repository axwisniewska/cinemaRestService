package org.hyperskill.cinemarestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeatService {
    private final Seats seats;
    private final Map<String, List<Seat>> takenSeatsMap = new HashMap<>();

    public SeatService(@Autowired Seats seats) {
        this.seats = seats;

        takenSeatsMap.put("available", seats.getAvailableSeats());
    }


    public Seats getSeats() {
        return seats;
    }

    public Ticket purchaseTicket(Seat seat) {
        if (seat.getRow() > seats.getTotalRows() || seat.getRow() <= 0) {
            throw new IllegalArgumentException("The number of a row or a column is out of bounds!");
        }
        if (seat.getColumn() > seats.getTotalColumns() || seat.getColumn() <= 0) {
            throw new IllegalArgumentException("The number of a row or a column is out of bounds!");
        }

        Seat tempSeat = calculateSeatPrice(seat);
        List<Seat> seats = takenSeatsMap.get("available");
        if (seats.contains(tempSeat)) {
            List<Seat> takenSeats = new ArrayList<>();
            seats.remove(tempSeat);
            takenSeats.add(tempSeat);
            takenSeatsMap.put("booked", takenSeats);
            return new Ticket(calculateSeatPrice(seat));
        } else {
            throw new IllegalArgumentException("The ticket has been already purchased!");
        }
    }

    private Seat calculateSeatPrice(Seat seat) {
        if (seat.getRow() <= 4) {
            return new Seat(seat.getRow(), seat.getColumn(), 10);
        } else {
            return new Seat(seat.getRow(), seat.getColumn(), 8);
        }
    }

}