package com.mh.restapi03.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositoy productRepositoy;
    public Product addProduct(Product product) {
        Product dbProduct = productRepositoy.save(product);
        return dbProduct;
    }
}
