package com.shine.dsst.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.shine.dsst.bean.Subject;
import com.shine.dsst.bean.TestPaper;
import com.shine.dsst.bean.TestpaperSubject;
import com.shine.dsst.bean.User;
import com.shine.dsst.service.TestPaperService;
import com.shine.dsst.service.TestPaperSubjectService;
import com.shine.dsst.service.impl.TestPaperServiceImpl;
import com.shine.dsst.service.impl.TestPaperSubjectServiceImpl;
import com.shine.dsst.utils.Countdown;
import com.shine.dsst.utils.SelectedThread;

public class UserTestView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user;
	private int count = 0;
	private TestPaperService testPaperService = new TestPaperServiceImpl();
	private TestPaper autoTestPaper;
	private List<Subject> choices;
	private List<Subject> judges;
	private int time = 45*60;
	private Thread t ;
	
	private TestPaperSubjectService tpss = new TestPaperSubjectServiceImpl();
	private JTable table;
	private HashMap<Integer,Integer> hashMap = new HashMap<>();
	
	private Thread t2 ;
	
//	int row = 0;
//	int column = 0;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserTestView frame = new UserTestView();
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
	public UserTestView(User user) {
		
		this.user = user;
		autoTestPaper = testPaperService.autoTestPaper(user);
		choices = autoTestPaper.getChoices();
		judges = autoTestPaper.getJudges();
		setBackground(Color.WHITE);
		setTitle("开始考试");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(5, 5, 840, 530);
		splitPane.setResizeWeight(0.6);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBackground(Color.WHITE);
		splitPane_1.setBounds(0, 0, 838, 313);
		splitPane_1.setResizeWeight(0.9);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_1);
		
		JPanel panel_2 = new JPanel();
		splitPane_1.setRightComponent(panel_2);
		panel_2.setLayout(null);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setBounds(0, 0, 836, 30);
		splitPane_2.setResizeWeight(0.2);
		panel_2.add(splitPane_2);
		
		JPanel panel_4 = new JPanel();
		splitPane_2.setLeftComponent(panel_4);
		panel_4.setLayout(null);
		
		//计时器
		JLabel tip_time = new JLabel();
		tip_time.setBounds(54, 0, 72, 18);
		tip_time.setBackground(Color.WHITE);
		panel_4.add(tip_time);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		splitPane_2.setRightComponent(panel_5);
		
		JPanel panel_3 = new JPanel();
		splitPane_1.setLeftComponent(panel_3);
		panel_3.setLayout(null);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setBounds(0, 0, 836, 274);
		splitPane_3.setResizeWeight(0.2);
		panel_3.add(splitPane_3);
		
		JPanel panel_6 = new JPanel();
		splitPane_3.setLeftComponent(panel_6);
		panel_6.setLayout(null);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setResizeWeight(0.1);
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_4.setBounds(0, 0, 166, 272);
		panel_6.add(splitPane_4);
		
		JPanel panel_8 = new JPanel();
		splitPane_4.setLeftComponent(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("第01号考台");
		lblNewLabel.setBounds(30, 0, 120, 27);
		panel_8.add(lblNewLabel);
		
		JPanel panel_9 = new JPanel();
		splitPane_4.setRightComponent(panel_9);
		panel_9.setLayout(null);
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setResizeWeight(0.5);
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_6.setBounds(0, 0, 164, 238);
		panel_9.add(splitPane_6);
		
		JPanel panel_12 = new JPanel();
		splitPane_6.setLeftComponent(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 162, 102);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\桌面\\DrivingSST\\images\\people.jpg"));
		panel_12.add(lblNewLabel_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		splitPane_6.setRightComponent(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("考生姓名："+ user.getName());
		lblNewLabel_2.setBounds(0, 0, 162, 18);
		panel_13.add(lblNewLabel_2);
		
		JLabel label = new JLabel("性    别：" + user.getSex());
		label.setBounds(0, 23, 162, 18);
		panel_13.add(label);
		
		JLabel label_1 = new JLabel("考生电话：" + user.getPhone());
		label_1.setBounds(0, 48, 162, 18);
		panel_13.add(label_1);
		
		JLabel label_2 = new JLabel("考试车型：机动车");
		label_2.setBounds(0, 79, 162, 18);
		panel_13.add(label_2);
		
		JPanel panel_7 = new JPanel();
		splitPane_3.setRightComponent(panel_7);
		panel_7.setLayout(null);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setResizeWeight(0.8);
		splitPane_5.setBounds(0, 0, 663, 272);
		panel_7.add(splitPane_5);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		splitPane_5.setLeftComponent(panel_10);
		
		JPanel panel_11 = new JPanel();
		splitPane_5.setRightComponent(panel_11);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		
		
		// 下一题或上一题
		Subject s = choices.get(count);
		panel_10.setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 524, 66);
		textArea.setEditable(false);
		textArea.setText((count+1) + "、" +s.getStitle());
		textArea.setLineWrap(true);
		panel_10.add(textArea);
		
		JTextArea txtrA = new JTextArea();
		txtrA.setBounds(0, 76, 524, 38);
		txtrA.setEditable(false);
		txtrA.setText("A、" + s.getOptiona());
		txtrA.setLineWrap(true);
		panel_10.add(txtrA);
		
		JTextArea txtrB = new JTextArea();
		txtrB.setBounds(0, 121, 524, 38);
		txtrB.setEditable(false);
		txtrB.setText("B、" + s.getOptionb());
		txtrB.setLineWrap(true);
		panel_10.add(txtrB);
		
		JTextArea txtrC = new JTextArea();
		txtrC.setBounds(0, 158, 524, 38);
		txtrC.setEditable(false);
		txtrC.setText("C、" + s.getOptionc());
		txtrC.setLineWrap(true);
		panel_10.add(txtrC);
		
		JTextArea txtrD = new JTextArea();
		txtrD.setBounds(0, 200, 524, 38);
		txtrD.setEditable(false);
		txtrD.setText("D、" + s.getOptiond());
		txtrD.setLineWrap(true);
		panel_10.add(txtrD);
		
		JPanel panel_111 = new JPanel();
		splitPane_5.setRightComponent(panel_111);
		panel_111.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 132, 270);
		panel_111.add(lblNewLabel_3);
		
		
		//是否有图片
		JLabel pic = new JLabel("");
		pic.setHorizontalAlignment(SwingConstants.CENTER);
		pic.setIcon(new ImageIcon(s.getPic()));
		pic.setBounds(0, 0, 838, 210);
		panel_1.add(pic);
		
		
		JLabel label_3 = new JLabel("您的答案：");
		label_3.setBounds(10, 244, 99, 18);
		panel_10.add(label_3);
		
		JRadioButton choice_1 = new JRadioButton("A");
		choice_1.setBounds(222, 240, 49, 27);
		panel_10.add(choice_1);
		
		JRadioButton choice_2 = new JRadioButton("B");
		choice_2.setBounds(286, 240, 49, 27);
		panel_10.add(choice_2);
		
		JRadioButton choice_3 = new JRadioButton("C");
		choice_3.setBounds(351, 240, 49, 27);
		panel_10.add(choice_3);
		
		JRadioButton choice_4 = new JRadioButton("D");
		choice_4.setBounds(415, 240, 49, 27);
		panel_10.add(choice_4);
		
		
		ButtonGroup bg = new ButtonGroup();
        bg.add(choice_1);
		bg.add(choice_2);
		bg.add(choice_3);
		bg.add(choice_4);
		
		JLabel lblNewLabel_5 = new JLabel("选择：");
		lblNewLabel_5.setBounds(163, 244, 43, 18);
		panel_10.add(lblNewLabel_5);
		panel_5.setLayout(null);
		
		
		JLabel label_4 = new JLabel("选择题：请选择A或B或C或D");
		label_4.setBounds(0, 0, 200, 28);
		label_4.setFont(new Font("黑体", Font.PLAIN, 12));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_4);
		
		
		
		table = new JTable(){
            public boolean isCellEditable(int row, int column)
            {
            	//录入答案
            	if(count==100) {
            		count--;
            	}
            	Subject s1 = count<50?choices.get(count):judges.get(count-50);
   				String answer = "";
   				if(choice_1.isSelected()) {
   					answer = count<50?s1.getOptiona():choice_1.getText();
   				}
   				if(choice_2.isSelected()) {
   					answer = count<50?s1.getOptionb():choice_2.getText();
   				}
   				if(choice_3.isSelected()) {
   					answer = s1.getOptionc();
   				}
   				if(choice_4.isSelected()) {
   					answer = s1.getOptiond();
   				}
   				boolean isAnswer = false;
   				if(choice_1.isSelected() || choice_2.isSelected()||choice_3.isSelected()||choice_4.isSelected()) {
   					isAnswer = true;
   				}
   				if(isAnswer) {
   					TestpaperSubject ts = new TestpaperSubject();
   					ts.setTpsn(autoTestPaper.getTpsn());
   					ts.setSubject(s1);
   					ts.setAnswer(answer);
   					String answered = tpss.getAnswer(ts);
   					if(answered!=null) {
   						tpss.updateAnswer(ts);
   					}else{
   						boolean addAnswer = tpss.addAnswer(ts);
   						if(!addAnswer) {
   							JOptionPane.showMessageDialog(null, "答案录入失败，请您联系监考员进行解决");
   						}
   					}
   				}
   				bg.clearSelection();
   				int count_copy ;
        		count_copy = (int) table.getValueAt(row, column);
        		Object value = table.getValueAt(row, column);
        		table.setDefaultRenderer(Object.class, new EvenOddRenderer(row, column));
        		
        		count = count_copy - 1;
   				System.out.println("*********"+count);
   				if(count<50) {
   					Subject s = choices.get(count);
   					textArea.setText((count+1) + "、" +s.getStitle());			
   					txtrA.setText("A、" + s.getOptiona());		
   					txtrB.setText("B、" + s.getOptionb());		
   					txtrC.setText("C、" + s.getOptionc());
   					txtrD.setText("D、" + s.getOptiond());
   					pic.setIcon(new ImageIcon(s.getPic()));
   					System.out.println(s.getPic());
   					choice_1.setText("A");
   					choice_2.setText("B");
   					choice_3.show();
   					choice_4.show();
   					label_4.setText("选择题：请选择A或B或C或D");
   					//查看这一题是否已经作答
   					TestpaperSubject tps = new TestpaperSubject();
   					tps.setTpsn(autoTestPaper.getTpsn());
   					tps.setSubject(s);
   					String answered = tpss.getAnswer(tps);
   					System.out.println(answered);
   					if(answered!=null) {
   						if(answered.equals(s.getOptiona())) {
   							System.out.println("选A");
   							choice_1.setSelected(true);
   						}else if(answered.equals(s.getOptionb())) {
   							System.out.println("选B");
   							choice_2.setSelected(true);
   						}else if(answered.equals(s.getOptionc())) {
   							System.out.println("选C");
   							choice_3.setSelected(true);
   						}else if(answered.equals(s.getOptiond())) {
   							System.out.println("选D");
   							choice_4.setSelected(true);
   						}
   					}
   					
   				} else if(count >= 50 && count < 100){
   					Subject s = judges.get(count - 50);
   					textArea.setText((count+1) + "、" +s.getStitle());			
   					txtrA.setText("");		
   					txtrB.setText("");		
   					txtrC.setText("");
   					txtrD.setText("");
   					pic.setIcon(new ImageIcon(s.getPic()));
   					System.out.println(s.getPic());
   					choice_1.setText("对");
   					choice_2.setText("错");
   					choice_3.hide();
   					choice_4.hide();
   					label_4.setText("判断题：请选择对或错");
   					TestpaperSubject tps = new TestpaperSubject();
   					tps.setTpsn(autoTestPaper.getTpsn());
   					tps.setSubject(s);
   					String answered = tpss.getAnswer(tps);
   					System.out.println(answered);
   					if(answered!=null) {
   						if(answered.equals(choice_1.getText())) {
   							System.out.println("对");
   							choice_1.setSelected(true);
   						}else if(answered.equals(choice_2.getText())) {
   							System.out.println("错");
   							choice_2.setSelected(true);
   						}
   					}
   					
   				}
                   return false;
               }//表格不允许被编辑
            };
       
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1, 2, 3, 4, 5,6},
				{ 7, 8, 9, 10,11, 12},
				{ 13, 14, 15,16, 17, 18},
				{ 19, 20,21, 22, 23, 24},
				{25,26, 27, 28, 29, 30},
				{31, 32, 33, 34, 35,36},
				{ 37, 38, 39, 40,41, 42},
				{43, 44, 45,46, 47, 48},
				{ 49, 50,51, 52, 53, 54},
			    {55,56, 57, 58, 59, 60},
				{61, 62, 63, 64, 65,66},
				{ 67, 68, 69, 70,71, 72},
				{73, 74, 75,76, 77, 78},
				{79, 80,81, 82, 83, 84},
				
				{85,86, 87, 88, 89, 90},
				{91, 92, 93, 94, 95,96},
				{ 97, 98, 99, 100,null,null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(0, 0, 132, 270);
		panel_111.add(table);
		JButton button = new JButton("上一题");
		button.setBounds(199, 0, 100, 28);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0) {
					return;
				}
				//答案插入数据库
				System.out.println("count:" + count);
				if(count == 100) {
					count--;
				}
				Subject s1 = count<50?choices.get(count):judges.get(count-50);
				String answer = "";
				if(choice_1.isSelected()) {
					answer = count<50?s1.getOptiona():choice_1.getText();
				}
				if(choice_2.isSelected()) {
					answer = count<50?s1.getOptionb():choice_2.getText();
				}
				if(choice_3.isSelected()) {
					answer = s1.getOptionc();
				}
				if(choice_4.isSelected()) {
					answer = s1.getOptiond();
				}
				boolean isAnswer = false;
				if(choice_1.isSelected() || choice_2.isSelected()||choice_3.isSelected()||choice_4.isSelected()) {
					isAnswer = true;
				}
				if(isAnswer) {
					TestpaperSubject ts = new TestpaperSubject();
					ts.setTpsn(autoTestPaper.getTpsn());
					ts.setSubject(s1);
					ts.setAnswer(answer);
					String answered = tpss.getAnswer(ts);
					if(answered!=null) {
						tpss.updateAnswer(ts);
					}else{
						boolean addAnswer = tpss.addAnswer(ts);
						if(!addAnswer) {
							JOptionPane.showMessageDialog(null, "答案录入失败，请您联系监考员进行解决");
						}
					}
				}
				bg.clearSelection();
				count--;
				System.out.println(count);
				if(count<50) {
					Subject s = choices.get(count);
					textArea.setText((count+1) + "、" +s.getStitle());			
					txtrA.setText("A、" + s.getOptiona());		
					txtrB.setText("B、" + s.getOptionb());		
					txtrC.setText("C、" + s.getOptionc());
					txtrD.setText("D、" + s.getOptiond());
					pic.setIcon(new ImageIcon(s.getPic()));
					System.out.println(s.getPic());
					choice_1.setText("A");
					choice_2.setText("B");
					choice_3.show();
					choice_4.show();
					label_4.setText("选择题：请选择A或B或C或D");
					//查看上一题是否已经作答
					TestpaperSubject tps = new TestpaperSubject();
					tps.setTpsn(autoTestPaper.getTpsn());
					tps.setSubject(s);
					String answered = tpss.getAnswer(tps);
					System.out.println(answered);
					if(answered!=null) {
						if(answered.equals(s.getOptiona())) {
							System.out.println("选A");
							choice_1.setSelected(true);
						}else if(answered.equals(s.getOptionb())) {
							System.out.println("选B");
							choice_2.setSelected(true);
						}else if(answered.equals(s.getOptionc())) {
							System.out.println("选C");
							choice_3.setSelected(true);
						}else if(answered.equals(s.getOptiond())) {
							System.out.println("选D");
							choice_4.setSelected(true);
						}
					}
					
				} else if(count >= 50 && count < 100){
					Subject s = judges.get(count - 50);
					textArea.setText((count+1) + "、" +s.getStitle());			
					txtrA.setText("");		
					txtrB.setText("");		
					txtrC.setText("");
					txtrD.setText("");
					pic.setIcon(new ImageIcon(s.getPic()));
					System.out.println(s.getPic());
					choice_1.setText("对");
					choice_2.setText("错");
					choice_3.hide();
					choice_4.hide();
					label_4.setText("判断题：请选择对或错");
					TestpaperSubject tps = new TestpaperSubject();
					tps.setTpsn(autoTestPaper.getTpsn());
					tps.setSubject(s);
					String answered = tpss.getAnswer(tps);
					System.out.println(answered);
					if(answered!=null) {
						if(answered.equals(choice_1.getText())) {
							System.out.println("对");
							choice_1.setSelected(true);
						}else if(answered.equals(choice_2.getText())) {
							System.out.println("错");
							choice_2.setSelected(true);
						}
					}
					
					
					
				}
			}
		});
		button.setForeground(Color.RED);
		button.setBackground(Color.WHITE);
		panel_5.add(button);
		
//		SelectedThread st = new SelectedThread(table,time);
//		t2 = new Thread(st);
//		t2.start();
		
		JButton button_1 = new JButton("下一题");
		button_1.setBounds(315, 0, 100, 28);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count == 100) {
					return;
				}
				
				Subject s1 = count<50?choices.get(count):judges.get(count-50);
				String answer = "";
				if(choice_1.isSelected()) {
					answer = count<50?s1.getOptiona():choice_1.getText();
				}
				if(choice_2.isSelected()) {
					answer = count<50?s1.getOptionb():choice_2.getText();
				}
				if(choice_3.isSelected()) {
					answer = s1.getOptionc();
				}
				if(choice_4.isSelected()) {
					answer = s1.getOptiond();
				}
				boolean isAnswer = false;
				if(choice_1.isSelected() || choice_2.isSelected()||choice_3.isSelected()||choice_4.isSelected()) {
					isAnswer = true;
					System.out.println("开始线程");
				}
				//录入答案
				if(isAnswer) {
					TestpaperSubject ts = new TestpaperSubject();
					ts.setTpsn(autoTestPaper.getTpsn());
					ts.setSubject(s1);
					ts.setAnswer(answer);
					String answered = tpss.getAnswer(ts);
					if(answered!=null) {
						tpss.updateAnswer(ts);
					}else{
						boolean addAnswer = tpss.addAnswer(ts);
						if(!addAnswer) {
							JOptionPane.showMessageDialog(null, "答案录入失败，请您联系监考员进行解决");
						}
					}
				}
				bg.clearSelection();
				count++;
				System.out.println("--------count" + count);
				if(count==100) {
					count--;
				}
				if(count<50) {
					Subject s = choices.get(count);
					textArea.setText((count+1) + "、" +s.getStitle());			
					txtrA.setText("A、" + s.getOptiona());		
					txtrB.setText("B、" + s.getOptionb());		
					txtrC.setText("C、" + s.getOptionc());
					txtrD.setText("D、" + s.getOptiond());
					pic.setIcon(new ImageIcon(s.getPic()));
					choice_1.setText("A");
					choice_2.setText("B");
					choice_3.show();
					choice_4.show();
					label_4.setText("选择题：请选择A或B或C或D");
					//是否有答案
					TestpaperSubject tps = new TestpaperSubject();
					tps.setTpsn(autoTestPaper.getTpsn());
					tps.setSubject(s);
					String answered = tpss.getAnswer(tps);
					if(answered!=null) {
						if(answered.equals(s.getOptiona())) {
							System.out.println("选A");
							choice_1.setSelected(true);
						}else if(answered.equals(s.getOptionb())) {
							System.out.println("选B");
							choice_2.setSelected(true);
						}else if(answered.equals(s.getOptionc())) {
							System.out.println("选C");
							choice_3.setSelected(true);
						}else if(answered.equals(s.getOptiond())) {
							System.out.println("选D");
							choice_4.setSelected(true);
						}
					}
				} else if(count >= 50 && count < 100){
					Subject s = judges.get(count - 50);
					textArea.setText((count+1) + "、" +s.getStitle());			
					txtrA.setText("");		
					txtrB.setText("");		
					txtrC.setText("");
					txtrD.setText("");
					choice_1.setText("对");
					choice_2.setText("错");
					choice_3.hide();
					choice_4.hide();
					label_4.setText("判断题：请选择对或错");
					pic.setIcon(new ImageIcon(s.getPic()));
					//是否有答案
					TestpaperSubject tps = new TestpaperSubject();
					tps.setTpsn(autoTestPaper.getTpsn());
					tps.setSubject(s);
					String answered = tpss.getAnswer(tps);
					if(answered!=null) {
						if(answered.equals(choice_1.getText())) {
							choice_1.setSelected(true);
						}else if(answered.equals(choice_2.getText())) {
							choice_2.setSelected(true);
						}
					}
				}
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setForeground(Color.RED);
		panel_5.add(button_1);
		
		t = new Thread(new Countdown(time,tip_time,this,choice_1,choice_2,choice_3,choice_4));
		t.start();
		
		
		
		
		
		JButton button_2 = new JButton("交卷");
		button_2.setBounds(425, 0, 100, 28);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//强制交卷
				handInTestPaper(count,choices,judges,
						choice_1,choice_2,choice_3,choice_4,
						autoTestPaper,tpss,testPaperService
						);
				t.stop();
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setForeground(Color.RED);
		panel_5.add(button_2);
				
		
		
		
		
	}
	
	public void handInTestPaper(int count,List<Subject> choices,List<Subject> judges,
			JRadioButton choice_1,JRadioButton choice_2,JRadioButton choice_3,JRadioButton choice_4,
			TestPaper autoTestPaper,TestPaperSubjectService tpss,TestPaperService testPaperService
			) {
		System.out.println("count" + count);
		if(count==100) {
			count--;
		}
		Subject s1 = count<50?choices.get(count):judges.get(count-50);
		String answer = "";
		if(choice_1.isSelected()) {
			answer = count<50?s1.getOptiona():choice_1.getText();
		}
		if(choice_2.isSelected()) {
			answer = count<50?s1.getOptionb():choice_2.getText();
		}
		if(choice_3.isSelected()) {
			answer = s1.getOptionc();
		}
		if(choice_4.isSelected()) {
			answer = s1.getOptiond();
		}
		boolean isAnswer = false;
		if(choice_1.isSelected() || choice_2.isSelected()||choice_3.isSelected()||choice_4.isSelected()) {
			isAnswer = true;
		}
		//录入答案
		if(isAnswer) {
			TestpaperSubject ts = new TestpaperSubject();
			ts.setTpsn(autoTestPaper.getTpsn());
			ts.setSubject(s1);
			ts.setAnswer(answer);
			String answered = tpss.getAnswer(ts);
			if(answered!=null) {
				tpss.updateAnswer(ts);
			}else{
				boolean addAnswer = tpss.addAnswer(ts);
				if(!addAnswer) {
					JOptionPane.showMessageDialog(null, "答案录入失败，请您联系监考员进行解决");
				}
			}
		}
		int autoScore = testPaperService.autoScore(autoTestPaper);
		JOptionPane.showMessageDialog(null, "您的分数是" + autoScore);
		UserTestView.this.dispose();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public TestPaperService getTestPaperService() {
		return testPaperService;
	}

	public void setTestPaperService(TestPaperService testPaperService) {
		this.testPaperService = testPaperService;
	}

	public TestPaper getAutoTestPaper() {
		return autoTestPaper;
	}

	public void setAutoTestPaper(TestPaper autoTestPaper) {
		this.autoTestPaper = autoTestPaper;
	}

	public List<Subject> getChoices() {
		return choices;
	}

	public void setChoices(List<Subject> choices) {
		this.choices = choices;
	}

	public List<Subject> getJudges() {
		return judges;
	}

	public void setJudges(List<Subject> judges) {
		this.judges = judges;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	public TestPaperSubjectService getTpss() {
		return tpss;
	}

	public void setTpss(TestPaperSubjectService tpss) {
		this.tpss = tpss;
	}
}
