import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *  ScatterPlot.java is used for our "Plot Data" requirement. In this method our goal is to
 *  create a chart using the attendance data per student. Specifically, a Scatter Plot.
 *  Y-axis is how many students (0,n). X-axis is % of attendance ranging (0, 100), given
 *  that 100% is attendance of 75min+.
 *
 *  To achieve this we extend JFrame and add a new Jpanel where we create a JFreeChart
 *  using the mandatory JFreeChart library.
 */

public class ScatterPlot extends JFrame {

    //attendance table array


    //dataset creation
    XYDataset attendanceData = createDataset();

    public ScatterPlot(String attendance) {
        super(attendance);

        JPanel jPanel = new JPanel();

        //Create chart
        JFreeChart chart = ChartFactory.createScatterPlot("Students vs Attendance %",
                "% of Attendance", "Count of students", attendanceData);

        //background color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255,228,196));

        //Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    /** create the plot points in the chart
     * Y-axis is how many students (0 to total row)
     * X-axis is % of attendance (100% is 75 minutes or more)
     */
    private XYDataset createDataset() {
        //roster series creation
        XYSeriesCollection attendanceData = new XYSeriesCollection();

        /** Checks to see if mainTable has attendance column
         */
        if(MainFrame.mainTable.getValueAt(0,6) != null)
        {
                    XYSeries series = new XYSeries(MainFrame.mainTable.getColumnName(6));

                    /** Iterates for the row size*/
                    for(int x = 0; x < MainFrame.mainTable.getRowCount(); x++){
                        /** Creates a double for the attendance percent and parses the value as a
                         * string for the current index */
                        double attendancePercent = Double.parseDouble((String) MainFrame.mainTable.getValueAt(x,6));

                        /** Creates the percent and scales it to 100 */
                        attendancePercent = (attendancePercent / 75) * 100;

                        /** adds attendence percent to series depending on it
                         * it is more 100 or less than 100 */
                        if(attendancePercent < 100)
                            series.add(attendancePercent, x + 1);
                        else
                            series.add(100, x + 1);
                    }
                attendanceData.addSeries(series);
        }

        return attendanceData;
    }

}


