## 会话技术
    1、会话：一次会话中包含多次请求和响应
        * 一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止
    2、功能：再一次会话范围类的多次请求间，共享数据
    3、方式：
        1、客户端会话技术：Cookie
        2、服务器端会话技术：Session
        
## Cookie
    1、客户端会话技术，将数据保存到客户端
    2、快速入门
        * 使用步骤
            1、创建Cookie对象，绑定数据
                * new Cookie（String，String）
            2、发送Cookie对象
                1、response.addCookie(Cookie cookie)
            3、获取Cookie对象，拿到数据
                1、Cookie []  request.getCookies()
    3、实现原理
        * 基于响应头set-cookie和请求头set-cookie实现
    4、cookie的细节：
        1、一次可不可以发送多个Cookie？
            * 可以
        2、Cookie在浏览器中可以保存多久
            * 默认情况下，当浏览器关闭后，cookie数据被销毁
            * 持久化存储
                * setMaxAge（int seconds）
                    1、正数：将Cookie数据写到硬盘的文件中，持久化存储。Cookie的存活时间
                    2、负数：默认值，存在浏览器的内存中
                    3、零：代表删除Cookie信息
        3、Cookie是否可以存储中文：
            * 在tomcat 8之前Cookie不能直接存储中文编码
            * 在tomcat 8之后支持
        4、Cookie的共享范围有多大？
            * 假设在一个tomcat服务器中，部署流多个web项目，那么在这些web项目中cookie能不能共享
                * 默认情况下不能共享
                * 如果要共享setPath（"/"），设置虚拟目录
            * 不同的tomcat服务器间cookie的共享问题：
                * 调用Cookie的setDomain（String path）：如果设置一级域名相同，那么多个服务器之间cookie可以共享
        5、Cookie的特点和作用
            1、Cookie存储数据在客户端浏览器
            2、浏览器对于单个cookie有大小和数量限制
        * 作用：
            1、cookie一般用于存储少量的不太敏感的数据
            2、在不登陆的情况下，完成服务器对客户端的身份验证
## jsp页面
    1、概念：java Server Pages：java服务器端页面
     * 可以理解为：一个特殊的页面，其中既可以定义html标签，又可以定义java代码
    2、原理
     * jsp本质上就是一个Servlet
    3、JSp的脚本：jsp定义java代码的方式
        1、<% 代码 %>:定义的java代码，在service方法中，service方法中可以定义什么，该脚本中就可以定义什么
        2、<%! 代码 %>:定义的java代码，在jsp转换后的java类中的成员位置
        3、<%= 代码 %>:定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么
    4、jsp的内置对象：
        * 在jsp页面中不需要获取和创建，可以直接使用的对象
        * jsp一共有9个内置对象
            * request：
            * response
            * out ：字符输出流对象，可以将数据输出到页面上。和response。getwriter（）类型
                out和response.getWriter的区别：
                    getWriter永远在out之前
 
 
 ## Session
    1、概念：服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。HttpSession
    2、快速入门：
        * Session是依赖于Cookie而实现的
    3、细节问题：
        1、当客户端关闭，服务器开启，两次获取的是同一个session吗？
            * 默认情况下不是
            * 可以通过cookie的setMaxAge设置最长失效值
        2、当服务器端关闭，客户端一直开启，两次获取的是否是同一个session
            * 不是同一个，但是要确保数据不丢失
                * session的钝化：
                    * 在服务器正常关闭之前，将session对象序列化到硬盘上
                * session的活化
                    * 在服务器启动后，将session文件转化为内存中session对象中
        3、生命周期
            1、服务器被关闭
            2、调用invalidate()
            3、默认事件30分装，可以在conf-xml文件中更改配置文件，更改时间
         
        