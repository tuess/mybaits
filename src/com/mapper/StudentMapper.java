package com.mapper;

import com.entity.Student;
import com.entity.StudentBusinsess;
import com.entity.StudentClass;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//操作mybatis的接口
public interface StudentMapper {
    /*方法名和mapper.xml文件中的id名一样
      方法的输入参数和mapper.xml文件中的标签的parameterType类型一致
      方法的返回值和mapper.xml文件中的resultType类型一致*/

    //查询单个学生
    Student queryStudentById(int id);

    //查询全部学生
    List<Student> queryAllStudent();

    //增加学生
    void addStudent(Student student);

    //删除学生
    void deleteStudentById(int id);

    //修改学生
    Student updateStudent(Student student);

    //查询学生并排序
    List<Student> queryAllStudentOrderByColumn(String column);

    //模糊查询学生
    List<Student> queryAllStudentOrderByIdOrName(Student student);

    //模糊查询学生withHashMap
    List<Student> queryAllStudentOrderByIdOrNameWithHashMap(Map<String,Object> map);

    //调用存储过程查询学生
    List<Student>  queryStudentWithProcedure();

    //输出HashMap类型
    List<HashMap<String,Object>> queryStudentOutByHashMap();

    //类型不一致通过resultMap转换
    Student queryStudentWithAnotherName(int id);

    //类型不一致通过HashMap转换
    Student queryStudentWithHashMap(int id);

    //动态sql语句
    Student queryStudentByNameWithTag(Student student);

    //where语句处理的动态sql语句
    Student queryStudentWithTag(Student student);

    //foreach处理数组
    List<Student> queryStudentWithForeach(int[] id);

    //业务扩展类形式的一对一
    StudentBusinsess queryStudentByIdWithOO(int id);

    //resultMap形式的一对一
    Student queryStudentResultMapByIdWithOO(int id);

    //一对多
    StudentClass queryClassAndStudents(int classid);
}
