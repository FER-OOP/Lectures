package hr.fer.oop.generictable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * A scrollable panel with a table of records of type T.
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 * @param <T> The type of records.
 */
public class GenericTablePanel<T> extends JPanel {

    private final JScrollPane scrollPane;
    private final JTable table;

    /**
     * Creates a new scrollable panel with an empty table. Only public attributes of tClass are added to the table.
     * @param tClass The class of records.
     */
    public GenericTablePanel(Class<T> tClass) {
        //set border layout
        super.setLayout(new BorderLayout());

        //create and fill the table
        table = new JTable(new GenericTableModel(tClass));

        //create a sorter for the table
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        scrollPane = new JScrollPane(table);
        super.add(scrollPane);
    }
    
    /**
     * Updates table content and revalidates the panel.
     * @param records The records to put in the table.
     */
    public void update(List<T> records) {
        ((GenericTableModel) table.getModel()).setData(records);
        table.invalidate();
        this.revalidate();
    }
    
    /**
     * Get a list of records that are currently shown in the table. 
     * @return The list of shown records.
     */
    public List<T> getRecords() {
        return ((GenericTableModel) table.getModel()).getData();
    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        setColumnSizes(preferredSize.getWidth());
        super.setPreferredSize(preferredSize);
    }
    
    /**
     * Sets the same width for all columns.
     * @param width The width in pixels.
     */
    private void setColumnSizes(double width) {
        //set column sizes
        for (int i = 0; i < table.getModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setMinWidth((int) (width / table.getModel().getColumnCount()));
        }
    }

    private class GenericTableModel extends AbstractTableModel {

        List<T> records;
        private final Class<T> tClass;
        Field[] fields;

        private GenericTableModel(Class<T> tClass) {
            this.records = new ArrayList<>();
            this.tClass = tClass;
            this.fields = tClass.getFields();
        }

        @Override
        public int getRowCount() {
            return records.size();
        }

        @Override
        public int getColumnCount() {
            return fields.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try {
                return fields[columnIndex].get(records.get(rowIndex));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            return fields[column].getName();
        }
        
        private void setData(List<T> records) {
            this.records = records;
        }
        
        private List<T> getData() {
            return records;
        }
    }
}
