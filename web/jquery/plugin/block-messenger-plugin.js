(function ($) {
    var Block = {
        defaults: {
            css: {
                width: '400px',
                border: '2px solid #CCC'
            },
            overlayCSS: {
                opacity: '.5'
            }
        },
        openBlock: function (options, timeout, timeoutCallback) {
            $.blockUI($.extend({}, this.defaults, options));
            timeout && timeoutCallback && setTimeout(function () {
                timeoutCallback();
            }, timeout);
        },
        closeBlock: function (callback) {
            $.unblockUI();
            callback && callback();
        }
    };

    var Dialog = {
        Type: {
            Tip: 1,
            Alert: 2,
            Confirm: 3,
            Prompt: 4
        },
        Content: {
            dialog_text: '<div class="dialog_text" style="margin: 20px 0 0 0; text-align: center; font-size: 16px; font-weight: 500;">',
            dialog_input: '<div class="dialog_input" style="margin: 20px 0 0 0; text-align: center; padding-left: 20px; padding-right: 20px;"><input type="text" class="form-control" /></div>',
            dialog_button: '<div class="dialog_button" style="margin: 20px 0; text-align: center;">',
            dialog_div_suffix: '</div>',
            dialog_button_ok: '<button type="button" class="btn btn-success btn-ok" style="padding-left:30px; padding-right:30px;">',
            dialog_button_cancel: '<button type="button" class="btn btn-danger btn-cancel" style="margin-left:50px; padding-left:30px; padding-right:30px;">',
            dialog_button_hidden: '<button type="button" class="btn-hidden"></button>',
            dialog_button_suffix: '</button>'
        },
        buildDialog: function (type, options) {
            if (type == Dialog.Type.Tip) {
                return this.buildText(options).replace('margin: 20px 0 0 0', 'margin: 15px 0');
            } else if (type == Dialog.Type.Alert) {
                return this.buildText(options) + this.buildButton(options, {hidden: true, ok: true});
            } else if (type == Dialog.Type.Confirm) {
                return this.buildText(options) + this.buildButton(options, {hidden: true, ok: true, cancel: true});
            } else if (type == Dialog.Type.Prompt) {
                return this.buildText(options) + this.buildInput() + this.buildButton(options, {
                        hidden: true,
                        ok: true,
                        cancel: true
                    });
            }
        },
        buildText: function (options) {
            return this.Content.dialog_text + options.text + this.Content.dialog_div_suffix;
        },
        buildInput: function () {
            return this.Content.dialog_input;
        },
        buildButton: function (options, buttons) {
            var content = this.Content.dialog_button;
            if (buttons.hidden) {
                content += this.buildButtonHidden(options);
            }
            if (buttons.ok) {
                content += this.buildButtonOk(options);
            }
            if (buttons.cancel) {
                content += this.buildButtonCancel(options);
            }
            return content + this.Content.dialog_div_suffix;
        },
        buildButtonOk: function (options) {
            return this.Content.dialog_button_ok + options.ok + this.Content.dialog_button_suffix;
        },
        buildButtonCancel: function (options) {
            return this.Content.dialog_button_cancel + options.cancel + this.Content.dialog_button_suffix;
        },
        buildButtonHidden: function (options) {
            return this.Content.dialog_button_hidden;
        }
    };

    $.extend({
        blockTip: function (options) {
            var defaults = {
                text: '提示'
            };
            $.extend(defaults, options);
            Block.openBlock({
                message: Dialog.buildDialog(Dialog.Type.Tip, defaults),
                onOverlayClick: function () {
                    Block.closeBlock();
                }
            }, defaults.timeout, Block.closeBlock);
        },

        blockAlert: function (options) {
            var defaults = {
                text: '提示',
                ok: 'Ok',
                Ok: function () {
                }
            };
            $.extend(defaults, options);
            var $dialog = $(Dialog.buildDialog(Dialog.Type.Alert, defaults))
                .delegate('.btn-ok', 'click', function () {
                    Block.closeBlock(function () {
                        defaults.Ok();
                    });
                });
            Block.openBlock({
                message: $dialog
            });
            setTimeout(function () {
                $dialog.find('.btn-hidden').remove();
            }, 10);
        },

        blockConfirm: function (options) {
            var defaults = {
                text: '提示',
                ok: 'Ok',
                cancel: 'Cancel',
                Ok: function () {
                },
                Cancel: function () {
                }
            };
            $.extend(defaults, options);
            var $dialog = $(Dialog.buildDialog(Dialog.Type.Confirm, defaults))
                .delegate('.btn-ok', 'click', function () {
                    Block.closeBlock(function () {
                        defaults.Ok();
                    });
                })
                .delegate('.btn-cancel', 'click', function () {
                    Block.closeBlock(function () {
                        defaults.Cancel();
                    });
                });
            Block.openBlock({
                message: $dialog
            });
            setTimeout(function () {
                $dialog.find('.btn-hidden').remove();
            }, 10);
        },

        blockPrompt: function (options) {
            var defaults = {
                text: '提示',
                ok: 'Ok',
                cancel: 'Cancel',
                Ok: function () {
                },
                Cancel: function () {
                }
            };
            $.extend(defaults, options);
            var $dialog = $(Dialog.buildDialog(Dialog.Type.Prompt, defaults))
                .delegate('.btn-ok', 'click', function () {
                    var $input = $dialog.find('input');
                    var value = $input.val();
                    if (value == null || value.trim() == '') {
                        $input.focus().closest('.dialog_input').addClass('has-error');
                        return;
                    }
                    Block.closeBlock(function () {
                        defaults.Ok(value);
                    });
                })
                .delegate('.btn-cancel', 'click', function () {
                    Block.closeBlock(function () {
                        defaults.Cancel();
                    });
                });
            Block.openBlock({
                message: $dialog
            });
            setTimeout(function () {
                $dialog.find('.btn-hidden').remove();
            }, 10);
        },

        blockAjax: function (options) {
            var defaults = {
                text: '正在处理中'
            };
            Block.openBlock({
                message: defaults.text
            });
            var cloneOptions = $.extend({}, options);
            if (options.success) {
                options.success = function () {
                    Block.closeBlock();
                    cloneOptions.success();
                }
            }
            if (options.error) {
                options.error = function () {
                    Block.closeBlock();
                    cloneOptions.error();
                }
            }
            $.ajax(options);
        },

        blockFormSubmit: function (options) {
            var defaults = {
                text: '表单提交中'
            };
            $.extend(defaults, options);
            $('#' + defaults.form).submit(function (e) {
                e.preventDefault();
                if (!defaults.beforeSubmit()) {
                    return;
                }
                $(this).submit();
                Block.openBlock({
                    message: defaults.text
                });
            });
        }
    });
})(jQuery);
