package sinauadmin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import sinauadmin.config.DatabaseDataSource;
import sinauadmin.model.AdminUser;
import sinauadmin.service.AdminUserService;
import sinauadmin.view.AdminUserGui;

public class AdminUserCariActionListener implements ActionListener {
	private AdminUserGui frame;

	public AdminUserCariActionListener(AdminUserGui frame) {
		this.frame = frame;
		mainComponent();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DatabaseDataSource mysqlDataSource = new DatabaseDataSource();
		AdminUserService adminUserService = new AdminUserService();
		adminUserService.setDataSource(mysqlDataSource.getMysqlDataSource());

		if(frame.getTxtCari().getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(frame, "Masukan data yang akan dicari!");
		} else {
			List<AdminUser> adm = adminUserService.getPersons();
			for (AdminUser a : adm){
				String ad = a.getUserId();
				if(frame.getTxtCari().getText().equals(ad)){
					adminUserService.getPerson(ad);
					frame.getTxtUserId().setText(ad);
					frame.getTxtEmail().setText(a.getEmail());
					frame.getTxtName().setText(a.getName());
					frame.getTxtPhone().setText(a.getPhone());
					frame.getTxtUserAddress().setText(a.getUserAddress());
					frame.getTxtOtherSchool().setText(a.getOtherSchool());

					cariComponent();
				}
			}
		}

	}

	public void mainComponent(){
		frame.getTxtCari().setEnabled(true);
		frame.getBtnCari().setEnabled(true);
		frame.getBtnTambahBaru().setEnabled(true);

		frame.getBtnDelete().setEnabled(false);
		frame.getBtnUbah().setEnabled(false);
		frame.getBtnSave().setEnabled(false);

		frame.getTxtUserId().setEnabled(false);
		frame.getTxtName().setEnabled(false);
		frame.getTxtEmail().setEnabled(false);
		frame.getTxtPhone().setEnabled(false);
		frame.getTxtUserAddress().setEnabled(false);
		frame.getTxtOtherSchool().setEnabled(false);

		frame.getTxtCari().setText("");
		frame.getTxtUserId().setText("");
		frame.getTxtName().setText("");
		frame.getTxtEmail().setText("");
		frame.getTxtPhone().setText("");
		frame.getTxtUserAddress().setText("");
		frame.getTxtOtherSchool().setText("");
	}

	public void cariComponent(){
		frame.getBtnTambahBaru().setEnabled(false);

		frame.getBtnDelete().setEnabled(true);
		frame.getBtnUbah().setEnabled(true);

		frame.getTxtCari().setEnabled(false);
		frame.getBtnCari().setEnabled(false);
	}

}
