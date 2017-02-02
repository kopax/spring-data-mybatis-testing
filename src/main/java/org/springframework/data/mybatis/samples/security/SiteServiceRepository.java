/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.mybatis.samples.security.projection.SiteServiceDefaultProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "siteServices", excerptProjection = SiteServiceDefaultProjection.class)
public interface SiteServiceRepository extends CrudRepository<SiteService, Long> {

	List<SiteService> findAll();

}