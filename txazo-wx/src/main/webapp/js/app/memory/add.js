$(function () {
    $('#add-form').submit(function (e) {
        e.preventDefault();
        var that = this;

        var parentId = $('#parentId').val();
        var type = $('#type').val();
        var name = $('#name').val();

        $.post('/memory/checkMemory.wx', {
            'parentId': parentId,
            'type': type,
            'name': name
        }, function (data) {
            if (!data) {
                alert('操作出错');
            }

            if (data.exists == "true") {
                var $name = $('#name');
                $name.closest('.form-group').addClass('has-error');
                $('#alertDanger').html('名称已经存在').show();
            } else {
                that.submit();
            }
        });
    });
});