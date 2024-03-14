package com.mh.restapi03.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.restapi03.product.Product;
import com.mh.restapi03.product.ProductController;
import com.mh.restapi03.product.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddProduct() throws Exception {
        // given

        // 상품 객체 생성
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(100.0);

        // 상품을 JSON 형식으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonProduct = objectMapper.writeValueAsString(product);
        System.out.println(jsonProduct);

        //when
        // MockMvc를 사용하여 POST 요청 보내기
        ResultActions resultActions =  mockMvc.perform(
                        MockMvcRequestBuilders.post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonProduct));

        //then
        resultActions.andExpect(MockMvcResultMatchers.status().isCreated());

        // ProductService가 제대로 호출되는지 확인할 수도 있음
        // Mockito.when(productService.addProduct(product)).thenReturn(product);

        // 이후 필요한 추가적인 검증을 수행할 수 있음
    }

}

