package ca.uqam.vivodataconnect.ldap.extract;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;

import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.security.sasl.AuthenticationException;

import org.apache.directory.api.ldap.model.cursor.SearchCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.Response;
import org.apache.directory.api.ldap.model.message.SearchRequest;
import org.apache.directory.api.ldap.model.message.SearchRequestImpl;
import org.apache.directory.api.ldap.model.message.SearchResultEntry;
import org.apache.directory.api.ldap.model.name.Dn;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;

import ca.uqam.tool.vivoproxy.swagger.client.api.OrganizationApi;
import ca.uqam.tool.vivoproxy.swagger.client.handler.ApiClient;
import ca.uqam.tool.vivoproxy.swagger.client.model.LinguisticLabel;
import ca.uqam.tool.vivoproxy.swagger.client.model.ModelAPIResponse;
import ca.uqam.tool.vivoproxy.swagger.client.model.Organization;
import ca.uqam.vivodataconnect.ldap.util.LdapHelper;
import ca.uqam.vivodataconnect.ldap.util.OpenDjHelper;
import ca.uqam.vocab.vivo.VIVO;

public class ExtractAllDept {

	public static void main(String[] args) throws LdapException, AuthenticationException {
		Hashtable<String, String> environment = new Hashtable<String, String>();

		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, "ldaps://"+LdapHelper.getAddress()+":"+LdapHelper.getPort());
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.SECURITY_PRINCIPAL, LdapHelper.getUserName());
		environment.put(Context.SECURITY_CREDENTIALS,  LdapHelper.getPasswd());
		//		LdapConnection connection = new LdapNetworkConnection( LdapHelper.getAddress(), LdapHelper.getPort(), true );	
		//		connection.bind("uid="+LdapHelper.getUserName(), LdapHelper.getPasswd());
		try {
			LdapContext ctx = new InitialLdapContext(environment, null);
			ctx.setRequestControls(null);
			NamingEnumeration<?> namingEnum = ctx.search(OpenDjHelper.UniteDomainAddress, "(objectClass=*)", getSimpleSearchControls());
			OrganizationApi  organizationVivoProxyApi = ExtractAllDept.getVivoProxyApiClient();
			while (namingEnum.hasMore ()) {
				SearchResult result = (SearchResult) namingEnum.next ();    
				Attributes attrs = result.getAttributes();
				Attribute cnAttrib = attrs.get("cn");
				System.out.println(cnAttrib.get(0));
				String uniteName=cnAttrib.get(0).toString();
				String uniteNo="";
				try {
					System.out.println(cnAttrib.get(1));
					uniteNo=cnAttrib.get(1).toString();
				} catch (Exception e) {
				}
				try {
					Organization org = ExtractAllDept.buildOrganization(uniteNo, uniteName);
					ModelAPIResponse resu = organizationVivoProxyApi.createOrganization(org);
					System.out.println(resu.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			namingEnum.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
	private static OrganizationApi getVivoProxyApiClient() {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://vivo-proxy.ca-central-1.elasticbeanstalk.com/vivo-proxy");
		OrganizationApi orgApi = new OrganizationApi(apiClient);
		return orgApi;
	}
	private static Organization buildOrganization(String uniteNo, String uniteName) {
		try {
			System.out.println("----"+uniteNo.split("\\ ")[1]+"-----"+uniteName+"----");
			Organization org = new Organization();
			org.setId(uniteNo.split("\\ ")[1]);
			LinguisticLabel cLabelFr = new LinguisticLabel();
			cLabelFr.setLabel(uniteName);
			cLabelFr.setLanguage(Locale.CANADA_FRENCH.toLanguageTag());
			org.addNamesItem(cLabelFr);
			LinguisticLabel overviewLabel = new LinguisticLabel();
			overviewLabel.setLabel(uniteNo + " : " +uniteName);
			overviewLabel.setLanguage(Locale.CANADA_FRENCH.toLanguageTag());
			org.addOverviewItem(overviewLabel);
			org.setOrganizationType(VIVO.AcademicDepartment.getURI());
			return org;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	private static SearchControls getSimpleSearchControls() {
		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		searchControls.setTimeLimit(30000);
		//String[] attrIDs = {"objectGUID"};
		//searchControls.setReturningAttributes(attrIDs);
		return searchControls;
	}
}
