package com.udea.graphqludea1.service;

import com.udea.graphqludea1.entity.Flight;
import com.udea.graphqludea1.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

private final FlightRepository flightRepository;


    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id){
        return flightRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
    }

    public Flight addFlight(String flightNumber, int seatsAvailable, String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightNumber);
        flight.setSeatsAvailable(seatsAvailable);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
       return flightRepository.save(flight);
    }


}
