package com.fu.blogsystemmaven.entity;

/**
 * Created by wunaifu on 2017/8/5.
 */
public class User {

    private int id;//自增
    private String phone;//联系方式（登陆账号）
    private String nickname;//昵称
    private String password;
    private String name;
    private int age;
    private String gender;//性别:男（1）女（0）
    private String address;
    private String profession;//职业
    private String introduction;//个人简介
    private int type=0;//用户类型:普通用户（0）管理员（1）

    //构造方法也可以根据需要来创建，方便初始化
    //创建get、set和tostring方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", profession='" + profession + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type=" + type +
                '}';
    }
}
