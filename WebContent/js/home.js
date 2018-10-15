function msgPost(twitter){
	console.log("home.js is working");	
	$.ajax({
		type:"POST",
		url:"../ForumServlet",
		data: "twitter="+twitter,
		success: function(result){
			console.log(result);
		}
	});
	
}

