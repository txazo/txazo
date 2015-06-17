package org.txazo.wx.app.email;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;

/**
 * EmailReceiverTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.06.2015
 */
public class EmailReceiverTest extends SpringAbstractTest {

    @Autowired
    private EmailReceiver emailReceiver;

    @Test
    public void testReceiveEmail() {
        emailReceiver.receiveEmail();
    }

}
