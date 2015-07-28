package org.txazo.java.lang.advanced;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * 可变长参数
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 28.07.2015
 */
public class VariableParameterTest {

    @Test
    public void test() {
        Assert.assertEquals(StringUtils.EMPTY, VariableParameter.show());
        Assert.assertEquals("1", VariableParameter.show(1));
        Assert.assertEquals("1,2", VariableParameter.show(1, 2));
        Assert.assertEquals("1,2,3", VariableParameter.show(new int[]{1, 2, 3}));
    }

    private static class VariableParameter {

        private static String show(int... params) {
            if (ArrayUtils.isEmpty(params)) {
                return StringUtils.EMPTY;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : params) {
                sb.append(i).append(",");
            }
            return sb.substring(0, sb.length() - 1);
        }

    }

}
