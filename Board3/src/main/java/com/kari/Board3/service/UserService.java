package com.kari.Board3.service;

import com.kari.Board3.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
@Service
public class UserService {

    private final String NAMESPACE = "mapper.UserMapper";

    @Autowired
    private SqlSession sqlSession;

    public List<UserDTO> selectAll() {
        return sqlSession.selectList(NAMESPACE + ".selectAll");
    }

    public UserDTO auth(UserDTO u) {
        return sqlSession.selectOne(NAMESPACE+ ".auth", u);
    }

    public void register(UserDTO u) {
        sqlSession.insert(NAMESPACE+ ".register", u);

    }

    public UserDTO selectOne(int id) {
        return sqlSession.selectOne(NAMESPACE + ".selectOne", id);
    }

}
