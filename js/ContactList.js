$(document).ready(function()
{
	function createRecord() {
		var firstName=$("input[name='firstName']").val();
		var secondName=$("input[name='secondName']").val();
		var phoneNumber=$("input[name='phoneNumber']").val();
		var email=$("input[name='email']").val();
		
		$("#contactTable").append("<tr><td class='rowIndex'></td><td>"+firstName+"</td></td><td>"+secondName+"</td></td><td>"+phoneNumber+"</td></td><td>"+email+"</td><td><a class='removeButton'><i class='icon-remove'></i></a></td></tr>");
	}
	
	function numerateRows() {
		$("#contactTable .rowIndex").each(function(i) {
				$(this).text(i+1);
		});
		
	}
	
	$('#myModal').modal({show: false});//hide modal window, when the page opens
	
	$("#AddContactBotton").click(function(){
		createRecord();
		numerateRows();
		$("#myModal input").val("");
		
		$(".removeButton:last").click(function(){
			$(this).parent().parent().remove();
			numerateRows();
		});
	});
	
	
});
