package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.UserDAO;
import model.UserDTO;

public class LoginForm extends JFrame {

	public JTextField txtID;
	public JTextField txtPwd;
	public JButton btnLogin;
	
	UserDAO userDAO;
	UserDTO user;
	
	public LoginForm() {
		// TODO Auto-generated constructor stub
		setLayout(null);	
		
		txtID = new JTextField();
		txtID.setBounds(10, 10, 200, 50);
		add(txtID);
		
		txtPwd = new JTextField();
		txtPwd.setBounds(10, 70, 200, 50);
		add(txtPwd);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(10, 130, 100, 50);
		add(btnLogin);
		
		userDAO = new UserDAO();
		
		btnLogin.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(userDAO.Login(txtID.getText(), txtPwd.getText()))
				{
					user = new UserDTO(txtID.getText(), txtPwd.getText());
					new LobbyForm(user);
					
					userDAO.Destructor();
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "로그인 실패");	
			}
			
		});
		
		setTitle("채팅 프로그램");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(10, 10, 400, 400);
	}
	
	
	
	
}
