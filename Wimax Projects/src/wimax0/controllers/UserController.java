/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimax0.controllers;

import core.Bts;
import core.User;
import javafx.scene.control.Label;

/**
 *
 * @author Amine
 */
public class UserController {
    private Label classe;
    private Label maxCollision;
    private Label CDMA;
    
    //parti 2
    
    private Label taille;     // keep this as it is for stats
    private Label taillec;    // decrement this 
    private Label tempsSejour;

    public UserController(Label classe, Label maxCollision, Label CDMA, Label taille, Label taillec, Label tempsSejour) {
        this.classe = classe;
        this.maxCollision = maxCollision;
        this.CDMA = CDMA;
        this.taille = taille;
        this.taillec = taillec;
        this.tempsSejour = tempsSejour;
    }
    
    void fill(int cycle,int id){
        try{
        User u = Bts.cycle.get(cycle).getUsers().get(id);
        
        classe.setText("classe : "+u.getClasse());
        maxCollision.setText("Max Collisons : "+u.getMaxCollision());
        CDMA.setText("CDMA  :   "+u.getCDMA());
        taille.setText("size : "+u.getTaille());
        taillec.setText("left size : "+u.getTaillec());
        tempsSejour.setText("times in : "+u.getTempsSejour());
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
