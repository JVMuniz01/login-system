package com.loginSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
		@Email
		@NotBlank
		String emailString,
		@NotBlank String password
		) {}
