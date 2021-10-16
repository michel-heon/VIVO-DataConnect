/**
 * 
 */
package ca.uqam.vivodataconnect.orcid.connect;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Endpoints

PRODUCTION

    Authorization requests: https://orcid.org/oauth/authorize
    Token exchange: https://orcid.org/oauth/token
    Public API calls: https://pub.orcid.org/[version]
    Member API calls: https://api.orcid.org/[version]

SANDBOX

    Authorization requests: https://sandbox.orcid.org/oauth/authorize
    Token exchange: https://sandbox.orcid.org/oauth/token
    Public API: https://pub.sandbox.orcid.org/[version]
    Member API: https://api.sandbox.orcid.org/[version]

 */
/**
 * ID client
APP-TUMEA1WMPQAAHXMB
Secret du client
6f887740-1ce1-467b-b90c-510eb9843f5b

https://pub.orcid.org/v2.0/
https://localhost:8080
https://vivo-i18n.dev.uqam.ca/vivodataconnect
https://developers.google.com/oauthplayground
https://localhost:8080/vivo-dataconnect
https://vivo-i18n.dev.uqam.ca:8080/vivodataconnect
https://localhost
https://vivo-i18n.dev.uqam.ca:8080/vivodataconnect/callback
https://vivo-dataconnect.dev.uqam.ca:8080/vivo/callback
https://vivo-i18n.dev.uqam.ca/vivodataconnect/callback

 */


/** ORCID SandBox
 * 1. Your sandbox Member API testing credentials
Client ID: APP-4RQIGQS5232XWH53
Client secret: c2c5d13a-a3e8-4edc-812b-9b5b9c8df149 
Redirect URIs:
https://api.sandbox.orcid.org/v3.0/ 
https://developers.google.com/oauthplayground http://localhost
http://localhost:8080
http://localhost:8080/vivo-dataconnect
http://localhost:8080/vivo-dataconnect/callback1
http://localhost:8080/vivo-dataconnect/callback2

 */
/**
 * @author heon
 *
 */
public class OAuthAcces {
	private static final String clientId = "APP-4RQIGQS5232XWH53";//clientId
	private static final String callBackUrl = "http://localhost:8080";//The url defined in WSO2
	private static final String authorizeUrl = "https://sandbox.orcid.org/oauth/authorize";
	private static final Pattern pat = Pattern.compile(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*");
	private static final String clientSecret = "c2c5d13a-a3e8-4edc-812b-9b5b9c8df149";//client secret
	private static final String tokenUrl = "https://sandbox.orcid.org/oauth/token";
	private static final String auth = clientId + ":" + clientSecret;
	private static final String authentication = Base64.getEncoder().encodeToString(auth.getBytes());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//OAuthAcces.getClientCredentials();
		//OAuthAcces.useBearerToken("a000283e-63c5-4eb6-a469-c60f0fde918c");
		/*
		 * Prod Tocken
		 */
		OAuthAcces.useBearerToken("bd87396a-3257-4351-85d6-78cda3ccfab9");
		
		// TODO Auto-generated method stub

	}

	private static String getAuthGrantType(String callbackURL){
	    return authorizeUrl + "?response_type=code&client_id=" + clientId + "&redirect_uri=" + callbackURL + "&scope=openid";
	}
	
	private static String getClientCredentials() {
	    String content = "grant_type=client_credentials";
	    BufferedReader reader = null;
	    HttpsURLConnection connection = null;
	    String returnValue = "";
	    try {
	        URL url = new URL(tokenUrl);
	        connection = (HttpsURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);
	        connection.setRequestProperty("Authorization", "Basic " + authentication);
	        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        connection.setRequestProperty("Accept", "application/json");
	        PrintStream os = new PrintStream(connection.getOutputStream());
	        os.print(content);
	        os.close();
	        InputStream cis = connection.getInputStream();
	        InputStreamReader istr = new InputStreamReader(cis);
	        reader = new BufferedReader(istr);
	        String line = null;
	        StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
	        while ((line = reader.readLine()) != null) {
	            out.append(line);
	        }
	        String response = out.toString();
	        Matcher matcher = pat.matcher(response);
	        if (matcher.matches() && matcher.groupCount() > 0) {
	            returnValue = matcher.group(1);
	        }
	    } catch (Exception e) {
	        System.out.println("Error : " + e.getMessage());
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e) {
	            }
	        }
	        connection.disconnect();
	    }
	    return returnValue;
	}
	
	//Wait for user to logIn and then
	//getAccessToken(with the authorizationCode from header name 'authorization_code', callbackUrl);
	//Then call useBearerToken('access_token')
	private static void useBearerToken(String bearerToken) {
	    BufferedReader reader = null;
	    try {
//	        URL url = new URL("https://pub.sandbox.orcid.org/v3.0/search/?q=affiliation-org-name:%22Boston%20University%22");
	        URL url = new URL("https://pub.orcid.org/v3.0/0000-0002-9227-8514/employment/22411");
	        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
	        connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setDoOutput(true);
	        connection.setRequestMethod("GET");
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line = null;
	        StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
	        while ((line = reader.readLine()) != null) {
	            out.append(line);
	        }
	        String response = out.toString();
	        System.out.println(response);
	    } catch (Exception e) {

	    }
	 }

	String authorizationRedirect = getAuthGrantType(callBackUrl);

}
