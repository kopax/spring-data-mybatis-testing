/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import org.springframework.data.mybatis.annotations.Column;
import org.springframework.data.mybatis.domains.LongId;

import javax.validation.constraints.NotNull;

/**
 * Created by dka on 1/13/17.
 */
public abstract class SiteAccess extends LongId {

    @Column(name = "NAME")
    @NotNull
    private String name;

    protected SiteAccess() {
    }

    public SiteAccess(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
