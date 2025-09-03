package io.dougluciano.poc.api_notas.API.notas.Fiscais.controller;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.Invoice;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.dto.InvoiceDTO;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService service;

    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
