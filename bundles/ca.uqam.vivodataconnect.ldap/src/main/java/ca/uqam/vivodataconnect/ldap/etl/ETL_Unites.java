package ca.uqam.vivodataconnect.ldap.etl;

import java.util.Locale;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;
import javax.security.sasl.AuthenticationException;

import org.apache.directory.api.ldap.model.exception.LdapException;

import ca.uqam.tool.vivoproxy.swagger.client.api.OrganizationApi;
import ca.uqam.tool.vivoproxy.swagger.client.handler.ApiClient;
import ca.uqam.tool.vivoproxy.swagger.client.model.LinguisticLabel;
import ca.uqam.tool.vivoproxy.swagger.client.model.ModelApiResponse;
import ca.uqam.tool.vivoproxy.swagger.client.model.Organization;
import ca.uqam.vivodataconnect.ldap.util.OpenDjHelper;
import ca.uqam.vivodataconnect.util.DataConnectHelper;
import ca.uqam.vocab.vivo.VIVO;

public class ETL_Unites {

    public static void main(String[] args) throws LdapException, AuthenticationException {
        try {
            LdapContext ctx = OpenDjHelper.InitialLdapContext();
            NamingEnumeration<?> namingEnum = ctx.search(OpenDjHelper.UniteDomainAddress, "(objectClass=*)", getSimpleSearchControls());
            OrganizationApi  organizationVivoProxyApi = ETL_Unites.getVivoProxyApiClient();
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
                    Organization org = ETL_Unites.buildOrganization(uniteNo, uniteName);
                    ModelApiResponse resu = organizationVivoProxyApi.createOrganization(org);
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
        apiClient.setBasePath(DataConnectHelper.getVivoProxyUrl());
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
