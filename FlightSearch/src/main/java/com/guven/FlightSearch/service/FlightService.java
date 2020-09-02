package com.guven.FlightSearch.service;

import com.guven.FlightSearch.database.FlightDatabase;
import com.guven.FlightSearch.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightDatabase database;

    @Autowired
    public FlightService(@Qualifier("Database") FlightDatabase database) {
        this.database = database;
    }

    public boolean addFlight(Flight flight){
        return database.addFlight(flight);
    }

    public List<Flight> getAllFlights() {
        return database.getAllFlights();
    }

    public Flight getNearestFlight(Flight flight) {
        return database.getNearestFlight(flight);
    }
}
