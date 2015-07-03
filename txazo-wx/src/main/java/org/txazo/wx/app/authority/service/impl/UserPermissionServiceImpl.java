package org.txazo.wx.app.authority.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.txazo.wx.app.authority.enums.AuthorityType;
import org.txazo.wx.app.authority.service.UserPermissionService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * UserPermissionServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    private static Map<String, AuthorityType> userPermissions = new ConcurrentHashMap<String, AuthorityType>();

    static {
        userPermissions.put("txazo1218", AuthorityType.ADMIN);
        userPermissions.put("ilk413", AuthorityType.MEMORY_READ);
    }

    @Override
    public boolean checkUserPermission(String user, AuthorityType type) {
        if (StringUtils.isBlank(user) || type == null) {
            return false;
        }
        AuthorityType userAuthorityType = userPermissions.get(user);
        return userAuthorityType != null && (userAuthorityType.getId() & type.getId()) > 0;
    }

}
