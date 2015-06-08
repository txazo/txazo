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

    public void addRemind(Remind remind);

    public List<Remind> getAllReminds();

}
