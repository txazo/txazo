package org.txazo.wx.app.user;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.app.user.bean.User;
import org.txazo.wx.app.user.service.UserService;

import java.util.List;

/**
 * UserServiceImplTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public class UserServiceImplTest extends SpringAbstractTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUserName("txazo1218");
        user.setTrueName("涂小洲");
        user.setPrivilege(1);
        Assert.assertTrue(userService.addUser(user));
    }

    @Test
    public void testDeleteUser() {
        Assert.assertTrue(userService.deleteUser(1));
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1);
        user.setUserName("txazo1218");
        user.setTrueName("涂小洲");
        user.setPrivilege(2);
        Assert.assertTrue(userService.updateUser(user));
    }

    @Test
    public void testGetUser() {
        Assert.assertNotNull(userService.getUser(1));
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        Assert.assertTrue(CollectionUtils.isNotEmpty(users));
    }

}
