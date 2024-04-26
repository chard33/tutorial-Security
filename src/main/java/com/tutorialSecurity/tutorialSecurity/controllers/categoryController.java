package com.tutorialSecurity.tutorialSecurity.controllers;

import com.tutorialSecurity.tutorialSecurity.dtos.saveCategory;
import com.tutorialSecurity.tutorialSecurity.entities.Category;
import com.tutorialSecurity.tutorialSecurity.services.categoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class categoryController {

    private final categoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable){

        Page<Category> categoryPage = categoryService.findAll(pageable);

        if (categoryPage.hasContent()){

            return ResponseEntity.ok().body(categoryPage);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id){

        Optional<Category> category = categoryService.findOne(id);

        if (category.isPresent()){

            return ResponseEntity.ok().body(category.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Category> creatOne(@RequestBody @Valid saveCategory saveCategory) {

        Category category = categoryService.creatOne(saveCategory);

        URI url = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(url).body(category);
    }


}
