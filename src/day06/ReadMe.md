## Response
    1、请求消息：客户端发送给服务器端的数据
        * 数据格式：
            1、请求行
            2、请求头
            3、请求空行
            4、请求体
    2、响应消息：服务器端发送给客户端的数据
        * 数据格式
            1、响应行
                1、组成：协议/版本 响应状态码 状态码描述
                2、响应状态码：服务器告诉客户端浏览器请求和响应的一个状态
                    1、状态码都是三位数字
                    2、状态码分类：
                        1、1xx：服务器接收客户端消息，但没有接收完成，等待一段时间后，发送1xx的状态码
                        2、2xx：代表成功。代表状态码200
                        3、3xx：重定向302，304访问缓存
                        4、4xx：客户端错误：
                            1、404：请求路径没有对应的资源
                            2、405：请求方式没有对应的do方法
                        5、5xx：服务器端错误，500服务器内部出现异常，
            2、响应头
                1、格式：头名称 ： 值
                2、常见的响应头：
                    1、Content-Type：服务器告诉客户端本次响应体数据格式及编码格式
                    2、Content-disposition：服务器告诉客户端以什么格式打开响应体数据
                        * 值：
                            * in-line：默认值，在当前页面内打开
                            * attachment；filename=xxx 以附件形式打开响应体数据
            3、响应空行
            4、响应体
## Response
    * 功能：设置响应消息
        1、设置响应行
            1、格式：http://1.1 200 ok
            2、设置状态码：setStatus（int sc）
        2、设置响应头：setHeader（String name，String value）
        3、设置响应体：
            * 使用步骤
                1、获取输出流
                    * 字符输出流：PrintWriter getWriter（）
                    * 字节输出流：ServletOutputStream getOutputStream()
                2、使用输出流，将数据输出到客户端浏览器
## 方法：
    1、重定向：资源跳转的方式
        * 代码实现：
            1、设置状态码
            response.setStatus(302);
            //2、设置location的值
            response.setHeader("location","/ServletDemo/ResponseDemo02");
            //封装好的重定向方法，原理还是 1，2
            response.sendRedirect("/ServletDemo/ResponseDemo02");
        1、重定向（sendRidirect）的特点：
            1、地址栏发生变化
            2、重定向可以访问其它站点（服务器）的资源
            3、重定向是两次请求，不能用request对象来共享数据
        2、转发（getRequestDispatcher)的特点：
            1、转发地址栏不变
            2、转发只能访问当前服务器下的资源
            3、转发是一次请求，可以使用request对象来共享数据
        * 路径写法：
            1、相对路径：通过相对路径不可以确定唯一资源
                * 如：./index.html
                * 规则：找到当前资源和目标资源之间的相对位置关系
                    * ./表示当前目录
                    * ../后退一级目录
            2、绝对路径：通过决定路径可以确定唯一资源
                * 如：http：//localhost/day15/responseDemo02
                * 以/开头的路径
                    * 给客户端使用，需要加虚拟目录
                        * 可以动态获取 request.getContextPath()
                    * 给服务器使用，不需要加虚拟目录
    2、服务器输出字符流数据到浏览器
        * 步骤
            1、获取字符流
            2、输出数据
                * 中文乱码问题：
                //1、获取流对象之前，设置流的对象为utf-8，流对象的默认编码为ISO-8859-1
                        response.setCharacterEncoding("utf-8");    
                //2、告诉浏览器，服务器发送消息体数据的编码，建议浏览器使用该编码解码
                        response.setHeader("content-type","text/html;charset=utf-8"); 
                //使用封装好的方法，设置消息体数据的编码
                        response.setContentType("text/html;charset=utf-8");
    3、服务器输出字节流数据写到浏览器
    4、校验码
## ServletContext
    1、获取：this.getServletContext();或者request.getServletContext()
    2、方法：
        1、getRealPath（）获取真实路径，tomcat服务器下的真实路径
        2、getMimeType（）获取文件名称，大类型/小类型  类型与 text/html
        3、获取元素（getAttrubute setAttribute removeAttribute） 慎用，从服务器开启时就一直存在