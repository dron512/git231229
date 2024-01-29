package com.example.testingweb.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }
}
