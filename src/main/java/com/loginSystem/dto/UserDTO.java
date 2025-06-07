package com.loginSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
		@NotBlank(message = "O nome de usuário é obrigatório")
		String username,
		
		@NotBlank(message = "O Email do usuário é obrigatório")
		@Email
		String email, 
		@NotBlank(message = "A senha é obrigatória")
		String password) {

	
}