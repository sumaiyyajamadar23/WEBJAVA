package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/test1",loadOnStartup=1)//annotation nothing but internally interfaces
//Web container reads only once at web app deployment time
//Web container creates empty map(at web appp deployment time) & then populates url map
//key:/test1 value:pages.Servelet1
public class Servelet1 extends HttpServlet 
{

	@Override//created by container use by programmer
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get method:"+Thread.currentThread());
		//set response content type(setting Header:content type:text/html
		resp.setContentType("text/html");
		//get printwriter to send character,buffer data to client
		try(PrintWriter pw=resp.getWriter())
		{
			pw.print("<h2>Helloooo"+getClass()+"TS"+LocalDateTime.now()+"<h2>");
		}//wc:pw.flush()-->buffer content are sent in response packet-->pw.close()
	}

	@Override
	public void destroy() {
		System.out.println("in destroy method:"+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init method:"+Thread.currentThread());
	}

}
