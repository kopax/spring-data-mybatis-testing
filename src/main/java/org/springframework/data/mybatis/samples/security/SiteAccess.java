/*
 * Kopax Ltd Copyright (c) 2017.
 */

package org.springframework.data.mybatis.samples.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mybatis.annotations.Column;
import org.springframework.data.mybatis.domains.LongId;
import org.springframework.data.mybatis.samples.common.I18nId;

import javax.validation.constraints.NotNull;

/**
 * Created by dka on 1/13/17.
 */
public abstract class SiteAccess extends I18nId {

    @Column(name = "NAME")
    @NotNull
    private String name;

    protected SiteAccess() {
    }

    public SiteAccess(String name) {
        this.name = name;
    }

    public SiteAccess(String name, String i18nMessageId) {
        this.name = name;
        this.setMessageId(i18nMessageId);
    }

    @JsonIgnore
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    @JsonIgnore
    public String getDefaultMessage() {
        return getName();
    }

}
