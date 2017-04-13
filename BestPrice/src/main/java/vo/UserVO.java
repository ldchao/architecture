package vo;

import Entity.User;

/**
 * Created by ldchao on 2017/4/13.
 */
public class UserVO {

    private int userid;
    private String name;
    private String password;
    private String email;
    private String address;
    private Integer state;

    public UserVO() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User makeUser(){
        User user=new User();
        user.setUserid(userid);
        user.setName(name);
        user.setPassword(password);
        user.setAddress(address);
        user.setEmail(email);
        user.setState(state);
        return user;
    }

    public void update(User user){
        this.userid=user.getUserid();
        this.name=user.getName();
        this.password=user.getPassword();
        this.address=user.getAddress();
        this.email=user.getEmail();
        this.state=user.getState();
    }

}
