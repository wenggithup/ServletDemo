package day05.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo2")
public class requestDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* //获取字符流
        BufferedReader br = request.getReader();
        String method = request.getMethod();
        System.out.println(method);
        //读取数据
        String line=null;
        System.out.println("我要开始了");
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }*/
        /*
            *
                    2、String【】getParameterValues（String name）：根据参数名称获取参数值的数据
                    3、Enumberation<String> getParameternames（）：获取所有请求的参数名称
                    4、Map<String,String []>getParameterMap（）：获取所有参数的map集合
        * */
        //1、String getParameter（String name） ：根据参数名称获取参数值
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);

        //2、String【】getParameterValues（String name）：根据参数名称获取参数值的数据
        String[] passwords = request.getParameterValues("password");
        for (String password : passwords) {
            System.out.print(password +" ,");

        }
        //3、Enumberation<String> getParameternames（）：获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println(parameterNames);

        //Map<String,String []>getParameterMap（）：获取所有参数的map集合
        Map<String, String[]> map = request.getParameterMap();
        Set<String> key = map.keySet();
        for (String s : key) {
            String[] values = map.get(s);
            for (String value : values) {
                System.out.println(s+"=="+value);

            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
