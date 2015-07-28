package org.txazo.java.collection.list;

import org.junit.Test;
import org.txazo.util.time.ExecutionUtils;
import org.txazo.util.time.Executor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * RandomAccessTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.RandomAccess
 * @since 28.07.2015
 */
public class RandomAccessTest {

    /**
     * RandomAccess
     * <p/>
     * 1) 用来被List实现, 为List提供快速随机访问功能
     * 2) 使用List.get()遍历性能高于Iterator遍历
     */

    @Test
    public void test() {
        int times = 10000;
        final List<Integer> list = new ArrayList<Integer>(1000000);
        for (int i = 0, length = list.size(); i < length; i++) {
            list.add(i);
        }

        ExecutionUtils.executeTime("RandomAccess", times, new Executor() {

            @Override
            public void execute() {
                for (int i = 0, length = list.size(); i < length; i++) {
                    list.get(i);
                }
            }

        });

        ExecutionUtils.executeTime("Iterator", times, new Executor() {

            @Override
            public void execute() {
                for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
                    iterator.next();
                }
            }

        });
    }

}
