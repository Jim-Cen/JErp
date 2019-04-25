$(document).ready(function(){
    bindSideNav();
			
    $(window).bind("load resize", function () {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse');
            $('.navbar-side').css({left: '0px'});
            $('#page-wrapper').css({'margin-left' : '0px'}); 
        } else {
            $('div.sidebar-collapse').removeClass('collapse');
            if($("#sideNav").hasClass('closed') && $('.navbar-side').css("left") == "260px"){
                $('.navbar-side').css({left: '-260px'});
                $('#page-wrapper').css({'margin-left' : '0px'});    
            }
            else{
                $('.navbar-side').css({left: '0px'});
                $('#page-wrapper').css({'margin-left' : '260px'}); 
            }
        }
    });


    $("#sideNav").click(function(){
        if($(this).hasClass('closed')){
            $('.navbar-side').animate({left: '0px'});
            $(this).removeClass('closed');
            $('#page-wrapper').animate({'margin-left' : '260px'});
            
        }
        else{
            $(this).addClass('closed');
            $('.navbar-side').animate({left: '-260px'});
            $('#page-wrapper').animate({'margin-left' : '0px'}); 
        }
    });
    
    //显示首页
    $.ajax({
        url:"dashboard.html",
        cache:false,
        async:false,
        type: "get",
        beforeSend:function(XMLHttpRequest){},
        success:function(data, textStatus){
            $("#page-inner").html(data);
            $("#main-menu li a[data-href='dashboard.html']").addClass("active-menu");
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){},
        complete:function(XMLHttpRequest, textStatus){},
    })
})

function bindSideNav(){
    $.postForm({
        url:"/program/get",
        cache:false,
        async:true,
        type: "post",
        dataType: "json",
        beforeSend:function(XMLHttpRequest){},
        success:function(data, textStatus){
            let result = data;
            let index = 0;
            for (let i = 0; i < result.length; i++) {
                if(result[i].level != 0){
                    index = i;
                    break;
                }
                let sideBar = "<li id='level_0_" + result[i].uuid + "'><a href='#' data-href='" + (!!result[i].href ? result[i].href : "") + "'><i class='fa " + result[i].icon + "'></i>" + result[i].name + "</a></li>";
                $("#main-menu").append(sideBar);
            }
            
            let secondLevel = null;
            let parentUuid = null;
            for(let i =index; i < result.length + 1; i++){
                if( i ==  result.length || result[i].level != 1){
                    index = i;
                    if(secondLevel != null){
                        $("#level_0_"+parentUuid).append(secondLevel+"</ul>");
                        $("#level_0_"+parentUuid).children("a").append("<span class='fa arrow'></span>");
                    }
                    break;
                }
                if(parentUuid != result[i].parentUuid){
                    if(secondLevel != null){
                        $("#level_0_"+parentUuid).append(secondLevel+"</ul>");
                        $("#level_0_"+parentUuid).children("a").append("<span class='fa arrow'></span>");
                    }
                    secondLevel="<ul class='nav nav-second-level'>";
                    parentUuid = result[i].parentUuid;
                }
                secondLevel+="<li id='level_1_" + result[i].uuid + "'><a href='#' data-href='" + (!!result[i].href ? result[i].href : "") + "'>" + result[i].name + "</a></li>";
            }

            secondLevel = null;
            parentUuid = null;
            for(let i =index; i < result.length + 1; i++){
                if( i ==  result.length || result[i].level != 2){
                    index = i;
                    if(secondLevel != null){
                        $("#level_1_"+parentUuid).append(secondLevel+"</ul>");
                        $("#level_1_"+parentUuid).children("a").append("<span class='fa arrow'></span>");
                    }
                    break;
                }
                if(parentUuid != result[i].parentUuid){
                    if(secondLevel != null){
                        $("#level_1_"+parentUuid).append(secondLevel+"</ul>");
                        $("#level_1_"+parentUuid).children("a").append("<span class='fa arrow'></span>");
                    }
                    secondLevel="<ul class='nav nav-third-level'>";
                    parentUuid = result[i].parentUuid;
                }
                secondLevel+="<li><a href='#' data-href='" + (!!result[i].href ? result[i].href : "") + "'>" + result[i].name + "</a></li>";
            }
            
            $('#main-menu').metisMenu();
            
            $("#main-menu li a").click(function(e){
                var self = this;
                if(!!$(this).data("href")){
                    $.ajax({
                        url:$(this).data("href"),
                        cache:false,
                        async:true,
                        type: "get",
                        beforeSend:function(XMLHttpRequest){},
                        success:function(data, textStatus){
                            $("#page-inner").html(data);
                            $("#main-menu li a").removeClass("active-menu");
                            $(self).addClass("active-menu");
                        },
                        error:function(XMLHttpRequest, textStatus, errorThrown){},
                        complete:function(XMLHttpRequest, textStatus){},
                    })
                }
            });
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            window.location.replace("login.html");
        },
        complete:function(XMLHttpRequest, textStatus){}
    })
}