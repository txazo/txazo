package org.txazo.java.pattern.behavior.interpreter.core;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Arithmetic
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Arithmetic {

    private static Pattern plusPattern = Pattern.compile("([^\\+]+)\\+(.+)");
    private static Pattern minusPattern = Pattern.compile("([^\\-]+)\\-(.+)");
    private static Pattern mulPattern = Pattern.compile("([^\\*]+)\\*(.+)");
    private static Pattern subPattern = Pattern.compile("([^/]+)/(.+)");

    public double arithmetic(String expression) {
        return interpreter(expression).interpreter();
    }

    public Expression interpreter(String expression) {
        Matcher matcher = null;
        if ((matcher = plusPattern.matcher(expression)).find()) {
            return new PlusExpression(interpreter(matcher.group(1)), interpreter(matcher.group(2)));
        } else if ((matcher = minusPattern.matcher(expression)).find()) {
            return new MinusExpression(interpreter(matcher.group(1)), interpreter(matcher.group(2)));
        } else if ((matcher = mulPattern.matcher(expression)).find()) {
            return new MulExpression(interpreter(matcher.group(1)), interpreter(matcher.group(2)));
        } else if ((matcher = subPattern.matcher(expression)).find()) {
            return new SubExpression(interpreter(matcher.group(1)), interpreter(matcher.group(2)));
        }
        return new ValueExpression(NumberUtils.toDouble(expression, 0.0));
    }

}
