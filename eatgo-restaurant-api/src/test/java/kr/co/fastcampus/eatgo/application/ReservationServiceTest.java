package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Reservation;
import kr.co.fastcampus.eatgo.domain.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ReservationServiceTest {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getReservations() {

        long restaurantId = 1004L;
        List<Reservation> reservations =  reservationService.getReservations(restaurantId);

        verify(reservationRepository).findAllByRestaurantId(restaurantId);
    }
}