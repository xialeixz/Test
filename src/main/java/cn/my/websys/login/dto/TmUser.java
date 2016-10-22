package cn.my.websys.login.dto;

/**
 * Created by jasonxxia on 2016/10/18.
 */
public class TmUser {
    private String name;

    private String password;

    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
