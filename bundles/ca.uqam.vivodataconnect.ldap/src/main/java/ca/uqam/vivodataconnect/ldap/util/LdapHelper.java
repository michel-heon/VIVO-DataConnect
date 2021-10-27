package ca.uqam.vivodataconnect.ldap.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Michel Héon; Université du Québec à Montréal
 * @filename LdapHelper.java
 * @date 19 oct. 2021
 */
public class LdapHelper{
	private static Properties loginProperties;
	private static LdapHelper login_instance;
	public static LdapHelper getInstance()
	{
		if (login_instance == null)
			login_instance = new LdapHelper();

		return login_instance;
	}
	/**
	 * 
	 */
	private LdapHelper(){
		try (InputStream input = LdapHelper.class.getClassLoader().getResourceAsStream("ldap.properties")) {
			if (input == null) {
				System.out.println("Sorry, unable to find ldap.properties");
			}
			loginProperties = new Properties();
			//load a properties file from class path, inside static method
			loginProperties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		LdapHelper.getInstance();
		//get the property value and print it out
		System.out.println(LdapHelper.getUserName());
		System.out.println(LdapHelper.getPasswd());
	}
	/**
	 * @return the passwd
	 */
	static public String getPasswd() {
		LdapHelper.getInstance();
		return loginProperties.getProperty("password");    
	}
	/**
	 * @return the userName
	 */
	static public String getUserName() {
		LdapHelper.getInstance();
		return loginProperties.getProperty("username");
	}
	/**
	 * @return the userName
	 */
	static public String getAddress() {
		LdapHelper.getInstance();
		return loginProperties.getProperty("address");
	}
	/**
	 * @return the userName
	 */
	static public int getPort() {
		LdapHelper.getInstance();
		return Integer.valueOf(loginProperties.getProperty("port"));
	}
}