package testpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/two")
public class Servlet2 extends HttpServlet {
	
       

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
		Integer temp = (Integer) request.getSession().getAttribute("temp");
		String choice= (String)request.getSession().getAttribute("choice");
		
		if(temp == null) {
			// invalid user, send to login page with the error message
			response.sendRedirect("Servlet1?msg=Please insert a value");
		}
		else{
			double result = (temp-32) * 5.0/9.0;
			request.getSession().setAttribute("temp",temp);
			request.getSession().setAttribute("choice", choice);
			request.getSession().setAttribute("result", result);
			response.sendRedirect("Servlet3");	
		}
	}

}
