package com.tutorialSecurity.tutorialSecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tutorialSecurity.tutorialSecurity.dtos.saveCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "")
@NoArgsConstructor
@AllArgsConstructor
@Data
<<<<<<< HEAD
public class Category implements Serializable {
=======
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {
>>>>>>> 87180c95fb0a899903d88717d1be3ef08ef023f1

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
