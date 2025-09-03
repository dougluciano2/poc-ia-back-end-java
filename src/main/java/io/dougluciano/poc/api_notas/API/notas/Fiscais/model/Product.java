package io.dougluciano.poc.api_notas.API.notas.Fiscais.model;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.base.AbstractFullEntity;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity @Table(name = "tbl_products")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Product extends AbstractFullEntity {

    @Column(name = "brand", nullable = false, length = 150)
    private String brand;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 150)
    private ProductCategory category;

    @Column(name = "list_price", nullable = false)
    private BigDecimal listPrice;

}
