/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimax0.controllers;

import core.Bts;
import core.Config;
import core.Cycle;
import core.OCycle;
import core.Results;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Amine
 */
public class TableController {
    
    private ArrayList<OCycle> cycles = new ArrayList<>();
    
    private ArrayList<String> columns = new ArrayList<String>();

    private final TableView<OCycle> table;
    
    public TableController(TableView table) {
        this.table = table;
        initTableView();
        columns.add("CycleId");
        reloadTable();
    }
    
    public void initTableView(){
    }
    
    public void addColumn(String col){
        if(!columns.contains(col)){
            columns.add(col);
            reloadTable();
        }

    }
    
    public void removeColumn(String col){
        if(columns.contains(col) && columns.size()>1){
            columns.remove(col);
            reloadTable();
        }
    }
    private void reloadTable(){
        table.getColumns().clear();
        table.getItems().clear();
        for(String s:columns){
            TableColumn nameColumn = new TableColumn(s);
            nameColumn.setCellValueFactory(new PropertyValueFactory<>(s));
            table.getColumns().add(nameColumn);
        }
        LoadData();
        
    }
    private void LoadData(){
        table.getItems().addAll(Results.cycles);
    }
    
}
