package day08Case.Dao;
import day08Case.Bean.PageBean;
import day08Case.Bean.day04User;
import day08Case.utils.JDBCUtil;
import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

import static com.sun.tools.javadoc.Main.execute;

public class UserDao {
  private JdbcTemplate template=new JdbcTemplate(JDBCUtil.getDataSource());//定义全局变量
    //查询所有的用户信息，
    public List<day04User> selectAllUser(){
        try {
            day04User user=new day04User();
            List <day04User> list=new ArrayList<>();
            //定义sql语句
            String sql="select * from day04user";
            //使用template封装查询出来的对象
            list = template.query(sql,new BeanPropertyRowMapper<day04User>(day04User.class));
            return list;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    //插入用户信息
    public void insertUser(day04User user){
        //定义sql插入语句
        String sql="insert into day04user(name,gender,age,address,qq,email)values(?,?,?,?,?,?)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }
    //通过用户姓名删除用户信息

    public void deleteUserByid(Integer id){
        //定义删除语句
        String sql="delete from day04user where id = ?";
        template.update(sql,id);
    }

    //通过用户姓名更新信息
    public void updateUser(day04User user){
        String sql="update day04user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    public day04User selectUserById(String id) {
        Integer ids=Integer.parseInt(id);
        String sql="select * from day04user where id=?";
        day04User user = template.queryForObject(sql, new BeanPropertyRowMapper<day04User>(day04User.class),ids);
        return user;
    }

    public void deleteUserByArraysId(String[] uid) {
        for (String s : uid) {
            Integer id=Integer.parseInt (s);
            deleteUserByid (id);
        }
    }

    public PageBean<day04User> selectPageBean(String currentpage, String ROWS, Map<String,String[]> map) {
        //新建pageBean对象
        PageBean<day04User> pageBean=new PageBean<> ();
        //将参数转换成int类型
        int currentPage=Integer.parseInt (currentpage);
        int rows=Integer.parseInt (ROWS);
        //将参数封装到对象中
        pageBean.setRows (rows);
        pageBean.setCurrentPage (currentPage);
        //查询总记录数量
        int totalCount=selectAllUserCount(map);
        //计算总分页数量
        int totalPage=totalCount%rows==0?totalCount/rows : totalCount/rows+1;
        //计算每页开始的索引
        int start=(currentPage-1)*rows;
        //调用方法，查询并接收List集合

        List<day04User> list= selectUserByList(start,rows,map);
        //封装对象
        pageBean.setList (list);
        pageBean.setTotalCount (totalCount);
        pageBean.setTotalPage (totalPage);
        return pageBean;

    }
    //分页查询用户信息
    public List<day04User> selectUserByList(int start, int rows,Map<String,String[]> map) {
        String sql="select * from day04user where 1=1 ";
        //调用公共方法，得到sql语句和参数集合
        List<Object> listsql = appendSql (sql, map);
        //拿到sql语句
        StringBuilder sb =(StringBuilder) listsql.get (0);
        List list=new ArrayList ();
        //拿到存储参数列表的list集合
        list =(List) listsql.get (1);
        //追加sql语句，追加limit参数
        sb.append (" limit ?,? ");
        list.add (start);
        list.add (rows);
        //调用方法，得到list集合并返回

        List<day04User> list1 = template.query (sb.toString (), new BeanPropertyRowMapper<day04User> (day04User.class),list.toArray ());
        return list1;

    }
    //查询总记录条数
    public int selectAllUserCount(Map<String,String[]> map) {
        //定义sql模板，动态添加sql语句
        String sql="select count(*) from day04user where 1=1 ";
        List<Object> listsql = appendSql (sql, map);
        StringBuilder sb =(StringBuilder) listsql.get (0);
        List list=new ArrayList ();
        list =(List) listsql.get (1);
        Integer totalCount = template.queryForObject (sb.toString (), Integer.class,list.toArray ());
        return totalCount;
    }
    //分页模糊查询公共类
    private List<Object> appendSql(String sql,Map<String,String[]> map){
        //新建list集合，存储数据
        List listsql=new ArrayList ();
        StringBuilder sb=new StringBuilder (sql);
        Set<String> keyset = map.keySet ();
        //定义list集合存放value
        List list=new ArrayList ();
        //遍历参数列表集合
        for (String key : keyset) {
            //判断map集合中的key是否是表单中的参数，如果是，添加到sql语句上，如果不是，不添加
            String [] values=map.get (key);
            for (String value : values) {
                if(("name".equals (key)|| "address".equals (key)||"email".equals (key))&&value!=null &&!"".equals (value)){
                    //追加sql
                    sb.append (" and "+key+" like ? ");
                    list.add ("%"+value+"%");
                }
            }
        }
        listsql.add (sb);
        listsql.add (list);
        return listsql;

    }


}
