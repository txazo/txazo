package org.txazo.reflection.vo;

import org.txazo.reflection.anno.*;

/**
 * AnnoClass
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 28.05.2015
 */
@ClassAnno
public class AnnoClass {

    @FieldAnno()
    private int id;

    @ConstructorAnno
    public AnnoClass() {
    }

    @MethodAnno
    public void setId(int id) {
        @LocalAnno String name;
    }

    public void param(@ParamAnno(name = "id") int id, @ParamAnno(name = "name") String name) {
    }

}
