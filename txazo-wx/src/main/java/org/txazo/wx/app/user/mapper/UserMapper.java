package org.txazo.wx.app.user.mapper;

import org.txazo.wx.app.user.bean.User;

import java.util.List;

/**
 * UserMapper
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public interface UserMapper {

    public int addUser(User user);

    public int deleteUser(int id);

    public int updateUser(User user);

    public User getUser(int id);

    public List<User> getAllUsers();

}
