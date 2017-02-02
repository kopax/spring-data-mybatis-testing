package org.springframework.data.mybatis.samples.reservation;

import org.springframework.data.mybatis.annotations.Entity;
import org.springframework.data.mybatis.domains.LongId;

/**
 * Created by dka on 2/2/17.
 */
@Entity
public class Reservation extends LongId {

	private String reservationName;

	public Reservation() {
	}

	public Reservation(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationName() {
		return reservationName;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"reservationName='" + reservationName + '\'' +
				'}';
	}
}