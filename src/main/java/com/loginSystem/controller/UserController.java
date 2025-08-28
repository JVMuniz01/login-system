package com.loginSystem.controller;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginSystem.dto.LoginDTO;
import com.loginSystem.dto.RegisterDTO;
import com.loginSystem.dto.UserResponseDTO;
import com.loginSystem.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService service;	
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	//METODO CREATE
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO>create(@Valid @RequestBody RegisterDTO dto) {
		UserResponseDTO response = service.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//READ ALL
	@GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
	// READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        UserResponseDTO response = service.findById(id);
        return ResponseEntity.ok(response);
    }
    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @Valid @RequestBody RegisterDTO dto) {
        UserResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto){
    	try {
    		String token = service.login(dto.email(), dto.password());
    		return ResponseEntity.ok(Map.of("Token", token));
    	}catch (RuntimeException e) {
    		return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
    
}
