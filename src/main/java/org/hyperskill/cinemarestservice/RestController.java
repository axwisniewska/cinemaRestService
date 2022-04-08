package org.hyperskill.cinemarestservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final SeatService seatService;

    public RestController(@Autowired SeatService seatService) {
        this.seatService = seatService;
    }


    @GetMapping("/seats")
    public Seats seats() {
        return seatService.getSeats();
    }


    @PostMapping("/pur")
    public void purchase(int row, int column){
    }
    @PostMapping("/purchase")
    public Seat purchaseSeat(@RequestBody Seat seat) {
        Ticket ticket = seatService.purchaseTicket(seat);
        if (Optional.of(ticket.getSeat()).isPresent()){
            return ticket.getSeat();
        } else
            return Optional.of(ticket.getSeat()).orElse(new Seat());
    }
}
