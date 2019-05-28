package com.qfedu.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer sex;

    private Integer isteacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsteacher() {
        return isteacher;
    }

    public void setIsteacher(Integer isteacher) {
        this.isteacher = isteacher;
    }
}