package org.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/17
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map user = sqlSession.selectOne("org.example.mybatis.test.User.findUserById", 1);
        //5. 打印结果
        System.out.println(user);
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
