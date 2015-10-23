(function ($) {
    function openBlock(options, timeout, timeoutCallback) {
        $.blockUI(options);
        timeout && setTimeout(function () {
            timeoutCallback && timeoutCallback();
        }, timeout);
    }

    function closeBlock(callback) {
        $.unblockUI();
        callback();
    }

    var DialogType = {
        Tip: 1,
        Alert: 2,
        Confirm: 3,
        Input: 4
    };

    var Dialog = {
        dialog_title: '<div class="dialog_title">',
        dialog_text: '<div class="dialog_text" style="margin:10px; text-align:center;">',
        dialog_button: '<div class="dialog_button">',
        dialog_div_suffix: '</div>',
        dialog_button_ok: '<button type="button" class="btn btn-success ok">',
        dialog_button_cancel: '<button type="button" class="btn btn-danger cancel">',
        dialog_button_hidden: '<button type="button" class="hidden">',
        dialog_button_suffix: '</button>'
    };

    function buildDialog(type, options) {
        if (type == DialogType.Tip) {
            return Dialog.dialog_text + options.text + Dialog.dialog_div_suffix;
        }
    }

    $.extend({
        blockTip: function (options) {
            var defaults = {
                text: 'Tip',
                timeout: 100000,
                css: {
                    width: '20%',
                    left: '40%',
                    color: 'green',
                    border: 'none',
                    // border: '3px solid #a00',
                    '-webkit-border-radius': '10px',
                    '-moz-border-radius': '10px',
                    backgroundColor: '#999'
                },
                overlayCSS: {
                    opacity: '.6'
                }
            };
            $.extend(defaults, options);
            openBlock({
                message: buildDialog(DialogType.Tip, options),
                css: defaults.css,
                overlayCSS: defaults.overlayCSS
            }, defaults.timeout, closeBlock);
        },

        blockAlert: function (options) {
            var $dialog;
            var defaults = {
                title: '提示',
                text: '',
                ok: '确定',
                Ok: function () {
                }
            };

            $.extend(defaults, options);

            init();
            openDialog();

            function init() {
                defaults.dialog = '<div class="modal-body" style="text-align: center; margin-top: 10px;">' +
                '<div>' + defaults.text + '</div></div>' +
                '<div class="modal-footer" style="text-align: center; padding-top: 0px; border-top: 0px;">' +
                '<button type="button" class="btn-hidden" style="width:1px;"></button>' +
                '<button type="button" class="btn btn-success ok" style="padding-left: 10px; padding-right: 10px;">' + defaults.ok + '</button>' +
                '</div>';
            }

            function openDialog() {
                $dialog = $(defaults.dialog).delegate('.ok', 'click', Ok);
                $.blockUI({
                    message: $dialog,
                    css: {
                        width: '20%',
                        left: '40%'
                    }
                });
                setTimeout(function () {
                    $dialog.find('.btn-hidden').remove();
                }, 10);
            }

            function Ok() {
                defaults.Ok();
                $.unblockUI();
            }
        },

        blockConfirm: function (options) {
            var defaults = {
                title: '提示',
                text: '',
                ok: 'ok',
                cancel: 'cancel',
                Ok: function () {
                },
                Cancel: function () {
                }
            };

            $.extend(defaults, options);

            init();
            openDialog();

            function init() {
                defaults.dialog = '<div class="modal-header">' +
                    // '<button type="button" class="close">×</button>' +
                '<h4 class="modal-title">' + defaults.title + '</h4></div>' +
                '<div class="modal-body" style="text-align: center">' +
                '<div>' + defaults.text + '</div></div>' +
                '<div class="modal-footer" style="text-align: center">' +
                '<button type="button" class="btn btn-success ok">' + defaults.ok + '</button>' +
                '<button type="button" class="btn btn-danger cancel" style="margin-left: 50px;">' + defaults.cancel + '</button>' +
                '</div>';
            }

            function openDialog() {
                $.blockUI({
                    message: $(defaults.dialog).delegate('.ok', 'click', Ok)
                        // .delegate('.close', 'click', Cancel)
                        .delegate('.cancel', 'click', Cancel)
                });
            }

            function Ok() {
                defaults.Ok();
                $.unblockUI();
            }

            function Cancel() {
                defaults.Cancel();
                $.unblockUI();
            }
        },

        blockInput: function (options) {
            var $dialog;
            var defaults = {
                text: '请输入',
                ok: 'Ok',
                cancel: 'Cancel',
                Ok: function () {
                }
            };

            $.extend(defaults, options);

            init();
            openDialog();

            function init() {
                defaults.dialog =
                    '<div class="modal-body" style="text-align: center">' +
                    '<div>' + defaults.text + '</div></div>' +
                    '<div class="modal-body form-group" style="text-align: center">' +
                    '<input type="text" class="form-control input" /></div>' +
                    '<div class="modal-footer" style="text-align: center; padding-top: 0px; border-top: 0px;">' +
                    '<button type="button" class="btn btn-success ok">' + defaults.ok + '</button>' +
                    '<button type="button" class="btn btn-danger cancel" style="margin-left: 50px;">' + defaults.cancel + '</button>' +
                    '</div>';
            }

            function openDialog() {
                $dialog = $(defaults.dialog).delegate('.ok', 'click', Ok)
                    .delegate('.cancel', 'click', Cancel);
                $.blockUI({
                    message: $dialog
                });
            }

            function Ok() {
                var $input = $dialog.find('.input');
                var text = $input.val();
                if (text == null || text.trim() == '') {
                    $input.focus().closest('.form-group').addClass('has-error');
                    return;
                }
                $.unblockUI();
                defaults.Ok(text);
            }

            function Cancel() {
                $.unblockUI();
            }
        }
    });
})
(jQuery);
