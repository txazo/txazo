package org.txazo.reflection.remote.service;

import org.txazo.reflection.remote.api.VersionApi;

/**
 * VersionService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 29.05.2015
 */
public class VersionService implements VersionApi {

    @Override
    public String getVersion() {
        return "1.0";
    }

}
