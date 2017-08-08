package com.fu.blogsystemmaven.dao;

import com.fu.blogsystemmaven.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wunaifu on 2017/8/5.
 * 配置spring和junit整合，这样junit在启动时就会加载spring容器
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    //注入Dao实现类依赖
//    @Resource
    @Autowired
    private UserDao userDao;

//    @Test
//    public void addUserByUser() throws Exception {
//        User user1=new User();
//        user1.setPhone("18219111603");
//        user1.setPassword("123456");
//        int addAmount = userDao.addUserByUser(user1);
//        System.out.println("更新操作后返回的数目：" + addAmount);
//    }

    @Test
    public void addUserByPam() throws Exception {
        int addAmount = userDao.addUserByPam("18219111603","123456");
        System.out.println("更新操作后返回的数目：" + addAmount);
    }

    @Test
    public void deleteUserByPhone() throws Exception {
        int deleteAmount = userDao.deleteUserByPhone("18219111602");
        System.out.println("更新操作后返回的数目：" + deleteAmount);
    }

    @Test
    public void updateUserByPhone() throws Exception {
        int updateAmount = userDao.updateUserByPhone("18219111609","testpassword01");
        System.out.println("更新操作后返回的数目：" + updateAmount);
    }

    @Test
    public void findUserByPhone() throws Exception {

        User user = userDao.findUserByPhone("18219111629");
        System.out.println("user==="+user);
    }

    @Test
    public void findAllUser() throws Exception {

        List<User> userList=userDao.findAllUser();
        for (User user : userList) {
            System.out.println("User===="+user);
        }

    }

}