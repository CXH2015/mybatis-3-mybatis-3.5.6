package com.mm;

import com.mm.dao.UserDao;
import com.mm.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author CXH2015
 * @date 2021/2/8
 * @url https://blog.csdn.net/qq_18860653/article/details/80605690
 */
public class Application {
  public static void main( String[] args ) throws Exception{
    InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    User user;
//    user = sqlSession.selectOne("com.mm.dao.UserDao.getUserById",3L);
//    System.out.println(user);
    try {
      UserDao dao = sqlSession.getMapper(UserDao.class);
      user = dao.getUserById(1L);
      System.out.println(user);
      user = dao.getUserById(2L);
      System.out.println(user);
    }
    catch (Throwable e){
      e.printStackTrace();
    }
    finally {
      sqlSession.close();
    }
  }
}
