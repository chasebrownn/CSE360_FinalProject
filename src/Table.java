import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * The Table.java class is used for building the table you see once you load the student roster.
 * It builds the table by using the JTable frame which is then added to our main table model and given headers.
 * It is then filled with the information (outside of this class) that is pulled from the loaded .csv file which
 * is sorted amongst the 6 categories listen in the table header.
 */

public class Table extends JFrame {

    JTable frame = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll;
    String headers[] = {"ID", "First Name", "Last Name", "Program", "Level", "ASURITE"};

    public Table (List<Roster> roster)
    {
        model.setColumnIdentifiers(headers);
        frame.setModel(model);
        scroll = new JScrollPane(frame);

        for (int i = 0; i < roster.size(); i++) {
            model.addRow(new Object[]
                    { roster.get(i).getId(),
                    roster.get(i).getFirstName(),
                    roster.get(i).getLastName(),
                    roster.get(i).getMajor(),
                    roster.get(i).getLevel(),
                    roster.get(i).getAsurite() });
        }

        frame.add(scroll, BorderLayout.CENTER);
        frame.setSize(954, 300);
        frame.setVisible(true);

    }
}

/*
JTable  table = new JTable();
  DefaultTableModel model = new DefaultTableModel();
  JScrollPane scroll;
  String headers[] = { "col1", "col2" };
  String[] data = { "AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ",
      "KK", "LL", "MM", "NN", "OO", "PP", "QQ", "RR" };

      public Main() {
    model.setColumnIdentifiers(headers);
    table.setModel(model);
    scroll = new JScrollPane(table);

    insert();

    add(scroll, BorderLayout.CENTER);
    setSize(300, 300);
    setVisible(true);
  }
 */

/*
public void insert() {
    ArrayList<String> ar = new ArrayList<String>();
    for (int i = 0; i < data.length; i++) {
      ar.add(data[i]);
    }

    for (int i = 0; i < (ar.size() / 2); i++) {
      model.addRow(new Object[] { String.valueOf(ar.get(2 * i)),
          String.valueOf(ar.get((2 * i) + 1)) });
    }
  }
 */