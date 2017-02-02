package org.springframework.data.mybatis.samples.reservation;

import org.springframework.data.mybatis.repository.support.MybatisRepository;
import org.springframework.data.mybatis.samples.reservation.Reservation;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dka on 2/2/17.
 */
@RepositoryRestResource
public interface ReservationRepository extends MybatisRepository<Reservation, Long> {
}

