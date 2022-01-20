package ca.uqam.vivodataconnect.ldap.eval;

import java.io.IOException;

import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.apache.directory.api.ldap.model.cursor.SearchCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.Response;
import org.apache.directory.api.ldap.model.message.SearchRequest;
import org.apache.directory.api.ldap.model.message.SearchRequestImpl;
import org.apache.directory.api.ldap.model.message.SearchResultEntry;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.api.ldap.model.name.Dn;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;

import ca.uqam.vivodataconnect.util.DataConnectHelper;

/**
 * @author Michel Héon; Université du Québec à Montréal
 * @filename TestUqamLdap.java
 * @date 16 oct. 2021
 */
public class TestUqamLdap {
	public static void main(String[] args) throws LdapException, CursorException, IOException {
		System.out.println("Get connection");
		LdapConnection connection = new LdapNetworkConnection( DataConnectHelper.getAddress(), DataConnectHelper.getPort(), true );	
		System.out.println("Get bind");
		System.out.println(DataConnectHelper.getUserName());
		connection.bind("uid="+DataConnectHelper.getUserName(), DataConnectHelper.getPasswd());
		System.out.println("Get cursor");
        // Create the SearchRequest object
        SearchRequest req = new SearchRequestImpl();
        req.setScope( SearchScope.SUBTREE );
//        req.addAttributes( "member;range=1-5" );
        req.setSizeLimit(10000);
        //       req.setSizeLimit(2);

//        req.setTimeLimit( 0 );
        req.setBase( new Dn(  "ou=personnes,dc=code,dc=uqam,dc=ca" ) );
        req.setFilter( "(mail=n*)" );
        req.setFilter( "(mail=nguyen.minh_dat@uqam.ca)" );
        req.setFilter( "(uqamEduPersonNomUniteRegroupement=SPUQ)" );
//        req.setFilter( "(mail=nkambou.roger*)" );
//        req.setFilter( "(objectClass=*)" );
        SearchCursor searchCursor = connection.search( req);
        int ctr=0;
        while ( searchCursor.next() )
        {
            Response response = searchCursor.get();
            ctr++;

            // process the SearchResultEntry
            if ( response instanceof SearchResultEntry )
            {
                Entry resultEntry = ( ( SearchResultEntry ) response ).getEntry();
             	System.out.println( resultEntry.get("mail") );
             	System.out.println( resultEntry.get("title") );
             	System.out.println( resultEntry.get("uqamEduPersonStatutEmploiPrincipal"));
             	System.out.println( resultEntry.get("uqamEduPersonNomUniteOrg"));
//               System.out.println( resultEntry.get("uqamEduPersonNomUniteRegroupement") );
//                System.out.println( resultEntry );
            }
        }
        
//		EntryCursor cursor = connection.search( "ou=personnes,dc=code,dc=uqam,dc=ca", "(title=Professeur)", SearchScope.SUBTREE);
//        EntryCursor cursor = connection.search( req );
//		System.out.println("Get entrys");
//		while ( cursor.next() )
//		{
//		    Entry entry = cursor.get();
//		    System.out.println(entry);
//		    System.exit(0);
//		}
//		connection.unBind();
		System.out.println(ctr);
		System.out.println("Done");
		connection.close();
	}
}
