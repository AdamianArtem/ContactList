package com.adamian.contacts.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.adamian.contacts.exception.ContactsException;

/**
 * Utility class to establish connections with database
 */
public class DatabaseConnector {
	
	private static Properties properties = new Properties();
	static {
		try {
			// load connection properties from configuration file
			properties.load(DatabaseConnector.class.getResourceAsStream("/connection.properties"));
			Class.forName(properties.getProperty("database.driver"));
		} catch (IOException e) {
			throw new ContactsException("Can not load database property file", e);
		} catch (ClassNotFoundException e) {
			throw new ContactsException("Can not find driver class", e);
		}
	}
	
	public static Connection connect() {
		try {
            return DriverManager.getConnection(properties.getProperty("database.url"), properties.getProperty("database.user"), properties.getProperty("database.password"));
		} catch (Exception e) {
			throw new ContactsException("Can not connect to database", e);
		}
	}
}
