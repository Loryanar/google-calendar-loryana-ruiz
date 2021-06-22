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

import org.json.JSONObject;

import Controllers.UserManager;
import Helpers.Queries;



/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		String res = UserManager.showCookie(request);
		out.println(res);
	}
protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int res = UserManager.showc(request);
		int data=res;
		PrintWriter out = response.getWriter();
		JSONObject mensaje = new JSONObject();
		Queries db = new Queries();
		System.out.println("La data es: "+ data);
		
		try {
			System.out.println(data);
			if(db.EliminarUsuario(data)) {
				mensaje.put("status", 200).put("response", "Fue borrado el usuario");
				System.out.println("Ya se borro el Usuario");
			}else {
				mensaje.put("status", 409).put("response", "No fue borrado el usuario");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResources();
		}
		out.println(mensaje.toString());	
	}
protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	JSONObject mensaje = new JSONObject();
	JSONObject data = new JSONObject(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
	Queries db = new Queries();
	
	System.out.println("La data es: "+ data);
	
	try {
		boolean correo = db.VerificarCorreo(data.getString("email"));
		if(!correo) {
			if(db.ActualizarUsuario(data)) {
				mensaje.put("status", 200).put("response", "Se actualizo el usuario");
				System.out.println("Todo bien se actualizo el usuario");
			}else {
				mensaje.put("status", 500).put("response", "No se puedo actualizar el usuario");
				System.out.println("No se actualizo el usuario");
			}
		}else {
			mensaje.put("status", 409).put("response", "El correo ya existe");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		db.closeResources();
	}
	
	
	out.print(mensaje.toString());
	}

}
