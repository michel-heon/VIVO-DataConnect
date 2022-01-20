package ca.uqam.vivodataconnect.ldap.etl;

import java.util.Locale;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;
import javax.security.sasl.AuthenticationException;

import org.apache.directory.api.ldap.model.exception.LdapException;

import ca.uqam.tool.vivoproxy.swagger.client.api.PersonApi;
import ca.uqam.tool.vivoproxy.swagger.client.handler.ApiClient;
import ca.uqam.tool.vivoproxy.swagger.client.model.AddressSchema;
import ca.uqam.tool.vivoproxy.swagger.client.model.LinguisticLabel;
import ca.uqam.tool.vivoproxy.swagger.client.model.ModelApiResponse;
import ca.uqam.tool.vivoproxy.swagger.client.model.PersonWithOfficeInfo;
import ca.uqam.vivodataconnect.ldap.util.OpenDjHelper;
import ca.uqam.vivodataconnect.util.DataConnectHelper;
import ca.uqam.vocab.vivo.VIVO;

public class ETL_Personnes {

	private static PersonWithOfficeInfo person;
	public static void main(String[] args) throws LdapException, AuthenticationException {
		int ctr=0;
		try {
			LdapContext ctx = OpenDjHelper.InitialLdapContext();
			NamingEnumeration<?> namingEnum = ctx.search(OpenDjHelper.ProfesseurDA, "(objectClass=*)", getSimpleSearchControls());
			PersonApi  personVivoProxyApi = ETL_Personnes.getVivoProxyApiClient();
			while (namingEnum.hasMore ()) {
				SearchResult result = (SearchResult) namingEnum.next ();    
				Attributes attrs = result.getAttributes();
				NamingEnumeration<?> members = attrs.get("member").getAll();
				while (members.hasMoreElements()) {
					String member = ((String) members.nextElement()).split(",")[0];
//					System.out.println(member);
					NamingEnumeration<?> personneInfo = ETL_Personnes.searchInfoOf(member, ctx);
					ModelApiResponse resu = personVivoProxyApi.createPersonWithEmail(person);
					System.out.println("ctr = "+ctr++ + "\n" +resu.toString());
//					if(ctr > 10) break;
				}
			}
			namingEnum.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}
	private static PersonApi getVivoProxyApiClient() {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(DataConnectHelper.getVivoProxyUrl());
		PersonApi api = new PersonApi(apiClient);
		return api;
	}
	private static NamingEnumeration<?> searchInfoOf(String member, LdapContext ctx) throws NamingException {
		NamingEnumeration<?> namingEnum = ctx.search(OpenDjHelper.PersonneDA, member, getSimpleSearchControls());
		while (namingEnum.hasMore ()) {
			SearchResult result = (SearchResult) namingEnum.next ();    
			Attributes attrs = result.getAttributes();
			buildPersonne(attrs);
		}
		
		return null;
	}
	private static void buildPersonne(Attributes attrs) throws NamingException {
		person = new PersonWithOfficeInfo();	
		person.setPersonType(VIVO.FacultyMember.getURI());
		person.setEMail(OpenDjHelper.getValueOfAttrib(attrs,"mail;public"));
		try {
			person.addTitleItem(buildLinguisticLabel(attrs, "title;primary"));
		} catch (Exception e) { 
			System.err.println(errorMessage("title;primary"));
		}
		try {
			NamingEnumeration<?> titleAttr = attrs.get("title").getAll();
			while (titleAttr.hasMore ()) {
				String value = (String) titleAttr.next ();   
				LinguisticLabel label = new LinguisticLabel();
				label.setLabel(value);
				label.setLanguage(Locale.CANADA_FRENCH.toLanguageTag());
				person.addSecondaryTitleItem(label);			}
		} catch (Exception e) {
			System.err.println(errorMessage("title"));
		}
		person.addLastNameItem(buildLinguisticLabel(attrs, "sn"));
		person.addFirstNameItem(buildLinguisticLabel(attrs, "givenName"));
		person.setId(OpenDjHelper.getValueOfAttrib(attrs, "cn"));
		try {
			person.addDisplayNameItem(buildLinguisticLabel(attrs, "displayName"));
		} catch (Exception e) { 
			System.err.println(errorMessage("displayName"));
		}
		try {
			person.setOrganizationUnitId(OpenDjHelper.getValueOfAttrib(attrs,"departmentNumber;primary"));
		} catch (Exception e) { 
			System.err.println(errorMessage("departmentNumber;primary"));
		}
		try {
			person.setTelephone(OpenDjHelper.getValueOfAttrib(attrs,"telephoneNumber"));
		} catch (Exception e) { 
			System.err.println(errorMessage("telephoneNumber"));
		}
		try {
			AddressSchema address = new AddressSchema();
			address.setOfficeNumber(OpenDjHelper.getValueOfAttrib(attrs,"physicalDeliveryOfficeName"));
			person.addAddressItem(address);
		} catch (Exception e) { 
			System.err.println(errorMessage("physicalDeliveryOfficeName"));
		}
		try {
			NamingEnumeration<?> mailAtt = attrs.get("mail").getAll();
			while (mailAtt.hasMore ()) {
				Object result = mailAtt.next ();   
				person.addSecondaryMailsItem((String) result);
			}
		} catch (Exception e) {
			System.err.println(errorMessage("mail"));
		}
	}
	private static String errorMessage(String key) {
		// TODO Auto-generated method stub
		return "key: (" + key +") NOT FOUND";
	}
	private static LinguisticLabel buildLinguisticLabel(Attributes attrs, String key) throws NamingException {
		LinguisticLabel label = new LinguisticLabel();
		Attribute atribute = attrs.get(key);
		Object value = atribute.get(0);
		label.setLabel(value.toString());
		label.setLanguage(Locale.CANADA_FRENCH.toLanguageTag());
		return label;
		
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
