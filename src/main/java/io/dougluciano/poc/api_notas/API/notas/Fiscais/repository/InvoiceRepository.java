package io.dougluciano.poc.api_notas.API.notas.Fiscais.repository;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
