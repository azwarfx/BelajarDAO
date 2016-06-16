package sinauadmin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinauadmin.view.AdminUserGui;

public class AdminUserTambahBaruActionListener implements ActionListener {
	private AdminUserGui frame;

	public AdminUserTambahBaruActionListener(AdminUserGui frame) {
		this.frame = frame;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		tambahBaruComponent();
	}

	public void tambahBaruComponent(){
		frame.getTxtCari().setText("");

		frame.getTxtCari().setEnabled(false);
		frame.getBtnCari().setEnabled(false);

		frame.getBtnSave().setEnabled(true);

		frame.getTxtUserId().setEnabled(true);
		frame.getTxtName().setEnabled(true);
		frame.getTxtEmail().setEnabled(true);
		frame.getTxtPhone().setEnabled(true);
		frame.getTxtUserAddress().setEnabled(true);
		frame.getTxtOtherSchool().setEnabled(true);
	}

}
