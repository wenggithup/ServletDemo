## 用户信息表展示案例
    1、技术：springMvc + Servlet + mysql + jdbcTemplate + druid + BeanUtils+ jsp
    2、思路：
        1、导入项目所需jar包（
        mysql驱动jar包 mysql-jdbc.jar
        druid连接池jar包 druid-1.0.9.jar
        jdbcTemplate
                    spring-beans-5.1.10.RELEASE.jar
                    spring-core-5.1.10.RELEASE.jar
                    spring-jdbc-5.1.10.RELEASE.jar
                    spring-tx-5.1.10.RELEASE.jar
        BeanUtils
                    commons-beanutils.jar
                    commons-logging-1.2.jar
        Jstl        jstl.jar
                    standard.jar
        2、导入配置文件druid.properties连接数据库
        3、新建数据库表格，新建实体类变量对应数据库表中的数据
        4、定义dao层添加curd方法,利用Template查询并封装sql语句，完成对数据的操作
        5、利用sevlet承担控制器的效果，调用并返回参数给到前端，前端利用el表达式和c标签获取servlet中查询出来的数据
    3、功能：
        1、分页查询：
            1、新建pegeBean对象（totalPage（总页码数）、cruuentPage（当前页码）、rows（每页显示的记录条数）、totalCount（总记录条数）
               、list（页面展示数据的集合）。
            2、前端传参（rows、currentPage）：将参数放在uri列表中，当前页可以通过遍历分页标签得到变量i，rows此项目中固定写5（可以
               价格表单自定义rows条目）
            3、新建servlet获取前台传过来的参数（rows、currentPage），通过rows和currentPage返回peagBean对象，并将pageBean对象放入
               request域中，并转发至前端list页面；
            4、拿到后台对象后，使用c标签和el表达式将查询到的数据展示到页面上；
        2、增加、修改用户信息
            1、将表单action或href属性设置为对应的servlet，在修改用户信息时，要将唯一用户的标志，id传到后台
            2、获取前台传过来的参数，并通过sql语句查询返回完整的User对象，并存入request域中，之后转发到负责展示页面的serlet页面上
            3、前台将域中的数据取出，并展示；
        3、删除用户信息
            1、前台将id封装到地址栏中并传到对应的servlet中，为防止用户误操作，将删除本身的链接定义为函数，在函数中判断是否要执行当前操作
            2、在servlet中，获取到传过来的id，通过id调用dao层方法删除该用户信息，删除后转发至展示页面
        4、删除选中：
            1、设置checkbox value值，利用form表单提交时会自动将checkbox值提交，将value设置为id值，通过name属性获取id的值
            2、servlet获取参数后，通过id删除信息，并转发至展示页面
        5、模糊查询：
            1、需要在原有的分页查询基础上优化，如果没有条件则展示不查询的list页面，如果有条件，则展示通过条件查询的页面
            2、动态sql：查询所有的页面的sql语句不能固定，要写成动态sql语句，如果有条件将条件加入sql语句，如果没有条件则返回固定的sql语句

    4、总结：案例充分使用mvc结构模式，其中jsp页面负责view，servlet承担control,jdbcTemplate负责与数据库交互承担modle

