package com.tutorialSecurity.tutorialSecurity.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record saveCategory(

        @NotBlank
        String name
) {

    public record updateCategory(
            @NotNull
            Long id,
            String name
    ){}
}
