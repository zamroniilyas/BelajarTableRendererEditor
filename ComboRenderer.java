import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ComboRenderer implements TableCellRenderer{

//    private JComboBox comboBox;

//    public ComboRenderer(JComboBox comboBox) {
//        this.comboBox = comboBox;
//    }
                                
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComboBox comboBox = new JComboBox();
        
        comboBox.setSelectedItem(value);
        return comboBox;
    }
    
}
