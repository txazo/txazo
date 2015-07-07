package org.txazo.wx.app.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.wx.app.common.mapper.UserMapper;
import org.txazo.wx.app.common.service.UserService;

/**
 * UserServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

}
