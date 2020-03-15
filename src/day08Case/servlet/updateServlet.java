package day08Case.servlet;

import day08Case.Bean.day04User;
import day08Case.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取唯一标志id
        String id = request.getParameter("id");
        //调用dao层方法，获取user对象
        UserDao userDao=new UserDao();
        day04User user= userDao.selectUserById(id);
        //将user对象存入session域中，以便与在页面展示数据
        request.getSession().setAttribute("USER",user);
        //存入数据后转发到修改界面
        response.sendRedirect(request.getContextPath()+"/day08case/updateUser.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
