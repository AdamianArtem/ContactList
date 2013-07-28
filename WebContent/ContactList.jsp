<!DOCTYPE html>
<%@page import="com.adamian.contacts.model.Contact"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Contact List</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="navbar">
				<div class="navbar-inner">
					<a class="brand" href="#">Contact List</a>
					<h5 class="pull-right">
						<a href="#addDialog" role="button" data-toggle="modal">Add Contact</a>
					</h5>
				</div>
			</div>
		</div>
		<%
			if (request.getAttribute("error") != null) {
		%>
		<div class="row">
			<div class="alert alert-error">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<%=request.getAttribute("error")%>
			</div>
		</div>
		<%
			}
		%>
		<div class="row">
			<table class="table table-striped" id="contactTable">
				<tr>
					<td><strong>#</strong></td>
					<td><strong>First Name</strong></td>
					<td><strong>Second Name</strong></td>
					<td><strong>Phone Number</strong></td>
					<td><strong>Email</strong></td>
					<td></td>
				</tr>
				<%
					List<Contact> contacts = (List<Contact>) request
							.getAttribute("contacts");
					for (int i = 0; i < contacts.size(); i++) {
						Contact contact = contacts.get(i);
				%>
				<tr>
					<td><%=i + 1%></td>
					<td><%=contact.getFirstName()%></td>
					<td><%=contact.getSecondName()%></td>
					<td><%=contact.getPhoneNumber()%></td>
					<td><%=contact.getEmail()%></td>
					<td><a href="Contacts?deleteContact=<%=contact.getId()%>"
						class='removeButton'><i class='icon-remove'></i></a></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>

	<!--modal window Add Contact-->
	<div class="modal hide" id="addDialog">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>Add Contact</h3>
		</div>
		<div class="modal-body">
			<form method="post" class="form-horizontal" action="Contacts">
				<div class="control-group">
					<label class="control-label">First Name</label>
					<div class="controls">
						<input type="text" name="firstName" placeholder="First Name">
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">Second Name</label>
					<div class="controls">
						<input type="text" name="secondName" placeholder="Second Name">
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">Phone Number</label>
					<div class="controls">
						<input type="text" name="phoneNumber" placeholder="Phone Number">
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">Email</label>
					<div class="controls">
						<input type="text" name="email" placeholder="Email">
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" id="AddContactBotton" class="btn btn-primary"
						aria-hidden="true">Add Contact</button>
					<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
				</div>
			</form>
		</div>
	</div>
	<!--end modal window Add Contact-->

	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>