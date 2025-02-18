package com.envestnet.doit.dto.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.envestnet.doit.beans.Task;
import com.envestnet.doit.dao.beans.TaskBean;
import com.envestnet.doit.dto.ReadDTO;

public class ReadDTOImpl implements ReadDTO {

	@Override
	public List<Task> convertFrom(List<TaskBean> taskbeans) {
		
		List<Task> tasks=new ArrayList<Task>();
		for(TaskBean taskbean:taskbeans){
			
			Task task=new Task();
			task.setTaskid(taskbean.getTaskid());
			task.setCategory(taskbean.getCategory());
			task.setPriority(taskbean.getPriority());
			task.setTask(taskbean.getTask());
			task.setTaskdatetime(LocalDateTime.of(taskbean.getTaskdate(), taskbean.getTasktime()));
			task.setTaskgroup(taskbean.getTaskgroup());
			task.setUserid(taskbean.getUserid());
			task.setDone(taskbean.getDone());
			tasks.add(task);
		}
		return tasks;
	}

}
