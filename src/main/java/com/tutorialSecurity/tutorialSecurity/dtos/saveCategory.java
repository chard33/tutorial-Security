package com.tutorialSecurity.tutorialSecurity.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

public record saveCategory(

        @NotBlank
        String name
) implements Serializable{

    public record updateCategory(
            @NotNull
            Long id,
            String name
    ) implements Serializable{}
}
