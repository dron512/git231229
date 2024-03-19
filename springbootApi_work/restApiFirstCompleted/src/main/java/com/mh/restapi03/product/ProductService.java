package com.mh.restapi03.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositoy productRepositoy;
    private final JPAQueryFactory jpaQueryFactory;

    public Product addProduct(Product product) {
        Product dbProduct = productRepositoy.save(product);
        return dbProduct;
    }

    public List<Product> getProduct() {
        QProduct product = QProduct.product;

        List<Product> list = jpaQueryFactory.selectFrom(product)
                .where(product.id.isNull())
                .fetch();

        return list;
    }
}
