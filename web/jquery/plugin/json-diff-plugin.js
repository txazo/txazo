(function ($) {
    var JSONDiff = {
        options: {
            left: {},
            right: {},
            leftTarget: {},
            rightTarget: {}
        },
        nodeTemplate: '<div class="node"><div class="key"></div><div class="value"></div></div>'
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
            return '{' + Object.getOwnPropertyNames(value).length + '}';
        } else {
            return value;
        }
    };

    JSONDiff.compare = function (left, right, leftParent, rightParent) {

    };

    JSONDiff.compareArray = function (left, right, leftParent, rightParent) {
        this.buildTree(left);


    };

    JSONDiff.buildNode = function (key, value, parentNode) {
        var node = $(this.nodeTemplate);
        node.find('.key').html(key);
        node.find('.value').html(value);
        parentNode.append(node);
        return node;
    };

    JSONDiff.buildTree = function (left, right, leftNode, rightNode) {
        if (this.isArray(left)) {
            if (this.isArray(right)) {

            } else {

            }
        } else if (this.isObject(left)) {
            if (this.isObject(right)) {

            } else {

            }
        } else {
            if (!this.isJson(right)) {

            } else {

            }
        }
    };

    JSONDiff.diff = function (options) {
        this.buildTree(this.options.left, this.options.right, this.options.leftTarget, this.options.rightTarget);
    };

    $.extend({
        jsonDiff: function (options) {
            JSONDiff.diff(options);
        }
    });
})(jQuery);
