package com.fu.blogsystemmaven.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fu.blogsystemmaven.entity.User;
import com.fu.blogsystemmaven.service.UserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wunaifu on 2017/8/7.
 */
@Component
@RequestMapping("/user")//url:模块/资源/{}/细分
public class UserController {

    @Autowired
    private UserService userService;

//    method = RequestMethod.GET  get方式的请求，不写method则表示get和post方法请求都可以
    @RequestMapping(value = "/allUser",method = RequestMethod.POST)
    public String findAllUser(HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取列表页
        List<User> userList = userService.findAllUser();

        //将List转换成json数据
        JSONArray jsonArray = new JSONArray();
        for (User user : userList) {
            JSONObject jsonObj = (JSONObject) JSON.toJSON(user);
            jsonArray.add(jsonObj);
        }

        System.out.println("userList===="+userList);
        System.out.println("jsonArry===="+jsonArray);

        out.print(jsonArray.toString());;//向APP传输json数据

        out.flush();
        out.close();
        return null;//这里返回空就行
    }

    //1.这个是Restful接口设计方法
    @RequestMapping(value = "/{phone}/user", method = RequestMethod.POST)
    //@ResponseBody//这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数
    public String findUserByPhone0(@PathVariable("phone") String phone,HttpServletResponse response)
            throws IOException{

//        response.setContentType("text/html;charset=utf-8");

        User user = new User();
            user = userService.findUserByPhone(phone);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将User转换成json数据
        JSONObject jsonObject=new JSONObject();
        String userJson=jsonObject.toJSONString(user);

        System.out.println("user===="+user);
        System.out.println("userJson===="+userJson);

        //获取到的数据传过去APP端
        out.print(userJson);

        out.flush();
        out.close();
        return null;
    }

    //2.这个是简单的接口设计方法
    @RequestMapping(value = "/findUserByPhone1", method = RequestMethod.POST)
    //@ResponseBody//这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数
    public String findUserByPhone1(@Param("phone") String phone, HttpServletResponse response)
            throws IOException{

//        response.setContentType("text/html;charset=utf-8");

        User user = new User();
        user = userService.findUserByPhone(phone);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将User转换成json数据
        JSONObject jsonObject=new JSONObject();
        String userJson=jsonObject.toJSONString(user);

        System.out.println("user===="+user);
        System.out.println("userJson===="+userJson);

        //获取到的数据传过去APP端
        out.print(userJson);

        out.flush();
        out.close();
        return null;
    }

    //2.这个是简单的接口设计方法
    @RequestMapping(value = "/findUserByPhone2", method = RequestMethod.POST)
    //@ResponseBody//这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数
    public String findUserByPhone2(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("UTF-8");

        String phone = request.getParameter("phone");

        User user = new User();
        user = userService.findUserByPhone(phone);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将User转换成json数据
        JSONObject jsonObject=new JSONObject();
        String userJson=jsonObject.toJSONString(user);

        System.out.println("user===="+user);
        System.out.println("userJson===="+userJson);

        //获取到的数据传过去APP端
        out.print(userJson);

        out.flush();
        out.close();
        return null;
    }

}
