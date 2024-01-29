package com.example.testingweb;

import com.example.testingweb.product.Product;
import com.example.testingweb.product.ProductService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ProductService productService;

	@Test
	void contextLoads() {
		Product product = new Product();
		product.setName("myproduct");
		product.setPrice(10000);
		product.setId(1L);

		Product newProduct = new Product();
		product.setName("myproduct");
		product.setPrice(10000);
		product.setId(1L);
	}
}

