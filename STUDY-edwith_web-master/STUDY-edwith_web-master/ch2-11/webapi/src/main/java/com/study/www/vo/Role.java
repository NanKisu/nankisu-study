package com.study.www.vo;

public class Role {
	private int roleId;
	private String description;
	
	public Role() {
		super();
	}
	public Role(int roleId, String description) {
		super();
		this.roleId = roleId;
		this.description = description;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
}
