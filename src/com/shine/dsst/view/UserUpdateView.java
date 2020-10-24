package com.shine.dsst.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.shine.dsst.bean.User;
import com.shine.dsst.bean.UserType;
import com.shine.dsst.service.UserService;
import com.shine.dsst.service.impl.UserServiceImpl;

public class UserUpdateView extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField sex;
	private JTextField phone;
	private JTextField idcard;
	private JTextField tid;
	private JTextField grade;
	
	
	private UserService userService = UserServiceImpl.getUserServiceInstance();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserUpdateView(User user) {
		int uid = user.getUid();
		setTitle("修改");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("修改用户信息");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(10, 10, 234, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("用户名");
		label_1.setBounds(10, 46, 54, 15);
		panel.add(label_1);
		
		username = new JTextField();
		username.setBounds(62, 43, 332, 21);
		panel.add(username);
		username.setColumns(10);
		username.setText(user.getUsername());
		
		JLabel lbla = new JLabel("密码");
		lbla.setBounds(10, 81, 54, 15);
		panel.add(lbla);
		
		password = new JTextField();
		password.setBounds(62, 78, 254, 21);
		panel.add(password);
		password.setColumns(10);
		password.setText(user.getPassword());
		
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
		name.setText(user.getName());
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(62, 159, 254, 21);
		panel.add(sex);
		sex.setText(user.getSex());
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(62, 199, 254, 21);
		panel.add(phone);
		phone.setText(user.getPhone());
		
		JLabel label_2 = new JLabel("身份证");
		label_2.setBounds(10, 244, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("分数");
		label_3.setBounds(10, 281, 54, 15);
		panel.add(label_3);
		
		idcard = new JTextField();
		idcard.setColumns(10);
		idcard.setBounds(62, 241, 254, 21);
		panel.add(idcard);
		idcard.setText(user.getIdcard());
		
		grade = new JTextField();
		grade.setColumns(10);
		grade.setBounds(62, 278, 254, 21);
		panel.add(grade);
		grade.setText(user.getGrade());
		
		JLabel label_4 = new JLabel("用户类型");
		label_4.setBounds(10, 323, 54, 15);
		panel.add(label_4);
		JRadioButton radioButton = new JRadioButton("用户");
		radioButton.setBounds(81, 319, 93, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("管理员");
		radioButton_1.setBounds(195, 319, 121, 23);
		panel.add(radioButton_1);
		ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton);
		bg.add(radioButton_1);
		if(user.getTid()==1) {
			radioButton.setSelected(true);
		}else {
			radioButton_1.setSelected(true);
		}
		
		JButton button = new JButton("确认修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = username.getText();
				String pass = password.getText();
				String na = name.getText();
				String se = sex.getText();
				String pho = phone.getText();
				String idc = idcard.getText();
				String g = grade.getText();
				boolean type = radioButton.isSelected();
				int tid = 0;
				if(type) {
					tid=1;
				}else {
					tid=2;
				}
				UserType userType = new UserType();
				userType.setTid(tid);
				User user = new User(null,uname,pass,na,se,pho,idc,userType);
                boolean temp = userService.updateUser(uid, user);
				if(temp) {
					UserView frame = new UserView();
					frame.setVisible(true);
					UserUpdateView.this.dispose();
				}
			}
		});
		button.setBounds(144, 390, 93, 23);
		panel.add(button);
	}
}
