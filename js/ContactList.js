$(document).ready(function()
{
	/**
		takes number of record
		return record stored in <table> 
		record consists of: First Name, Second Name, Phone Number, Email and remove botton
	**/
	function createRecord(id) {
		var firstName=$("input[placeholder='First Name']").val();
		var secondName=$("input[placeholder='Second Name']").val();
		var phoneNumber=$("input[placeholder='Phone Number']").val();
		var email=$("input[placeholder='Email']").val();
		
		$("#tableId").append("<tr><td>"+id+"</td><td>"+firstName+"</td></td><td>"+secondName+"</td></td><td>"+phoneNumber+"</td></td><td>"+email+"</td><td><a><i class='icon-remove'></i></a></td></tr>");
	}
	
	$('#myModal').modal({show: false});//hide modal window, when the page opens
	var id=0;//count record
	
	$("#AddContactBotton").click(function(){
		id++;
		createRecord(id);
		
		$("td a").click(function(){
			var tr=$(this).parent().parent();//var removeId=$(this).attr("id");// removeId stores the id remove button
			$(tr).remove();
		});
	});
});
