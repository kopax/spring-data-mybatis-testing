/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.mybatis.samples.security.projection.SiteContentDefaultProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "siteContents", excerptProjection = SiteContentDefaultProjection.class)
public interface SiteContentRepository extends CrudRepository<SiteContent, Long> {

}