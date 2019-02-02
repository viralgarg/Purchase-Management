import javax.swing.table.AbstractTableModel;

public abstract class MyTableModel extends AbstractTableModel {

    public boolean isCellEditable(int row, int column){  
        return false;  
    }

}
