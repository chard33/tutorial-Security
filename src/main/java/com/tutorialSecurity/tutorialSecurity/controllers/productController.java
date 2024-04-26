package com.tutorialSecurity.tutorialSecurity.controllers;

import com.tutorialSecurity.tutorialSecurity.dtos.saveProduct;
import com.tutorialSecurity.tutorialSecurity.entities.Product;
import com.tutorialSecurity.tutorialSecurity.services.productService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class productController {

    private final com.tutorialSecurity.tutorialSecurity.services.productService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable){

        Page<Product> productPage = productService.findAll(pageable);

        if(productPage.hasContent()){
            return ResponseEntity.ok().body(productPage);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id){

        Optional<Product> product = productService.findById(id);

        if(product.isPresent()){
            return ResponseEntity.ok().body(product.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Product> createOne(@RequestBody @Valid saveProduct saveProd){

        Product product = productService.save(saveProd);

        URI url = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(url).body(product);
    }

    @PutMapping()
    public ResponseEntity<Product> updateOne(@RequestBody @Valid saveProduct.saveUpdate saveUpdate){

        Product product = productService.updateProduct(saveUpdate);

        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}/disabled")
    public ResponseEntity<Product> disableOne(@PathVariable Long id){

        Product product = productService.disabledProduct(id);

        return ResponseEntity.ok().body(product);
    }
}
