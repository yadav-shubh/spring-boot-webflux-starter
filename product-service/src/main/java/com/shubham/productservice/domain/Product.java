package com.shubham.productservice.domain;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Document("products")
public class Product {

    @Id
    String id;
    String name;
    String description;
    Double price;
    String imageUrl;
    String category;
}
