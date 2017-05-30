package testpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/one")
public class Servlet1 extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String msg = "";
		if(request.getParameter("msg") != null) msg = request.getParameter("msg");
		
		out.println(OurUtils.getHtmlHeader("Temparature Conversion"));
		out.println("<h1>Formula Calculation</h1>");
		out.println("<h3 style=\"color:red;\">"+msg+"</h3>");
		out.println("<form method=post>");
		out.println("Value: <input type=text name=temp value=98.6><br>");
		out.println("F: <input type=radio name=choice value=fahrenheit checked=checked><br>");
		out.println("C: <input type=radio name=choice value=celsius><br>");
		out.println("<input type=submit value=Send>");
		out.println("</form>");
		out.println(OurUtils.getHtmlFooter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double value = Double.parseDouble(request.getParameter("temp"));
		String temp = request.getParameter("choice");
		
		boolean data = OurUtils.validateTextInput("temp");
		
		if(data){
			request.getSession();
			response.sendRedirect("Servlet2");
		}
		else
		{
			response.sendRedirect("Servlet1?msg=Please enter a value");
		}
		}
		
		
	
}
