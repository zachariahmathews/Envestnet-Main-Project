package mvcdemo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvcdemo.bean.User;
import mvcdemo.dao.LoginDAO;
import mvcdemo.db.SQLConnUtil;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public User login(String userId, String password) throws SQLException {
		
		SQLConnUtil sqlconn=SQLConnUtil.getInstance();
		Connection conn=sqlconn.openConnection();
		String sql="select * from USER_LOGIN where USER_ID=? and USER_PASSWORD=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, userId);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		User u=null;
		if(rs.next()){
			u=new User();
			u.setUserId(rs.getString("USER_ID"));
		}
		rs.close();
		ps.close();
		sqlconn.closeConnection();
		return u;
	}
}
