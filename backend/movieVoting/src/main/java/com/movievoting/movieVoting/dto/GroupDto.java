package com.movievoting.movieVoting.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class GroupDto {

	@NotBlank
	private String name;

	public GroupDto(@NotBlank String name) {
		super();
		this.name = name;
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
