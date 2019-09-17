package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import baen.Admin;
import utils.jdbc.JdbcUtil;

public class AdminDao {
	
	JdbcUtil jdbcUtil = new JdbcUtil();
	
	
	/**
	 * 根据账号查询管理员
	 * @return
	 */
	public Admin getAdmin(String adminName) {
		
		Admin admin = null;
		
		String sql = "select * from admin where admin_name=?";
		
		ResultSet rs = jdbcUtil.executeQuery(sql, adminName);
		
		try {
			if(rs.next()) {
				
				admin = new Admin();
				
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminName(rs.getString("admin_name"));
				admin.setAdminPwd(rs.getString("admin_pwd"));
				admin.setName(rs.getString("name"));
				admin.setSex(rs.getInt("sex"));
				admin.setAge(rs.getInt("age"));
				admin.setPhone(rs.getString("phone"));
				admin.setEmail(rs.getString("email"));
				admin.setIs_active(rs.getInt("is_active"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			jdbcUtil.close();
			
		}
		
		return admin;
	}
	
	
}