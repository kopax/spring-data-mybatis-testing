/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.mybatis.annotations.Entity;
import org.springframework.data.mybatis.annotations.JdbcType;
import org.springframework.data.mybatis.annotations.JoinColumn;
import org.springframework.data.mybatis.annotations.OneToOne;

import javax.validation.constraints.NotNull;

import static org.apache.ibatis.type.JdbcType.BIGINT;

@Entity(table = "SITE_CONTENT")
public class SiteContent extends SiteAccess {

	@JdbcType(BIGINT)
	@OneToOne
	@JoinColumn(name = "SITE_FUNCTION_ID")
	@NotNull
	private SiteFunction siteFunction;

	public SiteFunction getSiteFunction() {
		return siteFunction;
	}

	public void setSiteFunction(SiteFunction siteFunction) {
		this.siteFunction = siteFunction;
	}
}
