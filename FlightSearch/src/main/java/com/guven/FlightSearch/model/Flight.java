package com.guven.FlightSearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Flight {
    private final int ID;
    private final String whereFrom;
    private final String whereTo;

    @JsonFormat(pattern="yyyy-MM-dd")
    private final LocalDate departureDate;
    private final int price;
    private final int duration;

    public Flight(@JsonProperty("id") int ID,
                  @JsonProperty("from") String whereFrom,
                  @JsonProperty("to") String whereTo,
                  @JsonProperty("date") LocalDate departureDate,
                  @JsonProperty("price") int price,
                  @JsonProperty("duration") int duration) {
        this.ID = ID;
        this.whereFrom = whereFrom;
        this.whereTo = whereTo;
        this.departureDate = departureDate;
        this.price = price;
        this.duration = duration;
    }


    public int getID() {
        return ID;
    }

    public String getWhereFrom() {
        return whereFrom;
    }

    public String getWhereTo() {
        return whereTo;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }
}
