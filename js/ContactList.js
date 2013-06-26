$(document).ready(function()
{
	/**
		takes id, this id for number of record and for number of remove button
	**/
	function createRecord(id) {
		var firstName=$("#inputFirstName").val();
		//$("#inputFirstName").empty();
		$("#tableId").append("<tr><td>"+firstName+"</td></tr>");
	}
	$('#myModal').modal({show: false});//hide modal window, when the page opens
	
	$("#AddContactBotton").click(function(){
		createRecord();
		$("#inputFirstName").empty();
		//alert("you are clicked");
	});
});
