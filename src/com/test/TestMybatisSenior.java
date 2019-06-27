package com.test;

import com.entity.Student;
import com.entity.StudentBusinsess;
import com.entity.StudentClass;
import com.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

//普通的代理方式CRUD
public class TestMybatisSenior {

    //查询单个学生
    public static void queryStudentById() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        Student student = studentMapper.queryStudentById(10001);
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    //查询全部学生
    public static void queryAllStudent() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        List<Student> student = studentMapper.queryAllStudent();
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    //增加学生
    public static void addStudent() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建statement语句
        String statement = "com.entity.studentMapper.addStudent";
        //实例化一个要增加的对象
        Student student = new Student(10005, "小风", "男");
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        studentMapper.addStudent(student);
        //提交
        sqlSession.commit();
        //打印结果集
        System.out.println("增加成功");
        sqlSession.close();
    }

    //删除学生
    public static void deleteStudentById() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        studentMapper.deleteStudentById(10005);
        //提交
        sqlSession.commit();
        //打印结果集
        System.out.println("删除成功");
        sqlSession.close();
    }

    //修改学生
    public static void updateStudent() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        //设置要修改哪一个人的id
        student.setId(10001);
        //设置要修改的数据
        student.setName("小白");
        student.setSex("女");
        //执行接口中的方法
        studentMapper.updateStudent(student);
        //提交
        sqlSession.commit();
        //打印结果集
        System.out.println("修改成功");
        sqlSession.close();
    }

    //查询全部学生并排序
    public static void queryAllStudentOrderByColumn() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        List<Student> student = studentMapper.queryAllStudentOrderByColumn("id");
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    //模糊查询全部学生
    public static void queryAllStudentOrderByIdOrName() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId(10002);
        student.setName("小");
        //执行接口中的方法
        List<Student> student1 = studentMapper.queryAllStudentOrderByIdOrName(student);
        //打印结果集
        System.out.println(student1);
        sqlSession.close();
    }

    //模糊查询全部学生WithHashMap
    public static void queryAllStudentOrderByIdOrNameWithHashMap() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //实例化一个map对象
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("id", 10001);
        studentMap.put("name", "小明");
        //执行接口中的方法
        List<Student> student1 = studentMapper.queryAllStudentOrderByIdOrNameWithHashMap(studentMap);
        //打印结果集
        System.out.println(student1);
        sqlSession.close();
    }

    //调用存储过程查询学生
    public static void queryStudentWithProcedure() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        List<Student> student = studentMapper.queryStudentWithProcedure();
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    //输出HashMap数组
    public static void queryStudentOutByHashMap() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        List<HashMap<String, Object>> studentMap = studentMapper.queryStudentOutByHashMap();
        //打印结果集
        System.out.println(studentMap);
        sqlSession.close();
    }

    //类型不一致通过resultMap转换
    public static void queryStudentWithAnotherName() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        Student student = studentMapper.queryStudentWithAnotherName(10001);
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    //类型不一致通过resultMap转换
    public static void queryStudentWithHashMap() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        Student student = studentMapper.queryStudentWithHashMap(10001);
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    //动态sql语句
    public static void queryStudentByNameWithTag() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("小明");
        //执行接口中的方法
        Student student1 = studentMapper.queryStudentByNameWithTag(student);
        //打印结果集
        System.out.println(student1);
        sqlSession.close();
    }

    //动态sql语句
    public static void queryStudentWithTag() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //使用where语句来处理if语句，会自动处理第一个if标签中的and
        Student student = new Student();
        student.setId(10001);
        student.setName("小白");
        //执行接口中的方法
        Student student1 = studentMapper.queryStudentWithTag(student);
        //打印结果集
        System.out.println(student1);
        sqlSession.close();
    }

    //动态sql语句
    public static void queryStudentWithForeach() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int[] id = {10001, 10002};
        //执行接口中的方法
        List<Student> student = studentMapper.queryStudentWithForeach(id);
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    //一对一查询
    public static void queryStudentByIdWithOO() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        StudentBusinsess studentBusinsess = studentMapper.queryStudentByIdWithOO(10001);
        //打印结果集
        System.out.println(studentBusinsess);
        sqlSession.close();
    }

    //使用resultMap一对一查询
    public static void queryStudentResultMapByIdWithOO() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        Student student = studentMapper.queryStudentResultMapByIdWithOO(10001);
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    //一对多查询
    public static void queryClassAndStudents() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        StudentClass studentClass = studentMapper.queryClassAndStudents(1);
        //打印结果集
        System.out.println(studentClass);
        //班级对应的学生
        List<Student> students = studentClass.getStudents();
        for(Student student:students){
            System.out.println(student.getId()+","+student.getName()+","+student.getSex());
        }
        sqlSession.close();
    }

//    使用注解添加学生
    public static void addStudentByInterface() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //实例化一个要增加的对象
        Student student = new Student(100013, "小灰灰", "男");
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        studentMapper.addStudentByInterface(student);
        //提交
        sqlSession.commit();
        //打印结果集
        System.out.println("增加成功");
        sqlSession.close();
    }

//    使用接口查询全部学生
    public static void queryAllStudentByInterface() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到接口,返回查询结果集
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //执行接口中的方法
        List<Student> student = studentMapper.queryAllStudentByInterface();
        //打印结果集
        System.out.println(student);
        sqlSession.close();
    }

    public static void main(String[] args) throws IOException {
//        可以在main方法中定义getMapper，然后每一个方法在main中调用的时候传mapper进去
//        queryStudentById();
//        queryAllStudent();
//        addStudent();
//        deleteStudentById();
//        updateStudent();
//        queryAllStudentOrderByColumn();
//        queryAllStudentOrderByIdOrName();
//        queryAllStudentOrderByIdOrNameWithHashMap();
//        queryStudentWithProcedure();
//        queryStudentOutByHashMap();
//        queryStudentWithAnotherName();
//        queryStudentWithHashMap();
//        queryStudentByNameWithTag();
//        queryStudentWithTag();
//        queryStudentWithForeach();
//        queryStudentByIdWithOO();
//        queryStudentResultMapByIdWithOO();
//        queryClassAndStudents();
//        addStudentByInterface();
        queryAllStudentByInterface();
    }
}
