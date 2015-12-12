package org.txazo.java.collection.list;

import org.junit.Test;
import org.txazo.util.time.TimeWatch;
import org.txazo.util.time.TimeWatchTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * RandomAccess
 *
 * @see java.util.RandomAccess
 */
public class RandomAccessTest {

    /**
     * RandomAccess
     * <pre>
     * 1) List的标记接口, 标识List支持快速随机访问
     * 2) 实现RandomAccess的List遍历时, for (int i = 0, n = list.size(); i < n; i++)性能高于
     *    for (Iterator i = list.iterator(); i.hasNext(); )
     * 3) 原理: Iterator.next()比<List extends RandomAccess>.get()多几步操作
     * 4) RandomAccess的实现类有:
     *    Stack
     *    Vector
     *    ArrayList
     *    CopyOnWriteArrayList
     * </pre>
     */

    @Test
    public void test() throws Throwable {
        int times = 100000;
        final List<Integer> list = new ArrayList<Integer>(1000000);
        for (int i = 0, n = list.size(); i < n; i++) {
            list.add(i);
        }

        TimeWatch timeWatch = new TimeWatch();

        timeWatch.watch("RandomAccess", times, new TimeWatchTask() {

            @Override
            public void execute() {
                for (int i = 0, n = list.size(); i < n; i++) {
                    list.get(i);
                }
            }

        });

        timeWatch.watch("Iterator", times, new TimeWatchTask() {

            @Override
            public void execute() {
                for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
                    i.next();
                }
            }

        });

        timeWatch.showTime();
    }

}
