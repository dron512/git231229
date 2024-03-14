package com.mh.restapi03.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoy extends JpaRepository<Product,Long> {
}
