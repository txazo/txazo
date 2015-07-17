(function ($) {
    $.fn.extend({
        multiTextArea: function (options) {
            var defaults = {
                name: 'textarea',
                left: 3,
                leftPaddingTop: '12px',
                leftContent: '<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>',
                middle: 8,
                middleRow: 2,
                right: 1,
                rightPaddingTop: '12px',
                rightPlus: '<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>',
                rightMinus: '<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>'
            };

            var settings = $.extend(defaults, options);
            settings.this = this;

            init(settings);
            bindClick(settings);

            function init(settings) {
                $(buildTextArea(0)).appendTo($(settings.this)).show();
            }

            function bindClick(settings) {
                $(settings.this).delegate('.plus', 'click', function () {
                    $(buildTextArea(1)).insertAfter($(this).closest('.text-area-multi'))
                        .animate({
                            height: 'toggle'
                        });
                }).delegate('.minus', 'click', function () {
                    $(this).closest('.text-area-multi').animate({
                        height: 'toggle'
                    }, function() {
                        $(this).remove();
                    });
                });
            }

            function buildTextArea(type) {
                var html = '<div class="form-group text-area-multi" style="display: none;">';
                html += '<div class="col-xs-' + settings.left + '" style="padding-top: ' + settings.leftPaddingTop + ';">';
                html += settings.leftContent;
                html += '</div>';
                html += '<div class="col-xs-' + settings.middle + '">';
                html += '<textarea name="' + settings.name + '" class="form-control" rows="' + settings.middleRow + '" required></textarea>';
                html += '</div>';
                html += '<div class="col-xs-' + settings.right + '" style="padding-top: ' + settings.rightPaddingTop + ';">';
                html += '<a href="javascript:;" class="' + (type == 0 ? 'plus' : 'minus') + '">' + (type == 0 ? settings.rightPlus : settings.rightMinus) + '</a>';
                html += '</div>';
                html += '</div>';
                return html;
            }
        }
    });
})(jQuery);
