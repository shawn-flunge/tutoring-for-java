package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.UserDTO;

public class LobbyForm extends JFrame {

	UserDTO user;
	
	JLabel lblTemp;
	
	public LobbyForm(UserDTO user) {
		setLayout(null);
		this.user=user;
	
		lblTemp = new JLabel(user.getId() + "님 환영합니다.");
		lblTemp.setBounds(10, 130, 3000, 100);
		add(lblTemp);
		
		setTitle("로비");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(10, 10, 400, 400);
	}
	
}
