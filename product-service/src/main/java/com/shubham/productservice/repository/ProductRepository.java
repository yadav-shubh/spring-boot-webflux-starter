package com.shubham.productservice.repository;

import com.shubham.productservice.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<Product> findAllByPriceBetween(Double minPrice, Double maxPrice);
}
