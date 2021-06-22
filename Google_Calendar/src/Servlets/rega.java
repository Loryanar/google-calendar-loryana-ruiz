package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONObject;

import Controllers.UserManager;
import Helpers.Queries;



/**
 * Servlet implementation class rega
 */
@WebServlet("/rega")
public class rega extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rega() {
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
		Queries db = new Queries();
		UserManager us= new UserManager();
		String id=data.getString("idc");
		System.out.println(data);
		try {
			System.out.println("comenzamos");
				if(!db.VerificarId(data.getInt("idc"))) {
					System.out.println("email correcto");
					boolean status = db.RegistrarC(data);
					if (status) {
						mensaje.put("status", 200).put("response", "El CALENDARIO fue creado");
						System.out.println("El usuario  fue creado");
					}else {
						mensaje.put("status", 409).put("response", "El usuario no fue creado");
						System.out.println("El usuario no fue creado");
					}
				}else {
					
					mensaje.put("status", 405).put("response", "este correo ya existe");
				}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResources(); 
		}
		out.println(mensaje.toString());
		
	}

}

	


