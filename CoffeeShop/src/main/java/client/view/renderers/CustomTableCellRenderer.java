package client.view.renderers;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

 public class CustomTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set background color for odd rows
        if (row % 2 == 1) {
            c.setBackground(new Color(32,36,38)); 
        } else {
            c.setBackground(new Color(20,23,24)); 
        }
        
        ((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
		return c;
		
        
        
	}
	

}
