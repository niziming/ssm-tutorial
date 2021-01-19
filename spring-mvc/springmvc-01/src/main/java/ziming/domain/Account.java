package ziming.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable{
    private Integer id;
    private String username;
    private String password;
    private Double money;

   // private User user;

    private List<User> list;
    private Map<String,User> map;

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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    /*

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
*/
    public static void main(String[] args) {
        String s = Integer.toBinaryString((byte)-10);
        // String s1 = Integer.toBinaryString(-10);
        System.out.println(s);
        // System.out.println(s1);
        // System.out.println(s1.length());
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
