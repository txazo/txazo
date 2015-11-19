(function ($) {
    var JSONDiff = {
        options: {
            left: {},
            right: {},
            leftTarget: {},
            rightTarget: {}
        },
        defaultKey: '',
        nodeTemplate: '<div class="node"><div class="key"></div><div class="value"></div><div class="child"></div></div>'
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
            return '[' + value.length + ']';
        } else if (this.isObject(value)) {
            return '{' + this.getPropertyCount(value) + '}';
        } else {
            return value;
        }
    };

    JSONDiff.buildNode = function (key, value, parentNode) {
        var node = $(this.nodeTemplate);
        node.find('.key').html(key);
        node.find('.value').html(this.buildNodeValue(value));
        parentNode.append(node);
        return node.find('.child');
    };

    JSONDiff.buildNodeWithChild = function (key, value, parentNode) {
        var node = this.buildNode(key, value, parentNode);
        this.buildChildNode(value, node);
    };

    JSONDiff.buildChildNode = function (value, parentNode) {
        var that = this;
        if (that.isArray(value)) {
            for (var i = 0; i < value.length; i++) {
                that.buildNodeWithChild(i, value[i], parentNode);
            }
        } else if (that.isObject(value)) {
            $.each(value, function (k, v) {
                that.buildNodeWithChild(k, v, parentNode);
            });
        }
    };

    JSONDiff.compareValue = function (left, right) {
        return left == right;
    };

    JSONDiff.compare = function (key, left, leftParentNode, right, rightParentNode) {
        var that = this;
        var isSame = false;

        left = that.convertToJson(left);
        right = that.convertToJson(right);

        var leftNode = that.buildNode(key, left, leftParentNode);
        var rightNode = that.buildNode(key, right, rightParentNode);

        if (that.isArray(left)) {
            if (that.isArray(right)) {
                isSame = (left.length == right.length);
                var minLength = (left.length < right.length) ? left.length : right.length;
                for (var i = 0; i < minLength.length; i++) {
                    isSame = that.compare(i, left[i], leftNode, right[i], rightNode) && isSame;
                }
                for (var j = minLength; j < left.length; j++) {
                    that.buildNodeWithChild(j, left[j], leftNode);
                }
                for (var k = minLength; k < right.length; k++) {
                    that.buildNodeWithChild(k, right[k], rightNode);
                }
            } else {
                that.buildChildNode(left, leftNode);
                if (that.isObject(right)) {
                    that.buildChildNode(right, rightNode);
                }
                isSame = false;
            }
        } else if (that.isObject(left)) {
            if (that.isObject(right)) {
                isSame = (that.getPropertyCount(left) == that.getPropertyCount(right));
                var samePropertys = that.getSamePropertys(left, right);
                isSame = isSame && (that.getPropertyCount(left) == samePropertys.length);
                $.each(left, function (k, v) {
                    if (that.isInArray(k, samePropertys)) {
                        isSame = that.compare(k, v, leftNode, right[k], rightNode) && isSame;
                    }
                });
                $.each(left, function (k, v) {
                    if (!that.isInArray(k, samePropertys)) {
                        that.buildNodeWithChild(k, v, leftNode);
                    }
                });
                $.each(right, function (k, v) {
                    if (!that.isInArray(k, samePropertys)) {
                        that.buildNodeWithChild(k, v, rightNode);
                    }
                });
            } else {
                that.buildChildNode(left, leftNode);
                if (that.isArray(right)) {
                    that.buildChildNode(right, rightNode);
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

        if (!isSame) {
            rightNode.addClass('diff');
        }

        return isSame;
    };

    JSONDiff.diff = function (options) {
        this.options = $.extend({}, this.options, options);
        this.compare(this.defaultKey, this.options.left, this.options.leftTarget, this.options.right, this.options.rightTarget);
    };

    $.extend({
        jsonDiff: function (options) {
            JSONDiff.diff(options);
        }
    });
})(jQuery);