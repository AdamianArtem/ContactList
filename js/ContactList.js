﻿$(document).ready(function()
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
		
		$("#tableId").append("<tr><td id='"+id+"'>"+id+"</td><td>"+firstName+"</td></td><td>"+secondName+"</td></td><td>"+phoneNumber+"</td></td><td>"+email+"</td><td><a class='removeButton'><i class='icon-remove'></i></a></td></tr>");
	}
	
	$('#myModal').modal({show: false});//hide modal window, when the page opens
	var id=0;//count record
	
	$("#AddContactBotton").click(function(){
		
		id++;
		createRecord(id);
		
		$("#myModal input").val("");
		
		$(".removeButton:last").click(function(){
			
			$(this).parent().parent().remove();
			var number=parseInt($(this).parent().parent().text());
			//alert(parseInt($(this).parent().parent().text()));
			for(var record=number;record<id;record++) {
				$("#"+(record+1)).text(record);
				//alert($("#"+(r+1)).text());
			}
			id--;
			//$("#"+4).text(record);
		});
	});
	
	
});
