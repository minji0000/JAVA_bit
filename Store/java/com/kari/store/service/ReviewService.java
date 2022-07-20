package com.kari.store.service;

import com.kari.store.model.ReviewDTO;
import com.kari.store.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class ReviewService {
    private final String NAMESPACE = "mapper.ReviewMapper";

    @Autowired
    private SqlSession sqlSession;

    public void register(ReviewDTO r) {
        sqlSession.insert(NAMESPACE + ".register", r);
    }

}
