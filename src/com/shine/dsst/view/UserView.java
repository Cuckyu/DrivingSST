package com.shine.dsst.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.shine.dsst.bean.User;
import com.shine.dsst.service.UserService;
import com.shine.dsst.service.impl.UserServiceImpl;

public class UserView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable user;
	private JTextField userkey;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	
	private UserService userService=UserServiceImpl.getUserServiceInstance();
	Integer uid=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView();
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
	public void setResult(List<User> userList) {
		Object[][] obj=new Object[userList.size()][9];
		for(int i=0;i<userList.size();i++) {
			obj[i][0]=userList.get(i).getUid();
			obj[i][1]=userList.get(i).getUsername();
			obj[i][2]=userList.get(i).getPassword();
			obj[i][3]=userList.get(i).getName();
			obj[i][4]=userList.get(i).getSex();
			obj[i][5]=userList.get(i).getPhone();
			obj[i][6]=userList.get(i).getIdcard();
			obj[i][7]=userList.get(i).getTid()==1?"用户":"管理员";
			obj[i][8]=userList.get(i).getGrade();

		}

		user.setModel(new DefaultTableModel(
				obj,new String[] {
						 "用户编号", "用户名", "密码", "姓名", "姓别", "电话","身份证", "用户类型", "分数"
				}

		));
	}
	
	public UserView() {
		setTitle("题库管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1126, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 126, 1073, 444);
		contentPane.add(scrollPane);
		
		user = new JTable(){
            public boolean isCellEditable(int row, int column)
	            {
	                   return false;
	               }//表格不允许被编辑
	            };
        user.getTableHeader().setPreferredSize(new Dimension(1, 40));
        user.getTableHeader().setBackground(new Color(230, 230, 250));
        
		user.setRowHeight(30);
		
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        user.setDefaultRenderer(Object.class,r);
        
		user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				获取行索引  索引从0开始
				int row=user.getSelectedRow();
//				System.out.println(row);
//				获取指定列的值  第一列数据
				uid = (Integer) user.getValueAt(row, 0);
//				System.out.println(sid);
			}
		});
		user.setFont(new Font("宋体", Font.PLAIN, 18));
		

		scrollPane.setViewportView(user);
		setResult(userService.queryAll());
		
		JLabel lblNewLabel = new JLabel("题目关键字：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 45, 143, 41);
		contentPane.add(lblNewLabel);
		
		userkey = new JTextField();
		userkey.setBounds(116, 49, 330, 30);
		contentPane.add(userkey);
		userkey.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = userkey.getText();
				ArrayList<User> list = userService.queryUser(title);
				setResult(list);
			}
		});
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(475, 50, 77, 30);
		contentPane.add(btnNewButton);
		
		button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAddView frame = new UserAddView();
				frame.setVisible(true);
			}
		});
		button.setBounds(602, 52, 89, 30);
		contentPane.add(button);
		
		button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				获试题编号
				if(uid!=null) {
//					调用方法执行删除试题
					boolean temp=userService.removeUser(uid);
					if(temp) {
						JOptionPane.showMessageDialog(null, "删除成功");
						UserView frame = new UserView();
						frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				}else {
					JOptionPane.showMessageDialog(null, "请选择要删除的试题");
				}
			}
		});
		
		button_1.setBounds(730, 52, 89, 30);
		contentPane.add(button_1);
		
		button_2 = new JButton("编辑");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(uid!=null) {
					System.out.println(uid);
					User user = userService.queryUserByuid(uid);
					System.out.println(user);
					UserUpdateView frame = new UserUpdateView(user);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "请选择要修改的试题");
				}
			}
		});
		button_2.setBounds(846, 52, 89, 30);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("试题管理");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectView frame = new SubjectView();
				frame.setVisible(true);
			}
		});
		button_3.setBounds(975, 55, 89, 30);
		contentPane.add(button_3);

		

	}
}
