package com.tutorialSecurity.tutorialSecurity.dtos;

import com.tutorialSecurity.tutorialSecurity.entities.productStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

public record saveProduct(
        @NotBlank
        String name,
        @NotNull
        BigDecimal price,
        @NotNull
        Long categoryId)
        implements Serializable {

    public record saveUpdate(
            @NotNull
            Long id,
            @NotBlank
            String name,
            @NotNull
            BigDecimal price,
            @NotNull
            Long categoryId
    ) implements Serializable {

    }
}
