package org.txazo.wx.app.remind.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.mapper.RemindMapper;
import org.txazo.wx.app.remind.service.RemindService;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * RemindServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
@Service("remindService")
public class RemindServiceImpl implements RemindService {

    @Autowired
    private RemindMapper remindMapper;

    @Override
    public boolean addRemind(Remind remind) {
        try {
            return checkRemind(remind) && remindMapper.addRemind(remind) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkRemind(Remind remind) {
        return remind != null &&
                StringUtils.isNoneBlank(remind.getAccount()) &&
                StringUtils.isNoneBlank(remind.getTitle()) &&
                CronExpression.isValidExpression(remind.getCronExpression()) &&
                remind.getTotalTimes() >= 0;
    }

    @Override
    public boolean updateRemind(Remind remind) {
        try {
            return checkRemind(remind) && remind.getId() > 0 && remindMapper.updateRemind(remind) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRemind(int id) {
        return id > 0 && remindMapper.deleteRemind(id) > 0;
    }

    @Override
    public Remind getRemind(int id) {
        return id <= 0 ? null : remindMapper.getRemind(id);
    }

    @Override
    public List<Remind> getAllReminds(String account) {
        return account == null ? Collections.EMPTY_LIST : remindMapper.getAllReminds(account);
    }

    @Override
    public List<Remind> getAllValidReminds(String account) {
        List<Remind> reminds = getAllReminds(account);
        for (Iterator<Remind> iterator = reminds.iterator(); iterator.hasNext(); ) {
            if (!checkRemind(iterator.next())) {
                iterator.remove();
            }
        }
        return reminds;
    }

    @Override
    public boolean increaseRemindedTimes(int id) {
        return id > 0 && remindMapper.increaseRemindedTimes(id) > 0;
    }

}
