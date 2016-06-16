package sinauadmin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import sinauadmin.dao.AdminUserDao;
import sinauadmin.dao.AdminUserDaoImpl;
import sinauadmin.model.AdminUser;

public class AdminUserService {
	private AdminUserDao adminUserDao;
	private Connection connection;

	public AdminUserService() {

	}

	public void setDataSource(DataSource dataSource){
		try {
			connection = dataSource.getConnection();
			adminUserDao = new AdminUserDaoImpl();
			((AdminUserDaoImpl)adminUserDao).setConnection(connection);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}

	public AdminUser saveOrUpdate(AdminUser adminUser, boolean isUpdate){
		try{
			connection.setAutoCommit(false);
			adminUserDao.saveOrUpdate(adminUser, isUpdate);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException ex){
			try{
				connection.rollback();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return adminUser;
	}

	public AdminUser delete(String userId){
		try{
			connection.setAutoCommit(false);
			adminUserDao.delete(userId);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException ex){
			try{
				connection.rollback();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}

	public AdminUser getPerson(String userId){
		AdminUser adminUser = null;
		try{
			adminUser = adminUserDao.getById(userId);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return adminUser;
	}

	public List<AdminUser> getPersons(){
		try{
			return adminUserDao.getAll();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ArrayList<AdminUser>();
	}


}
