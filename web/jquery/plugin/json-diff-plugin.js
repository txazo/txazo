(function ($) {
    var JSONDiff = {
        options: {
            left: {},
            right: {},
            leftTarget: {},
            rightTarget: {}
        },
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

    JSONDiff.buildValue = function (value) {
        if (this.isArray(value)) {
            return '[' + value.length + ']';
        } else if (this.isObject(value)) {
            return '{' + this.getPropertyCount(value) + '}';
        } else {
            return value;
        }
    };

    JSONDiff.getPropertyCount = function(value) {
        return this.isObject(value) ? Object.getOwnPropertyNames(value).length : 0;
    };

    JSONDiff.getSamePropertys = function(left, right) {
        var propertys = [];
        if (this.isObject(left) && this.isObject(right)) {
            $.each(leftValue, function(k, v) {
                if (rightValue.hasOwnProperty(k)) {
                    propertys.push(k);
                }
            }
        }
        return propertys;
    };

    JSONDiff.compare = function (left, right, leftParent, rightParent) {

    };

    JSONDiff.compareArray = function (left, right, leftParent, rightParent) {
        this.buildTree(left);
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

    JSONDiff.buildNode = function (key, value, parentNode) {
        var node = $(this.nodeTemplate);
        node.find('.key').html(key);
        node.find('.value').html(this.buildValue(leftValue));
        parentNode.append(node);
        return node;
    };

    JSONDiff.buildJsonNode = function (value, parentNode) {
        if (this.isArray(value)) {
            for (var i = 0; i < value.length; i++) {
                this.buildTree(i, value[i], node);
            }
        } else if (this.isObject(value)) {
            $.each(value, function(k, v) {
                this.buildTree(k, v, node);
            });
        }
    };

    JSONDiff.buildTree = function (leftKey, leftValue, leftParentNode, rightKey, rightValue, rightParentNode) {
        var isSame = false;

        leftValue = this.convertToJson(leftValue);
        rightValue = this.convertToJson(rightValue);

        var leftNode = this.buildNode(leftKey, this.buildValue(leftValue), leftParentNode);
        var rightNode = this.buildNode(rightKey, this.buildValue(rightValue), rightParentNode);

        if (this.isArray(leftValue)) {
            if (this.isArray(rightValue)) {
                isSame = leftValue.length == rightValue.length;
                var minLength = leftValue.length < rightValue.length ? leftValue.length : rightValue.length;
                for (var i = 0; i < minLength.length; i++) {
                    isSame = isSame & this.buildTree(i, leftValue[i], leftNode, i, rightValue[i], rightNode);
                }
                for (var i = minLength; i < leftValue.length; i++) {
                    this.buildNode(i, leftValue[i], leftNode);
                }
                for (var i = minLength; i < rightValue.length; i++) {
                    this.buildNode(i, rightValue[i], rightNode);
                }
            } else {
                this.buildJsonNode(leftValue, leftNode);
                if (this.isObject(rightValue)) {
                    this.buildJsonNode(rightValue, rightNode);
                }
                isSame = false;
            }
        } else if (this.isObject(leftValue)) {
            if (this.isObject(rightValue)) {
                isSame = this.getPropertyCount(leftValue) == this.getPropertyCount(rightValue);
                var samePropertys = this.getSamePropertys(leftValue, rightValue);
                isSame = isSame & this.getPropertyCount(leftValue) = samePropertys.length;
                $.each(leftValue, function(k, v) {
                    if ($.inArray(k, samePropertys)) {
                        isSame = isSame & this.buildTree(k, v, leftNode, k, rightValue[v], rightNode);
                    }
                });
                $.each(leftValue, function(k, v) {
                    if (!$.inArray(k, samePropertys)) {
                        this.buildJsonNode(k, v, leftNode);
                    }
                });
                $.each(rightValue, function(k, v) {
                    if (!$.inArray(k, samePropertys)) {
                        this.buildJsonNode(k, v, rightNode);
                    }
                });
            } else {
                this.buildJsonNode(leftValue, leftNode);
                if (this.isArray(rightValue)) {
                    this.buildJsonNode(rightValue, rightNode);
                }
                isSame = false;
            }
        } else {
            if (!this.isJson(rightValue)) {
                isSame = this.compareValue(leftValue, rightValue);
            } else {
                this.buildJsonNode(rightValue, rightNode);
                isSame = false;
            }
        }

        if (!isSame) {
            rightNode.addClass('diff');
        }
    };

    JSONDiff.compareValue = function(left, right) {
        return left == right;
    };

    JSONDiff.diff = function (options) {
        this.buildTree('', this.options.left, this.options.leftTarget, '', this.options.right, this.options.rightTarget);
    };

    $.extend({
        jsonDiff: function (options) {
            JSONDiff.diff(options);
        }
    });
})(jQuery);