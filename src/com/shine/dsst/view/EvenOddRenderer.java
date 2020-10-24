package com.shine.dsst.view;

import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class EvenOddRenderer implements TableCellRenderer {

	private int row;
	private int column;
	
	
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

	public EvenOddRenderer() {
		super();
	}

	public EvenOddRenderer(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public static DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);
		Color foreground, background;
		if (row == this.row && column == this.column) {
			Color c = new Color(230,230,255);
			foreground = Color.black;
			System.out.println("改变颜色");
			background = c;
		} else {
			foreground = Color.BLACK;
			background = Color.WHITE;
		}
		renderer.setForeground(foreground);
		renderer.setBackground(background);
		return renderer;
	}
}
