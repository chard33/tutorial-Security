package com.tutorialSecurity.tutorialSecurity.services;

import com.tutorialSecurity.tutorialSecurity.dtos.saveProduct;
import com.tutorialSecurity.tutorialSecurity.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface productService {
    Page<Product> findAll(Pageable pageable);
    Optional<Product> findById(Long id);

    Product save(saveProduct saveProd);

    Product updateProduct(saveProduct.saveUpdate saveUpdate);

    Product disabledProduct(Long id);
}
