package org.hyperskill.cinemarestservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("9")
    private int rows;
    @Value("9")
    private int columns;

    @Bean
    public int getRows() {
        return rows;
    }

    @Bean
    public int getColumns() {
        return columns;
    }

    @Bean
    public Seats createSeats(@Qualifier("getRows") int rows, @Qualifier("getColumns") int columns) {
        List<Seat> availableSeats = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (i <= 4) {
                    availableSeats.add(new Seat(i, j, 10));
                } else {
                    availableSeats.add(new Seat(i, j, 8));
                }

            }
        }
        return new Seats(rows, columns, availableSeats);
    }
}
