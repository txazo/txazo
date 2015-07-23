package org.txazo.test.util;

import java.util.Collection;

/**
 * CollectionUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 25.05.2015
 */
public class CollectionUtils {

    public static boolean isEmpty(final Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(final Collection<?> coll) {
        return !isEmpty(coll);
    }

}
