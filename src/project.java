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
import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.json.JSONArray;
import org.json.JSONException;
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

	public static void validateneedle(String token, int needle)
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
           HttpPost httpPost = new HttpPost("http://challenge.code2040.org/api/validateneedle");

           String json = "";

           // 3. build jsonObject
           JSONObject jsonObject = new JSONObject();
           jsonObject.accumulate("token", token);
           jsonObject.accumulate("needle", needle);

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
	
	public static JSONObject getPrefix(String token)
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
           HttpPost httpPost = new HttpPost("http://challenge.code2040.org/api/prefix");

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
	
	public static void validateprefix(String token, String[] array)
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
           HttpPost httpPost = new HttpPost("http://challenge.code2040.org/api/validateprefix");

           String json = "";

           // 3. build jsonObject
           JSONObject jsonObject = new JSONObject();
           jsonObject.accumulate("token", token);
           jsonObject.accumulate("array", array);

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
	
	public static JSONObject getTime(String token)
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
           HttpPost httpPost = new HttpPost("http://challenge.code2040.org/api/time");

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
           System.out.print(dictionary);
         
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
	
	public static void main(String[] args) throws JSONException {
		
		//part0:Registration
        String token = getToken();
        
        //-------------------------------------------------------------
        
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
        
        //---------------------------------------------------
        
        //partII: needle in a haystack
        JSONObject dictionary = haystack(token);
        //retrieve array and needle find needle in array.
        
        String needle = dictionary.getString("needle");
        JSONArray hay = dictionary.getJSONArray("haystack");
        
        int location = -1;
        
        for(int j = 0; j < hay.length(); j++)
        {
        	if(needle.compareTo(hay.getString(j)) == 0)
        	{
        		location = j;
        	}
        }
        
        validateneedle(token, location);
        
        //---------------------------------------------------
        
        //partIII: prefixes
        JSONObject dict2 = getPrefix(token);
        
        String prefix = dict2.getString("prefix");
        JSONArray array = dict2.getJSONArray("array");
        JSONArray array2 = new JSONArray();
        String temp = "";

        for(int k = 0; k < array.length(); k++)
        {
        	temp = array.getString(k);
        	if(!temp.startsWith(prefix))
        	{
        		array2.put(temp);
        	}
        }
        String[] array3 = new String[array2.length()];
        for(int q = 0; q < array2.length(); q++)
        {
        	array3[q] = array2.getString(q);
        }
        
        validateprefix(token, array3);
        
        //----------------------------------------------------------------
        
        //PartIV: the dating game
        JSONObject dict4 = getTime(token);
        String datestamp = dict4.getString("datestamp");
        int interval = dict4.getInt("interval");
        
        int sec = interval%60;
        int min = (interval/60)%60;
        int hr = (interval/3600)%24;
        int day = (interval/86400)%365;
        int year = (interval/315360000);
        
        MutableDateTime datetime = new MutableDateTime(datestamp);
        datetime.addSeconds(sec);
        datetime.addMinutes(min);
        datetime.addHours(hr);
        datetime.addDays(day);
        datetime.addYears(year);
        
        System.out.print(year + "\n"+ day + "\n" + hr + "\n" + min + "\n" + sec);
        
        
        String newdate = datetime.toString(); 
        System.out.print("\n" + newdate);
        
        
	}

}
