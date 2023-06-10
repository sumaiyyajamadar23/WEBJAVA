package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdaoimp;
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
