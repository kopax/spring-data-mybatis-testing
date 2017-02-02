/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security.projection;

import org.springframework.data.mybatis.samples.security.SiteContent;
import org.springframework.data.mybatis.samples.security.SiteService;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;


/**
 * Created by dka on 1/13/17.
 */
@Projection(name = "siteContentDefault", types = { SiteContent.class })
public interface SiteContentDefaultProjection {

	String getName();

	SiteService getSiteFunction();

}
