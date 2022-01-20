package ca.uqam.vivodataconnect.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Michel Héon; Université du Québec à Montréal
 * @filename LdapHelper.java
 * @date 19 oct. 2021
 */
/**
 * @author heon
 *
 */
public class DataConnectHelper{

	private static Properties loginProperties;
	private static DataConnectHelper login_instance;
	public static DataConnectHelper getInstance()
	{
		if (login_instance == null)
			login_instance = new DataConnectHelper();

		return login_instance;
	}
	/**
	 * 
	 */
	private DataConnectHelper(){
		try (InputStream input = DataConnectHelper.class.getClassLoader().getResourceAsStream(Constant.VIVO_DATACONNECT_PROPERTIES)) {
			if (input == null) {
				System.out.println("Sorry, unable to find "+Constant.VIVO_DATACONNECT_PROPERTIES);
			}
			loginProperties = new Properties();
			//load a properties file from class path, inside static method
			loginProperties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DataConnectHelper.getInstance();
		//get the property value and print it out
		System.out.println(DataConnectHelper.getUserName());
		System.out.println(DataConnectHelper.getPasswd());
	}
	
	/**
	 * @return VIVO_PROXY_URL
	 */
	public static String getVivoProxyUrl() {
		DataConnectHelper.getInstance();
		return loginProperties.getProperty(Constant.VIVO_PROXY_URL);    
	}

	/**
	 * @return the passwd
	 */
	static public String getPasswd() {
		DataConnectHelper.getInstance();
		return loginProperties.getProperty(Constant.OPENDJ_PASSWORD);    
	}
	/**
	 * @return the userName
	 */
	static public String getUserName() {
		DataConnectHelper.getInstance();
		return loginProperties.getProperty(Constant.OPENDJ_USERNAME);
	}
	/**
	 * @return the adresss
	 */
	static public String getAddress() {
		DataConnectHelper.getInstance();
		return loginProperties.getProperty(Constant.OPENDJ_ADDRESS);
	}
	/**
	 * @return the port
	 */
	static public int getPort() {
		DataConnectHelper.getInstance();
		return Integer.valueOf(loginProperties.getProperty(Constant.OPENDJ_PORT));
	}
}