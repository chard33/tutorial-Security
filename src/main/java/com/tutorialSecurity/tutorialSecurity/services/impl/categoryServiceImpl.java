package com.tutorialSecurity.tutorialSecurity.services.impl;

import com.tutorialSecurity.tutorialSecurity.dtos.saveCategory;
import com.tutorialSecurity.tutorialSecurity.entities.Category;
import com.tutorialSecurity.tutorialSecurity.repositories.categoryRepository;
import com.tutorialSecurity.tutorialSecurity.services.categoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class categoryServiceImpl implements categoryService {

    private final categoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findOne(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category creatOne(saveCategory saveCategory) {

        return categoryRepository.save(new Category(saveCategory));
    }

    @Override
    @Transactional
    public Category updateOne(saveCategory.updateCategory updateCategory) {

        Category category = categoryRepository.getReferenceById(updateCategory.id());

        category.update(updateCategory);

        return category;
    }

    @Override
    @Transactional
    public Category disableOne(Long id) {

        Category category = categoryRepository.getReferenceById(id);

        category.disable();

        return category;
    }
}
