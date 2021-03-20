package com.dreamplume.pojo;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/3/19 23:49
 * @Created by 翊
 */
public class User {
    String name;
    int age;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
