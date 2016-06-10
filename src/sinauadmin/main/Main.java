package sinauadmin.main;

import java.awt.EventQueue;

import sinauadmin.view.AdminUserGui;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUserGui frame = new AdminUserGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
