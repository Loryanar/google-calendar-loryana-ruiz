package Controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONObject;

import Helpers.LeerProperties;



public class ArchivoManager {
	private static UserManager um = new UserManager();
	private static LeerProperties pr = new LeerProperties();
	
	
	//Crear Foto de perfil
    
    
    	public boolean createFdp(JSONObject data, Part part) {
        	boolean result = false;
        	
        	try {
    			
        		InputStream fileIn;
        		OutputStream fileOut;
        		
        		//Path donde se crearan las carpetas
    			File newFolder = new File(pr.getFile("path") + data.getString("cedula"));
    			
        		if(newFolder.mkdirs()) {
        			System.out.println("Carpetas del usuario con la cedula " + data.getString("cedula") + " creadas correctamente");
        		}else {
        			System.out.println("Las carpetas ya han sido creadas");
        		}
        		
        		//Se crea el archivo vacio dentro de la carpeta del usuario
        		fileOut = new FileOutputStream(new File(newFolder.getAbsolutePath() + "/" + part.getName()));
        		System.out.println("Archivo Creado");
        		
        		fileIn = part.getInputStream();
        		
        		 	//Se llena el archivo vacio
        			int a = 0;
        	        final byte[] bytes = new byte[1024];
        	        try{
        	            while ((a = fileIn.read(bytes)) != -1) {
        	                fileOut.write(bytes, 0, a);
        	            }
        	            System.out.println("Archivo actualizado");
        	            fileOut.close();
        	            fileIn.close();
        	            
        	            result = true;
        	        }catch(Exception e){
        	            System.out.println(e);
        	            result = false;
        	        }
        		  		
    		} catch (Exception e) {
    			result = false;
    			System.out.println("Error en la creacion del archivo");
    		}
        	
        	return result;
        	
        	
        }
  
    
}


