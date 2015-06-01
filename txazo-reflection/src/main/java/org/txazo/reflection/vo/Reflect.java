package org.txazo.reflection.vo;

import org.txazo.reflection.anno.ClassAnno;
import org.txazo.reflection.anno.FieldAnno;

/**
 * Reflect
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 24.05.2015
 */
@ClassAnno
public class Reflect extends SuperReflect implements ReflectInterface {

    public static int NUM = 1;

    @FieldAnno(desc = "id")
    private int id;
    private String name;

    public Reflect() {
    }

    public Reflect(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private void privateMethod() {
    }

    public static void setNUM(int NUM) {
        Reflect.NUM = NUM;
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
