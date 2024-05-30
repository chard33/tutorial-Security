package com.tutorialSecurity.tutorialSecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tutorialSecurity.tutorialSecurity.dtos.saveProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 333)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private productStatus status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(saveProduct saveProd) {
        Category category1 = new Category();
        category1.setId(saveProd.categoryId());
        name = saveProd.name();
        price = saveProd.price();
        status = productStatus.ENABLED;
        category = category1;
    }

    public void update(saveProduct.saveUpdate saveUpdate) {

        if(saveUpdate.name() != null){
            name = saveUpdate.name();
        }
        if(saveUpdate.price() != null){
            price = saveUpdate.price();
        }
        if(saveUpdate.categoryId() != null){
            Category category1 = new Category();
            category1.setId(saveUpdate.categoryId());

            category = category1;
        }
    }

    public void disable() {

        status = productStatus.DISABLED;
    }
}
