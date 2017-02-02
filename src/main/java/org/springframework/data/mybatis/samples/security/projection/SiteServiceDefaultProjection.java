/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security.projection;

import org.springframework.data.mybatis.samples.security.SiteFunction;
import org.springframework.data.mybatis.samples.security.SiteService;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Created by dka on 1/13/17.
 */
@Projection(name = "siteServiceDefault", types = { SiteService.class })
public interface SiteServiceDefaultProjection {

	String getTranslateMessage();

	String getName();

	List<SiteFunction> getSiteFunctionList();

}
