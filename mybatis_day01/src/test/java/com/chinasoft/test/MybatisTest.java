package com.chinasoft.test;

import com.chinasoft.domain.User;
import com.chinasoft.mapper.IUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    InputStream in = null;
    IUserMapper mapper=null;
    SqlSession sqlSession =null;


    @Before
    public void init() throws IOException {
        //        1、读取mybatis的配置文件
        in = Resources.getResourceAsStream("mybatis.xml");
//        2、创建sqlsessionFactory对象         工厂模式
        SqlSessionFactoryBuilder factory = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = factory.build(in);
//        3、创建sqlsession对象
        sqlSession = build.openSession();
//        4、创建IUserMapper的代理对象          代理模式
        mapper = sqlSession.getMapper(IUserMapper.class);
    }


    //查找所有数据
    @Test
    public void test01() throws IOException {
//        5、通过代理对象执行对应方法
        List<User> all = mapper.findAll();
        System.out.println(all);

    }

    //增加
    @Test
    public void test02() throws IOException {
//        5、通过代理对象执行对应方法
        User user = new User( "张三", new Date(), 18, "男", "软件园");
        mapper.addUser(user);
        System.out.println(user.getId());
        //提交
        sqlSession.commit();
    }

    //删除
    @Test
    public void test03() throws IOException {
//       5、通过代理对象执行对应方法
        mapper.delUser(32);
        //提交
        sqlSession.commit();
    }


    //修改
    @Test
    public void test04() throws IOException {
        User user = new User( 33,"张三", new Date(), 45, "男", "大学");
//       5、通过代理对象执行对应方法
        mapper.updUser(user);
        //提交
        sqlSession.commit();
    }

    //模糊查询
    @Test
    public void test05() {
//        5、通过代理对象执行对应方法
        List<User> all = mapper.findUserByName("曹");
        for (User user : all) {
            System.out.println(user);
        }

    }


    //查询
    @Test
    public void test06() {
        String username="曹";
        String gender="男";
        List<User> useCoditions = mapper.findUserByCondition(username, gender);

        for (User user : useCoditions) {
            System.out.println(user);
        }

    }














    @After
    public void destory() throws IOException {
        //        6、关闭资源
        sqlSession.close();
        in.close();
    }


}
