package org.txazo.wx.app.remind.service;

import org.txazo.wx.app.remind.bean.Remind;

import java.util.List;

/**
 * RemindService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public interface RemindService {

    public boolean addRemind(Remind remind);

    public boolean updateRemind(Remind remind);

    public boolean deleteRemind(int id);

    public Remind getRemind(int id);

    public List<Remind> getAllReminds(String account);

    public List<Remind> getAllValidReminds(String account);

    public boolean increaseRemindedTimes(int id);

    public void remindMessage(Remind remind) throws Throwable;

}
