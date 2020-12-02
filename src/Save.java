import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

/**
 *  Save.java is used for our "Save" requirement. In this method our goal is to
 *  create a savable .csv file that a user can store on their computer. The .csv takes
 *  our JTable and all the information and translates it into a csv format and then writes it to
 *  a downloadable aka savable.
 */

public class Save
{
    public void JtableToCSV(JTable table) throws IOException {
        JFileChooser fc = new JFileChooser(); // Maps path from java to documents
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            TableModel model = table.getModel(); // creates table model
            FileWriter csv = new FileWriter(fc.getSelectedFile()+".csv"); // Selects .csv file for writing
            BufferedWriter bw = new BufferedWriter(csv);

            for (int Column = 0; Column < model.getColumnCount(); Column++) { // Iterates through Jtable for data and prints it on selected file
                if (Column > 0) {
                    bw.write(",");
                }
                bw.write(model.getColumnName(Column));
            }
            for (int row = 0; row < model.getRowCount(); row++) {
                bw.newLine();
                for (int column = 0; column < model.getColumnCount(); column++) {
                    if (column > 0) {
                        bw.write(",");
                    }
                    bw.write(model.getValueAt(row, column).toString()); //Writes Jtable data onto CSV file
                }
            }
            bw.close();

        }
    }
}

