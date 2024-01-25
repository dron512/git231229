package com.example.testingweb;

import com.example.testingweb.service.ProductService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestingWebApplicationTests {

	@Autowired
	ProductService productService;

	@Test
	void contextLoads() {
		Product product = new Product();
		product.setName("내상품");
		product.setPrice(10000);
		product.setId(1L);

		Product newProduct = new Product();
		product.setName("내상품");
		product.setPrice(10000);
		product.setId(1L);


	}

	private class Product {
		private String name;
		private int price;
		private Long id;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	}

}

