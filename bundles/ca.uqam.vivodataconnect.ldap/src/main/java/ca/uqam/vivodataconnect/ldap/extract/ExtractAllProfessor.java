package ca.uqam.vivodataconnect.ldap.extract;

import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;

import ca.uqam.vivodataconnect.ldap.util.LdapHelper;

public class ExtractAllProfessor {

	public static void main(String[] args) throws LdapException {
		LdapConnection connection = new LdapNetworkConnection( LdapHelper.getAddress(), LdapHelper.getPort(), true );	
		connection.bind("uid="+LdapHelper.getUserName(), LdapHelper.getPasswd());
	}

}
