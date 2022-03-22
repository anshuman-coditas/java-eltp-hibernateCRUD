package com;

import javax.persistence.*;

@Entity
@Table(name = "StuInfo")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Column(name = "sname")
    private String name;

    private float marks;

}
