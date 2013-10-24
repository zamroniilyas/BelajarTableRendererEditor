import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Chromatics
 */
public class TanggalRenderer extends DefaultTableCellRenderer{
    private SimpleDateFormat dateFormat;

    public TanggalRenderer() {
        dateFormat = new SimpleDateFormat("dd MMMM yyyy");
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        if (value instanceof Date) {
            Date tanggal = (Date) value;
            String tanggalString = dateFormat.format(tanggal);
            
            label.setText(tanggalString);
        }
        
        return label;
    }     
}
