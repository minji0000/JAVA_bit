package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import connector.DBConnector;
import connector.MySqlConnector;
import controller.StudentController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDTO;

@WebServlet("/student/update.do")
public class update extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBConnector connector = new MySqlConnector();
		StudentController controller = new StudentController(connector);
		
	
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDTO s = controller.selectOne(id);
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println();
		out.println("<HTML>");
		out.println("<head>");
		out.println("</head>");
		
		out.println("<form method = \"post\" action = \"/student/update.do\">");
		
		out.println(" <input type = \"hidden\" name=\"id\" value = \""+id+"\">");
		out.println("<br />");
		out.println("이름 <input type = \"text\" name=\"name\">");
		out.println("<br />");
		out.println("국어점수 <input type = \"text\" name=\"korean\">");
		out.println("<br />");
		out.println("영어점수 <input type = \"text\" name=\"english\">");
		out.println("<br />");
		out.println("수학점수 <input type = \"text\" name=\"math\">");
		out.println("<br />");
		out.println("<button type = \"submit\"> 수정하기 </button>");
		out.println("</form>");
		out.println();
		
		out.println("<body>");
		out.println("</body>");
		out.println("</HTML>");
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DBConnector connector = new MySqlConnector();
		StudentController controller = new StudentController(connector);
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDTO s = controller.selectOne(id);
		String name = req.getParameter("name");
		int korean =  Integer.parseInt(req.getParameter("korean"));
		int english =  Integer.parseInt(req.getParameter("english"));
		int math =  Integer.parseInt(req.getParameter("math"));
		sdf.format(s.getEntryDate().getTime());
		
		s.setName(name);
		s.setKorean(korean);
		s.setEnglish(english);
		s.setMath(math); 
		s.setId(id);
		
		controller.update(s);
		
		resp.sendRedirect("/student/list.do");
		
	}
	
	
}
