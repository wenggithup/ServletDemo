package day08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    //实体类，用el表达式获取数据
    private String name;
    private String password;
    private int age;
    private Date birthday;

    public String getBirStr(){
        if(birthday!=null){
            //格式化日期
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(birthday);
        }
        return "";
    }
    public User() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
