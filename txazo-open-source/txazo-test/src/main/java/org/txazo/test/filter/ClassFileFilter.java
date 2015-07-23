package org.txazo.test.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * ClassFileFilter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class ClassFileFilter implements FileFilter {

    /** 是否忽略目录 */
    private boolean ignoreDir;

    public ClassFileFilter(boolean ignoreDir) {
        this.ignoreDir = ignoreDir;
    }

    public boolean accept(File file) {
        return (ignoreDir && file.isDirectory()) || file.getName().endsWith(".class");
    }

}
