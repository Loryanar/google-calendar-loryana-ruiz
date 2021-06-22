package Controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Helpers.Encriptamiento;
import Helpers.Queries;

public class Cook {
	JSONObject mensaje = new JSONObject();
	Queries db = new Queries();
	JSONObject userData = new JSONObject();

public void CrearC(JSONObject data, HttpServletResponse response) {
	// TODO Auto-generated method stub
	try {
		
		
		userData = db.ObtenerDatos(data);
		System.out.println("Obteniendo cookie");
		System.out.println(userData);
		
	
		String email=data.getString("correo");
		Cookie cookie8= new Cookie("correo",email );
		cookie8.setMaxAge(60*60*24); 
		response.addCookie(cookie8);
	 
	
		String name=userData.getString("nameus");
		System.out.println(name);
		Cookie cookie2= new Cookie("nombre",name );
		cookie2.setMaxAge(60*60*24); 
		response.addCookie(cookie2);

		int id=userData.getInt("id_us");
		String ids= String.valueOf(id);
		System.out.println(id);
		Cookie cookie4= new Cookie("id",ids);
		cookie4.setMaxAge(60*60*24); 
		response.addCookie(cookie4);
		
		
		String lastname=userData.getString("lastnameus");
		System.out.println(lastname);
		Cookie cookie3= new Cookie("apellido",lastname );
		cookie3.setMaxAge(60*60*24); 
		response.addCookie(cookie3);
		
		
		
	
		
		
	
		
		
		
		
	
		 
		 
	
	}catch( Exception e){
		
	}
	
	
}
public void crearcu(JSONObject data, HttpServletResponse response) {
	
	try {
		
		
		userData = db.ObtenerDatos(data);
		System.out.println("Obteniendo cookie");
		System.out.println(userData);
		
	
		String email=data.getString("correo");
		Cookie cookie8= new Cookie("correo",email );
		cookie8.setMaxAge(60*60*24); 
		response.addCookie(cookie8);
	 
	
		String name=userData.getString("nameus");
		System.out.println(name);
		Cookie cookie2= new Cookie("nombre",name );
		cookie2.setMaxAge(60*60*24); 
		response.addCookie(cookie2);

		int id=userData.getInt("id_us");
		String ids= String.valueOf(id);
		System.out.println(id);
		Cookie cookie4= new Cookie("id",ids);
		cookie4.setMaxAge(60*60*24); 
		response.addCookie(cookie4);
		
		
		String lastname=userData.getString("lastnameus");
		System.out.println(lastname);
		Cookie cookie3= new Cookie("apellido",lastname );
		cookie3.setMaxAge(60*60*24); 
		response.addCookie(cookie3);
		
		
		
	
		
		
	
		
		
		
		
	
		 
		 
	
	}catch( Exception e){
		
	}
}
}