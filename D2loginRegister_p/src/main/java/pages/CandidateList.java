package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/candidate_list")

public class CandidateList extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		     response.setContentType("text/html");
		     try (PrintWriter pw = response.getWriter())
		     {
	
			Cookie[] cookies=request.getCookies();
			if(cookies != null)
			{
				for(Cookie c: cookies)
					if(c.getName().equals("user_dtls"))
				pw.print("<h5> validate usser detail"+c.getValue()+"<h5>");
			}
			else
			{
				pw.print("<h5>Failll no cookieeeee</h5>");
			}
			
		}
	}

}
