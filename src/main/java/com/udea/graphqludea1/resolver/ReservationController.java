package com.udea.graphqludea1.resolver;

import com.udea.graphqludea1.entity.Reservation;
import com.udea.graphqludea1.service.ReservationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {
//private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @MutationMapping
    public Reservation reserveFlight(@Argument Long flightId, @Argument String passengerName, @Argument String seatNumber) {
        return reservationService.reserveFlight(flightId, passengerName, seatNumber);
    }

}
