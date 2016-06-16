package sinauadmin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinauadmin.view.AdminUserGui;

public class AdminUserUbahActionListener implements ActionListener {
	private AdminUserGui frame;

	public AdminUserUbahActionListener(AdminUserGui frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ubahComponent();
	}

	public void ubahComponent(){
		frame.getBtnSave().setEnabled(true);

		frame.getBtnDelete().setEnabled(false);

		frame.getTxtName().setEnabled(true);
		frame.getTxtEmail().setEnabled(true);
		frame.getTxtPhone().setEnabled(true);
		frame.getTxtUserAddress().setEnabled(true);
		frame.getTxtOtherSchool().setEnabled(true);
	}

}
