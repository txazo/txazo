package org.txazo.java.pattern.behavior.visitor.core;

import java.util.ArrayList;
import java.util.List;

/**
 * ObjectSturcture
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class ObjectSturcture {

    private List<Destination> destinations = new ArrayList<Destination>();

    public void attach(Destination destination) {
        destinations.add(destination);
    }

    public void detach(Destination destination) {
        destinations.remove(destination);
    }

    public void display(Visitor visitor) {
        for (Destination destination : destinations) {
            destination.accept(visitor);
        }
    }

}
