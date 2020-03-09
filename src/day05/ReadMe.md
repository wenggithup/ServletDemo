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
    


## Druid：数据库连接池技术，由阿里巴巴提供
    * 步骤：
        1、导入jar包 druid-1.0.9.jar
        2、通过类加载器引入配置文件
        3、通过druid工厂创建连接池对象
        4、获取链接
        
# Spring jdbc
    Spring框架对jdbc的简单封装，提供类一个jdbcTemplate对象简化jdbc的开发
* 步骤
    1、导入jar包
    2、创建jdbcTemplate对象，依赖于dataSource
    3、调用JdbcTemplate的方法完成CURD的操作
        * update（）执行DML语句，增删改
        * queryForMap：查询将结果集封装为map集合
        * queryForList（）：查询将结果集封装为list集合
        * query（）：查询结果，将结果封装为javabean对象
        * queryForObject：查询结果，将结果封装为对象
























