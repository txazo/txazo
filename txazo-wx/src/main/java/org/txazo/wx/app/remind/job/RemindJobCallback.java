package org.txazo.wx.app.remind.job;

import org.apache.commons.lang3.RandomUtils;
import org.txazo.util.schedule.quartz.job.JobCallback;
import org.txazo.weixin.WeiXinUtils;
import org.txazo.weixin.develop.message.MessageBuilder;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.bean.RemindExt;
import org.txazo.wx.app.remind.constant.RemindConstant;
import org.txazo.wx.app.remind.enums.RemindShowType;
import org.txazo.wx.app.remind.service.RemindService;

/**
 * RemindJobCallback
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.07.2015
 */
public class RemindJobCallback implements JobCallback<Remind> {

    private RemindService remindService;

    public RemindJobCallback(RemindService remindService) {
        this.remindService = remindService;
    }

    @Override
    public void callback(Remind remind) throws Exception {
        int index = 0;
        RemindExt ext = remind.getExt();
        int length = ext.getContent().length;
        if (ext.getShowType() == RemindShowType.SEQUENCE.getId()) {
            index = ext.getNext();
            ext.setNext((index + 1) % length);
            remind.setExt(ext);
            remindService.updateRemind(remind);
        } else {
            index = RandomUtils.nextInt(0, length);
        }

        WeiXinUtils.sendMessage(MessageBuilder.buildTextMessage(remind.getUserName(),
                RemindConstant.REMIND_AGENT_ID, remind.getExt().getContent()[index]));
    }

}
