package com.tutorialSecurity.tutorialSecurity.services.impl;

import com.tutorialSecurity.tutorialSecurity.dtos.saveProduct;
import com.tutorialSecurity.tutorialSecurity.entities.Category;
import com.tutorialSecurity.tutorialSecurity.entities.Product;
import com.tutorialSecurity.tutorialSecurity.repositories.productRepository;
import com.tutorialSecurity.tutorialSecurity.services.productService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class productServiceImpl implements productService {

    private final productRepository productRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(saveProduct saveProd) {
        return productRepository.save(new Product(saveProd));
    }

    @Override
    @Transactional
    public Product updateProduct(saveProduct.saveUpdate saveUpdate) {

        Product product = productRepository.findById(saveUpdate.id()).get();

        product.update(saveUpdate);

//        if(saveUpdate.name() != null){
//            product.setName(saveUpdate.name());
//        }
//        if(saveUpdate.price() != null){
//            product.setPrice(saveUpdate.price());
//        }
//        if(saveUpdate.categoryId() != null){
//            Category category1 = new Category();
//            category.setId(saveUpdate.id());
//
//            this.setCategory(category1);
//        }

        //productRepository.save(product);

        return  product;
    }

    @Override
    @Transactional
    public Product disabledProduct(Long id) {

        Product product = productRepository.findById(id).get();

        product.disable();

        return product;
    }
}
