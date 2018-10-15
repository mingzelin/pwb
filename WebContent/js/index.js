	/* This is auto-adjust part */
		var fromTop, winHeight, pageUnitHeight, unitNO, autoScrollPos, scrollLastPos, oldUnitNO;
		window.requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
		
		$(document).scroll(function(){				
		 	fromTop = 0 - document.getElementById("s1").getBoundingClientRect().top;	/* The height from top of the page */
			winHeight = $(window).height();
			pageUnitHeight = 1.3 * winHeight;	/* A unit consist of one pic and its bar behind(sub) */
			unitNO = Math.round(fromTop/pageUnitHeight);	/* on which unit the client is viewing */
			autoScrollPos = unitNO * pageUnitHeight;
		 	(scrollLastPos == undefined)?scrollLastPos = fromTop:false; 	
		 	(oldUnitNO == undefined)?oldUnitNO = 0:false; 	
	 	
		 	/* auto ajust when scroll over half of a page */
		 	if(fromTop > scrollLastPos && unitNO > oldUnitNO){ /* scroll down */ 		
		 		var subScrollPos = (autoScrollPos - fromTop)/25;
		 		var scrollInterval = fromTop + subScrollPos;
				function step(timestamp){
					window.scrollTo(0,scrollInterval);
			 		scrollInterval += subScrollPos;  
			 		if(scrollInterval <= autoScrollPos)window.requestAnimationFrame(step);
					}	
				window.requestAnimationFrame(step);	 	
		 	}else if(fromTop < scrollLastPos && unitNO < oldUnitNO){ /* scroll up */
		 		var subScrollPos = (fromTop - autoScrollPos)/25;
				var scrollInterval = fromTop - subScrollPos;
				function step(timestamp){
					window.scrollTo(0,scrollInterval);
			 		scrollInterval -= subScrollPos;  
			 		if(scrollInterval >= autoScrollPos)window.requestAnimationFrame(step);
					}	
				window.requestAnimationFrame(step);	
		 	}
		 	scrollLastPos = fromTop;
		 	oldUnitNO = unitNO; 	
		 	});		
		/* auto ajust page when click */
		$(document).click(function(){
			if(fromTop > autoScrollPos){	/* page should scroll up */
				var subScrollPos = (autoScrollPos - fromTop)/25;
		 		var scrollInterval = fromTop + subScrollPos;
				function step(timestamp){
					window.scrollTo(0,scrollInterval);
			 		scrollInterval += subScrollPos;  
			 		if(scrollInterval >= autoScrollPos)window.requestAnimationFrame(step);
					}	
				window.requestAnimationFrame(step);	
				}
			else if(fromTop < autoScrollPos){	/* page should scroll down */ 
				var subScrollPos = (fromTop - autoScrollPos)/25;
				var scrollInterval = fromTop - subScrollPos;
				function step(timestamp){
					window.scrollTo(0,scrollInterval);
			 		scrollInterval -= subScrollPos;  
			 		if(scrollInterval <= autoScrollPos)window.requestAnimationFrame(step);
					}	
				window.requestAnimationFrame(step);	
				}	
			});
		
		/* This is register onclick part */
		 function formSwitch(){
			document.getElementById("loginForm").setAttribute("hidden", "hidden");	
			document.getElementsByTagName("h1")[0].setAttribute("hidden", "hidden");	
			document.getElementById("registerForm").removeAttribute("hidden");	
			document.getElementsByTagName("h1")[1].removeAttribute("hidden");
		}	 
		
		/* This is for registration info check */
		function checkForm(){
			var usrname = document.getElementById("usrname").value;
			var pwd = document.getElementById("pwd").value;
			var repwd = document.getElementById("repwd").value;
			var email = document.getElementById("email").value;
			var reg1 = new RegExp('^([a-zA-Z0-9]{5,10})$');
			var reg2 = new RegExp('^([a-zA-Z0-9]{1,15})+@([a-zA-Z0-9])+\.([a-zA-Z]{2,4})$');
			
			 if(($.trim(usrname).length == 0) ||
			    ($.trim(pwd).length == 0)     ||	
			    ($.trim(repwd).length == 0)   ||	
			    ($.trim(email).length == 0)) {
			
				$("#msg").get(0).innerHTML = "Please do not leave section blank";
				$("#usrname").select();
				$("#usrname").focus();
				return false;
			} else if(pwd != repwd){
				$("#msg").get(0).innerHTML = "Your password doesn't match";
				$("#usrname").select();
				$("#usrname").focus();
				 return false;
			} else if(!(reg1.test(usrname) && reg1.test(pwd))) {
				$("#msg").get(0).innerHTML = "Not appropriate username or password, must be five to ten digits consisting of letters or numbers only"
				$("#usrname").select();
				$("#usrname").focus();
				return false;
			} else if(!reg2.test(email)){
				$("#msg").get(0).innerHTML = "Not appropriate form of email address"
				$("#email").select();
				$("#email").focus();
			} else {
				$("#registerForm").submit();	
			}			
		}	
		
//		This checks when login
		 function loginCheck(){
			 var username = document.getElementById("loginUsrname").value;
			 var password = document.getElementById("loginPwd").value;
			 if(($.trim(username).length == 0) || ($.trim(password).length == 0)){
				 $("#loginMsg").get(0).innerHTML = "Please not leave section blank";
				 $("#usrname").select();
				 $("#usrname").focus();
			 } else { 
				 $.ajax({
					   type: "POST",
					   url: "../LoginServlet",
					   data: "loginUsrname=" + username + "&loginPwd=" + password,
					   success: function(result){
						   if(result == "true"){window.location.replace("home.jsp");}
						   else{$("#loginMsg").html("False username or password");}
					   }
					});
			 }
		 }
		 
//		 A float symbol on #popup
		 $(document).on('mouseenter','#popup', function (event) {
			    $( this ).find('#symBar').hide();
			}).on('mouseleave','#popup',  function(){
			    $( this ).find('#symBar').show();
			});
		 
		 
		 
		 
		 
		 
		 