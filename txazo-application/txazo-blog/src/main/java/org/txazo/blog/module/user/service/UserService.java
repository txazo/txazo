package org.txazo.blog.module.user.service;

import org.txazo.blog.module.user.bean.User;

/**
 * UserService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public interface UserService {

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean removeUser(int id);

    public User getUser(int id);

    public User getUserByUserName(String userName);

    public User getUserByEmail(String email);

}
