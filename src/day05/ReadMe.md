##HTTP:
#概念：Hyper Text Transfer protocol 超文本传输协议
    * 传输协议：定义了客户端和服务器端通信时，发送数据的格式
    * 特点：
            1、基于TCP/IP的高级协议
            2、默认端口号：80
            3、基于请求响应模型：一次请求对应一次响应
            4、无状态的：每次请求之间相互独立，不能交互数据
#请求消息格式：
    1、请求行：
        请求方式  请求url 请求协议/版本
        例子：GET/login.html Http/1.1
        请求方式：
            * http中有7中请求方式，常用的有两种
                * GET：
                    1、请求参数在请求行中，在url后
                    2、请求的url是有限制的
                    3、不太安全
                * POST
                    1、请求参数在请求体中
                    2、请求的url长度没有限制
                    3、相对安全
    2、请求头：    
        请求头名称：请求头值
        *常见的请求头
            1、User—Agent：浏览器告诉服务器，我反问你使用的浏览器的版本信息
                * 可以在夫妻段获取该头的信息，解决浏览器的兼容问题  
    3、请求空行：
    4、请求体（正文）：
    
## Request
    1、request对象和response对象的原理
        * request和response对象是由服务器创建的，我们来使用他们
        * request对象十来获取请求消息，response对象是用来设置响应消息的
    2、request对象继承体系结构
        * ServletRequest 接口
                |继承
        * HttpServletRequest 接口
                |实现
        * org.apache.catalina.connector.RequestFcade.java 
    3、request：功能：
        1、获取请求消息数据
            1、获取请求行数据
                * 方法：
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
                    
        2、其它功能
    