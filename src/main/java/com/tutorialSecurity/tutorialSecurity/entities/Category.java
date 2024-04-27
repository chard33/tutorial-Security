package com.tutorialSecurity.tutorialSecurity.entities;

import com.tutorialSecurity.tutorialSecurity.dtos.saveCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 333)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private categoryStatus status;

    public Category(saveCategory saveCategory) {
        name = saveCategory.name();
        status = categoryStatus.ENABLED;
    }

    public void update(saveCategory.updateCategory updateCategory) {

        if(updateCategory.name() != null){
            name = updateCategory.name();
        }
    }

    public void disable() {

        status = categoryStatus.DISABLED;
    }
}
