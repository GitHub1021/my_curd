package com.hxkj.system.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSysUserRole<M extends BaseSysUserRole<M>> extends Model<M> implements IBean {

	public void setUserId(String userId) {
		set("user_id", userId);
	}

	public String getUserId() {
		return get("user_id");
	}

	public void setRoleId(Integer roleId) {
		set("role_id", roleId);
	}

	public Integer getRoleId() {
		return get("role_id");
	}

}
