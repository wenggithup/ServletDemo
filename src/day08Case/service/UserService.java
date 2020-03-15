package day08Case.service;
import day08Case.Bean.day04User;
import day08Case.Dao.UserDao;
import java.util.List;

public class UserService {
    //定义dao层全局变量
    private UserDao userDao;

    public List<day04User> findAllUser() {
    return userDao.selectAllUser();
    }

    public void createUser(day04User user) {
        userDao.insertUser(user);
    }
}