package com.example.orderservice.service;

import com.example.orderservice.dto.ProductResponseDTO;
import com.example.orderservice.entity.Product;
import com.example.orderservice.exception.ResourceNotFoundException;
import com.example.orderservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private ProductResponseDTO mapToProductResponseDTO(Product product) {
        return new ProductResponseDTO(product.getId(), product.getName(), product.getSellPrice());
    }

    public ProductResponseDTO getProductById(Long productId) {
        return mapToProductResponseDTO(productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product not found with id: " + productId)
        ));
    }
}
