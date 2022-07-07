package controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.UserDTO;

public class UserController {
	private SqlSessionFactory sqlSessionFactory;
	private final String NAMESPACE = "board.UserMapper";
	
	public void init() {
		sqlSessionFactory = builder.SqlBuilder.build();	
	}
	
	public  List<UserDTO> selectAll() {
		List<UserDTO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList(NAMESPACE + ".selectAll");
		
		session.close();
		
		return list;
	}
	
	public UserDTO selectOne(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		UserDTO u = session.selectOne(NAMESPACE+ ".selectOne", id);
		
		session.close();
		
		return u;
	}
	
	public void insert(UserDTO u) {
		
		
		System.out.println("before id : " + u.getId());
		
	
		SqlSession session = sqlSessionFactory.openSession();
		
		// 영향을 받은 row가 몇줄인지 나옴
		int id = session.insert(NAMESPACE + ".insert", u);
		
		// 이게 들어가야 테이블에 제대로 insert가 됨 
		session.commit();
		
		System.out.println("after id : " + u.getId());
		
		session.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
