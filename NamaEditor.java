import absensi.component.filter.JTextFieldFilter;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Chromatics
 */
public class NamaEditor extends AbstractCellEditor implements TableCellEditor{

    private JTextField textField;

    public NamaEditor(JTextField textField) {
        this.textField = textField;
        textField.setDocument(new JTextFieldFilter(JTextFieldFilter.ALPHABETIC, 20));
    }
    
    @Override
    public Object getCellEditorValue() {
        return textField.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        textField.setText((String) value);
        return textField;
    }
    
}
