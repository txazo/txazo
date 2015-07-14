package org.txazo.wx.app.remind.mapper;

import org.txazo.wx.app.remind.bean.Remind;

import java.util.List;

/**
 * RemindMapper
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public interface RemindMapper {

    public int addRemind(Remind remind);

    public int deleteRemind(int id);

    public int updateRemind(Remind remind);

    public int updateRemindStatus(Remind remind);

    public Remind getRemind(int id);

    public List<Remind> getRemindsByUserName(String userName);

}
