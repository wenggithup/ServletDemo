package day08Case.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource ds;
    //静态代码块，1、加载配置文件,2、获取连接池对象
    static {
        Properties pro=new Properties();
        try {
            pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //提供连接数据库的方法
    public static Connection getConnection() throws SQLException {

           return ds.getConnection();

    }

    //提供关闭数据库的方法
    public static void close(Connection con, Statement stmt){
        close(con,stmt,null);

    }
    public static void close(Connection con, Statement stmt, ResultSet rs){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public  static DataSource getDataSource(){
        return ds;
    }

}
