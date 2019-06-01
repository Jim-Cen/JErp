(function($){
    $.postForm = function(options){
        var headers = {};
        if (typeof options.verify === 'undefined' || options.verify) {
            var clientId = sessionStorage.getItem("clientId");
            if(clientId){
              var token = sessionStorage.getItem("token");
              var timestamp = new Date().getTime();
              var signature = md5(token + "WIN" + timestamp);
              headers.clientId = clientId;
              headers.timestamp = timestamp;
              headers.signature = signature;
            }
        }
        var data={};
        $("input[type=text],input[type=password],input[type=email],input[type=hidden],select,textarea").each(function(i,e){
            data[e.name || e.id] = e.value;
        });
        var cbParams={};
        $("input[type=checkbox],input[type=radio]").filter(":checked").each(function(i,e){
              var name = e.name || e.id;
              if(cbParams[name] != null){
                cbParams[name].push(e.value);
              }else{
                cbParams[name]=[e.value];
              }
        });
        Object.keys(cbParams).forEach(function(key){
          data[key] = cbParams[key].join(",");
        })

        if(options.checkData){
            let checked = $checkData(data);
            if(!checked) return;
        }

        data = Object.assign(data,options.data);
        if(options.type==='get')
                options.data = data;
         else
                options.data=JSON.stringify(data);

        options.contentType="application/json; charset=utf-8";
        options.headers = $.extend({},options.headers,headers);
        $.ajax(options);
      }

      function $checkData(data){
            for(let key in data){
                if(data[key] == ""){
                    let name = $(`label[for=${key}]`).html();
                    alert(`${name}不能为空`);
                    $(`#${key}`).focus();
                    return false;
                }
            }
            return true;
      }

      //回车焦点定位
      $(document).keypress(function(e){
           e = event || e;
           var that = event.srcElement || event.target;
           var next = false;
          if( e.keyCode == 13 && 
              that.type !='button' &&  that.type !='submmit' &&
             (that.tagName == 'INPUT' || that.tagName == 'TEXTAREA' || that.tagName == 'BUTTON')
             ){
            $("input,textarea,button").each(function(i,el){
                  if(next){
                    el.focus();
                    return false;
                  }
                  next = (el == that);
            });
          }
      })
})(jQuery);

