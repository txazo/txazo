(function () {
    Date.prototype.getDateString = function () {
        return this.getFullYear() + '-' + convertZero(this.getMonth() + 1) + '-' + convertZero(this.getDate());
    };

    function convertZero(number) {
        return number > 9 ? number : '0' + number;
    }
}());