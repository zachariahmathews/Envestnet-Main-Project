package mvcdemo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcdemo.handlers.BookListHandler;
import mvcdemo.handlers.LoginHandler;
import mvcdemo.handlers.LogoutHandler;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			processRequest(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			processRequest(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	private void processRequest(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		String handlerName=request.getParameter("handler");
		
		if("login.jsp".equals(handlerName)){
			
			requestForward(request,response,"login.jsp");
		}
		else if("validateLogin".equals(handlerName)){
			
			LoginHandler lh=new LoginHandler(request);
			if(lh.validate()==null){
				
				requestForward(request,response,"login.jsp");
			}
			else{
				
				requestForward(request,response,"home.jsp");
			}
		}
		else if("listBooks".equals(handlerName)){
			
			BookListHandler bh=new BookListHandler();
			request.setAttribute("bookList", bh.getBookList());
			requestForward(request, response, "book_list.jsp");
			
		}
		else if("logout.jsp".equals(handlerName)){
			
			LogoutHandler lh=new LogoutHandler(request);
			lh.updateDB();
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
	}
	private void requestForward(HttpServletRequest request, HttpServletResponse response,String dest) throws IOException, ServletException {
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/pages/"+dest);
		rd.forward(request, response);
	}
}
