package com.entity;

import java.util.List;

public class StudentClass {
    private int classid;
    private String classname;
    //通过该字段将StudentClass和Student关联起来
    List<Student> students;

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return this.classid+","+this.classname;
    }
}
