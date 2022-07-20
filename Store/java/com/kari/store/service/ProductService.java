package com.kari.store.service;

import com.kari.store.model.ProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public class ProductService {
    private final String NAMESPACE = "mapper.ProductMapper";
    @Autowired
    private SqlSession sqlSession;

    public void register(ProductDTO p) {
        sqlSession.insert(NAMESPACE + ".register", p);
    }

    public void register2(ProductDTO p) {
        sqlSession.insert(NAMESPACE + ".register2", p);
    }

    public List<ProductDTO> selectAll() {
        return sqlSession.selectList(NAMESPACE + ".selectAll");
    }

    public ProductDTO selectOne(int id) {
        return sqlSession.selectOne(NAMESPACE + ".selectOne", id);
    }



}
