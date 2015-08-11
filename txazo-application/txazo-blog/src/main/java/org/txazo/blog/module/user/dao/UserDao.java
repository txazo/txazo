package org.txazo.blog.module.user.dao;

import org.txazo.blog.module.user.bean.User;

/**
 * UserDao
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public interface UserDao {

    public int addUser(User user);

    public int updateUser(User user);

    public int removeUser(int id);

    public User getUser(int id);

    public User getUserByUserName(String userName);

    public User getUserByEmail(String email);

}
