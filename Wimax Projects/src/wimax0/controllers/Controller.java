/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimax0.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import core.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Amine
 */
public class Controller implements Initializable {
    //inputs
    
     @FXML
    private TextField input_cycles;

    @FXML
    private TextField input_users;

    @FXML
    private TextField input_resources;

    @FXML
    private TextField input_be;

    @FXML
    private TextField input_rt;

    @FXML
    private TextField input_nrt;

    @FXML
    private TextField input_delay_rt;

    @FXML
    private Button btn_start_simulation;
    
    //Menu
    @FXML
    private Button menu_inputs;

    @FXML
    private Button menu_results;

    @FXML
    private Button menu_cycles;

    @FXML
    private Button menu_compare;
    
    @FXML
    private Button menu_user;
    
    //Pans
    @FXML
    private Pane pane_compare;
        
    @FXML
    private Pane pane_cycle;
    
    @FXML
    private Pane pane_results;
    
    @FXML
    private Pane pane_inputs;
    
    @FXML
    private Pane pane_user;
    
    //results
    @FXML
    private ListView<Label> res_list;
    
    @FXML
    private ComboBox<String> res_combox;
    
    @FXML
    private TableView<?> res_table;
    
    @FXML
    private LineChart<?, ?> res_line;
    
    //Cycle
    @FXML
    private PieChart cyc_pie_stat;
    
    @FXML
    private PieChart cyc_pie_entries;
    
    @FXML
    private PieChart cyc_col_be;

    @FXML
    private PieChart cyc_col_rt;

    @FXML
    private PieChart cyc_col_nrt;
    
    @FXML
    private ComboBox<?> cyc_combox;
     
    @FXML
    private TextField cyc_val;
    
    @FXML
    private TextField inp_be_min;

    @FXML
    private TextField inp_be_max;

    @FXML
    private TextField inp_rt_min;

    @FXML
    private TextField inp_rt_max;

    @FXML
    private TextField inp_nrt_min;

    @FXML
    private TextField inp_nrt_max;

    @FXML
    private Label user_class;

    @FXML
    private Label user_maxcol;

    @FXML
    private Label user_cdma;

    @FXML
    private Label user_taille;

    @FXML
    private Label user_tailec;

    @FXML
    private Label user_sejours;

    @FXML
    private TextField user_inp_cycle;

    @FXML
    private TextField user_inp_id;
    
    @FXML
    private Label title_id;

    

    private TableController table;
    private ToolsController tools;
    private LineChartController line;
    private PieChartsControllers pies;
    private UserController user;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table= new TableController(res_table);
        tools = new ToolsController(res_list, res_combox);
        line = new LineChartController(res_line);
        pies = new PieChartsControllers(cyc_pie_stat, cyc_pie_entries, cyc_col_be, cyc_col_rt, cyc_col_nrt);
        pies.setComb(cyc_combox);
        user = new UserController(user_class, user_maxcol, user_cdma, user_taille, user_tailec, user_sejours);
   } 
    
    @FXML
    private void handleStartSimulation(ActionEvent event) {
        try{
        Config.NumberofCycles = Integer.parseInt(input_cycles.getText());
        Config.NumberofUsers = Integer.parseInt(input_users.getText());
        Config.Ressource = Integer.parseInt(input_resources.getText());
        Config.TailleBE = Integer.parseInt(input_be.getText());
        Config.TailleNRT = Integer.parseInt(input_nrt.getText());
        Config.TailleRT = Integer.parseInt(input_rt.getText());
        Config.DelaiRT = Integer.parseInt(input_delay_rt.getText());
        
        BE.setCDMAmin(Integer.parseInt(inp_be_min.getText()));
        BE.setCDMAmin(Integer.parseInt(inp_be_max.getText()));
        RT.setCDMAmin(Integer.parseInt(inp_rt_min.getText()));
        RT.setCDMAmin(Integer.parseInt(inp_rt_max.getText()));
        NRT.setCDMAmin(Integer.parseInt(inp_nrt_min.getText()));
        NRT.setCDMAmin(Integer.parseInt(inp_nrt_max.getText()));
        
        Bts.addCycle();
        Bts.runBts();
        pane_results.toFront();
        }catch(Exception ex){
            System.out.println("erroe in inputs : " + ex);
        }
    }
    
    @FXML
    private void handleClicks(ActionEvent event){
        
        if(event.getSource() == menu_inputs){
            pane_inputs.toFront();
            
        }else if(event.getSource() == menu_results){
             pane_results.toFront();  
        }else if(event.getSource() == menu_cycles){
            pane_cycle.toFront();
            
        }else if(event.getSource() == menu_compare){
            pane_compare.toFront(); 
            
        }else if(event.getSource() == menu_user){
            pane_user.toFront(); 
        }        
    }
    
    @FXML
    void getUser(ActionEvent event) {
        try{
            user.fill(Integer.parseInt(user_inp_cycle.getText()), Integer.parseInt(user_inp_id.getText()));
        }catch(Exception ex){
            System.out.println("Wrrong inputs");
        }
    }
    
    @FXML
    private void handleClose(){
        System.exit(0);
    }
    
    @FXML
    private void removeColumn() {
        if(res_list.getSelectionModel().getSelectedIndex()>=0){
            String text = tools.removeFromList();
            table.removeColumn(text);
            line.removeLine(text);
        }
    }
    
    @FXML
    private void AddColumn(ActionEvent event) {
        if(!res_combox.getValue().equals("")){
            String text = tools.addToList();
            table.addColumn(text);
            if(text!="CycleId")line.addLine(text);
        }
    }
    
    @FXML
    void showCycle(ActionEvent event) {
        try{
        pies.setCycle(Integer.parseInt(cyc_val.getText()));
        }catch(Exception ex){
            System.out.println("Wrrong input");
        }
    }

    @FXML
    void updatePies(ActionEvent event) {
        pies.update();
    }
   
}
