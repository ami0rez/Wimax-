/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimax0.controllers;

import core.Config;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author Amine
 */
public class ToolsController {
    
    private ListView<Label> list;
    private ComboBox<String> combox;

    public ToolsController(ListView<Label> list, ComboBox<String> combox) {
        this.list = list;
        this.combox = combox;
        fillComboBox();
    }
    
    public String addToList(){
        String text = combox.getValue();
        addInList(text);
        removeFromComboBox(text);
        return text;
    }
    
    public String removeFromList(){
        String text =list.getSelectionModel().getSelectedItem().getText();
        combox.getItems().add(text);
        list.getItems().remove(list.getSelectionModel().getSelectedIndex());
        return text;
    }
    
    public void removeFromComboBox(String text){
         combox.getItems().remove(text);
    }
    
    
    private void fillComboBox(){    
        for(String str:Config.choices){
            if(!str.equals("CycleId"))combox.getItems().add(str);
        }
    }
    
    private void addInList(String text){
        Label lbl = new Label(text);
        list.getItems().add(lbl);
    }
}
