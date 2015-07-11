define(function (require, exports, module) {
    (function () {
        $('#add-form').submit(function (e) {
            e.preventDefault();
            var that = this;

            var userName = $('#userName').val();

            $.post('/user/checkUserExists', {
                'userName': userName
            }, function (data) {
                if (!data) {
                    showError('操作出错');
                }

                if (data.exists) {
                    var $userName = $('#userName');
                    $userName.closest('.form-group').addClass('has-error');
                    showError('微信号已经存在');
                } else {
                    that.submit();
                }
            });
        });

        function showError(msg) {
            $('#alertDanger').show().find('div').html(msg);
        }
    })();
});