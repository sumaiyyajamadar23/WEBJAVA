package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdaoimp;
import pojos.User;
@WebServlet(value = "/login", loadOnStartup = 1)
public class LoginServ extends HttpServlet 
{
private Userdaoimp dao;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
resp.setContentType("text/html");
try(PrintWriter pw=resp.getWriter())
{
	String email=req.getParameter("nm");
	String passwd=req.getParameter("pass");
    User use=dao.authenticate(email, passwd);	
    if(use==null)
    {
    	pw.print("<h4> Invalid Email or Password , Please <a href='login.html'>Retry</a></h4>");
    	pw.print("<h4> Something wrong register again , Please <a href='register.html'>Retry</a></h4>");
    }
    else
    {
    	Cookie c=new Cookie("user_dtls",use.toString());
        resp.addCookie(c);
        pw.print("<h4> Validated User details " + use + "</h4>");
        if (use.getRole().equals("admin")) {
	    resp.sendRedirect("admin_page");
    } 
        else 
      if (use.isVotingStatus())
      {
	    resp.sendRedirect("logout");
   }
      else 
   {
	resp.sendRedirect("candidate_list");
    }
}
}
catch(Exception p)
{
	throw new ServletException("Erroe in do get"+getClass()+""+p);
}
}

@Override
public void destroy() {
	try {
		dao.cleanUp();
	} catch (SQLException e) {
		System.out.println("login destroy in:"+getClass()+" "+e);
	}
}

@Override
public void init() throws ServletException {	

try 
{
dao=new Userdaoimp();
}
catch(Exception e)
{
	throw new ServletException("err in init of " + getClass(), e);
}

}

}
