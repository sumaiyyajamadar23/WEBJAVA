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

@WebServlet("/register")
public class RegisterServ extends HttpServlet 
{
	private Userdaoimp dao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	resp.setContentType("text/html");
	try(PrintWriter pw=resp.getWriter())
	{
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String pass=req.getParameter("passw");
		String dob=req.getParameter("dob");
		
	    int use=dao.register(fname, lname, email, pass, dob);
	    if(use==1)
	    {
	    	//pw.print("<h4> Register successful, Please <a href='login.html'>Retry</a></h4>");
	    	pw.print("<h4>  Register successfully" + use + "</h4>");
	    	pw.print("<h4> Register successful, Please <a href='login.html'>Retry</a></h4>");
	    }
	    else
	    {
	 	    	pw.print("<h4> Something wrong register again , Please <a href='register.html'>Retry</a></h4>");
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
