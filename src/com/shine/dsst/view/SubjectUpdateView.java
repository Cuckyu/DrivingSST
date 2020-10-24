package com.shine.dsst.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.shine.dsst.bean.Subject;
import com.shine.dsst.bean.SubjectType;
import com.shine.dsst.service.SubjectService;
import com.shine.dsst.service.impl.SubjectServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubjectUpdateView extends JFrame {

	private JPanel contentPane;
	private JTextField stitle;
	private JTextField optiona;
	private JTextField optionb;
	private JTextField optionc;
	private JTextField optiond;
	private JTextField pic;
	private JTextField answer;
	
	
	private SubjectService subjectService = SubjectServiceImpl.getSubjectServiceImplInstance();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SubjectUpdateView frame = new SubjectUpdateView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SubjectUpdateView(Subject subject) {
		int sid = subject.getSid();
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
		
		JLabel label = new JLabel("修改试题信息");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(10, 10, 234, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("题目");
		label_1.setBounds(10, 46, 54, 15);
		panel.add(label_1);
		
		stitle = new JTextField();
		stitle.setBounds(62, 43, 332, 21);
		panel.add(stitle);
		stitle.setColumns(10);
		stitle.setText(subject.getStitle());
		
		JLabel lbla = new JLabel("选项A");
		lbla.setBounds(10, 81, 54, 15);
		panel.add(lbla);
		
		optiona = new JTextField();
		optiona.setBounds(62, 78, 254, 21);
		panel.add(optiona);
		optiona.setColumns(10);
		optiona.setText(subject.getOptiona());
		
		JLabel lblb = new JLabel("选项B");
		lblb.setBounds(10, 122, 54, 15);
		panel.add(lblb);
		
		JLabel lblb_1 = new JLabel("选项C");
		lblb_1.setBounds(10, 162, 54, 15);
		panel.add(lblb_1);
		
		JLabel lbld = new JLabel("选项D");
		lbld.setBounds(10, 202, 54, 15);
		panel.add(lbld);
		
		optionb = new JTextField();
		optionb.setColumns(10);
		optionb.setBounds(62, 119, 254, 21);
		panel.add(optionb);
		optionb.setText(subject.getOptionb());
		
		optionc = new JTextField();
		optionc.setColumns(10);
		optionc.setBounds(62, 159, 254, 21);
		panel.add(optionc);
		optionc.setText(subject.getOptionc());
		
		optiond = new JTextField();
		optiond.setColumns(10);
		optiond.setBounds(62, 199, 254, 21);
		panel.add(optiond);
		optiond.setText(subject.getOptiond());
		
		JLabel label_2 = new JLabel("图片");
		label_2.setBounds(10, 244, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("答案");
		label_3.setBounds(10, 281, 54, 15);
		panel.add(label_3);
		
		pic = new JTextField();
		pic.setColumns(10);
		pic.setBounds(62, 241, 254, 21);
		panel.add(pic);
		pic.setText(subject.getPic());
		
		answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(62, 278, 254, 21);
		panel.add(answer);
		answer.setText(subject.getAnswer());
		
		JLabel label_4 = new JLabel("试题类型");
		label_4.setBounds(10, 323, 54, 15);
		panel.add(label_4);
		JRadioButton radioButton = new JRadioButton("选择");
		radioButton.setBounds(81, 319, 93, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("判断");
		radioButton_1.setBounds(195, 319, 121, 23);
		panel.add(radioButton_1);
		ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton);
		bg.add(radioButton_1);
		if(subject.getStid()==1) {
			radioButton.setSelected(true);
		}else {
			radioButton_1.setSelected(true);
		}
		
		JButton button = new JButton("确认修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = stitle.getText();
				String a = optiona.getText();
				String b = optionb.getText();
				String c = optionc.getText();
				String d = optiond.getText();
				String src = pic.getText();
				String as = answer.getText();
				boolean type = radioButton.isSelected();
				int stid = 0;
				if(type) {
					stid=1;
				}else {
					stid=2;
				}
				SubjectType subjectType = new SubjectType();
				subjectType.setStid(stid);
				Subject subject = new Subject(sid,title,a,b,c,d,src,as,subjectType);
				boolean temp = subjectService.editeSubjectById(sid, subject);
				System.out.println(temp);
				if(temp) {
					SubjectView frame = new SubjectView();
					frame.setVisible(true);
					SubjectUpdateView.this.dispose();
				}
			}
		});
		button.setBounds(144, 390, 93, 23);
		panel.add(button);
	}
}
