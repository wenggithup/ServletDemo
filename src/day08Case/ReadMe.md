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
        4、定义dao层添加curd方法