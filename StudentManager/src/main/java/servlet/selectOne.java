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
import model.StudentDTO;

@WebServlet("/student/selectOne.do")
public class selectOne extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBConnector connector = new MySqlConnector();
		StudentController controller = new StudentController(connector);
		StudentDTO s = new StudentDTO();
		
		int id = Integer.parseInt(req.getParameter("id"));
	
		s = controller.selectOne(id);
		resp.setContentType("text/html;charset=UTF-8");

		
		PrintWriter out = resp.getWriter();
		
		out.println("이름 :" + s.getName());
		out.println("국어점수 : " + s.getKorean());
		out.println("영어점수 : " + s.getEnglish());
		out.println("수학점수 :" + s.getMath());
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	

	

}
