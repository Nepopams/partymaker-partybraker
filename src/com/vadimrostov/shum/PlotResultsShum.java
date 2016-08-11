package com.vadimrostov.shum;

import java.awt.Color;
import java.awt.BasicStroke;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

/**
 * Created by uad on 09.08.2016.
 */
public class PlotResultsShum extends ApplicationFrame{

    public PlotResultsShum( String applicationTitle, String chartTitle ,HashMap<Double,Double>map)
    {
        super(applicationTitle);
        try{ JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Category" ,
                "Score" ,
                createDataset(map) ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        int width = 640;
        int height = 480;
        File XYChart = new File( "XYLineChart.jpeg" );
        ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);}
       catch (IOException c){

       }
    }

    private XYDataset createDataset(HashMap<Double,Double>map)
    {
        final XYSeries psgak = new XYSeries( "PSGAK" );
        for(Map.Entry<Double,Double> pair:map.entrySet()){
        psgak.add(pair.getKey(),pair.getValue());
        }

        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( psgak );

        return dataset;
    }



}
