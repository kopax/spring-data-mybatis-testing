/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.mybatis.annotations.*;

import javax.validation.constraints.NotNull;
import java.util.List;

import static org.apache.ibatis.type.JdbcType.BIGINT;


@Entity(table = "SITE_SERVICE")
public class SiteService extends SiteAccess {

	@JdbcType(BIGINT)
	@OneToMany
	@JoinTable(name = "SITE_FUNCTION")
	@JoinColumn(name = "SITE_SERVICE_ID")
	@NotNull
	private List<SiteFunction> siteFunctionList;

	public List<SiteFunction> getSiteFunctionList() {
		return siteFunctionList;
	}

	public void setSiteFunctionList(List<SiteFunction> siteFunctionList) {
		this.siteFunctionList = siteFunctionList;
	}

}
