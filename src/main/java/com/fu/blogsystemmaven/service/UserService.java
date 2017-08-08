package com.fu.blogsystemmaven.service;

import com.fu.blogsystemmaven.entity.User;
import com.fu.blogsystemmaven.exception.MyTestException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wunaifu on 2017/8/6.
 * 业务接口:站在使用者(程序员)的角度设计接口
 * 三个方面:1.方法定义粒度，方法定义的要非常清楚2.参数，要越简练越好
 * 3.返回类型(return 类型一定要友好/或者return异常，我们允许的异常)
 */
public interface UserService {//创建test快捷方式，选中类名，右键go to->test

    /**
     *  phone和password 来添加 User
     * @param phone
     * @param password
     * @return 插入的行数
     */
    int addUserByPam( String phone, String password);

    /**
     * 通过phone删除User
     * @param phone
     * @return 删除成功返回1,删除失败或者重复删除返回0
     */
    int deleteUserByPhone(String phone);

    /**
     * 通过phone更新User密码 并插入一条数据
     * 这个操作目前没有意义，只是测试一下同时进行多种数据库更新操作，运用事务机制的好处
     * 比如能够成功通过phone更新User密码，但插入一条数据失败，则事务会回滚，两种数据库操作都会失败，
     * 相当于这个方法没有执行，两种数据库操作都没有执行
     * @param phoneU
     * @param passwordU
     * @param phoneI
     * @param passwordI
     * @return
     */
    int updateAndAddUser(String phoneU,String passwordU,String phoneI,String passwordI)
            throws MyTestException,Exception;

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
