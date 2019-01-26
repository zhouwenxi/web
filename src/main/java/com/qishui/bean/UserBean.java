package com.qishui.bean;

/**
 * Created by zhou on 2019/1/26.
 * 实体类
 */
public class UserBean {

    private int id;
    private String username;
    private String password;

    public UserBean() {
    }

    public UserBean(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
