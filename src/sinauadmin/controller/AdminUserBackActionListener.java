package sinauadmin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinauadmin.view.AdminUserGui;

public class AdminUserBackActionListener implements ActionListener {
	private AdminUserGui frame;

	public AdminUserBackActionListener(AdminUserGui frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
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

}
