(function ($) {
    var DiffType = {
        SAME: {},
        DIFF: {
            key: 'jdiff'
        },
        LEFT: {
            key: 'jleft'
        },
        RIGHT: {
            key: 'jright'
        }
    };

    var JSONDiff = {
        options: {
            left: {},
            right: {},
            leftTarget: {},
            rightTarget: {},
            defaultLevel: 0
        },
        initTarget: false,
        defaultKey: '',
        nodeTemplate: '<div class="jnode"><div class="jparent"><div class="jkey"></div><div class="jvalue"></div></div><div class="jchild" style="display: none;"></div></div>'
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

    JSONDiff.buildNode = function (level, index, key, value, parentNode, diffType) {
        var node = $(this.nodeTemplate);
        node.find('.jkey').html(key).css('margin-left', 80 * (level - 1) + 'px');
        node.find('.jvalue').html(this.buildNodeValue(value));
        if (this.isJson(value)) {
            node.find('.jvalue').css('color', '#A333C8').css('font-weight', 'bold');
        }
        if (diffType && diffType != DiffType.SAME) {
            node.find('.jparent').addClass(diffType.key);
        }
        if (level <= this.options.defaultLevel) {
            node.find('.jchild').show();
        }
        parentNode.append(node);
        return node.find('.jchild').attr('nid', this.buildNodeId(level, parentNode.children().length, parentNode));
    };

    JSONDiff.buildEmptyNode = function (level, index, parentNode) {
        var node = $(this.nodeTemplate);
        node.find('.jkey').css('margin-left', 80 * (level - 1) + 'px');
        node.find('.jparent').addClass('empty').css('padding', '20.5px 15px');
        if (level <= this.options.defaultLevel) {
            node.find('.jchild').show();
        }
        parentNode.append(node);
        return node.find('.jchild').attr('nid', this.buildNodeId(level, parentNode.children().length, parentNode));
    };

    JSONDiff.buildNodeWithChild = function (level, index, key, value, parentNode, otherParentNode, diffType) {
        var node = this.buildNode(level, index, key, value, parentNode, diffType);
        var otherNode = this.buildEmptyNode(level, index, otherParentNode);
        this.buildChildNode(level + 1, value, node, otherNode, diffType);
    };

    JSONDiff.buildChildNode = function (level, value, parentNode, otherParentNode, diffType) {
        var that = this;
        if (that.isArray(value)) {
            for (var i = 0; i < value.length; i++) {
                that.buildNodeWithChild(level, i, i, value[i], parentNode, otherParentNode, diffType);
            }
        } else if (that.isObject(value)) {
            var j = 0;
            $.each(value, function (k, v) {
                that.buildNodeWithChild(level, j++, k, v, parentNode, otherParentNode, diffType);
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
                    that.buildNodeWithChild(level + 1, j, j, left[j], leftNode, rightNode, DiffType.LEFT);
                }
                for (var k = minLength; k < right.length; k++) {
                    that.buildNodeWithChild(level + 1, left.length + k, k, right[k], rightNode, leftNode, DiffType.RIGHT);
                }
            } else {
                that.buildChildNode(level + 1, left, leftNode, rightNode, DiffType.LEFT);
                if (that.isObject(right)) {
                    that.buildChildNode(level + 1, right, rightNode, leftNode, DiffType.RIGHT);
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
                        that.buildNodeWithChild(level + 1, m++, k, v, leftNode, rightNode, DiffType.LEFT);
                    }
                });
                $.each(right, function (k, v) {
                    if (!that.isInArray(k, samePropertys)) {
                        that.buildNodeWithChild(level + 1, m++, k, v, rightNode, leftNode, DiffType.RIGHT);
                    }
                });
            } else {
                that.buildChildNode(level + 1, left, leftNode, rightNode, DiffType.LEFT);
                if (that.isArray(right)) {
                    that.buildChildNode(level + 1, right, rightNode, leftNode, DiffType.RIGHT);
                }
                isSame = false;
            }
        } else {
            if (!that.isJson(right)) {
                isSame = that.compareValue(left, right);
            } else {
                that.buildChildNode(level + 1, right, rightNode, leftNode, DiffType.RIGHT);
                isSame = false;
            }
        }

        if (!isSame) {
            leftNode.prev().addClass('jdiff');
            rightNode.prev().addClass('jdiff');
        }

        return isSame;
    };

    JSONDiff.adaptiveWidth = function () {
        this.options.leftTarget.find('.jparent').css('width', this.options.leftTarget[0].scrollWidth);
        this.options.rightTarget.find('.jparent').css('width', this.options.rightTarget[0].scrollWidth);
    };

    JSONDiff.nodeHover = function (node) {
        if (node.hasClass('jleft')) {
            node.addClass('jleft-hover');
        } else if (node.hasClass('jright')) {
            node.addClass('jright-hover');
        } else if (node.hasClass('jdiff')) {
            node.addClass('jdiff-hover');
        } else {
            node.addClass('jhover');
        }
    };

    JSONDiff.nodeHoverOut = function (node) {
        if (node.hasClass('jleft-hover')) {
            node.removeClass('jleft-hover');
        } else if (node.hasClass('jright-hover')) {
            node.removeClass('jright-hover');
        } else if (node.hasClass('jdiff-hover')) {
            node.removeClass('jdiff-hover');
        } else {
            node.removeClass('jhover');
        }
    };

    JSONDiff.hasChildNode = function (node) {
        return node.find('.jnode').length > node.find('.empty').length;
    };

    JSONDiff.initEvent = function (leftTarget, rightTarget) {
        var that = this;
        leftTarget.scroll(function () {
            rightTarget.scrollLeft(leftTarget.scrollLeft());
        }).on('click', '.jparent', function () {
            if (that.hasChildNode($(this).next())) {
                var childs = $(this).next().children().length;
                if (childs > 10) {
                    rightTarget.find('.jchild[nid="' + $(this).next().toggle().attr('nid') + '"]').toggle();
                    that.adaptiveWidth();
                } else if (childs > 0) {
                    rightTarget.find('.jchild[nid="' + $(this).next().toggle().attr('nid') + '"]').toggle();
                    that.adaptiveWidth();
                }
            }
        }).on('mouseover', '.jparent', function () {
            if ($(this).next().children().length > 0) {
                $(this).css('cursor', 'pointer');
            }
            that.nodeHover($(this));
            that.nodeHover(rightTarget.find('.jchild[nid="' + $(this).next().attr('nid') + '"]').prev());
        }).on('mouseout', '.jparent', function () {
            that.nodeHoverOut($(this));
            that.nodeHoverOut(rightTarget.find('.jchild[nid="' + $(this).next().attr('nid') + '"]').prev());
        });
    };

    JSONDiff.fold = function () {
        this.options.leftTarget.find('.jchild').hide();
        this.options.rightTarget.find('.jchild').hide();
    };

    JSONDiff.foldOut = function () {
        this.options.leftTarget.find('.jchild').show();
        this.options.rightTarget.find('.jchild').show();
    };

    JSONDiff.init = function (options) {
        if (this.initTarget) {
            options.leftTarget = this.options.leftTarget;
            options.rightTarget = this.options.rightTarget;
            this.options = $.extend({}, this.options, options);
        } else {
            this.initTarget = true;
            this.options = $.extend({}, this.options, options);
            this.initEvent(this.options.leftTarget, this.options.rightTarget);
            this.initEvent(this.options.rightTarget, this.options.leftTarget);
        }
        this.options.leftTarget.html('');
        this.options.rightTarget.html('');
    };

    JSONDiff.diff = function (options) {
        this.init(options);
        this.compare(0, 0, this.defaultKey, options.left, this.options.leftTarget, options.right, this.options.rightTarget);
        this.adaptiveWidth();
    };

    $.extend({
        jsonDiff: function (options, callback) {
            JSONDiff.diff(options);
            callback && callback();
        }
    });
})(jQuery);