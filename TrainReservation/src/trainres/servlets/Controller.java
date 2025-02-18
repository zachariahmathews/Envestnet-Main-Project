package trainres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trainres.handlers.CheckAvailHandler;
import trainres.handlers.JourneyHandler;
import trainres.handlers.PassengerHandler;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException {
		
		String handlerName=request.getParameter("handler");
		
		if("passenger.jsp".equals(handlerName)){
			
			PassengerHandler ph=new PassengerHandler(request);
			ph.storePassenger();
			requestForward(request, response, "journey.jsp");
		}
		else if("journey.jsp".equals(handlerName)){
			
			JourneyHandler jh=new JourneyHandler(request);
			jh.storeJourney();
			CheckAvailHandler ch=new CheckAvailHandler(request);
			if(ch.update())
				request.getSession().setAttribute("available", true);
			requestForward(request, response, "available.jsp");
		}
	}
	private void requestForward(HttpServletRequest request, HttpServletResponse response,String dest) throws IOException, ServletException {
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/pages/"+dest);
		rd.forward(request, response);
	}

}
