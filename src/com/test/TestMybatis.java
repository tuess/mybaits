package com.test;

import com.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

//普通的代理方式CRUD
public class TestMybatis {

    //查询单个学生
    public static void queryStudentById() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建statement语句
        String statement = "com.entity.studentMapper.queryStudentById";
        //加载语句,返回查询结果集
        Student student = sqlSession.selectOne(statement,10001);
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
        //创建statement语句
        String statement = "com.entity.studentMapper.queryAllStudent";
        //加载语句,返回查询结果集
        List<Student> student = sqlSession.selectList(statement);
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
        Student student = new Student(10005,"小风","男");
        //加载语句,返回查询结果集
        int count = sqlSession.insert(statement,student);
        //提交
        sqlSession.commit();
        //打印结果集
        System.out.println("增加"+count+"个学生");
        sqlSession.close();
    }

    //删除学生
    public static void deleteStudentById() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建statement语句
        String statement = "com.entity.studentMapper.deleteStudentById";
        //加载语句,返回查询结果集
        int count = sqlSession.delete(statement,10005);
        //提交
        sqlSession.commit();
        //打印结果集
        System.out.println("删除"+count+"个学生");
        sqlSession.close();
    }
    //修改学生
    public static void updateStudent() throws IOException {
        //加载mybatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建statement语句
        String statement = "com.entity.studentMapper.updateStudent";
        //实例化一个要修改的对象
        Student student = new Student();
        //设置要修改哪一个人的id
        student.setId(10001);
        //设置要修改的数据
        student.setName("小黑");
        student.setSex("男");
        //加载语句,返回查询结果集
        int count = sqlSession.update(statement,student);
        //提交
        sqlSession.commit();
        //打印结果集
        System.out.println("修改"+count+"个学生");
        sqlSession.close();
    }

    public static void main(String[] args) throws IOException {
//        queryStudentById();
//        queryAllStudent();
//        addStudent();
//        deleteStudentById();
        updateStudent();
    }
}
