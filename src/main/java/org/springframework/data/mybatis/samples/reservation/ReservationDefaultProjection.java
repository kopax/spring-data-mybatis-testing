package org.springframework.data.mybatis.samples.reservation;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by dka on 2/2/17.
 */
@Projection(name = "reservationPj", types = { Reservation.class })
public interface ReservationDefaultProjection {

	Long getId();

	String getReservationName();

}