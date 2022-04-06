package com.xiaoqu;


import org.springframework.stereotype.Component;

@Component
public class User {

    private String userName;
    private String usePwd;
    private String userRealname;
    private String userImg;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsePwd() {
        return usePwd;
    }

    public void setUsePwd(String usePwd) {
        this.usePwd = usePwd;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public void add(){
        System.out.println("add...");
    }

}
