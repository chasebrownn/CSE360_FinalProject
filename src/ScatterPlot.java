import java.awt.*;
import javax.swing.*;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterPlot extends JFrame {
    //dataset
    XYDataset rosterData = createDataset();

    public ScatterPlot(String roster) {
        super(roster);

        //Create chart
        JFreeChart chart = ChartFactory.createScatterPlot("Roster",
                "X-Axis", "Count", rosterData);

        //Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    //create the plot points in the chart
    private XYDataset createDataset() {
        XYSeriesCollection rosterData = new XYSeriesCollection();

        //November 3rd
        XYSeries series1 = new XYSeries("November 3");

        series1.add(1, 10); //(count, X-axis)
        rosterData.addSeries(series1);

        //November 10th
        XYSeries series2 = new XYSeries("November 10");
        series2.add(1, 10);
        series2.add(2, 15);

        rosterData.addSeries(series2);
        return rosterData;
    }

}



