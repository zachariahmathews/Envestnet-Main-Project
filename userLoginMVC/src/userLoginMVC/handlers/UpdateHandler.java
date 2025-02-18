package userLoginMVC.handlers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import userLoginMVC.beans.User;
import userLoginMVC.services.UpdateService;
import userLoginMVC.services.impl.UpdateServiceImpl;

public class UpdateHandler {

	HttpServletRequest request;

	public UpdateHandler(HttpServletRequest request) {
		
		this.request = request;
	}
	
	public void update(Set<User> users){
		
		User user=new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		if(users.add(user)){
			
			UpdateService us=new UpdateServiceImpl();
			us.update(user);
			request.getSession().setAttribute("updated", true);
		}
		else{
			request.getSession().setAttribute("updated", false);
		}
	}
}
