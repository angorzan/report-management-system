package utilities;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.style.Styler;
import reports.ProjectSummaryHoursReport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class BarChart {

    private static Map<String, Float> data;
    public static void saveChart(String path, ProjectSummaryHoursReport raport) throws IOException {

        data = raport.getData();
        CategoryChart chart = getChart();
        BitmapEncoder.saveBitmapWithDPI(chart, path, BitmapEncoder.BitmapFormat.JPG, 400);
    }



    public static CategoryChart getChart() {

        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).xAxisTitle("Realizowane projekty").yAxisTitle("Liczba godzin pracy nad projektem").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);

        // Series
        ArrayList<String> xData = new ArrayList<>();
        ArrayList<Float> yData = new ArrayList<>();
        for (String key : data.keySet()) {

            xData.add(key);
            yData.add(data.get(key));
        }
        chart.addSeries("Liczba godzin", xData, yData);

        return chart;
    }

}
