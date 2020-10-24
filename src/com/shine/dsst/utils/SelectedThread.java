package com.shine.dsst.utils;

import javax.swing.JTable;

import com.shine.dsst.view.SelectedRenderer;

public class SelectedThread implements Runnable{
	private int time;
	private JTable table ;
	private int row;
	private int column;
	private boolean flag = false;

	public SelectedThread(){
		
	}
	public SelectedThread(JTable table,int time){
		this.table = table;
		this.time = time;
	}
	@Override
	public void run() {
		while(time>0) {
			System.out.println("row:" + row + " column:" + column);
			if(flag) {
				SelectedRenderer sr = new SelectedRenderer(row,column);
				this.table.setDefaultRenderer(Object.class, sr);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time--;
		}
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	

}
