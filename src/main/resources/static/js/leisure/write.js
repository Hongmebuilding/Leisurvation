$(function(){
    var i = 0;
    $("#btnAdd").click(function(){
        $("#image").append(`
                <div class="input-group mb-2">
                    <input class="form-control col-xs-3" type="file" name="upfile${i}"/>
                    <button type="button" class="btn btn-outline-danger" onclick="$(this).parent().remove()">삭제</button>
                </div>`);
        i++;
    });
});
