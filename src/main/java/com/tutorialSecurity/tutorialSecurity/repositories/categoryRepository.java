package com.tutorialSecurity.tutorialSecurity.repositories;

import com.tutorialSecurity.tutorialSecurity.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface categoryRepository extends JpaRepository<Category, Long> {
}
