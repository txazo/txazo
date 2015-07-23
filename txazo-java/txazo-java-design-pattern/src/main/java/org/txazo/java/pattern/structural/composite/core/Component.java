package org.txazo.java.pattern.structural.composite.core;

import java.util.List;

/**
 * Component
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public abstract class Component {

    private String name;
    private Component parent = null;

    public Component(String name) {
        this.name = name;
    }

    public abstract void notify(String message);

    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    public Component index(int index) {
        throw new UnsupportedOperationException();
    }

    public List<Component> list() {
        throw new UnsupportedOperationException();
    }

    public String getFullName() {
        return parent == null ? getName() : getParent().getFullName() + "-" + getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }

}
