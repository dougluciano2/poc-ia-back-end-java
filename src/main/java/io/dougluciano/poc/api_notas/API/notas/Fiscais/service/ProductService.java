package io.dougluciano.poc.api_notas.API.notas.Fiscais.service;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.Product;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findlAll(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }
}
