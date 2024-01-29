package com.example.mateproject.proc_test.controller;

import com.example.mateproject.proc_test.repository.ProductsReplyRepository;
import com.example.mateproject.proc_test.dto.Product;
import com.example.mateproject.proc_test.dto.Product_reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products_reply")
public class ProductReplyController {

    @Autowired
    ProductsReplyRepository productsReplyRepository;

    @GetMapping("insert")
    @ResponseBody
    public String insert(Product_reply product_reply){
        System.out.println(product_reply);
        productsReplyRepository.doInsert(product_reply);
        return "test";
    }

    @PostMapping("insert")
//    @ResponseBody
    public String pinsert(Product_reply product_reply){
        System.out.println(product_reply);
        product_reply.setRef_idx_reply(product_reply.getIdx_reply());
        product_reply.setRef_level(product_reply.getRef_level()+1);
        productsReplyRepository.doInsert(product_reply);
        return "redirect:/product/view?idx="+product_reply.getIdx_products();
    }

    @GetMapping("view")
    public String view(Model model,Product product){
//        Product dbProduct = productsRepository.doSelectRow(product);
//        model.addAttribute("product",dbProduct);
        return "product/view";
    }
    
    @PostMapping("delete")
    @ResponseBody
    public String delete(Product_reply product_reply){
        productsReplyRepository.doDelete(product_reply);
        return "문자날아감";
    }

}
