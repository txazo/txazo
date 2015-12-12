package org.txazo.java.collection.list;

import org.junit.Test;
import org.txazo.util.time.TimeWatch;
import org.txazo.util.time.TimeWatchTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * List
 *
 * @see java.util.List
 */
public class ListTest {

    @Test
    public void test() throws Throwable {
        final List<Integer> arrayList = new ArrayList<Integer>(100000);
        final List<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0, n = arrayList.size(); i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        testLoop("ArrayList", arrayList);
        testLoop("LinkedList", linkedList);
    }

    public void testLoop(String loopName, final List<Integer> list) throws Throwable {
        int times = 1000000;

        TimeWatch timeWatch = new TimeWatch();

        timeWatch.watch(loopName + " Loop1", times, new TimeWatchTask() {

            @Override
            public void execute() {
                /** List遍历方式一, ArrayList遍历推荐使用 */
                for (int i = 0, n = list.size(); i < n; i++) {
                    list.get(i);
                }
            }

        });

        timeWatch.watch(loopName + " Loop2", times, new TimeWatchTask() {

            @Override
            public void execute() {
                /** List遍历方式二, 内部实现为Iterator */
                for (Integer i : list) {
                }
            }

        });

        timeWatch.watch(loopName + " Loop3", times, new TimeWatchTask() {

            @Override
            public void execute() {
                /** List遍历方式三, LinkedList遍历推荐使用 */
                for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
                    i.next();
                }
            }

        });

        timeWatch.watch(loopName + " Loop4", times, new TimeWatchTask() {

            @Override
            public void execute() {
                /** List遍历方式四 */
                Iterator<Integer> i = list.iterator();
                while (i.hasNext()) {
                    i.next();
                }
            }

        });

        timeWatch.showTime();
    }

}
