package org.txazo.wx.app.user.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.wx.app.user.bean.User;
import org.txazo.wx.app.user.mapper.UserMapper;
import org.txazo.wx.app.user.service.UserService;
import org.txazo.wx.cache.CacheService;

import java.util.List;

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

    @Autowired
    private CacheService cacheService;

    @Override
    public boolean addUser(User user) {
        if (checkUser(user)) {
            try {
                userMapper.addUser(user);
                return user.getId() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkUser(User user) {
        return user != null
                && user.getId() >= 0
                && StringUtils.isNoneBlank(user.getUserName())
                && StringUtils.isNoneBlank(user.getTrueName())
                && user.getPrivilege() >= 0;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean res = userMapper.deleteUser(id) > 0;
        if (res) {
            clearUserCache(id);
        }
        return res;
    }

    @Override
    public boolean updateUser(User user) {
        boolean res = false;
        if (checkUser(user)) {
            try {
                res = userMapper.updateUser(user) > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (res) {
            clearUserCache(user.getId());
        }
        return res;
    }

    @Override
    public User getUser(int id) {
        return getUserFromCache(id);
    }

    private String getUserKey(int id) {
        return "user_" + id;
    }

    private User getUserFromCache(int id) {
        String key = getUserKey(id);
        User user = cacheService.get(key, User.class);
        if (user == null) {
            user = userMapper.getUser(id);
            if (user != null) {
                cacheService.set(key, user, 600);
            }
        }
        return user;
    }

    private void clearUserCache(int id) {
        cacheService.delete(getUserKey(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

}
