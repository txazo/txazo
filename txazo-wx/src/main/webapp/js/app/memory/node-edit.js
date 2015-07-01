function addPoint(text) {
    var size = $('#points').find('.form-group').length;
    var html = '<div class="form-group">';
    html += '<div class="col-xs-1" style="padding-top: 12px;">';
    html += '<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>';
    html += '</div>';
    html += '<div class="col-xs-9">';
    html += '<textarea name="point" class="form-control" rows="2" required>' + text + '</textarea>';
    html += '</div>';
    html += '<div class="col-xs-1" style="padding-top: 12px;">';
    if (size > 0) {
        html += '<a href="javascript:;" onclick="minus(this);"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></a>';
    } else {
        html += '<a href="javascript:;" onclick="plus();"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>';
    }
    html += '</div>';
    html += '</div>';
    $('#points').append(html);
}

function plus() {
    addPoint('');
}

function minus(element) {
    $(element).closest('.form-group').remove();
}