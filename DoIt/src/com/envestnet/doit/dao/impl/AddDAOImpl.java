package com.envestnet.doit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.envestnet.doit.dao.AddDAO;
import com.envestnet.doit.dao.beans.TaskBean;
import com.envestnet.doit.db.SQLConnUtil;

public class AddDAOImpl implements AddDAO {

	@Override
	public void update(TaskBean t) {

		SQLConnUtil sql=SQLConnUtil.getInstance();
		Connection conn=sql.openConnection();

		try {
			
			PreparedStatement ps=conn.prepareStatement("insert into TASK(userid,category,task,taskdate,tasktime,priority,taskgroup,done) values(?,?,?,?,?,?,?,'n')");
			ps.setString(1, t.getUserid());
			ps.setString(2, t.getCategory());
			ps.setString(3, t.getTask());
			ps.setString(4, t.getTaskdate().toString());
			ps.setString(5, t.getTasktime().toString());
			ps.setInt(6, t.getPriority());
			ps.setInt(7, t.getTaskgroup());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			sql.closeConnection();
		}
	}

}
