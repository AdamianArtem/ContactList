$(document).ready(function()
{
	function createRecord() {
		var firstName=$("#inputFirstName").val();
		$("#tableId").append("<tr id='trId-1'><td>"+firstName+"</td></tr>");
	}
	$('#myModal').modal({show: false});//hide modal window, when the page opens
	$("#AddContactBotton").click(function(){
		createRecord();
		//alert("you are clicked");
	});
});
