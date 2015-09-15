package org.txazo.blog.module.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.blog.SpringAbstractTest;
import org.txazo.blog.common.enums.PrivilegeType;
import org.txazo.blog.module.user.bean.User;

/**
 * UserServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class UserServiceTest extends SpringAbstractTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUserName("txazo");
        user.setPassWord("123456");
        user.setEncryptKey("121212");
        user.setEmail("784990655@qq.com");
        user.setAvatar("my.jpg");
        user.setPrivilege(PrivilegeType.ADMIN.getId());
        Assert.assertTrue(userService.addUser(user));
    }

    @Test
    public void testUpdateUser() {
        User user = userService.getUser(1);
        user.setPassWord("121212");
        user.setAvatar("my1.jpg");
        user.setPrivilege(PrivilegeType.LOGIN.getId());
        Assert.assertTrue(userService.updateUser(user));
    }

    @Test
    public void testRemoveUser() {
        Assert.assertTrue(userService.removeUser(1));
    }

    @Test
    public void testGetUser() {
        Assert.assertNotNull(userService.getUser(1));
    }

    @Test
    public void testGetUserByUserName() {
        Assert.assertNotNull(userService.getUserByUserName("txazo"));
    }

    @Test
    public void testGetUserByEmail() {
        Assert.assertNotNull(userService.getUserByEmail("784990655@qq.com"));
    }

}
