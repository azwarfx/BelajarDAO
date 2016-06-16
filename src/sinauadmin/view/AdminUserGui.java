package sinauadmin.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sinauadmin.controller.AdminUserBackActionListener;
import sinauadmin.controller.AdminUserCariActionListener;
import sinauadmin.controller.AdminUserDeleteActionListener;
import sinauadmin.controller.AdminUserSaveActionListener;
import sinauadmin.controller.AdminUserTambahBaruActionListener;
import sinauadmin.controller.AdminUserUbahActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminUserGui extends JFrame {

	private JPanel contentPane;
	private JTextField txtCari;
	private JTextField txtOtherSchool;
	private JTextField txtUserAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtName;
	private JTextField txtUserId;
	private JButton btnCari;
	private JButton btnSave;
	private JButton btnBack;
	private JButton btnTambahBaru;
	private JButton btnDelete;
	private JButton btnUbah;

	public AdminUserGui() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAplikasiSinauAdmin = new JLabel("APLIKASI SINAU ADMIN");
		lblAplikasiSinauAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAplikasiSinauAdmin.setBounds(79, 11, 195, 41);
		contentPane.add(lblAplikasiSinauAdmin);

		JLabel lblAdminUser = new JLabel("Admin User");
		lblAdminUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminUser.setBounds(136, 49, 71, 14);
		contentPane.add(lblAdminUser);

		txtCari = new JTextField();
		txtCari.setBounds(15, 102, 225, 20);
		contentPane.add(txtCari);
		txtCari.setColumns(10);


		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(15, 179, 46, 14);
		contentPane.add(lblUserId);

		JLabel lblNama = new JLabel("Name");
		lblNama.setBounds(15, 204, 46, 14);
		contentPane.add(lblNama);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(15, 229, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(15, 254, 46, 14);
		contentPane.add(lblPhone);

		JLabel lblUserAddress = new JLabel("User Address");
		lblUserAddress.setBounds(15, 279, 78, 14);
		contentPane.add(lblUserAddress);

		JLabel lblOtherSchool = new JLabel("Other School");
		lblOtherSchool.setBounds(15, 304, 78, 14);
		contentPane.add(lblOtherSchool);

		txtOtherSchool = new JTextField();
		txtOtherSchool.setBounds(103, 301, 236, 20);
		contentPane.add(txtOtherSchool);
		txtOtherSchool.setColumns(10);

		txtUserAddress = new JTextField();
		txtUserAddress.setColumns(10);
		txtUserAddress.setBounds(103, 276, 236, 20);
		contentPane.add(txtUserAddress);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(103, 251, 236, 20);
		contentPane.add(txtPhone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 226, 236, 20);
		contentPane.add(txtEmail);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(103, 201, 236, 20);
		contentPane.add(txtName);

		txtUserId = new JTextField();
		txtUserId.setColumns(10);
		txtUserId.setBounds(103, 176, 236, 20);
		contentPane.add(txtUserId);

		btnTambahBaru = new JButton("Tambah Baru");
		btnTambahBaru.setBounds(15, 133, 114, 23);
		btnTambahBaru.addActionListener(new AdminUserTambahBaruActionListener(this));
		contentPane.add(btnTambahBaru);

		btnUbah = new JButton("Edit");
		btnUbah.setBounds(136, 133, 95, 23);
		btnUbah.addActionListener(new AdminUserUbahActionListener(this));
		contentPane.add(btnUbah);

		btnSave = new JButton("Save");
		btnSave.setBounds(49, 336, 95, 23);
		btnSave.addActionListener(new AdminUserSaveActionListener(this));
		contentPane.add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(202, 336, 95, 23);
		btnDelete.addActionListener(new AdminUserDeleteActionListener(this));
		contentPane.add(btnDelete);

		btnBack = new JButton("Kembali Ke Pencarian");
		btnBack.setBounds(206, 438, 133, 23);
		btnBack.addActionListener(new AdminUserBackActionListener(this));
		contentPane.add(btnBack);

		btnCari = new JButton("Cari");
		btnCari.setBounds(250, 101, 89, 23);
		btnCari.addActionListener(new AdminUserCariActionListener(this));
		contentPane.add(btnCari);
	}

	public JTextField getTxtCari() {
		return txtCari;
	}
	public JTextField getTxtOtherSchool() {
		return txtOtherSchool;
	}
	public JTextField getTxtUserAddress() {
		return txtUserAddress;
	}
	public JTextField getTxtPhone() {
		return txtPhone;
	}
	public JTextField getTxtEmail() {
		return txtEmail;
	}
	public JTextField getTxtName() {
		return txtName;
	}
	public JTextField getTxtUserId() {
		return txtUserId;
	}
	public JButton getBtnCari() {
		return btnCari;
	}
	public JButton getBtnSave() {
		return btnSave;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public JButton getBtnTambahBaru() {
		return btnTambahBaru;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnUbah() {
		return btnUbah;
	}
}
