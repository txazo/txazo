package org.txazo.java.pattern.behavior.observer.core;

import org.junit.Test;

/**
 * ObserverTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class ObserverTest {

    @Test
    public void test() {
        Subject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("张三"));
        subject.attach(new ConcreteObserver("李四"));
        subject.attach(new ConcreteObserver("王五"));
        subject.change("本周五放假一天");
        subject.change("下周二晚上7点学院集合");
    }

}
