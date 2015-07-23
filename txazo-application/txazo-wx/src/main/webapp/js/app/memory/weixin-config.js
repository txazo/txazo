$(function () {
    $.get('/weixin/servlet/getjsconfig', function (data) {
        if (!data) {
            return;
        }
        var jsConfig = data;
        wx.config({
            debug: false,
            appId: jsConfig.appId,
            timestamp: jsConfig.timestamp,
            nonceStr: jsConfig.nonceStr,
            signature: jsConfig.signature,
            jsApiList: ['hideOptionMenu', 'hideAllNonBaseMenuItem', 'hideMenuItems']
        });
    })
});

wx.ready(function () {
    // wx.hideOptionMenu();
    // wx.hideAllNonBaseMenuItem();
    // wx.hideMenuItems({
    //     menuList: ['menuItem:exposeArticle', 'menuItem:setFont']
    // });
    wx.showMenuItems({
        menuList: [
            'menuItem:refresh',
            'menuItem:favorite',
            'menuItem:share:appMessage',
            'menuItem:share:timeline',
            'menuItem:share:qq',
            'menuItem:share:QZone',
            'menuItem:share:weiboApp',
            'menuItem:addContact'
        ]
    });
});

wx.error(function (res) {
});