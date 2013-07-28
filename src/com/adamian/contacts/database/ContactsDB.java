package com.adamian.contacts.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.adamian.contacts.exception.ContactsException;
import com.adamian.contacts.model.Contact;

/**
 * Provides all database related operation for contact list
 */
public class ContactsDB {
	
	private static final Logger log = Logger.getLogger(ContactsDB.class);
	
	private static final String SELECT_ALL = "SELECT * from contact";
	private static final String SAVE_CONTACT = "INSERT INTO contact (`firstName`, `secondName`, `phoneNumber`, `email`) VALUES (?, ?, ?, ?)";
	private static final String DELETE_CONTACT = "DELETE FROM contact WHERE id= ?";
	
	/**
	 * Gets list of all contacts
	 */
	public List<Contact> getAllContacts() {
		log.info("Loading list of contacts");
		
		List<Contact> contacts = new ArrayList<>();
		
		// connect to database
		Connection connection = DatabaseConnector.connect();
		
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
        	preparedStatement = connection.prepareStatement(SELECT_ALL);
        	resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getInt("id"));
				contact.setFirstName( resultSet.getString("firstName"));
				contact.setSecondName(resultSet.getString("secondName"));
				contact.setPhoneNumber(resultSet.getString("phoneNumber"));
				contact.setEmail(resultSet.getString("email"));
				contacts.add(contact);
			} 
        } catch (SQLException e) {
        	throw new ContactsException("Can not load list of contacts", e);
        } finally {
        	closeConnection(connection, preparedStatement, resultSet);
        }
        
		return contacts;
	}

	/**
	 * Saves contact in database
	 */
	public void saveContact(Contact contact) {
		log.info("Saving contact "+contact);
		
		Connection connection = DatabaseConnector.connect();
		PreparedStatement preparedStatement = null;
        try {
        	preparedStatement = connection.prepareStatement(SAVE_CONTACT);
        	preparedStatement.setString(1, contact.getFirstName());
        	preparedStatement.setString(2, contact.getSecondName());
        	preparedStatement.setString(3, contact.getPhoneNumber());
        	preparedStatement.setString(4, contact.getEmail());
        	
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	throw new ContactsException("Can not save contact "+contact, e);
        } finally {
        	closeConnection(connection, preparedStatement, null);
        }
		
	}
	
	/**
	 * Deletes contact by id
	 */
	public void deleteContact(int id) {
		log.info("Deleting contact "+id);
		
		Connection connection = DatabaseConnector.connect();
		PreparedStatement preparedStatement = null;
        try {
        	preparedStatement = connection.prepareStatement(DELETE_CONTACT);
        	preparedStatement.setInt(1, id);
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	throw new ContactsException("Can not delete contact "+id, e);
        } finally {
        	closeConnection(connection, preparedStatement, null);
        }
	}
	
	private static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				log.warn("Can not close result set", e);
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				log.warn("Can not close prepared statement", e);
			}
		}
		try {
			connection.close();
		} catch (SQLException e) {
			log.warn("Can not close connection", e);
		}
	}
}
