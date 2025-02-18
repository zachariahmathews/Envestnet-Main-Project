package com.envestnet.doit.handlers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import com.envestnet.doit.beans.Task;
import com.envestnet.doit.services.EditService;
import com.envestnet.doit.services.impl.EditServiceImpl;

public class EditHandler {

	private HttpServletRequest request;

	public EditHandler(HttpServletRequest request) {
		
		this.request = request;
	}

	public List<Task> edit(List<Task> tasks) {
		
		int i=0;
		Task task=new Task();
		task.setTaskid(Integer.parseInt(request.getParameter("taskid")));
		task.setUserid(""+request.getSession().getAttribute("userid"));
		task.setPriority(Integer.parseInt(request.getParameter("priority")));
		task.setCategory(request.getParameter("category"));
		task.setTask(request.getParameter("task"));
		String[] date=request.getParameter("taskdate").split("-");
		task.setTaskdatetime(LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]),Integer.parseInt(request.getParameter("hour")), Integer.parseInt(request.getParameter("minute"))));
		if(request.getParameter("meridian").equals("PM")){
			task.setTaskdatetime(task.getTaskdatetime().plusHours(12));
		}
		ListIterator<Task> iterator = tasks.listIterator();
		while(iterator.hasNext()) {
    	    Task temp=iterator.next();
			if(temp.getTaskid()==task.getTaskid()){
				temp.setCategory(task.getCategory());
				temp.setTask(task.getTask());
				temp.setPriority(task.getPriority());
				temp.setTaskdatetime(task.getTaskdatetime());
				temp.setTaskid(task.getTaskid());
				temp.setUserid(task.getUserid());
			}
    	    iterator.set(temp);    // Change the element the iterator is currently at
    	} 
		
		EditService es=new EditServiceImpl();
		es.edit(task);
		
		return tasks;
		
	}
	
}
