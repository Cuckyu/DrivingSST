package com.shine.dsst.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.shine.dsst.bean.User;
import com.shine.dsst.bean.UserType;
import com.shine.dsst.service.UserService;
import com.shine.dsst.service.impl.UserServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserAddView extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField sex;
	private JTextField phone;
	private JTextField idcard;
	private JTextField tid;
	
	private UserService userService = UserServiceImpl.getUserServiceInstance();
	/**
	 * Create the frame.
	 */
	public UserAddView() {
		setTitle("添加");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("请输入要添加的用户信息");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(10, 10, 234, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("用户名");
		label_1.setBounds(10, 46, 54, 15);
		panel.add(label_1);
		
		username = new JTextField();
		username.setBounds(62, 43, 254, 21);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lbla = new JLabel("密码");
		lbla.setBounds(10, 81, 54, 15);
		panel.add(lbla);
		
		password = new JTextField();
		password.setBounds(62, 78, 254, 21);
		panel.add(password);
		password.setColumns(10);
		
		JLabel lblb = new JLabel("姓名");
		lblb.setBounds(10, 122, 54, 15);
		panel.add(lblb);
		
		JLabel lblb_1 = new JLabel("性别");
		lblb_1.setBounds(10, 162, 54, 15);
		panel.add(lblb_1);
		
		JLabel lbld = new JLabel("电话");
		lbld.setBounds(10, 202, 54, 15);
		panel.add(lbld);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(62, 119, 254, 21);
		panel.add(name);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(62, 159, 254, 21);
		panel.add(sex);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(62, 199, 254, 21);
		panel.add(phone);
		
		JLabel label_2 = new JLabel("身份证");
		label_2.setBounds(10, 244, 54, 15);
		panel.add(label_2);
		
		idcard = new JTextField();
		idcard.setColumns(10);
		idcard.setBounds(62, 241, 254, 21);
		panel.add(idcard);
		
		JLabel label_4 = new JLabel("用户类型");
		label_4.setBounds(10, 287, 54, 15);
		panel.add(label_4);
		JRadioButton radioButton = new JRadioButton("用户");
		radioButton.setBounds(84, 283, 93, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("管理员");
		radioButton_1.setBounds(195, 283, 121, 23);
		panel.add(radioButton_1);
		ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton);
		bg.add(radioButton_1);
		
		JButton button = new JButton("添加");
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = username.getText();
				String pass = password.getText();
				String na = name.getText();
				String se = sex.getText();
				String pho = phone.getText();
				String idc = idcard.getText();

				int tid = 0;
				if(radioButton.isSelected()) {
					tid=1;
				}else {
					tid=2;
				}
				 
				UserType userType = new UserType();
				userType.setTid(tid);
				User user = new User(null,uname,pass,na,se,pho,idc,userType);
                boolean temp = userService.AddUser(user);
				if(temp) {
					UserView frame = new UserView();
					frame.setVisible(true);
					UserAddView.this.dispose();
				}
			}
		});
		button.setBounds(143, 349, 82, 37);
		panel.add(button);

	}
}
