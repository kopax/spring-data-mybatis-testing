/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security.projection;

import org.springframework.data.mybatis.samples.security.SiteContent;
import org.springframework.data.mybatis.samples.security.SiteFunction;
import org.springframework.data.mybatis.samples.security.SiteService;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;


/**
 * Created by dka on 1/13/17.
 */
@Projection(name = "siteFunctionDefault", types = { SiteFunction.class })
public interface SiteFunctionDefaultProjection {

	String getName();

	SiteService getSiteService();

	List<SiteContent> getSiteContentList();

}
