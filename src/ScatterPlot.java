import java.awt.*;
import javax.swing.*;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterPlot extends JFrame {
    //dataset creation
    XYDataset rosterData = createDataset();

    public ScatterPlot(String roster) {
        super(roster);

        //Create chart
        JFreeChart chart = ChartFactory.createScatterPlot("Roster",
                "X-Axis", "Count", rosterData);

        //background color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255,228,196));

        //Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    /** create the plot points in the chart
     *
     * Y-axis is how many students (0 to total row)
     * X-axis is % of attendance (100% is 75 minutes or more)
     */
    private XYDataset createDataset() {
        //roster series creation
        XYSeriesCollection rosterData = new XYSeriesCollection();

        //November 3rd data points
        XYSeries series1 = new XYSeries("November 3");

        series1.add(1, 10);
        rosterData.addSeries(series1);

        //November 10th data points
        XYSeries series2 = new XYSeries("November 10");
        series2.add(1, 10);
        series2.add(2, 15);

        rosterData.addSeries(series2);
        return rosterData;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScatterPlot plot = new ScatterPlot("Roster Scatterplot");
            plot.setSize(800, 400);
            plot.setLocationRelativeTo(null);
            plot.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            plot.setVisible(true);
        });
    }
}


