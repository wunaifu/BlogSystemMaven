package com.fu.blogsystemmaven.service.impl;

import com.fu.blogsystemmaven.dao.UserDao;
import com.fu.blogsystemmaven.entity.User;
import com.fu.blogsystemmaven.exception.MyTestException;
import com.fu.blogsystemmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wunaifu on 2017/8/6.
 */
@Service
public class UserServiceImpl implements UserService{

    //注入Service依赖
    @Autowired //@Resource
    private UserDao userDao;

    /**
     *  phone和password 来添加 User
     * @param phone
     * @param password
     * @return 插入的行数
     */
    public int addUserByPam(String phone, String password) {
        return userDao.addUserByPam(phone,password);//成功添加返回1，失败返回0
    }

    /**
     * 通过phone删除User
     * @param phone
     * @return 删除成功返回1,删除失败或者重复删除返回0
     */
    public int deleteUserByPhone(String phone) {
        return userDao.deleteUserByPhone(phone);//成功删除返回1，删除失败或者重复删除返回0
    }


    /**
     * 使用注解控制事务方法的优点:
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作、只读操作不要事务控制
     *
     * 通过phone更新User密码 并插入一条数据
     * 这个操作目前没有意义，只是测试一下同时进行多种数据库更新操作，运用事务机制的好处
     * 就是如果有异常则事务会回滚，两种数据库操作都会回到未操作前，
     * 防止需要同时进行多种操作时有部分操作未完成或完成情况不符合我们需求，
     * 有时根据需要手动抛出错误，则事务回滚
     * @param phoneU
     * @param passwordU
     * @param phoneI
     * @param passwordI
     * @return
     */
    @Transactional//这个事务有问题，待测试
    public int updateAndAddUser(String phoneU, String passwordU, String phoneI, String passwordI)
            throws MyTestException,Exception{

        int flag = 0;

        try {
            int flag1 = userDao.updateUserByPhone(phoneU, passwordU);
            if (flag1 == 0) {
                flag = 0;
                throw new MyTestException("update_failure");
            } else {
                int flag2 = userDao.addUserByPam(phoneI, passwordI);
                if (flag2 == 0) {
                    flag = 0;
                    throw new MyTestException("insert_failure");
                }else{
                    flag = 1;
                }
            }
        }catch (Exception e) {
            throw new Exception("update_error:"+e.getMessage());
        }
        return flag;
    }

    /**
     * 通过phone查询User
     * @param phone
     * @return
     */
    public User findUserByPhone(String phone) {
        return userDao.findUserByPhone(phone);
    }
    /**
     * 查找所有User，并按降序排序好
     * @return
     */
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

}
