/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimax0.controllers;

import core.Config;
import core.OCycle;
import core.Results;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;

/**
 *
 * @author Amine
 */
public class LineChartController {
    
    private LineChart line;
    private Map<String, XYChart.Series> sets;

    public LineChartController(LineChart line) {
        this.line = line;
        sets = new HashMap<String, XYChart.Series>();
    }
   
    public void addLine(String str){
        XYChart.Series set1 = new XYChart.Series<>();
        for(int i = 0; i< Results.cycles.size(); i++){
            set1.getData().add(new XYChart.Data<>(i+"",Results.getVal(str, i)));
        }
        set1.setName(str);
        line.getData().add(set1);
        sets.put(str, set1);
    }
    
    public void removeLine(String str){
        line.getData().remove(sets.get(str));
    }
}
