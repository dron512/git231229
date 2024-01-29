package com.example.mateproject.proc_test.repository;

import com.example.mateproject.proc_test.dto.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository {

    @Autowired
    SqlSession sqlSession;

    public List<Product> doSelect(){
        return sqlSession.selectList("product.select");
    }

    public void doInsert(Product product) {
        sqlSession.insert("product.insert",product);
    }

    public Product doSelectRow(Product product){
        return sqlSession.selectOne("product.selectrow",product);
    }

    public void doDelete(Product product) {
        sqlSession.delete("product.delete", product);

    }
}
