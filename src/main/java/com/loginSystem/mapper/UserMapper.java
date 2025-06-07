package com.loginSystem.mapper;

import com.loginSystem.dto.UserDTO;
import com.loginSystem.dto.UserResponseDTO;
import com.loginSystem.entity.User;

public class UserMapper {
	public static User toEntity(UserDTO dto) {
        return new User(null, dto.username(), dto.email(), dto.password());
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
