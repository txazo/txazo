package org.txazo.wx.app.user.service;

import org.txazo.wx.app.user.bean.User;

import java.util.List;

/**
 * UserService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public interface UserService {

    public boolean addUser(User user);

    public boolean deleteUser(int id);

    public boolean updateUser(User user);

    public User getUser(int id);

    public User getUser(String userName);

    public List<User> getAllUsers();

}
