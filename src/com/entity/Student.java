package com.entity;

//学生类
public class Student {
    private int id;
    private String name;
    private String sex;
    //通过属性成员将两个类连接起来
    private StudentCard studentCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public StudentCard getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }

    public Student(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Student() {
    }

    @Override
    public String toString() {
        //return this.id+","+this.name+","+this.sex;
        return this.id+","+this.name+","+this.sex+","+this.studentCard.getCardid()+","+this.studentCard.getCardinfo();
    }
}
