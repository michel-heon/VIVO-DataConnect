package ca.uqam.vivodataconnect.ldap.util;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import ca.uqam.vivodataconnect.util.DataConnectHelper;

public class OpenDjHelper {
	public static String PersonneDA = "ou=personnes,dc=code,dc=uqam,dc=ca";
	public static String ProfesseurDA = "cn=Professeur 20,cn=Fonctions,ou=groupes,dc=code,dc=uqam,dc=ca";
	public static String UniteDomainAddress = "cn=Unités,ou=groupes,dc=code,dc=uqam,dc=ca";
	private static Hashtable<String, String> environment = new Hashtable<String, String>();


	public static LdapContext InitialLdapContext() throws NamingException {
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, "ldaps://"+DataConnectHelper.getAddress()+":"+DataConnectHelper.getPort());
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.SECURITY_PRINCIPAL, DataConnectHelper.getUserName());
		environment.put(Context.SECURITY_CREDENTIALS,  DataConnectHelper.getPasswd());
		//		LdapConnection connection = new LdapNetworkConnection( LdapHelper.getAddress(), LdapHelper.getPort(), true );	
		//		connection.bind("uid="+LdapHelper.getUserName(), LdapHelper.getPasswd());
		javax.naming.ldap.InitialLdapContext ctx = new InitialLdapContext(environment, null);
		ctx.setRequestControls(null);
		return ctx;
	}
	public static String getValueOfAttrib(Attributes attrs, String key) {
		return attrs.get(key).toString().split(" ")[1];
	}

}
