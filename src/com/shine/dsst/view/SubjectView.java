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

import com.shine.dsst.bean.Subject;
import com.shine.dsst.service.SubjectService;
import com.shine.dsst.service.impl.SubjectServiceImpl;

public class SubjectView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable subject;
	private JTextField subjectkey;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	
	private SubjectService subjectService=SubjectServiceImpl.getSubjectServiceImplInstance();
	Integer sid=null;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubjectView frame = new SubjectView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	
	/**
	 * Create the frame.
	 */
	public void setResult(List<Subject> subjectList) {
		Object[][] obj=new Object[subjectList.size()][9];
		for(int i=0;i<subjectList.size();i++) {
			obj[i][0]=subjectList.get(i).getSid();
			obj[i][1]=subjectList.get(i).getStitle();
			obj[i][2]=subjectList.get(i).getOptiona();
			obj[i][3]=subjectList.get(i).getOptionb();
			obj[i][4]=subjectList.get(i).getOptionc();
			obj[i][5]=subjectList.get(i).getOptiond();
			obj[i][6]=subjectList.get(i).getPic();
			obj[i][7]=subjectList.get(i).getAnswer();
			obj[i][8]=subjectList.get(i).getStid()==1?"选择题":"判断题";

		}

		subject.setModel(new DefaultTableModel(
				obj,new String[] {
						 "试题编号", "题目", "选项A", "选项B", "选项C", "选项D","图片", "答案", "试题类型"
				}

		));
	}
	
	public SubjectView() {
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
		
		subject = new JTable(){
            public boolean isCellEditable(int row, int column)
	            {
	                   return false;
	               }//表格不允许被编辑
	            };
        subject.getTableHeader().setPreferredSize(new Dimension(1, 40));
        subject.getTableHeader().setBackground(new Color(230, 230, 250));
        
		subject.setRowHeight(30);
		
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        subject.setDefaultRenderer(Object.class,r);
        
		subject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				获取行索引  索引从0开始
				int row=subject.getSelectedRow();
//				System.out.println(row);
//				获取指定列的值  第一列数据
				sid = (Integer) subject.getValueAt(row, 0);
//				System.out.println(sid);
			}
		});
		subject.setFont(new Font("宋体", Font.PLAIN, 18));
		

		scrollPane.setViewportView(subject);
		setResult(subjectService.queryAll());
		
		JLabel lblNewLabel = new JLabel("题目关键字：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 45, 143, 41);
		contentPane.add(lblNewLabel);
		
		subjectkey = new JTextField();
		subjectkey.setBounds(116, 49, 330, 30);
		contentPane.add(subjectkey);
		subjectkey.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = subjectkey.getText();
				ArrayList<Subject> list = subjectService.querySubject(title);
				setResult(list);
			}
		});
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(475, 50, 77, 30);
		contentPane.add(btnNewButton);
		
		button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectAddView frame = new SubjectAddView();
				frame.setVisible(true);
			}
		});
		button.setBounds(602, 52, 89, 30);
		contentPane.add(button);
		
		button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				获试题编号
				if(sid!=null) {
//					调用方法执行删除试题
					boolean temp=subjectService.removeSubject(sid);
					if(temp) {
						JOptionPane.showMessageDialog(null, "删除成功");
						SubjectView frame = new SubjectView();
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
				if(sid!=null) {
					System.out.println(sid);
					Subject subject = subjectService.querySubjectBysid(sid);
					System.out.println(subject);
					SubjectUpdateView frame = new SubjectUpdateView(subject);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "请选择要修改的试题");
				}
			}
		});
		button_2.setBounds(846, 52, 89, 30);
		contentPane.add(button_2);
		
		
		button_3 = new JButton("用户管理");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserView frame = new UserView();
				frame.setVisible(true);
			}
		});
		button_3.setBounds(974, 55, 89, 30);
		contentPane.add(button_3);

		
	}
}
