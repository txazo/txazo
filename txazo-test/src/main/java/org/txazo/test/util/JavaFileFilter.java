package org.txazo.test.util;

import java.io.File;
import java.io.FileFilter;

/**
 * JavaFileFilter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class JavaFileFilter implements FileFilter {

    /** 是否递归 */
    private boolean recursive;

    public JavaFileFilter(boolean recursive) {
        this.recursive = recursive;
    }

    public boolean accept(File file) {
        return (recursive && file.isDirectory()) || file.getName().endsWith(".class");
    }

}
