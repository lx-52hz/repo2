package com.chinasoft.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private Integer id;
    private String userName;
/*    private String birthdayStr;*/
    private Date birthday;
    private Integer age;
    private String gender;
    private String address;
	private Integer money;

    public User(Integer id, String userName, Date birthday, Integer age, String gender, String address) {
        this.id = id;
        this.userName = userName;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
/*        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = sdf.format(birthday);
        return format;*/
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User(String userName, Date birthday, Integer age, String gender, String address) {
        this.userName = userName;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
}

