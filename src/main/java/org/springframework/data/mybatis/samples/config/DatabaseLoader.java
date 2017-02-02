package org.springframework.data.mybatis.samples.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mybatis.samples.reservation.Reservation;
import org.springframework.data.mybatis.samples.reservation.ReservationRepository;
//import org.springframework.data.mybatis.samples.security.SiteService;
//import org.springframework.data.mybatis.samples.security.SiteServiceRepository;

@Configuration
public class DatabaseLoader implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

	private final ReservationRepository reservationRepository;
//	private final SiteServiceRepository siteServiceRepository;

	@Autowired
	public DatabaseLoader(
		ReservationRepository reservationRepository
//		SiteServiceRepository siteServiceRepository
	) {
		this.reservationRepository = reservationRepository;
//		this.siteServiceRepository = siteServiceRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		try {
			reservationRepository.save(new Reservation("Tom"));
			reservationRepository.save(new Reservation("Jack"));
			reservationRepository.save(new Reservation("Apple"));

//			siteServiceRepository.save(new SiteService("User service"));
//			siteServiceRepository.save(new SiteService("Reservation service"));
		} catch(Exception e) {
			logger.error("Can't load database data because of " + e.getMessage());
			throw e;
		}
	}

}