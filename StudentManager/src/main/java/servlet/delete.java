package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import connector.DBConnector;
import connector.MySqlConnector;
import controller.StudentController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/delete.do")
public class delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBConnector connector = new MySqlConnector();
		StudentController controller = new StudentController(connector);
		resp.setContentType("text/html;charset=UTF-8");

	
		int id = Integer.parseInt(req.getParameter("id"));
		PrintWriter out = resp.getWriter();
		controller.delete(id);
		
		out.println("<HTML>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		resp.sendRedirect("/student/list.do");
		out.println("<h1>까꿍</h1>");
		out.println("</body>");
		out.println("</HTML>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
	

}
