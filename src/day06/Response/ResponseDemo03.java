package day06.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResponseDemo03")
public class ResponseDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取流对象之前，设置流的对象为utf-8，流对象的默认编码为ISO-8859-1
        response.setCharacterEncoding("utf-8");

        //2、告诉浏览器，服务器发送消息体数据的编码，建议浏览器使用该编码解码
        response.setHeader("content-type","text/html;charset=utf-8");

        //使用封装好的方法，设置消息体数据的编码
        response.setContentType("text/html;charset=utf-8");

        //获取字符输出流
        PrintWriter writer = response.getWriter();
        //2、输出数据
        writer.write("<h1> 你好 hello word</h1>");


    }
}
