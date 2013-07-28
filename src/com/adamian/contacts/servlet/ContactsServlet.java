package com.adamian.contacts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adamian.contacts.database.ContactsDB;
import com.adamian.contacts.model.Contact;

public class ContactsServlet extends HttpServlet {

	private static final long serialVersionUID = -3501366363160639907L;
	
	private static final Logger log = Logger.getLogger(ContactsServlet.class);
	
	private static final String CONTACT_LIST_JSP = "/ContactList.jsp";
	private static final String DELETE_CONTACT_PARAMETER = "deleteContact";
	
	private static final ContactsDB db = new ContactsDB();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter(DELETE_CONTACT_PARAMETER) != null) {
			deleteContact(request, response);
		} else {
			displayContactList(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Contact contact = new Contact();
	        contact.setFirstName(request.getParameter("firstName"));
			contact.setSecondName(request.getParameter("secondName"));
			contact.setPhoneNumber(request.getParameter("phoneNumber"));
			contact.setEmail(request.getParameter("email"));
			db.saveContact(contact);
		} catch (Exception e) {
			log.error("Can not save contact", e);
			request.setAttribute("error", "Can not save contact");
		} finally {
			displayContactList(request, response);
		}
	}

	
	public void deleteContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int contactId = Integer.parseInt(request.getParameter(DELETE_CONTACT_PARAMETER));
			db.deleteContact(contactId);
		} catch (Exception e) {
			log.error("Can not delete contact", e);
			request.setAttribute("error", "Can not delete contact");
		} finally {
			displayContactList(request, response);
		}
	}
	
	public void displayContactList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("contacts", db.getAllContacts());
		} catch (Exception e) {
			log.error("Can not load list of contacts", e);
			request.setAttribute("error", "Can not load contact list");
		}
		request.getRequestDispatcher(CONTACT_LIST_JSP).forward(request, response);
	}

	
}
