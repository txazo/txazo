package org.txazo.wx.app.remind.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.util.schedule.quartz.util.CronUtils;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.bean.RemindExt;
import org.txazo.wx.app.remind.enums.RemindShowType;
import org.txazo.wx.app.remind.enums.RemindType;
import org.txazo.wx.app.remind.mapper.RemindMapper;
import org.txazo.wx.app.remind.service.RemindService;

import java.util.Collections;
import java.util.Date;
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
        if (checkAddRemind(remind)) {
            try {
                return remindMapper.addRemind(remind) > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkAddRemind(Remind remind) {
        return remind != null &&
                StringUtils.isNoneBlank(remind.getUserName()) &&
                RemindType.existsType(remind.getType()) &&
                checkRemindExt(remind.getExt());
    }

    private boolean checkRemindExt(RemindExt ext) {
        return ext != null &&
                CronUtils.isValidCronExpression(ext.getCronExpression()) &&
                RemindShowType.existsType(ext.getShowType()) &&
                ArrayUtils.isNotEmpty(ext.getContent());
    }

    @Override
    public boolean deleteRemind(int id) {
        return id > 0 && remindMapper.deleteRemind(id) > 0;
    }

    @Override
    public boolean updateRemind(Remind remind) {
        if (checkUpdateRemind(remind)) {
            try {
                return remindMapper.updateRemind(remind) > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkUpdateRemind(Remind remind) {
        return remind != null &&
                remind.getId() > 0 &&
                RemindType.existsType(remind.getType()) &&
                checkRemindExt(remind.getExt());
    }

    @Override
    public boolean updateRemindStatus(Remind remind) {
        return checkUpdateRemindStatus(remind) && remindMapper.updateRemindStatus(remind) > 0;
    }

    private boolean checkUpdateRemindStatus(Remind remind) {
        return remind != null &&
                remind.getId() > 0 &&
                (remind.getStatus() == 0 || remind.getStatus() == 1);
    }

    @Override
    public Remind getRemind(int id) {
        return id <= 0 ? null : remindMapper.getRemind(id);
    }

    @Override
    public List<Remind> getRemindsByUserName(String userName) {
        return StringUtils.isBlank(userName) ? Collections.EMPTY_LIST : remindMapper.getRemindsByUserName(userName);
    }

    @Override
    public List<Remind> getAllValidReminds() {
        List<Remind> reminds = remindMapper.getAllValidReminds();
        if (CollectionUtils.isNotEmpty(reminds)) {
            for (Iterator<Remind> iterator = reminds.iterator(); iterator.hasNext(); ) {
                filterRemind(iterator);
            }
        }
        return reminds;
    }

    private void filterRemind(Iterator<Remind> iterator) {
        if (!isValidRemind(iterator.next())) {
            iterator.remove();
        }
    }

    private boolean isValidRemind(Remind remind) {
        RemindExt ext = remind.getExt();
        if (!checkRemindExt(ext)) {
            return false;
        }
        return isBetweenBeginAndEnd(ext.getBeginTime(), ext.getEndTime());
    }

    private boolean isBetweenBeginAndEnd(Date beginTime, Date endTime) {
        Date now = null;
        return (beginTime == null || beginTime.before(now = new Date())) &&
                (endTime == null || endTime.after(now));
    }

}
