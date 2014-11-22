package java63.servlets.test04.dao;

import java63.servlets.test04.domain.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudentDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	
	public void setSqlSessionFactory
	   (SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public StudentDao() {}
	
	public Student selectOne(int no) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    
	    try {
	      return sqlSession.selectOne(
	        "java02.test19.server.StudentDao.selectOne", 
	        no);
	    } finally {
	      sqlSession.close();
	    }
	}

	public void update(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update(
		   "java02.test19.server.StudentDao.update", student);
		sqlSession.commit();	
		} finally {
			sqlSession.close();
		}
	 
	}
	

}
