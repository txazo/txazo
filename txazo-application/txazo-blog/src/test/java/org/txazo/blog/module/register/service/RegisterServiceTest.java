package org.txazo.blog.module.register.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.blog.SpringAbstractTest;
import org.txazo.blog.module.register.bean.RegisterResult;

/**
 * RegisterServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 01.07.2015
 */
public class RegisterServiceTest extends SpringAbstractTest {

    @Autowired
    private RegisterService registerService;

    @Test
    public void testRegiser() {
        String email = "784990655@qq.com";
        String passWord = "123456";
        String userName = "txazo";
        RegisterResult result = registerService.register(email, passWord, userName);
        Assert.assertTrue(result.succ());
    }

}
