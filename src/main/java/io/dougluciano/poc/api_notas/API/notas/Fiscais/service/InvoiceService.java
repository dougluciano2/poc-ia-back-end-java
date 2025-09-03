package io.dougluciano.poc.api_notas.API.notas.Fiscais.service;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.Invoice;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.dto.InvoiceDTO;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Transactional(readOnly = true)
    public List<InvoiceDTO> findAll(){
        List<Invoice> invoices = invoiceRepository.findAll();

        return invoices.stream()
                .map(InvoiceDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Invoice findbyId(Long id){
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }
}
