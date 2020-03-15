package day08Case.servlet;

import day08Case.Bean.day04User;
import day08Case.Dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取参数列表集合
        Map<String, String[]> map = request.getParameterMap();
        //新建user对象，以便与beanutils对象封装;
        day04User user=new day04User();
        //使用beanUtils对象封装
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用dao层方法进行更新数据
        UserDao userDao = new UserDao ();
        userDao.updateUser(user);
        //更新后重定向到展示列表
        response.sendRedirect(request.getContextPath()+"/findUserByServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
