package day08Case.Bean;
//day04User实体类
public class day04User {
    private int id;//编号
    private String name;//姓名
    private String gender;//性别
    private int age;//年龄
    private String address;//地址
    private  int qq;//QQ
    private  String email;//电子邮箱

    //定义空参构造器和get set方法，以便于使用beanUtils封装对象
    public day04User() {
    }

    public day04User(String name, String gender, int age, String address, int qq, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "day04User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", qq=" + qq +
                ", email='" + email + '\'' +
                '}';
    }
}


