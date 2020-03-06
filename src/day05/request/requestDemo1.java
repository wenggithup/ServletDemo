package day05.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
/*
* * 演示request方法
*
* */
public class requestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                                    throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * * 方法：
                    1、获取请求方式：GET
                        * String getMethod（）
                    2、获取虚拟目录：/ServletDemo
                        * String getContextPath（）
                    3、获取Servlet路径：/login
                        * String getServletPath（）
                    4、获取get方式的请求参数：
                        * String getQueryString（）
                    5、获取请求的URI：/ServletDemo/login
                        * Stirng getRequestURI（）：/ServletDemo/login
                        * StringBuffer getRequestURL（）：http：//localhost/ServletDemo/login
                    6、获取协议版本
                        * String getProtocol（）
                    7、获取客户机的ip地址：
                        * String getRemoteAddr（）
        * */
        //1.获取请求方式：get
        String method = request.getMethod();
        System.out.println(method);

        //2、获取虚拟目录
        String path = request.getContextPath();
        System.out.println(path);

        //3获取servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //4、获取get方式的请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //5.1、获取请求参数的uri
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        //5.2、获取完整的url
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);

        //6、获取协议版本号
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //7、获取客户机ip地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);

    }
}
