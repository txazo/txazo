package org.txazo.classfile.analysis.config;

import java.io.InputStream;

public interface TagParser {

    Tag parse(InputStream inputStream) throws Exception;

}
