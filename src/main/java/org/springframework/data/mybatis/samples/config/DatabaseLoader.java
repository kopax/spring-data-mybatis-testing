package org.springframework.data.mybatis.samples.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mybatis.samples.reservation.Reservation;
import org.springframework.data.mybatis.samples.reservation.ReservationRepository;
import org.springframework.data.mybatis.samples.security.*;
import org.springframework.stereotype.Component;
//import org.springframework.data.mybatis.samples.security.SiteService;
//import org.springframework.data.mybatis.samples.security.SiteServiceRepository;

@Configuration
public class DatabaseLoader implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

	private final ReservationRepository reservationRepository;
	private final SiteServiceRepository siteServiceRepository;
	private final SiteFunctionRepository siteFunctionRepository;
	private final SiteContentRepository siteContentRepository;

	@Autowired
	public DatabaseLoader(
		ReservationRepository reservationRepository,
		SiteServiceRepository siteServiceRepository,
		SiteFunctionRepository siteFunctionRepository,
		SiteContentRepository siteContentRepository
	) {
		this.reservationRepository = reservationRepository;
		this.siteServiceRepository = siteServiceRepository;
		this.siteFunctionRepository = siteFunctionRepository;
		this.siteContentRepository = siteContentRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		try {
			reservationRepository.save(new Reservation("Tom"));
			reservationRepository.save(new Reservation("Jack"));
			reservationRepository.save(new Reservation("Apple"));

//			siteServiceRepository.save(new SiteService("User service"));
//			siteServiceRepository.save(new SiteService("Reservation service"));

			SiteService userManagementService = new SiteService();
			userManagementService.setName("User management");
			this.siteServiceRepository.save(userManagementService);

			SiteFunction userManagerFunction = new SiteFunction();
			userManagerFunction.setName("User management");
			userManagerFunction.setSiteService(userManagementService);

			SiteContent viewManagerContent = new SiteContent();
			viewManagerContent.setName("view");
			viewManagerContent.setSiteFunction(userManagerFunction);

			this.siteServiceRepository.save(userManagementService);
			this.siteFunctionRepository.save(userManagerFunction);
			this.siteContentRepository.save(viewManagerContent);

		} catch(Exception e) {
			logger.error("Can't load database data because of " + e.getMessage());
			throw e;
		}
	}

}