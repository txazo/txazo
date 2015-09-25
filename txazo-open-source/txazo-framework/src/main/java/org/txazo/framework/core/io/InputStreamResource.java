package org.txazo.framework.core.io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamResource extends AbstractResource {

    private final InputStream inputStream;
    private final String description;
    private boolean read;

    public InputStreamResource(InputStream inputStream) {
        this(inputStream, "resource loaded through InputStream");
    }

    public InputStreamResource(InputStream inputStream, String description) {
        this.read = false;
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream must not be null");
        } else {
            this.inputStream = inputStream;
            this.description = description != null ? description : "";
        }
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

}
