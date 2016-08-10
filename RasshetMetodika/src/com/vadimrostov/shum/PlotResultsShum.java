package com.vadimrostov.shum;

import java.awt.Color;
import java.awt.BasicStroke;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartPanel;
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
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Category" ,
                "Score" ,
                createDataset(map) ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xylineChart.getXYPlot( );
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );

        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );

        plot.setRenderer( renderer );
        getContentPane().add(chartPanel );
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
