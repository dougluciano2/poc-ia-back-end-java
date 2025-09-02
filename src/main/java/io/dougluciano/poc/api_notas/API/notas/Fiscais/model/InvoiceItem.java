package io.dougluciano.poc.api_notas.API.notas.Fiscais.model;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity @Table(name = "tbl_invoice_items")
@Getter @Setter @Builder
public class InvoiceItem extends AbstractEntity {

    @Column(name = "num_seq", nullable = false)
    private Integer numSeq;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unity_value", nullable = false)
    private BigDecimal unityValue;

}
