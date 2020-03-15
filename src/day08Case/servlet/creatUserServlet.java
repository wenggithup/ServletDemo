package day08Case.servlet;



import day08Case.Bean.day04User;
import day08Case.Dao.UserDao;
import day08Case.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/creatUserServlet")
public class creatUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数钱设置字符集
        request.setCharacterEncoding("utf-8");
        //获取所有参数和值的map集合
        Map<String, String[]> map = request.getParameterMap();
        //新建bean对象，利用beanutils封装对象
        day04User user=new day04User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用userService中的添加用户信息方法
        UserDao userDao=new UserDao();
        userDao.insertUser(user);
        //插入后跳转到loginServlet
        response.sendRedirect(request.getContextPath()+"/findUserByServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
