package com.shubham.productservice.service;

import com.shubham.productservice.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> getProduct(String id);

    Mono<Product> createProduct(Product product);

    Mono<Product> updateProduct(Product product);

    void deleteProduct(String id);

    Flux<Product> getAllProducts(Double minPrice, Double maxPrice);
}
