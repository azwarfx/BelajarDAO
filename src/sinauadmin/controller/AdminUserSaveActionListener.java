package sinauadmin.controller;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinauadmin.config.DatabaseDataSource;
import sinauadmin.model.AdminUser;
import sinauadmin.service.AdminUserService;
import sinauadmin.view.AdminUserGui;

public class AdminUserSaveActionListener implements ActionListener{
	private AdminUserGui frame;

	public AdminUserSaveActionListener(AdminUserGui frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DatabaseDataSource mysqlDataSource = new DatabaseDataSource();
		AdminUserService adminUserService = new AdminUserService();
		adminUserService.setDataSource(mysqlDataSource.getMysqlDataSource());

		boolean isUpdate;
		if("".equals(this.frame.getTxtCari().getText())){
			isUpdate = false;
		} else {
			isUpdate = true;
		}

		AdminUser a = new AdminUser();
		a.setUserId(frame.getTxtUserId().getText());
		a.setName(frame.getTxtName().getText());
		a.setEmail(frame.getTxtEmail().getText());
		a.setPhone(frame.getTxtPhone().getText());
		a.setUserAddress(frame.getTxtUserAddress().getText());
		a.setOtherSchool(frame.getTxtOtherSchool().getText());

		adminUserService.saveOrUpdate(a, isUpdate);

		if(isUpdate == false){
			JOptionPane.showMessageDialog(frame, "Data ditambah");
		} else {
			JOptionPane.showMessageDialog(frame, "Data diubah");
		}

	}

}