package org.txazo.java.io;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * FileFilterTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.io.FileFilter
 * @since 27.07.2015
 */
public class FileFilterTest {

    /**
     * FileFilter - File.listFiles(FileFilter filter)过滤文件
     */

    @Test
    public void test() {
        File parent = new File("/Users/txazo");
        /** 回调模式 */
        File[] childs = parent.listFiles(new DefaultFileFilter());
        if (ArrayUtils.isNotEmpty(childs)) {
            for (File child : childs) {
                System.out.println(child.getName());
            }
        }
    }

    private class DefaultFileFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            return "Downloads".equalsIgnoreCase(pathname.getName());
        }

    }

}
