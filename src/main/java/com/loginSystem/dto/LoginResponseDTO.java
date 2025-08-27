package com.loginSystem.dto;

public record LoginResponseDTO(
	    String token,
	    String username,
	    String email
	) {}
