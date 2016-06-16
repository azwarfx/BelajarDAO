package sinauadmin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import sinauadmin.config.DatabaseDataSource;
import sinauadmin.service.AdminUserService;
import sinauadmin.view.AdminUserGui;

public class AdminUserDeleteActionListener implements ActionListener {

	private AdminUserGui frame;

	public AdminUserDeleteActionListener(AdminUserGui frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DatabaseDataSource mysqlDataSource = new DatabaseDataSource();
		AdminUserService adminUserService = new AdminUserService();
		adminUserService.setDataSource(mysqlDataSource.getMysqlDataSource());

		if(!frame.getTxtUserId().getText().trim().isEmpty()){
			adminUserService.delete(frame.getTxtUserId().getText());
			reset();
			JOptionPane.showMessageDialog(frame, "Data dihapus");
		}
	}

	public void reset(){
		frame.getTxtCari().setText("");
		frame.getTxtUserId().setText("");
		frame.getTxtName().setText("");
		frame.getTxtEmail().setText("");
		frame.getTxtPhone().setText("");
		frame.getTxtUserAddress().setText("");
		frame.getTxtOtherSchool().setText("");
	}

}
