(function ($) {
    var JSONDiff = {
        options: {
            left: {},
            right: {},
            leftTarget: {},
            rightTarget: {}
        },
        defaultKey: '',
        nodeTemplate: '<div class="node"><div class="parent"><div class="key"></div><div class="value"></div></div><div class="child" style="display: none;"></div></div>'
    };

    JSONDiff.isTypeOf = function (value, type) {
        return value && Object.prototype.toString.call(value) === type;
    };

    JSONDiff.isArray = function (value) {
        return this.isTypeOf(value, '[object Array]');
    };

    JSONDiff.isObject = function (value) {
        return this.isTypeOf(value, '[object Object]');
    };

    JSONDiff.isString = function (value) {
        return this.isTypeOf(value, '[object String]');
    };

    JSONDiff.isNumber = function (value) {
        return this.isTypeOf(value, '[object Number]');
    };

    JSONDiff.isBoolean = function (value) {
        return this.isTypeOf(value, '[object Boolean]');
    };

    JSONDiff.isJson = function (value) {
        return this.isArray(value) || this.isObject(value);
    };

    JSONDiff.isUndefined = function (value) {
        return typeof(value) == undefined;
    };

    JSONDiff.getPropertyCount = function (value) {
        return this.isObject(value) ? Object.getOwnPropertyNames(value).length : 0;
    };

    JSONDiff.getSamePropertys = function (left, right) {
        var propertys = [];
        if (this.isObject(left) && this.isObject(right)) {
            $.each(left, function (k, v) {
                if (right.hasOwnProperty(k)) {
                    propertys.push(k);
                }
            });
        }
        return propertys;
    };

    JSONDiff.isInArray = function (value, array) {
        return $.inArray(value, array) >= 0;
    };

    JSONDiff.convertToJson = function (value) {
        if (!this.isJson(value)) {
            try {
                value = eval('(' + value + ')');
            } catch (e) {
            }
        }
        return value;
    };

    JSONDiff.buildNodeValue = function (value) {
        if (this.isArray(value)) {
            return '[ ' + value.length + ' ]';
        } else if (this.isObject(value)) {
            return '{ ' + this.getPropertyCount(value) + ' }';
        } else {
            if (value == null) {
                return 'null';
            } else if (value == '') {
                return '""';
            } else if (this.isNumber(value) || this.isBoolean(value)) {
                return value;
            } else if (this.isString(value)) {
                return '"' + value + '"';
            }
        }
        return value;
    };

    JSONDiff.buildNodeId = function (level, index, parentNode) {
        var pnid = parentNode.attr('nid');
        return (pnid ? pnid + '-' : '') + level + '-' + index;
    };

    JSONDiff.buildNode = function (level, index, key, value, parentNode) {
        var node = $(this.nodeTemplate);
        node.find('.key').html(key).css('margin-left', 80 * (level - 1) + 'px');
        node.find('.value').html(this.buildNodeValue(value));
        if (this.isJson(value)) {
            node.find('.value').css('color', '#A333C8').css('font-weight', 'bold');
        }
        parentNode.append(node);
        return node.find('.child').attr('nid', this.buildNodeId(level, index, parentNode));
    };

    JSONDiff.buildEmptyNode = function (level, index, parentNode) {
        var node = $(this.nodeTemplate);
        node.find('.key').css('margin-left', 80 * (level - 1) + 'px');
        node.find('.parent').addClass('empty').css('padding', '18px 15px');
        parentNode.append(node);
        return node.find('.child').attr('nid', this.buildNodeId(level, index, parentNode));
    };

    JSONDiff.buildNodeWithChild = function (level, index, key, value, parentNode, otherParentNode) {
        var node = this.buildNode(level, index, key, value, parentNode);
        var otherNode = this.buildEmptyNode(level, index, otherParentNode);
        this.buildChildNode(level + 1, value, node, otherNode);
    };

    JSONDiff.buildChildNode = function (level, value, parentNode, otherParentNode) {
        var that = this;
        if (that.isArray(value)) {
            for (var i = 0; i < value.length; i++) {
                that.buildNodeWithChild(level, i, i, value[i], parentNode, otherParentNode);
            }
        } else if (that.isObject(value)) {
            var j = 0;
            $.each(value, function (k, v) {
                that.buildNodeWithChild(level, j++, k, v, parentNode, otherParentNode);
            });
        }
    };

    JSONDiff.compareValue = function (left, right) {
        return left == right;
    };

    JSONDiff.compare = function (level, index, key, left, leftParentNode, right, rightParentNode) {
        var that = this;
        var isSame = true;

        left = that.convertToJson(left);
        right = that.convertToJson(right);

        var leftNode = that.buildNode(level, index, key, left, leftParentNode);
        var rightNode = that.buildNode(level, index, key, right, rightParentNode);

        if (that.isArray(left)) {
            if (that.isArray(right)) {
                isSame = (left.length == right.length);
                var minLength = (left.length < right.length) ? left.length : right.length;
                for (var i = 0; i < minLength; i++) {
                    isSame = that.compare(level + 1, i, i, left[i], leftNode, right[i], rightNode) && isSame;
                }
                for (var j = minLength; j < left.length; j++) {
                    that.buildNodeWithChild(level + 1, j, j, left[j], leftNode, rightNode);
                }
                for (var k = minLength; k < right.length; k++) {
                    that.buildNodeWithChild(level + 1, left.length + k, k, right[k], rightNode, leftNode);
                }
            } else {
                that.buildChildNode(level + 1, left, leftNode, rightNode);
                if (that.isObject(right)) {
                    that.buildChildNode(level + 1, right, rightNode, leftNode);
                }
                isSame = false;
            }
        } else if (that.isObject(left)) {
            if (that.isObject(right)) {
                isSame = (that.getPropertyCount(left) == that.getPropertyCount(right));
                var samePropertys = that.getSamePropertys(left, right);
                isSame = isSame && (that.getPropertyCount(left) == samePropertys.length);
                var m = 0;
                $.each(left, function (k, v) {
                    if (that.isInArray(k, samePropertys)) {
                        isSame = that.compare(level + 1, m++, k, v, leftNode, right[k], rightNode) && isSame;
                    }
                });
                $.each(left, function (k, v) {
                    if (!that.isInArray(k, samePropertys)) {
                        that.buildNodeWithChild(level + 1, m++, k, v, leftNode, rightNode);
                    }
                });
                $.each(right, function (k, v) {
                    if (!that.isInArray(k, samePropertys)) {
                        that.buildNodeWithChild(level + 1, m++, k, v, rightNode, leftNode);
                    }
                });
            } else {
                that.buildChildNode(level + 1, left, leftNode, rightNode);
                if (that.isArray(right)) {
                    that.buildChildNode(level + 1, right, rightNode, leftNode);
                }
                isSame = false;
            }
        } else {
            if (!that.isJson(right)) {
                isSame = that.compareValue(left, right);
            } else {
                that.buildChildNode(right, rightNode);
                isSame = false;
            }
        }

        if (!isSame && that.isJson(right)) {
            rightNode.find('.parent').addClass('diff');
        }

        return isSame;
    };

    JSONDiff.adaptiveWidth = function () {
        this.options.leftTarget.find('.parent').css('width', this.options.leftTarget[0].scrollWidth);
        this.options.rightTarget.find('.parent').css('width', this.options.rightTarget[0].scrollWidth);
    };

    JSONDiff.initEvent = function (leftTarget, rightTarget) {
        var that = this;
        leftTarget.scroll(function () {
            rightTarget.scrollLeft(leftTarget.scrollLeft());
        }).on('click', '.parent', function () {
            if ($(this).next().children().length < 10) {
                rightTarget.find('.child[nid="' + $(this).next().slideToggle().attr('nid') + '"]').slideToggle(function () {
                    that.adaptiveWidth();
                });
            } else {
                rightTarget.find('.child[nid="' + $(this).next().toggle().attr('nid') + '"]').toggle();
                that.adaptiveWidth();
            }
        }).on('mouseover', '.parent', function () {
            rightTarget.find('.child[nid="' + $(this).next().attr('nid') + '"]').prev().addClass('hover');
        }).on('mouseout', '.parent', function () {
            rightTarget.find('.child[nid="' + $(this).next().attr('nid') + '"]').prev().removeClass('hover');
        });
    };

    JSONDiff.diff = function (options) {
        this.options = $.extend({}, this.options, options);
        this.compare(0, 0, this.defaultKey, this.options.left, this.options.leftTarget, this.options.right, this.options.rightTarget);
        this.adaptiveWidth();
        this.initEvent(this.options.leftTarget, this.options.rightTarget);
        this.initEvent(this.options.rightTarget, this.options.leftTarget);
    };

    $.extend({
        jsonDiff: function (options) {
            JSONDiff.diff(options);
        }
    });
})(jQuery);