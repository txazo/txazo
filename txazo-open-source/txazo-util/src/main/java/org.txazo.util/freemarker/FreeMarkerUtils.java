package org.txazo.util.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * FreeMarker工具类
 *
 * @author xiaozhou.tu
 * @email xiaozhou.tu@dianping.com
 * @date 2015-09-10
 */
public abstract class FreeMarkerUtils {

    private static Configuration cfg = null;
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String TEMPLATE_DIRECTORY = "/freemarker";

    static {
        try {
            cfg = new Configuration();
            cfg.setDefaultEncoding(DEFAULT_ENCODING);
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            cfg.setDirectoryForTemplateLoading(new File(FreeMarkerUtils.class.getResource(TEMPLATE_DIRECTORY).getPath()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] getTemplate(String input, Map<String, Object> dataMap) throws Exception {
        return getTemplate(input, DEFAULT_ENCODING, dataMap);
    }

    public static byte[] getTemplate(String input, String encoding, Map<String, Object> dataMap) throws Exception {
        Writer out = null;
        ByteArrayOutputStream baos = null;
        try {
            Template template = cfg.getTemplate(input, encoding);
            baos = new ByteArrayOutputStream();
            out = new OutputStreamWriter(baos);
            template.process(dataMap, new OutputStreamWriter(baos));
            out.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(baos);
        }
    }

}
