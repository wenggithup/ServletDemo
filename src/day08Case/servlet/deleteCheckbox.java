package day08Case.servlet;

import day08Case.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCheckbox")
public class deleteCheckbox extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("utf-8");
        //获取所有的为uid的参数值
        String[] uid = request.getParameterValues ("uid");
        UserDao userDao=new UserDao ();
        //调用UserDao中的根据id删除信息方法
        userDao.deleteUserByArraysId(uid);
        //重定向到展示页面
        response.sendRedirect (request.getContextPath ()+"/findUserByServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost (request, response);
    }
}
