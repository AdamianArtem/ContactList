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
		
		$("#tableId").append("<tr id='record"+id+"'><td>"+id+"</td><td>"+firstName+"</td></td><td>"+secondName+"</td></td><td>"+phoneNumber+"</td></td><td>"+email+"</td><td><a  id='"+id+"'><i class='icon-remove'></i></a></td></tr>");
	}
	$('#myModal').modal({show: false});//hide modal window, when the page opens
	
	var id=0;//count remove buttons
	
	$("#AddContactBotton").click(function(){
		id++;
		createRecord(id);
		
		$("#"+id).click(function(){
			var removeId=$(this).attr("id");// removeId stores the id remove button
			
			$("#record"+removeId).remove();
	});
	});
});
