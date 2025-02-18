package com.envestnet.doit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.envestnet.doit.dao.EditDAO;
import com.envestnet.doit.dao.beans.TaskBean;
import com.envestnet.doit.db.SQLConnUtil;

public class EditDAOImpl implements EditDAO {

	@Override
	public void edit(TaskBean taskbean) {
		
		SQLConnUtil sql=SQLConnUtil.getInstance();
		Connection conn=sql.openConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("update TASK set task=?,priority=?,taskdate=?,tasktime=? where taskid=?");
			ps.setString(1, taskbean.getTask());
			ps.setInt(2, taskbean.getPriority());
			ps.setString(3, taskbean.getTaskdate().toString());
			ps.setString(4, taskbean.getTasktime().toString());
			ps.setInt(5, taskbean.getTaskid());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			sql.closeConnection();
		}
	}

}
