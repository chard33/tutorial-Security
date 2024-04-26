package com.tutorialSecurity.tutorialSecurity.services;

import com.tutorialSecurity.tutorialSecurity.dtos.saveCategory;
import com.tutorialSecurity.tutorialSecurity.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface categoryService {
    Page<Category> findAll(Pageable pageable);

    Optional<Category> findOne(Long id);

    Category creatOne(saveCategory saveCategory);
}