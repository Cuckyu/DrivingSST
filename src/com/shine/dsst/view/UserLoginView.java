package com.shine.dsst.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.shine.dsst.bean.User;
import com.shine.dsst.service.UserService;
import com.shine.dsst.service.impl.UserServiceImpl;
import com.shine.dsst.utils.Countdown;

public class UserLoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idcard;
	private JTextField name;
	private UserService userService = UserServiceImpl.getUserServiceInstance();
	private static int userType = 1;
	private static String login = "开始考试";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginView frame = new UserLoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 849, 538);
		splitPane.setResizeWeight(0.35);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JLabel label_4 = new JLabel("驾驶人科目一考试系统");
		label_4.setBackground(Color.WHITE);
		label_4.setForeground(Color.BLACK);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("黑体", Font.BOLD, 29));
		label_4.setBounds(0, 0, 837, 186);
		panel.add(label_4);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.4);
		splitPane_1.setBounds(0, 0, 847, 345);
		panel_1.add(splitPane_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		splitPane_1.setLeftComponent(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("考场需知：");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("宋体", Font.BOLD, 19));
		label.setBounds(10, 22, 173, 69);
		panel_2.add(label);
		
		JLabel lblNewLabel = new JLabel("1、遵守考场纪律，服从监考员的安排");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 79, 316, 45);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2、手机关机");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 117, 316, 45);
		panel_2.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("3、考场内禁止抽烟");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		label_1.setBounds(10, 158, 316, 45);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("4、禁止吃零食");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("黑体", Font.BOLD, 15));
		label_2.setBounds(10, 195, 316, 45);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("5、如果有需求请找监考员");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("黑体", Font.BOLD, 15));
		label_3.setBounds(10, 235, 316, 45);
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		splitPane_1.setRightComponent(panel_3);
		panel_3.setLayout(null);
		
		JLabel username = new JLabel("身份证号：");
		username.setFont(new Font("黑体", Font.BOLD, 15));
		username.setBounds(54, 64, 144, 67);
		panel_3.add(username);
		
		JLabel password = new JLabel("姓    名：");
		password.setFont(new Font("黑体", Font.BOLD, 15));
		password.setBounds(54, 141, 112, 48);
		panel_3.add(password);
		
		idcard = new JTextField();
		idcard.setForeground(Color.BLACK);
		idcard.setBackground(Color.WHITE);
		idcard.setBounds(140, 76, 249, 44);
		panel_3.add(idcard);
		idcard.setColumns(10);
		
		name = new JTextField();
		name.setBackground(Color.WHITE);
		name.setColumns(10);
		name.setBounds(140, 141, 249, 44);
		panel_3.add(name);
		
		JButton button = new JButton("开始考试");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_idcard = idcard.getText();
				String user_name = name.getText();
				if(user_idcard == null || "".equals(user_idcard.trim())) {
					JOptionPane.showMessageDialog(null, "请输入身份证号");
					return;
				} else if(user_name == null || "".equals(user_name.trim())) {
					JOptionPane.showMessageDialog(null, "请输入密码");
					return;
				}
				User user = null;
				if(userType == 1) {
					user = userService.login(idcard.getText(), name.getText());
					if(user == null) {
						JOptionPane.showMessageDialog(null, "身份证号或姓名错误");
					} else {
						
						UserTestView utv = new UserTestView(user);
						utv.setVisible(true);
						UserLoginView.this.dispose();
					}
				} else {
					user = userService.adminLogin(idcard.getText(), name.getText());
					if(user == null) {
						JOptionPane.showMessageDialog(null, "账号或密码错误");
					} else {
						//去到管理员界面
						SubjectView frame = new SubjectView();
						frame.setVisible(true);
					}
				}
			}
		});
		button.setFont(new Font("黑体", Font.BOLD, 15));
		button.setBounds(251, 217, 138, 44);
		panel_3.add(button);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 if(e.getStateChange() == ItemEvent.SELECTED){
					 if(userType == 1) {
							userType = 2;
							username.setText("账号：");
							password.setText("密码：");
							button.setText("登录");
							//tips_1.setText("账号");
							//tips_2.setText("密码");
						}else {
							userType = 1;
							username.setText("身份证号：");
							password.setText("姓名：");
							button.setText("开始考试");
							//tips_1.setText("身份证号");
							//tips_2.setText("姓名");
						}
				 }
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"考生", "管理员"}));
		comboBox_1.setBounds(306, 33, 83, 21);
		panel_3.add(comboBox_1);
		
		JLabel label_5 = new JLabel("请选择您的身份");
		label_5.setFont(new Font("黑体", Font.BOLD, 15));
		label_5.setBounds(54, 39, 119, 15);
		panel_3.add(label_5);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
