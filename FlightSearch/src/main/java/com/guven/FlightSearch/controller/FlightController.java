package com.guven.FlightSearch.controller;

import com.guven.FlightSearch.model.Flight;
import com.guven.FlightSearch.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/flight")
@RestController
public class FlightController {
    private FlightService service;

    @Autowired
    public FlightController(FlightService service) {
        this.service = service;
    }

    @PostMapping
    public boolean addFlight(@RequestBody List<Flight> newFlights){
        for (Flight nf : newFlights) {
            if(!service.addFlight(nf))
                return false;
        }
        return true;
    }

    @GetMapping(value = "/all")
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping
    public Flight getNearestFlight(@RequestBody Flight flight) {
        return service.getNearestFlight(flight);
    }


}
