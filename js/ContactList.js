$(document).ready(function()
{
	/**
		takes id, this id for number of record and for number of remove buttons
		return record stored in <table> 
		record consists of: First Name, Second Name, Phone Number, Email and remove botton
	**/
	function createRecord(id) {
		var firstName=$("#inputFirstName").val();
		var secondName=$("#inputSecondName").val();
		var phoneNumber=$("#inputPhoneNumber").val();
		var email=$("#inputEmail").val();
		
		$("#tableId").append("<tr><td>"+id+"</td><td>"+firstName+"</td></td><td>"+secondName+"</td></td><td>"+phoneNumber+"</td></td><td>"+email+"</td><td><a href='#'><i class='icon-remove'></i></a></td></tr>");
	}
	$('#myModal').modal({show: false});//hide modal window, when the page opens
	
	var id=0;//record count and remove buttons
	
	$("#AddContactBotton").click(function(){
		id++;
		createRecord(id);
		//$("#inputFirstName").empty();
		//alert("you are clicked");
	});
});
