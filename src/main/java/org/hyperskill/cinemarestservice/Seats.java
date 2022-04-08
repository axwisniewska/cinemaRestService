package org.hyperskill.cinemarestservice;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Seats {
    @JsonProperty
    private int totalRows;
    @JsonProperty
    private int totalColumns;
    @JsonProperty
    private List<Seat> availableSeats;

    public Seats(int totalRows, int totalColumns, List<Seat> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }

    public Seats() {
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
