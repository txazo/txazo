package org.txazo.blog.module.user.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.common.cache.CacheKey;
import org.txazo.blog.common.cache.CacheService;
import org.txazo.blog.common.constant.Key;
import org.txazo.blog.module.user.bean.User;
import org.txazo.blog.module.user.dao.UserDao;
import org.txazo.blog.module.user.service.UserService;

import javax.annotation.Resource;

/**
 * UserServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String USER_ID_KEY = "User_Id_";

    @Autowired
    private UserDao userDao;

    @Resource
    private CacheService cacheService;

    @Override
    public boolean addUser(User user) {
        if (checkUser(user)) {
            try {
                return userDao.addUser(user) > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        if (checkUser(user)) {
            try {
                if (userDao.updateUser(user) > 0) {
                    clearUserCache(user.getId());
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkUser(User user) {
        return user != null &&
                StringUtils.isNoneBlank(user.getEmail()) &&
                StringUtils.isNoneBlank(user.getPassWord()) &&
                StringUtils.isNoneBlank(user.getEncryptKey()) &&
                StringUtils.isNoneBlank(user.getUserName()) &&
                StringUtils.isNoneBlank(user.getAvatar()) &&
                user.getPrivilege() >= 0;
    }

    private CacheKey getUserKey(int id) {
        return new CacheKey(Key.USER_ID, id);
    }

    private void clearUserCache(int id) {
        cacheService.delete(getUserKey(id));
    }

    @Override
    public boolean removeUser(int id) {
        if (userDao.removeUser(id) > 0) {
            clearUserCache(id);
            return true;
        }
        return false;
    }

    @Override
    public User getUser(int id) {
        CacheKey key = getUserKey(id);
        User user = cacheService.get(key, User.class);
        if (user == null) {
            user = userDao.getUser(id);
            if (user != null) {
                cacheService.set(key, user);
            }
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return StringUtils.isBlank(email) ? null : userDao.getUserByEmail(email);
    }

    @Override
    public User getUserByUserName(String userName) {
        return StringUtils.isBlank(userName) ? null : userDao.getUserByUserName(userName);
    }

}
