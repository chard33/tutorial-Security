package com.tutorialSecurity.tutorialSecurity.repositories;

import com.tutorialSecurity.tutorialSecurity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product, Long> {
}
