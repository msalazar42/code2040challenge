//CODE2040 Challenge
//Name: Marvin Salazar Jr
//Email: msalazar42@me.com

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Exception;import java.lang.String;import java.lang.StringBuilder;

//import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public class project {
	
	public static String getToken()
	{
		InputStream inputStream = null;
        String result;
        StringBuilder builder = new StringBuilder();
        String token = "";
        try 
        {    
          // 1. create HttpClient
           HttpClient httpclient = new DefaultHttpClient();

           // 2. make POST request to the given URL
           HttpPost httpPost = new HttpPost("http://challenge.code2040.org/api/register");

           String json = "";
           String email = "msalazar42@me.com";
           String repo = "https://github.com/msalazar42/code2040challenge.git";

           // 3. build jsonObject
           JSONObject jsonObject = new JSONObject();
           jsonObject.accumulate("email", email);
           jsonObject.accumulate("github", repo);

           // 4. convert JSONObject to JSON to String
           json = jsonObject.toString();

           // ** Alternative way to convert Person object to JSON string usin Jackson Lib
           // ObjectMapper mapper = new ObjectMapper();
           // json = mapper.writeValueAsString(person);

           // 5. set json to StringEntity
           StringEntity se = new StringEntity(json);

           // 6. set httpPost Entity
           httpPost.setEntity(se);

           // 7. Set some headers to inform server about the type of the content
           httpPost.setHeader("Accept", "application/json");
           httpPost.setHeader("Content-type", "application/json");


           // 8. Execute POST request to the given URL
           HttpResponse httpResponse = httpclient.execute(httpPost);

           // 9. receive response as inputStream
           inputStream = httpResponse.getEntity().getContent();

           BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           
           //retrieves string from json response
           while ((result = reader.readLine()) != null) {
               builder.append(result);
           }
           
           token = builder.toString();
           int begin = token.indexOf(':');
           int end = token.indexOf('}');
           token = token.substring(begin+2, end-1);
           

       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception ex) {
         ex.printStackTrace();
       }
        return token;
	}
	
	public static String getstring(String token)
	{
		InputStream inputStream = null;
        String result;
        StringBuilder builder = new StringBuilder();
        String string2rev = " ";
        try 
        {    
          // 1. create HttpClient
           HttpClient httpclient = new DefaultHttpClient();

           // 2. make POST request to the given URL
           HttpPost httpPost = new HttpPost("http://challenge.code2040.org/api/getstring");

           String json = "";

           // 3. build jsonObject
           JSONObject jsonObject = new JSONObject();
           jsonObject.accumulate("token", token);

           // 4. convert JSONObject to JSON to String
           json = jsonObject.toString();

           // ** Alternative way to convert Person object to JSON string usin Jackson Lib
           // ObjectMapper mapper = new ObjectMapper();
           // json = mapper.writeValueAsString(person);

           // 5. set json to StringEntity
           StringEntity se = new StringEntity(json);

           // 6. set httpPost Entity
           httpPost.setEntity(se);

           // 7. Set some headers to inform server about the type of the content
           httpPost.setHeader("Accept", "application/json");
           httpPost.setHeader("Content-type", "application/json");


           // 8. Execute POST request to the given URL
           HttpResponse httpResponse = httpclient.execute(httpPost);

           // 9. receive response as inputStream
           inputStream = httpResponse.getEntity().getContent();

           BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           
           //retrieves string from json response
           while ((result = reader.readLine()) != null) {
               builder.append(result);
           }
           //System.out.print(builder.toString());
           string2rev = builder.toString();
           int begin = string2rev.indexOf(':');
           int end = string2rev.indexOf('}');
           string2rev = string2rev.substring(begin+2, end-1);
           //System.out.print(string2rev);
           
           
       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception ex) {
         ex.printStackTrace();
       }
        return string2rev;
	}
	
	public static void validatestring(String token, String reverse)
	{
		InputStream inputStream = null;
        String result;
        StringBuilder builder = new StringBuilder();
        String valid = "";
        try 
        {    
          // 1. create HttpClient
           HttpClient httpclient = new DefaultHttpClient();

           // 2. make POST request to the given URL
           HttpPost httpPost = new HttpPost("http://challenge.code2040.org/api/validatestring");

           String json = "";

           // 3. build jsonObject
           JSONObject jsonObject = new JSONObject();
           jsonObject.accumulate("token", token);
           jsonObject.accumulate("string", reverse);

           // 4. convert JSONObject to JSON to String
           json = jsonObject.toString();

           // ** Alternative way to convert Person object to JSON string usin Jackson Lib
           // ObjectMapper mapper = new ObjectMapper();
           // json = mapper.writeValueAsString(person);

           // 5. set json to StringEntity
           StringEntity se = new StringEntity(json);

           // 6. set httpPost Entity
           httpPost.setEntity(se);

           // 7. Set some headers to inform server about the type of the content
           httpPost.setHeader("Accept", "application/json");
           httpPost.setHeader("Content-type", "application/json");


           // 8. Execute POST request to the given URL
           HttpResponse httpResponse = httpclient.execute(httpPost);

           // 9. receive response as inputStream
           inputStream = httpResponse.getEntity().getContent();

           BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           
           //retrieves string from json response
           while ((result = reader.readLine()) != null) {
               builder.append(result);
           }
           //System.out.print(builder.toString());
           valid = builder.toString();
           //System.out.print(valid);

       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception ex) {
         ex.printStackTrace();
       }
        
	}
	public static JSONObject haystack(String token)
	{
		InputStream inputStream = null;
        String result;
        StringBuilder builder = new StringBuilder();
        String dictionary = "";
        JSONObject dict = new JSONObject();
        try 
        {    
          // 1. create HttpClient
           HttpClient httpclient = new DefaultHttpClient();

           // 2. make POST request to the given URL
           HttpPost httpPost = new HttpPost("http://challenge.code2040.org/api/haystack");

           String json = "";

           // 3. build jsonObject
           JSONObject jsonObject = new JSONObject();
           jsonObject.accumulate("token", token);


           // 4. convert JSONObject to JSON to String
           json = jsonObject.toString();

           // ** Alternative way to convert Person object to JSON string usin Jackson Lib
           // ObjectMapper mapper = new ObjectMapper();
           // json = mapper.writeValueAsString(person);

           // 5. set json to StringEntity
           StringEntity se = new StringEntity(json);

           // 6. set httpPost Entity
           httpPost.setEntity(se);

           // 7. Set some headers to inform server about the type of the content
           httpPost.setHeader("Accept", "application/json");
           httpPost.setHeader("Content-type", "application/json");


           // 8. Execute POST request to the given URL
           HttpResponse httpResponse = httpclient.execute(httpPost);

           // 9. receive response as inputStream
           inputStream = httpResponse.getEntity().getContent();

           BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           
           //retrieves string from json response
           while ((result = reader.readLine()) != null) {
               builder.append(result);
           }
           //System.out.print(builder.toString());
           dictionary = builder.toString();
           int i = dictionary.indexOf(':');
           dictionary = dictionary.substring(i+1, dictionary.length()-1);
           //System.out.print(dictionary);
         
           dict = new JSONObject(dictionary);
           
       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception ex) {
         ex.printStackTrace();
       }
        return dict;
	}

	public static void main(String[] args) {
		
		//part0:Registration
        String token = getToken();
        
        
        //partI: reverse a string
        String string2rev = getstring(token);
        //System.out.print(string2rev);
        
        String rev = "";
        for(int i = string2rev.length()-1; i > -1; i--)
        {
        	rev = rev + string2rev.charAt(i);
        }
        //System.out.print("\n" + rev);
        
        validatestring(token, rev);
        
        //partII: needle in a haystack
        JSONObject dictionary = haystack(token);
        //retrieve array and needle find needle in array.
        System.out.print(dictionary.toString());
          
	}

}
