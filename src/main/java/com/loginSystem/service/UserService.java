package com.loginSystem.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loginSystem.dto.RegisterDTO;
import com.loginSystem.dto.UserResponseDTO;
import com.loginSystem.entity.User;
import com.loginSystem.mapper.UserMapper;
import com.loginSystem.repository.UserRepository;


@Service
public class UserService {
	
	private final UserRepository repository;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtService jwtService;	
	
	public UserService(UserRepository repository, JwtService jwtService) {
		this.repository = repository;
        this.jwtService = jwtService;
	}
	
	// CREATE
    @Transactional
    public UserResponseDTO create(RegisterDTO dto) {
    	
    	String encodedPassword = passwordEncoder.encode(dto.password());
        // Converter DTO para entidade
        User user = UserMapper.toEntity(dto, encodedPassword);
        // Salvar no banco
        repository.save(user);
        // Converter para DTO de resposta
        return UserMapper.toResponseDTO(user);
    }
    
    // READ ALL
    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(UserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
    
    // READ BY ID
    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return UserMapper.toResponseDTO(user);
    }
    
    // UPDATE
    @Transactional
    public UserResponseDTO update(Long id, RegisterDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        repository.save(user);
        return UserMapper.toResponseDTO(user);
    }
    // DELETE
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User not found with id " + id);
        }
        repository.deleteById(id);
    }

	
}
