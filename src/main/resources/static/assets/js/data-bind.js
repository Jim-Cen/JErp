var $table = $('#table');
var $url;
var setUrl = function (url){
    $url = url;
}
var showAdd =  function(){
    $(".modal-body input").val("");
    $(".modal-body select").val("");
    $(".modal-body #uuid").val("0");
    $(".modal-body button.btn.btn-danger").attr("disabled","disabled").hide();
    $(".modal-body button.btn.btn-primary").removeAttr("disabled").show();
    $(".modal").modal('show');
    $(".modal-body input[type=text]:eq(0)").focus();
}

var modal =  function(data){
    Object.keys(data).forEach(function(item,index){
        $(".modal #"+item).val(data[item]);
    });
    $(".modal-body button.btn.btn-primary").attr("disabled","disabled").hide();
    $(".modal-body button.btn.btn-danger").removeAttr("disabled").show();
    $(".modal").modal('show');
    $(".modal-body input[type=text]:eq(0)").focus();
}

var remove =  function(row){
    $.postForm({
        url:$url,
        cache:false,
        async:true,
        type: "delete",
        dataType: "text",
        data: row,
        beforeSend:function(XMLHttpRequest){},
        success:function(data, textStatus){
            $table.bootstrapTable('remove', {
              field: 'uuid',
              values: [row.uuid]
            })
           $(".modal").modal('hide');
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.responseText);
        },
        complete:function(XMLHttpRequest, textStatus){}
    });
}


var edit = function(){
    $.postForm({
        url:$url,
        cache:false,
        async:true,
        type: "put",
        dataType: "json",
        beforeSend:function(XMLHttpRequest){},
        success:function(data, textStatus){
            $table.bootstrapTable('updateRow', {
               index: updateIndex,
               row:data
             })
             $(".modal").modal('hide');
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.responseText);
        },
        complete:function(XMLHttpRequest, textStatus){}
    });
}

var add =  function(){
    $.postForm({
        url:$url,
        cache:false,
        async:true,
        type: "post",
        dataType: "json",
        checkData: true,
        beforeSend:function(XMLHttpRequest){},
        success:function(data, textStatus){
            $table.bootstrapTable('insertRow', {
                index:$table.children("tbody").children("tr").length + 1,
                row: data
             });
            alert("添加成功");
            $(".modal").modal('hide');
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.responseText);
        },
        complete:function(XMLHttpRequest, textStatus){}
    });
}

var tableLoad = function(){
    $.postForm({
        url:$url,
        cache:false,
        async:true,
        type: "get",
        dataType: "json",
        beforeSend:function(XMLHttpRequest){},
        success:function(data, textStatus){
            $table.bootstrapTable({data: data});
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.responseText);
        },
        complete:function(XMLHttpRequest, textStatus){}
    });
 }

var operateFormatter =  function (value, row, index) {
      return [
        '<a class="remove" href="javascript:void(0)" title="删除">',
        '<i class="fa fa-trash"></i>',
        '</a>  ',
        '<a class="update" href="javascript:void(0)" title="更新">',
        '<i class="fa fa-pencil-alt"></i>',
        '</a>'
      ].join('')
  }
var updateIndex;
var operateEvents = {
  'click .remove': function (e, value, row, index) {
       remove(row);
  },
  'click .update': function (e, value, row, index) {
    modal(row);
    updateIndex = index;
  }
}

$(document).ready(function(){
     tableLoad();
});