package org.txazo.java.pattern.creational.prototype.serializable;

import java.io.Serializable;

/**
 * Teacher
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 5772687179489753032L;

    private int id;
    private String name;

    public Teacher() {
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
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

}
