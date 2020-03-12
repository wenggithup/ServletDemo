## JSP：
    1、指令
        * 作用：用户配置JSP页面，导入资源文件
        * 格式：<%@ 指令名称 属性名1=属性值1 属性名2=属性值2...%>
        * 分类：
            1、page：配置jsp页面的
                * contentType：等同于response.setContentType
                    1、响应格式和字符集
                    2、设置当前jsp页面的编码（只能是高级的IDE才能生效），如果使用低级工具，则需要设置
                        pageEncoding来设置当前的字符集
                * languge：定义脚本原因
                * import：导包
                * errorpage：当前页面发生异常后，会自动跳转到指定的错误页面
                * iserrorpage：标示当前页面是否是错误页面
                    * true，是错误页面，可以使用exception内置对象
                    * flase 不可以使用
            2、include：页面包含的，导入页面的资源文件
                
            3、taglib：导入资源
        
    2、注释：
        1、html注释：<!-- --> 只能够注释html代码片段
        2、jsp注释：<%-- --%> 注释所有的代码
    3、内置对象：
        * jsp页面中不需要创建，直接使用的对象       作用
            1、PageContxt pageContext            当前页面共享数据            可以获取其它八个内置对象
            2、HttpServletRequest request        一个请求访问的多个资源
            3、HttpSession session               一次会话的多次请求间共享数据
            4、ServletContext application        所有用户之间去共享数据
            5、HttpServletResponse response      响应对象
            6、Object page                       当前页面servlet对象        
            7、JspWriter out                     输出对象，数据输出到页面上
            8、ServletConfig config              Servlet的配置对象
            9、Throwable exception               异常对象
## MVC 开发模式
    1、M ：model，模型，javaBean
        * 完成具体的业务操作，如：查询数据库，封装对象
    2、V ：View，视图  JSp
        * 展示数据
    3、C ：Control ，控制 Servlet
        * 获取用户的输入
        * 调用模型
        * 将数据交给视图进行展示
## EL表达式
    1、概念：Expression Langugae 表达式语言
    2、作用：替换和简化jsp页面中java代码的编写
    3、语法：${表达式}
    4、注意：* jsp默认支持el表达式，如果要忽略el表达式
        1、设置jsp中page指令中：isELignored="true" 忽略当前jsp也买呢中所有的el表达式
        2、\${表达式}:忽略当前的这个el表达式
    5、使用：
        1、运算：
            运算符：
                1、算数运算符：+ - * /（div） %(mod)
                2、比较运算符：> < >= <= == !=
                3、逻辑运算符：&&(and) ||(or) !(not)
                4、空运算符：empty
                    * 功能：用户判断字符串，集合，数组对象是否为null并且长度为0
                    * ${empty list}
        2、获取值
            1、el表达式只能从域对象中获取值
            2、语法：
                1、${域名称.键名}:从指定域中获取指定键的值
                    * 域名称：
                        1、pageScope -->pageConetxt
                        2、requestScope -->request
                        3、sessionScope -->session
                        4、applicationScope -->application(ServletContext)
                    * 举例在request域中存储来name=张三
                    * 获取：${requestScope.name}
                2、获取对象、list集合、map集合
                    * 对象： 通过对象的属性来获取
                    * list集合：${域名称.键名[索引]}
                    * map集合：${域名称.键名.key名称}或者${域名称.键名["键名"]}
    3、隐式对象：el表达式中有11个隐式对象
    * pageContext：pageConetext.getRequest.getConetxtPath动态获取虚拟目录
## JSTL标签
    1、概念：javaServer Pages Tag Libray jsp标准标签库
    2、作用：用于简化和替换jsp页面上的java代码
    3、使用步骤
        1、导入jstl相关的jar包
        2、引入标签库：taglib指令：<%@ taglib %>
    4、常用的JSTL标签
        1、if    ：相当于java代码的if语句
            1、属性：
                * test必须属性，接收boolean表达式
                    * 如果为true，则显示if标签体的内容，如果为false，则不显示标签体内容
                    * 一般情况下，test属性值会结合el表达式一起使用
                * 注意：c:if标签没有else情况，想要else，则需要再定义一个if标签
        2、choose：相当于java代码的switch语句
        3、foreach：相当于java代码的for语句
            1、完成重复操作
            * 属性：
                * begin：开始值
                * end：结束值
                * var：临时变量
                * setp：步长
                * varStatus:循环状态
                    * index:容器中元素的索引，从0开始
                    * count：循环次数
            2、遍历容器
                * 属性
                var：变量属性
                items：容器对象
## 三层架构:软件设计架构
    1、界面层（表示层）：用户看到的界面，用户可以通过界面上的组键和服务器进行交互
    2、业务逻辑层：处理业务逻辑；
    3、数据访问层：操作数据存储文件的