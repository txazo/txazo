package org.txazo.java.pattern.structural.composite;

/**
 * Leaf
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void notify(String message) {
        System.out.println("Notify to " + getFullName() + " with message: " + message);
    }

}
