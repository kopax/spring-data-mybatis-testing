/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "siteFunctions", excerptProjection = SiteFunctionRepository.class)
public interface SiteFunctionRepository extends CrudRepository<SiteFunction, Long> {

//	List<SiteFunction> findBySiteService(SiteService siteService);

//	List<SiteFunction> findBySiteServiceId(Long id);

}