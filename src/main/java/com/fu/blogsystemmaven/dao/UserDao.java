package com.fu.blogsystemmaven.dao;

import com.fu.blogsystemmaven.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wunaifu on 2017/8/5.
 */
public interface UserDao {//创建test快捷方式，选中类名，右键go to->test

    /**不可行，待测试
     * 通过 User 来添加 User
     * @param user1
     * @return  插入的行数
     */
//    int addUserByUser(User user1);

    /**
     *  phone和password 来添加 User
     * @param phone
     * @param password
     * @return 插入的行数
     */
    int addUserByPam(@Param("phone") String phone,@Param("password")String password);

    /**
     * 通过phone删除User
     * @param phone
     * @return 删除成功返回1,删除失败或者重复删除返回0
     */
    int deleteUserByPhone(String phone);

    /**
     * 通过phone更新User密码
     * @param phone
     * @param password
     * @return 更新成功返回1
     */
    int updateUserByPhone(@Param("phone") String phone,@Param("password")String password);

    /**
     * 通过phone查询User
     * @param phone
     * @return
     */
    User findUserByPhone(String phone);

    /**
     * 查找所有User，并按降序排序好
     * @return
     */
    List<User> findAllUser();

}
