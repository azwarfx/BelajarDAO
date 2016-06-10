package sinauadmin.dao;

import java.sql.SQLException;
import java.util.List;

import sinauadmin.model.AdminUser;

public interface AdminUserDao {
	public AdminUser saveOrUpdate(AdminUser adminUser, boolean isUpdate) throws SQLException;
	public AdminUser delete(String userId) throws SQLException;
	public AdminUser getById(String userId) throws SQLException;
	public List<AdminUser> getAll() throws SQLException;
}
