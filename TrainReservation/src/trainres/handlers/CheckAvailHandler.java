package trainres.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import trainres.beans.JourneyBean;
import trainres.beans.PassengerBean;
import trainres.services.CheckAvailService;
import trainres.services.impl.CheckAvailServiceImpl;

public class CheckAvailHandler {

	HttpServletRequest request;
	
	public CheckAvailHandler(HttpServletRequest request) {
		
		this.request = request;
	}

	public boolean update(){
		
		HttpSession session=request.getSession();
		PassengerBean pb=(PassengerBean) session.getAttribute("passenger");
		JourneyBean jb=(JourneyBean) session.getAttribute("journey");
		CheckAvailService ps=new CheckAvailServiceImpl();
		return ps.update(pb, jb);
	}
}
