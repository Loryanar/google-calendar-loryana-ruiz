package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class BDConexion extends LeerProperties{
	public PreparedStatement stmt;
	public Connection con;
	public ResultSet rs;
	public Properties leer= new LeerProperties().getFile("C:\\Users\\DELL\\web22\\Google_Calendar\\WebContent\\query.properties");
	
	public BDConexion(){
		  try{
			this.con = null;		
		    Class.forName ("org.postgresql.Driver");
		    this.con = DriverManager.getConnection("jdbc:postgresql://ec2-23-23-128-222.compute-1.amazonaws.com:5432/d7qnbefthrjlcv", "apohtjhfajodsn", "8434bc7e57d4f76fb5c0c3a0f893063aee359c1a413001bd73e4d8a13e4e0ba4");
		    //this.con = DriverManager.getConnection (leer.getProperty("url"), leer.getProperty("user"), leer.getProperty("password"));   
		  } 
		  catch (Exception e) {
			e.printStackTrace ();
		  }	
	}
	public ResultSet executeStatement(String query,Object...value) throws SQLException{
		
			this.stmt = this.con.prepareStatement(leer.getProperty(query));
			for(int i=0; i < value.length; i++ )
				this.stmt.setObject(i + 1, value[i]);
			
			return this.stmt.executeQuery();			
	}
	
	
	public int executeUpdate(String query,Object...value) throws SQLException{
		this.stmt = this.con.prepareStatement(leer.getProperty(query));
		for(int i=0; i < value.length; i++ )
		this.stmt.setObject(i + 1, value[i]);
		
		return this.stmt.executeUpdate();
	}
	
	public int excuteDelete(String query, int id) throws SQLException{
		this.stmt = this.con.prepareStatement(leer.getProperty(query));
		this.stmt.setInt(0, id);
		System.out.println("id usuario en executeDelete:"+id);
		System.out.println("query delete--"+query);
		return this.stmt.executeUpdate();
	}
	
	
	protected void closeMainResource() throws SQLException {
		if(this.stmt != null) 
			this.stmt.close();
	}
	
	public void dbPrepareStatement(Object value) {
		// TODO Auto-generated method stub
		
	}
	public static BDConexion getIntsnaces() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
