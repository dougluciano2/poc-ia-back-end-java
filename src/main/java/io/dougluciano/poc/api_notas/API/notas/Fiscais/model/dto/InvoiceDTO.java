package io.dougluciano.poc.api_notas.API.notas.Fiscais.model.dto;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.Invoice;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.enums.InvoiceStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record InvoiceDTO(
        Long id,
        String number,
        String serie,
        LocalDateTime issueDate,
        BigDecimal amountValue,
        InvoiceStatus status,
        PersonDTO issuer,
        PersonDTO customer
) {
    // Método de fábrica que usa o outro DTO para compor a resposta.
    public static InvoiceDTO fromEntity(Invoice invoice) {
        return new InvoiceDTO(
                invoice.getId(),
                invoice.getNumber(),
                invoice.getSeries(),
                invoice.getIssueDate(),
                invoice.getAmountValue(),
                invoice.getStatus(),
                PersonDTO.fromEntity(invoice.getIssuer()), // Conversão do emissor
                PersonDTO.fromEntity(invoice.getCustomer())  // Conversão do cliente
        );
    }
}
