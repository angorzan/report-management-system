package utilities;

import java.io.IOException;
import java.util.ArrayList;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.ChartTheme;

import reports.EmployeeProjectEngagementReport;

public class PiecakeChart {
	
    private static ArrayList<String> data;
    public static void saveChart(String path, EmployeeProjectEngagementReport raport) throws IOException {

        data = raport.getData();
        PieChart chart = getChart();
        BitmapEncoder.saveBitmapWithDPI(chart, path, BitmapEncoder.BitmapFormat.JPG, 400);
    }

	  public static PieChart getChart() throws IOException {
		  
		    // Create Chart
		  	PieChart chart = new PieChartBuilder().width(800).height(600).title("Procentowy udzial w projektach").theme(ChartTheme.GGPlot2).build();
		    // Customize Chart
		    chart.getStyler().setLegendVisible(false);
		    chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
		    chart.getStyler().setAnnotationDistance(1.15);
		    chart.getStyler().setPlotContentSize(.7);
		    chart.getStyler().setStartAngleInDegrees(90);

		    // Series
	        for (String key : data) {
	        	String[] hash = key.split("#");
	        	chart.addSeries(hash[0], Float.parseFloat(hash[1]));
	        }
		    
			return chart;
	  }

	}
