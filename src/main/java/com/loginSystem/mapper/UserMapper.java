package com.loginSystem.mapper;

import com.loginSystem.dto.RegisterDTO;
import com.loginSystem.dto.UserResponseDTO;
import com.loginSystem.entity.User;

public class UserMapper {
	public static User toEntity(RegisterDTO dto, String encodedPassword) {
        return new User(null, dto.username(), dto.email(), encodedPassword);
    }

	public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),	
            user.getCreatedAt()
        );
    }				
}
