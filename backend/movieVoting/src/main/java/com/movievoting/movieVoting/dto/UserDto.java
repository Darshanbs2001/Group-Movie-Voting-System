package com.movievoting.movieVoting.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	int userId;
	@NotEmpty(message = "Sorry user name cannot be empty")
	public String name;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?=.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d)[A-Za-z\\d\\W]{7,}$")
	public String password;
	@Email
	public String email;

	public UserDto(@NotEmpty(message = "Sorry user name cannot be empty") String name,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?=.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d)[A-Za-z\\d\\W]{7,}$") String password,
			@Email String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}

}
