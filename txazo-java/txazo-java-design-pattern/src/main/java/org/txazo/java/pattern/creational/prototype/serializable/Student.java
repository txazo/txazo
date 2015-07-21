package org.txazo.java.pattern.creational.prototype.serializable;

import java.io.Serializable;

/**
 * Student
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 5605038846230829095L;

    private int id;
    private String name;
    private Teacher teacher;

    public Student() {
    }

    public Student(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
