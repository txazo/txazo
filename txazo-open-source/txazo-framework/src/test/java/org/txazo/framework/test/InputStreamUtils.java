package org.txazo.framework.test;

import org.txazo.framework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class InputStreamUtils {

    public static String getString(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            return StringUtils.EMPTY;
        }
    }

}
