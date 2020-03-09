package day06.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向Demo
 *
 */
@WebServlet("/ResponseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo01...");
        //重定向：1、设置状态码
        response.setStatus(302);
        //2、设置location的值
        response.setHeader("location","/ServletDemo/ResponseDemo02");
        //封装好的重定向方法
        response.sendRedirect("/ServletDemo/ResponseDemo02");


    }
}
