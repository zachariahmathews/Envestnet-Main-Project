package com.envestnet.doit.handlers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import com.envestnet.doit.beans.Task;
import com.envestnet.doit.services.AddService;
import com.envestnet.doit.services.impl.AddServiceImpl;

public class AddHandler {

	HttpServletRequest request;

	public AddHandler(HttpServletRequest request) {
		
		this.request = request;
	}

	public Task update() {
		
		Task task=new Task();
		task.setUserid(""+request.getSession().getAttribute("userid"));
		task.setPriority(Integer.parseInt(request.getParameter("priority")));
		task.setCategory(request.getParameter("category"));
		task.setTask(request.getParameter("task"));
		String[] date=request.getParameter("taskdate").split("-");
		task.setDone('n');
		task.setTaskdatetime(LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]),Integer.parseInt(request.getParameter("hour")), Integer.parseInt(request.getParameter("minute"))));
		if(request.getParameter("meridian").equals("PM")){
			task.setTaskdatetime(task.getTaskdatetime().plusHours(12));
		}
		
		AddService us=new AddServiceImpl();
		us.update(task);
		return task;
		
	}
	
}
