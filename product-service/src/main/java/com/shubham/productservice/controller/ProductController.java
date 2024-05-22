package com.shubham.productservice.controller;

import com.shubham.productservice.domain.Product;
import com.shubham.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable String id) {
        return productService.getProduct(id).map(ResponseEntity::ok);
    }

    @PostMapping("/products")
    public Mono<ResponseEntity<Product>> createProduct(@RequestBody Product product) {
        return productService.createProduct(product).map(ResponseEntity::ok);
    }

    @PutMapping("/products")
    public Mono<ResponseEntity<Product>> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product).map(ResponseEntity::ok);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/products")
    public Flux<Product> getAllProducts(@RequestParam(required = false, defaultValue = "0") Double minPrice, @RequestParam(required = false, defaultValue = "100") Double maxPrice) {
        return productService.getAllProducts(minPrice, maxPrice);
    }

}
