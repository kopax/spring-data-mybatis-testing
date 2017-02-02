/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "siteFunctions", excerptProjection = SiteFunctionRepository.class)
public interface SiteFunctionRepository extends CrudRepository<SiteFunction, Long> {

    // not support now
//	List<SiteFunction> findBySiteService(SiteService siteService);

    List<SiteFunction> findBySiteServiceId(@Param("id") Long id);

}