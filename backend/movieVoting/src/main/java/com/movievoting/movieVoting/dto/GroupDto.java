package com.movievoting.movieVoting.dto;

import jakarta.validation.constraints.NotBlank;



public class GroupDto {
    private int groupId;
	@NotBlank
	private String name;
	private String inviteCode;

	public GroupDto(@NotBlank String name) {
		super();
		this.name = name;
		this.inviteCode=null;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public GroupDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GroupDto [name=" + name + "]";
	}
	 
}
