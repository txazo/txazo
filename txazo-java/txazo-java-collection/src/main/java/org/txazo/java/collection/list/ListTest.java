package org.txazo.java.collection.list;

import org.junit.Test;
import org.txazo.util.test.ExecutionUtils;
import org.txazo.util.test.Executor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ListTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.List
 * @since 28.07.2015
 */
public class ListTest {

    @Test
    public void test() {
        final List<Integer> arrayList = new ArrayList<Integer>(100000);
        final List<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0, n = arrayList.size(); i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        testLoop("ArrayList", arrayList);
        testLoop("LinkedList", linkedList);
    }

    public void testLoop(String loopName, final List<Integer> list) {
        int times = 1000000;

        ExecutionUtils.execute(loopName + " Loop1", times, new Executor() {

            @Override
            public void execute() {
                /** List遍历方式一, ArrayList遍历推荐使用 */
                for (int i = 0, n = list.size(); i < n; i++) {
                    list.get(i);
                }
            }

        });

        ExecutionUtils.execute(loopName + " Loop2", times, new Executor() {

            @Override
            public void execute() {
                /** List遍历方式二, 内部实现为Iterator */
                for (Integer i : list) {
                }
            }

        });

        ExecutionUtils.execute(loopName + " Loop3", times, new Executor() {

            @Override
            public void execute() {
                /** List遍历方式三, LinkedList遍历推荐使用 */
                for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
                    i.next();
                }
            }

        });

        ExecutionUtils.execute(loopName + " Loop4", times, new Executor() {

            @Override
            public void execute() {
                /** List遍历方式四 */
                Iterator<Integer> i = list.iterator();
                while (i.hasNext()) {
                    i.next();
                }
            }

        });
    }

}
