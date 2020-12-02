import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFileChooser;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;


public class Save
{
    public String  fileName = "output.csv";

    public void JtableToCSV(JTable table) throws IOException
    {
        JFileChooser fc = new JFileChooser(); // Directs your file path from java to documents
        int returnVal = fc.showSaveDialog(null); // Directs the GUI interaction
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {

            TableModel model = table.getModel(); // creates table model

            FileWriter csv = new FileWriter(fc.getSelectedFile()+".csv"); // will select a file from documents

            BufferedWriter bw = new BufferedWriter(csv);

            for (int Column = 0; Column < model.getColumnCount(); Column++) // searches Jtable for data and prints it on selected file
            {
                if (Column > 0) {
                    bw.write(",");
                }
                bw.write(model.getColumnName(Column));
            }
            for (int row = 0; row < model.getRowCount(); row++) // searches Jtable for data and prints it on selected file
                // {
                bw.newLine();
                for (int column = 0; column < model.getColumnCount(); column++) // searches Jtable for data and prints it on selected file
                {
                    if (column > 0) {
                        bw.write(",");
                    }
                    bw.write(model.getValueAt(row, column).toString()); //prints Jtable data onto CSV file
                }
            }
            bw.close();


        }
    }


}

