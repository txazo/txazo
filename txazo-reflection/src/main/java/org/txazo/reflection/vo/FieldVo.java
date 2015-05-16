package org.txazo.reflection.vo;

import org.txazo.reflection.anno.FieldAnno;

/**
 * ReflectionField
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.05.2015
 */
public class FieldVo {

    public static int NUM;

    @FieldAnno(desc = "id")
    private int id;
    private String name;

    public FieldVo() {
    }

    public FieldVo(int id, String name) {
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
