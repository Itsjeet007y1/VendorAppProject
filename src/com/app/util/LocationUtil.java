package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class LocationUtil {
	public void generatePieChart(String path,List<Object[]> data) {
		//1 create dataSet
		DefaultPieDataset dataSet=new DefaultPieDataset();
		for(Object[] ob: data) {
			//key(String), value(Double)
			dataSet.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//2.create JFreeChart object
		//(title,dataset,legend,tooltip,url)
		JFreeChart chart=ChartFactory.createPieChart3D("Location Pie Chart Report", dataSet, true, true,false);
		//3. save as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/ReportPieLoc.jpg"), chart,400, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//method end
	
	//Bar char generation method
	public void generateBarChart(String path, List<Object[]> data) {
		//1.create dataSet
		DefaultCategoryDataset dataSet=new DefaultCategoryDataset();
		for(Object[] ob:data) {
			dataSet.setValue(new Double(ob[1].toString()), ob[0].toString(),"");
		}
		//2. create JFreeChart
		JFreeChart chart=ChartFactory.createBarChart3D("Location Bar Chart Report", "Location Types", "count", dataSet);
		//3. save the image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/ReportBarLoc.jpg"), chart, 400, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
