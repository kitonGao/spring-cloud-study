package com.example.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName User
 * @Description
 * @create 2019/8/27/0027 17:06
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class User implements Serializable{

    private static final long serialVersionUID = -4321534132432L;

    private Long id;

    private String userName;

    private String passWord;

    public User(){}

    public User(Long id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }




    /*------------------------*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }




}
