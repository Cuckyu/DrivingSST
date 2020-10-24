package com.shine.dsst.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class EvenOddRenderer implements TableCellRenderer{
	public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);
		Color foreground, background;

		if (row == 2 && column == 2) {
			foreground = Color.red;
			background = Color.BLUE;
		} else {
			foreground = Color.BLACK;
			background = Color.WHITE;
		}
		renderer.setForeground(foreground);
		renderer.setBackground(background);
		return renderer;
	}
}
