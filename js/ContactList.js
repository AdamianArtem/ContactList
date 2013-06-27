$(document).ready(function()
{
	/**
		takes number of record
		return record stored in <table> 
		record consists of: First Name, Second Name, Phone Number, Email and remove botton
	**/
	function createRecord(id) {
		var firstName=$("input[name='firstName']").val();
		var secondName=$("input[name='secondName']").val();
		var phoneNumber=$("input[name='phoneNumber']").val();
		var email=$("input[name='email']").val();
		
		$("#tableId").append("<tr><td>"+id+"</td><td>"+firstName+"</td></td><td>"+secondName+"</td></td><td>"+phoneNumber+"</td></td><td>"+email+"</td><td><a><i class='icon-remove'></i></a></td></tr>");
	}
	
	$('#myModal').modal({show: false});//hide modal window, when the page opens
	var id=0;//count record
	
	$("#AddContactBotton").click(function(){
		id++;
		createRecord(id);
		
		$("td a").click(function(){
			$(this).parent().parent().remove();//var removeId=$(this).attr("id");// removeId stores the id remove button
		});
	});
});
