
function check(event) {
	var target = event.target || event.currentTarget;
	var accountId = target.id;
	  $.ajax({
		  url:"http://localhost:8080/proxibanquev3/webservices/check",
	  		method:"POST",
	  		contentType : "application/json" , 
			  data : JSON.stringify({ id : accountId })
	  }).done(function(status){
//		  if(status.chequeOk = true)
		  $("#statusmsg").append(status.msg);
		  
		  
	  })
}