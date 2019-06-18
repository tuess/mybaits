# mybatis学习笔记
---
## 简介
MyBatis可以简化JDBC操作，实现数据的持久化，需要的jar包是mybatis的jar包和数据库的jar包  
## 配置  
conf.xml:配置数据库信息和需要加载的映射文件，可以将数据库信息保存到另外的文件中，例如db.properties，再在配置文件中通过
```<properties resource="db.properties"/>```引入。然后通过mapper.xml将表映射成为类。mapper.xml通常和表映射成的类放在一起（dao层的接口的实现类可以改名为xxxmapper.class）,mapper文件中首先需要通过namespace引入映射类，然后定义好各种CRUD语句。此映射文件需要在配置文件中加载进去。如果配置文件中使用的事务方式为 jdbc,则需要手工commit提交，即session.commit();完整例子如下：  
```
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
```  
## 输入参数  
类型为简单类型（8个基本类型+String）  
 #{}，${}的区别：  
#{任意值}，${value} ，其中的标识符只能是value