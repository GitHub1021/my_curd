package com.hxkj.system.model.base;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSysOrg<M extends BaseSysOrg<M>> extends Model<M> implements IBean {

	public void setId(Integer id) {
		set("id", id);
	}

	public Integer getId() {
		return get("id");
	}

	public void setOrgName(String orgName) {
		set("org_name", orgName);
	}

	public String getOrgName() {
		return get("org_name");
	}

	public void setSort(Integer sort) {
		set("sort", sort);
	}

	public Integer getSort() {
		return get("sort");
	}

	public void setPid(Integer pid) {
		set("pid", pid);
	}

	public Integer getPid() {
		return get("pid");
	}
	
	 

}
