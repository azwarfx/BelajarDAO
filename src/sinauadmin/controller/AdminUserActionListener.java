package sinauadmin.controller;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinauadmin.config.DatabaseDataSource;
import sinauadmin.model.AdminUser;
import sinauadmin.service.AdminUserService;
import sinauadmin.view.AdminUserGui;

public class AdminUserActionListener implements ActionListener{
	private AdminUserGui frame;
	private DatabaseDataSource mysqlDataSource ;
	private AdminUserService adminUserService ;

	public AdminUserActionListener(AdminUserGui frame) {
		this.frame = frame;
		statusComponent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mysqlDataSource = new DatabaseDataSource();
		adminUserService = new AdminUserService();

		adminUserService.setDataSource(mysqlDataSource.getMysqlDataSource());

		String action = e.getActionCommand();
		switch(action){
		case "Save":
			saveOrUpdate();
			break;
		case "Delete":
			delete();
			break;
		case "Cari":
			cari();
			break;
		case "Ubah":
			ubahComponent();
			break;
		case "Back":
			backComponent();
			break;
		case "TambahBaru":
			tambahBaruComponent();
			break;
		}
	}

	public void saveOrUpdate(){
		AdminUser a = new AdminUser();
		a.setUserId(frame.getTxtUserId().getText());
		a.setName(frame.getTxtName().getText());
		a.setEmail(frame.getTxtEmail().getText());
		a.setPhone(frame.getTxtPhone().getText());
		a.setUserAddress(frame.getTxtUserAddress().getText());
		a.setOtherSchool(frame.getTxtOtherSchool().getText());

		adminUserService.saveOrUpdate(a, false);
	}

	public void delete(){
		if(!frame.getTxtUserId().getText().trim().isEmpty()){
			adminUserService.delete(frame.getTxtUserId().getText());
		}
	}

	public void cari(){
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


	public void statusComponent(){
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

	public void ubahComponent(){
		frame.getBtnSave().setEnabled(true);

		frame.getBtnDelete().setEnabled(false);

		frame.getTxtUserId().setEnabled(true);
		frame.getTxtName().setEnabled(true);
		frame.getTxtEmail().setEnabled(true);
		frame.getTxtPhone().setEnabled(true);
		frame.getTxtUserAddress().setEnabled(true);
		frame.getTxtOtherSchool().setEnabled(true);
	}

	public void backComponent(){
		statusComponent();
	}

	public void tambahBaruComponent(){
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