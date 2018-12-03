/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimax0.controllers;

import core.Config;
import core.Results;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Amine
 */

public class PieChartsControllers {
    private PieChart pie_stat,pie_users;
    
    private PieChart pie_col_be, pie_col_rt,pie_col_nrt;
    
    private ComboBox comb;

    public void setComb(ComboBox comb) {
        this.comb = comb;
        fillComboBox();
    }
    
//    private PieChar 

    int cycle;
    public void setCycle(int cycle) {
        this.cycle = cycle;
        fillPieStat();
        fillPieUsers();
        if(comb.getValue()==null || comb.getValue().equals("")){
            fillPieColBE();
            fillPieColRT();
            fillPieColNRT();
        }else update();
    }

    public PieChartsControllers(PieChart pie_stat, PieChart pie_users, PieChart pie_col_be, PieChart pie_col_rt, PieChart pie_col_nrt) {
        this.pie_stat = pie_stat;
        this.pie_users = pie_users;
        this.pie_col_be = pie_col_be;
        this.pie_col_rt = pie_col_rt;
        this.pie_col_nrt = pie_col_nrt;
    }
    
    public void fillPieStat(){
        int[] val = new int[]{Integer.parseInt(Results.cycles.get(cycle).getUsersBEstart()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersRTstart()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersNRTstart()),
        };
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        pieChartData.add(new PieChart.Data("BE "+val[0], val[0]));
        pieChartData.add(new PieChart.Data("RT "+val[1], val[1]));
        pieChartData.add(new PieChart.Data("NRT "+val[2], val[2]));
        
        pie_stat.setData(pieChartData);
    }
    
    public void fillPieUsers(){
        int[] val = new int[]{Results.cycles.get(cycle).getBeAfterBO(),
                    Results.cycles.get(cycle).getRtAfterBO(),
                    Results.cycles.get(cycle).getNrtAfterBO(),
        };

        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        pieChartData.add(new PieChart.Data("BE "+val[0], val[0]));
        pieChartData.add(new PieChart.Data("RT "+val[1], val[1]));
        pieChartData.add(new PieChart.Data("NRT "+val[2], val[2]));
        
        pie_users.setData(pieChartData);
    }
    
    public void fillPieColBE(){
        int[] val = new int[]{Integer.parseInt(Results.cycles.get(cycle).getUsersBE()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersBEbackoff()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersBEabandon()),
        };
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        pieChartData.add(new PieChart.Data("After Collision "+val[0], val[0]));
        pieChartData.add(new PieChart.Data("BackOff "+val[1], val[1]));
        pieChartData.add(new PieChart.Data("Abandon "+val[2], val[2]));
        
        pie_col_be.setData(pieChartData);
    }
    
    
    public void fillPieColRT(){
        int[] val = new int[]{Integer.parseInt(Results.cycles.get(cycle).getUsersRT()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersRTbackoff()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersRTabandon()),
        };
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        pieChartData.add(new PieChart.Data("After Collision "+val[0], val[0]));
        pieChartData.add(new PieChart.Data("BackOff "+val[1], val[1]));
        pieChartData.add(new PieChart.Data("Abandon "+val[2], val[2]));
        
        pie_col_rt.setData(pieChartData);
    }
    
    
    public void fillPieColNRT(){
        int[] val = new int[]{Integer.parseInt(Results.cycles.get(cycle).getUsersNRT()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersNRTbackoff()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersNRTabandon()),
        };
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        pieChartData.add(new PieChart.Data("After Collision "+val[0], val[0]));
        pieChartData.add(new PieChart.Data("BackOff "+val[1], val[1]));
        pieChartData.add(new PieChart.Data("Abandon "+val[2], val[2]));
        
        pie_col_nrt.setData(pieChartData);
    }
    
      public void fillPieResBE(){
        int[] val = new int[]{
                    Integer.parseInt(Results.cycles.get(cycle).getUsersBEdone()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersBEpropa())
        };
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        pieChartData.add(new PieChart.Data("Done "+val[0], val[0]));
        pieChartData.add(new PieChart.Data("Still "+val[1], val[1]));
        
        pie_col_be.setData(pieChartData);
    }
    
    
    public void fillPieResRT(){
        int[] val = new int[]{Integer.parseInt(Results.cycles.get(cycle).getUsersRTechec()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersRTdone()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersRTpropa())
        };
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        pieChartData.add(new PieChart.Data("Failed "+val[0], val[0]));
        pieChartData.add(new PieChart.Data("Done "+val[1], val[1]));
        pieChartData.add(new PieChart.Data("Still "+val[2], val[2]));
        
        pie_col_rt.setData(pieChartData);
    }
    
    
    public void fillPieResNRT(){
        int[] val = new int[]{
                    Integer.parseInt(Results.cycles.get(cycle).getUsersNRTdone()),
                    Integer.parseInt(Results.cycles.get(cycle).getUsersNRTpropa()),
        };
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        pieChartData.add(new PieChart.Data("Done "+val[0], val[0]));
        pieChartData.add(new PieChart.Data("Still "+val[1], val[1]));
        
        pie_col_nrt.setData(pieChartData);
    }
    
    private void fillComboBox(){    
        comb.getItems().add("Collision");
        comb.getItems().add("Deviding Ressources");
    }
    
    public void update(){
        if(comb.getValue()=="Collision"){
            fillPieColBE();
            fillPieColRT();
            fillPieColNRT();
        }else{
            fillPieResBE();
            fillPieResRT();
            fillPieResNRT();
        }
    }
}
