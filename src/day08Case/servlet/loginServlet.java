package day08Case.servlet;
import day08Case.Bean.day04User;
import day08Case.Dao.UserDao;
import day08Case.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单参数前，先设置编码格式
        request.setCharacterEncoding("utf-8");
        //拿到表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //使用超级管理员账号，写死了
        if("weng".equals(username) && "weng".equals(password)){
            //如果信息正确，查询所有的用户信息并返回list页面，否则返回登录界面
            response.sendRedirect(request.getContextPath()+"/findUserByServlet");
        }else {
            //存储错误信息
            request.setAttribute("user_error","用户名或密码错误");
            request.getRequestDispatcher("/day08case/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
