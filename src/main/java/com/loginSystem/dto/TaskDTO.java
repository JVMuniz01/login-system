package com.loginSystem.dto;

public record TaskDTO(Long id,          // id da task
        String title,
        String description,
        boolean completed) {

}
