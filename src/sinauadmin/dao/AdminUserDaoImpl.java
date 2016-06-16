package sinauadmin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import sinauadmin.model.AdminUser;

public class AdminUserDaoImpl implements AdminUserDao {
	private Connection connection;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement getByIdStatement;
	private PreparedStatement getAllStatement;

	private final String INSERT_QUERY = "insert into adm_user(user_id,email,name,phone,user_address,other_school)values(?,?,?,?,?,?)";
	private final String UPDATE_QUERY = "update adm_user set name=?, email=?, phone=?,user_address=?,other_school=? where user_id=?";
	private final String DELETE_QUERY = "delete from adm_user where user_id=?";
	private final String GET_BY_ID_QUERY = "select user_id,email,name,phone,user_address,other_school from adm_user where user_id=?";
	private final String GET_ALL_QUERY = "select user_id,email,name,phone,user_address,other_school from adm_user";

	public void setConnection(Connection connection) throws SQLException{
		this.connection = connection;
		insertStatement = (PreparedStatement) this.connection.prepareStatement(INSERT_QUERY);
		updateStatement = (PreparedStatement) this.connection.prepareStatement(UPDATE_QUERY);
		deleteStatement = (PreparedStatement) this.connection.prepareStatement(DELETE_QUERY);
		getByIdStatement = (PreparedStatement) this.connection.prepareStatement(GET_BY_ID_QUERY);
		getAllStatement = (PreparedStatement) this.connection.prepareStatement(GET_ALL_QUERY);
	}

	@Override
	public AdminUser saveOrUpdate(AdminUser adminUser, boolean isUpdate) throws SQLException {
		// TODO Auto-generated method stub
		if (!isUpdate){
			insertStatement.setString(1, adminUser.getUserId());;
			insertStatement.setString(2, adminUser.getName());
			insertStatement.setString(3, adminUser.getEmail());
			insertStatement.setString(4, adminUser.getPhone());
			insertStatement.setString(5, adminUser.getUserAddress());
			insertStatement.setString(6, adminUser.getOtherSchool());
			insertStatement.executeUpdate();
		} else {
			updateStatement.setString(1, adminUser.getName());
			updateStatement.setString(2, adminUser.getEmail());
			updateStatement.setString(3, adminUser.getPhone());
			updateStatement.setString(4, adminUser.getUserAddress());
			updateStatement.setString(5, adminUser.getOtherSchool());
			updateStatement.setString(6, adminUser.getUserId());
			updateStatement.executeUpdate();
		}
		return adminUser;
	}

	@Override
	public AdminUser delete(String userId) throws SQLException {
		// TODO Auto-generated method stub
		deleteStatement.setString(1, userId);
		deleteStatement.executeUpdate();
		return null;
	}

	@Override
	public AdminUser getById(String userId) throws SQLException {
		// TODO Auto-generated method stub
		getByIdStatement.setString(1, userId);
		ResultSet rs = getByIdStatement.executeQuery();

		if (rs.next()){
			AdminUser adminUser = new AdminUser();
			adminUser.setUserId(rs.getString("user_id"));
			adminUser.setEmail(rs.getString("email"));
			adminUser.setName(rs.getString("name"));
			adminUser.setPhone(rs.getString("phone"));
			adminUser.setUserAddress(rs.getString("user_address"));
			adminUser.setOtherSchool(rs.getString("other_school"));

			return adminUser;
		}
		return null;
	}

	@Override
	public List<AdminUser> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<AdminUser> adminUser = new ArrayList<AdminUser>();
		ResultSet rs = getAllStatement.executeQuery();
		while (rs.next()){
			AdminUser a = new AdminUser();
			a.setUserId(rs.getString("user_id"));
			a.setEmail(rs.getString("email"));
			a.setName(rs.getString("name"));
			a.setPhone(rs.getString("phone"));
			a.setUserAddress(rs.getString("user_address"));
			a.setOtherSchool(rs.getString("other_school"));

			adminUser.add(a);
		}

		return adminUser;
	}

}
