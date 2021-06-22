package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Controllers.Cook;
import Controllers.UserManager;
import Helpers.Queries;



/**
 * Servlet implementation class Log
 */
@WebServlet("/Log")
public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		JSONObject mensaje = new JSONObject();
		JSONObject data = new JSONObject(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		UserManager us= new UserManager();
		
		Queries db = new Queries();
		JSONObject userData = new JSONObject();
		HttpSession sesion = request.getSession();
		
		System.out.println("comenzamos");
		if(sesion.isNew()) {
			
			try {
				Cook c= new Cook();
				c.CrearC(data,response);
				 
			
			}catch( Exception e){
				
			}
			
			try {
				System.out.println("Obteniendo datos");
				userData = db.ObtenerDatos(data);
				
				if(userData.length() > 0) {
					storeValue(sesion, userData);
					mensaje.put("status", 200).put("userData", userData);
					System.out.println("Todo realizado con exito");
				}else {
					mensaje.put("status", 409).put("response", "Invalid email or password");
					sesion.invalidate();
				}
			}catch( SQLException e) {
				e.printStackTrace();
				sesion.invalidate();
			} finally {
				db.closeResources();
			}
		} 
		out.println(mensaje.toString());
		
	}
	
	private void storeValue(HttpSession session, JSONObject value) {
		if(value ==null) {
			session.setAttribute("session", value);
		}
		else {
			session.setAttribute("session", value);
		}
	}
	

}
