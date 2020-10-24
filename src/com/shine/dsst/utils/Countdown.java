package com.shine.dsst.utils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.shine.dsst.view.UserTestView;

public class Countdown implements Runnable{
	private int time;
	private JLabel tip_time;
	private boolean flag = true;
	private UserTestView utv;
	private JRadioButton choice_1;
	private JRadioButton choice_2;
	private JRadioButton choice_3;
	private JRadioButton choice_4;
	public Countdown() {
		
	}
	public Countdown(int time,JLabel tip_time,UserTestView utv,JRadioButton choice_1,JRadioButton choice_2,JRadioButton choice_3,JRadioButton choice_4) {
		this.tip_time = tip_time;
		this.time = time;
		this.utv = utv;
		this.choice_1 = choice_1;
		this.choice_2 = choice_2;
		this.choice_3 = choice_3;
		this.choice_4 = choice_4;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public void run() {
		while(time>0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int minutes = time / 60;
			if(minutes == 41) {
				minutes = 0;
				time = 10;
			}
			String s_minutes = String.valueOf(minutes);
			if(minutes<10 & minutes >=0) {
				s_minutes = 0 + s_minutes;
			}
			
			//剩余的秒数
			int seconds = time % 60;
			String s_seconds = String.valueOf(seconds);
			if(seconds<10 & seconds >=0) {
				s_seconds = 0 + s_seconds;
			}
			tip_time.setText(s_minutes + ":" + s_seconds);
			time--;
		}
		if(time==0) {
			tip_time.setText("00:00");
			JOptionPane.showMessageDialog(null, "时间到，已强制交卷");
			if(utv.getCount()<50) {
				choice_1.setText("A");
				choice_2.setText("B");
			} else if(utv.getCount()>=50 && utv.getCount()<100) {
				choice_1.setText("对");
				choice_2.setText("错");
			}
			utv.handInTestPaper(utv.getCount(), utv.getChoices(), utv.getJudges(),
					choice_1, choice_2, choice_3, choice_4, 
					utv.getAutoTestPaper(), utv.getTpss(), utv.getTestPaperService());
		}
		
		
	}

}
