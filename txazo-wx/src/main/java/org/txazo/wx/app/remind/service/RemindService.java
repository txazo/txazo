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

    public boolean deleteRemind(int id);

    public boolean updateRemind(Remind remind);

    public boolean updateRemindStatus(Remind remind);

    public Remind getRemind(int id);

    public List<Remind> getRemindsByUserName(String userName);

    public List<Remind> getAllValidReminds();

}
