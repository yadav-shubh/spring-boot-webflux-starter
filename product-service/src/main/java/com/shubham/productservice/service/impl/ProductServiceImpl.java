package com.shubham.productservice.service.impl;

import com.shubham.productservice.domain.Product;
import com.shubham.productservice.repository.ProductRepository;
import com.shubham.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Mono<Product> getProduct(String id) {
        return productRepository.findById(id).switchIfEmpty(Mono.error(new RuntimeException("Product not found")));
    }

    @Override
    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        if (product.getId() == null) {
            return Mono.error(new RuntimeException("Product id cannot be null"));
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id).subscribe();
    }

    @Override
    public Flux<Product> getAllProducts(Double minPrice, Double maxPrice) {
        return productRepository.findAllByPriceBetween(minPrice, maxPrice);
    }
}
