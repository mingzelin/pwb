
//a function of checking upload size and type is required
function uploadFile(){
	var data = new FormData($('#uploadImageForm')[0]);
	
	if(typeof FormData === "undefined") throw new Error("FormData is undefined");
	
	var request = new XMLHttpRequest();
	request.open("POST", "../ProfileUpload");
	request.onreadystate = function(){
		if(request.readystate === 4){console.log("upload success");}
	};
	request.send(data);
}


function uploadImg(){
	var str = document.getElementById("cropped").getAttribute("ng-src").split(",")[1];	
	$.ajax({
		method:"POST",
		url:"../croppedUpload",
		dataType:"json",
		data:{"img": str}
	});
}


////crop
angular.module('app', ['ngImgCrop'])
.controller('Ctrl', function($scope) {
  $scope.myImage='';
  $scope.myCroppedImage='';

  var handleFileSelect=function(evt) {
    var file=evt.currentTarget.files[0];
    var reader = new FileReader();
    reader.onload = function (evt) {
      $scope.$apply(function($scope){
        $scope.myImage=evt.target.result;
      });
    };
    reader.readAsDataURL(file);
  };
  angular.element(document.querySelector('#fileInput')).on('change',handleFileSelect);
});
////