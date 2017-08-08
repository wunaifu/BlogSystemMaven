package com.fu.blogsystemmaven.service;

import com.fu.blogsystemmaven.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wunaifu on 2017/8/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUserByPam() throws Exception {
        int flag = userService.addUserByPam("18219111604", "123456");
        System.out.println("添加返回=="+flag);
    }

    @Test
    public void deleteUserByPhone() throws Exception {
        int flag = userService.deleteUserByPhone("18219111604");
        System.out.println("删除返回==" + flag);
    }

    @Test
    public void updateAndAddUser() throws Exception {
        int flag=0;
        try {
            flag = userService.updateAndAddUser(
                    "18219111605", "update1234", "18219111606", "123456add");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("更新返回==" + flag);
    }

    @Test
    public void findUserByPhone() throws Exception {
        User user = userService.findUserByPhone("18219111624");
        System.out.println("查找User==="+user);
    }

    @Test
    public void findAllUser() throws Exception {
        List<User> userList=userService.findAllUser();
        for (User user : userList) {
            System.out.println("User===="+user);
        }
    }

}