package io.dougluciano.poc.api_notas.API.notas.Fiscais.model;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.base.AbstractFullEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "invoices")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Invoice extends AbstractFullEntity {

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "serie", nullable = false)
    private String serie;

    @Column(name = "emission_date", nullable = false)
    private LocalDateTime emissionDate;

    @Column(name = "amount_value", nullable = false)
    private BigDecimal amountValue;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Column(name = "seller_id", nullable = false)
    private Person seller;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Column(name = "customer_id", nullable = false)
    private Person customer;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceItem> items = new ArrayList<>();

}
