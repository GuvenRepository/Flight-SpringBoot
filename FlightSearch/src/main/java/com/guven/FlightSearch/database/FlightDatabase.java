package com.guven.FlightSearch.database;

import com.guven.FlightSearch.model.Flight;
import org.springframework.stereotype.Repository;

import java.io.Console;
import java.security.PublicKey;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository("Database")
public class FlightDatabase {
    private static List<Flight> flights = new ArrayList<>();
    private static int idCounter = 0;

    public boolean addFlight(Flight flight){
        try {
            Flight newFlight = new Flight(idCounter,    flight.getWhereFrom(),
                                                        flight.getWhereTo(),
                                                        flight.getDepartureDate(),
                                                        flight.getPrice(),
                                                        flight.getDuration());
            idCounter++;
            flights.add(newFlight);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public List<Flight> getAllFlights() {
        return flights;
    }

    public Flight getNearestFlight(Flight flight){

        Flight nearestFlight = null;
        for (Flight f: flights) {
            if (    f.getWhereFrom().equals(flight.getWhereFrom()) &&
                    f.getWhereTo().equals(flight.getWhereTo()) &&
                    f.getDepartureDate().isAfter(flight.getDepartureDate())){
                if (nearestFlight == null){
                    nearestFlight = f;
                }
                else{

                    long differenceWithCurrentMinimum = ChronoUnit.DAYS.between(flight.getDepartureDate(), nearestFlight.getDepartureDate());
                    long differenceWithTheNextFlight = ChronoUnit.DAYS.between(flight.getDepartureDate(), f.getDepartureDate());

                    if( differenceWithCurrentMinimum > differenceWithTheNextFlight){
                        nearestFlight = f;
                    }
                }
            }
        }
        return nearestFlight;
    }
}
