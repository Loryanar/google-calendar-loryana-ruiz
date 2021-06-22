package Controllers;
import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.JSONObject;

import Helpers.Queries;



public class UserManager {
	private static ArchivoManager am = new ArchivoManager();
	private static Queries db = new Queries();
	 public static String showCookie(HttpServletRequest request) {
	    	
	    	Cookie cookies[] = request.getCookies();
	    	String id = "";
	    	String idc = "";
	    	String name = "";
	    	String lastname = "";
	    	String email = "";
	    	
	    	
	    	for(Cookie c : cookies) {
	    		if(c.getName().equals("id")) {
	    			id = c.getValue();
	    		}
	    		
	    		if(c.getName().equals("nombre")) {
	    			name = c.getValue();
	    		}
	    		
	    		if(c.getName().equals("apellido")) {
	    			lastname = c.getValue();
	    		}
	    		
	    		
	    		
	    		if(c.getName().equals("correo")) {
	    			email = c.getValue();
	    		}
	    		if(c.getName().equals("idc")) {
	    			idc = c.getValue();
	    		}
	    	
	    		
	    		
	    	}
	    	
	    	
	    	
	    	String data = "{\"id\":\""  +  id +  "\", \"name\": \"" 
	    	+name+ "\", \"lastname\": \"" + lastname +"\", \"idc\": \"" + idc +   "\", \"correo\": \"" 
	    	    	+email+  "\"}";

	    	return data;
	    }
	 public static int showc(HttpServletRequest request) {
		 Cookie cookies[] = request.getCookies();
	    	String id1 = "";
	    	for(Cookie c : cookies) {
	    		if(c.getName().equals("id")) {
	    			id1 = c.getValue();
	    		} 
	    		
	    	
		 
	 }
	    	int id=Integer.parseInt(id1);
	    		return id;
	 
}
	 public static String showU(HttpServletRequest request) {
		 Cookie cookies[] = request.getCookies();
	    	String us1 = "";
	    	for(Cookie c : cookies) {
	    		if(c.getName().equals("email")) {
	    			us1 = c.getValue();
	    		} 
	    		
	    	
		 
	 }String p=us1;
	    		return p;
	 
}
	public void crearcu(String filee, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
    

