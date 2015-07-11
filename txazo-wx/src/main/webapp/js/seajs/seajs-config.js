seajs.config({
    base: 'http://127.0.0.1:8080/js/',
    charset: 'utf-8',
    vars: {
        'locale': 'zh-cn'
    },
    alias: {
        'user-add': 'app/user/add.js'
    }
});