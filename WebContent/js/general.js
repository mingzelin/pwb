//General js is suits any page containing: 
//"#popbar",


$(document).ready(function(){
	elemResize();
});
    
$(window).resize(function(){
	elemResize();
});

function elemResize(){
	var windowY = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
	var windowX = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    var popbarRow = document.getElementsByClassName("popbarRow");
    for(var i=0;i< popbarRow.length;i++){
    		popbarRow[i].style.height = (windowY * 0.1) + "px";	
    }
    $("#poptable").css('marginLeft', (windowY * 0.03)+"px");
}

$(document).on('mouseenter','#popbar', function (event) {
    $( this ).find('#symBar').hide();
}).on('mouseleave','#popbar',  function(){
    $( this ).find('#symBar').show();
});