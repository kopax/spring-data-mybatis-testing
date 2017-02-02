/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.mybatis.annotations.*;

import javax.validation.constraints.NotNull;

import java.util.List;

import static org.apache.ibatis.type.JdbcType.BIGINT;


@Entity(table = "SITE_FUNCTION")
public class SiteFunction extends SiteAccess {

	@JdbcType(BIGINT)
	@OneToOne
	@JoinColumn(name = "SITE_SERVICE_ID")
	@NotNull
	private SiteService siteService;

	@JdbcType(BIGINT)
	@OneToMany
	@JoinTable(name = "SITE_CONTENT")
	@JoinColumn(name = "SITE_CONTENT_ID")
	@NotNull
	private List<SiteContent> siteContentList;

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	public List<SiteContent> getSiteContentList() {
		return siteContentList;
	}

	public void setSiteContentList(List<SiteContent> siteContentList) {
		this.siteContentList = siteContentList;
	}
}
