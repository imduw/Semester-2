package client.view.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableHeaderRenderer extends DefaultTableCellRenderer{
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        //màu nền cho header
        label.setBackground(new Color(44,162,175)); 
        
        //màu chữ cho header
        label.setForeground(new Color(255, 255, 255));
        //label.setPreferredSize(new Dimension(label.getWidth(), 30));
        label.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15)); 
        label.setPreferredSize(new Dimension(label.getWidth(), 30));
        
        //căn giữa cho header
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        return label;
    }
}