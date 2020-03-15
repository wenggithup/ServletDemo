package day08Case.servlet;

import day08Case.Bean.PageBean;
import day08Case.Bean.day04User;
import day08Case.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByServlet")
public class findUserByServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("utf-8");
        String currentPage = request.getParameter ("currentPage");//当前页码
        String rows = request.getParameter ("rows");//每页显示条数
        if(currentPage==null||"".equals (currentPage)){
            currentPage="1";
        }
        if(rows==null||"".equals (rows)){
            rows="5";
        }
        //获取表单参数
        Map<String, String[]> map = request.getParameterMap ();
        //调用dao层方法，查询数据
        UserDao userDao=new UserDao ();
        PageBean<day04User> pageBean=userDao.selectPageBean(currentPage,rows,map);
        //将查询好的pageBean对象存到request域中
        request.setAttribute ("pageBean",pageBean);
        //将查询条件回写到页面上
        request.setAttribute ("map",map);
        //转发至展示页面
        request.getRequestDispatcher ("/day08case/list.jsp").forward (request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost (request, response);
    }
}
