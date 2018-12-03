/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author MAACHOU
 */
public class Ressource {
    
    public static double Res; // Ressource that we have.
    public double R;
    
    public static void getRessource(){
        Res=Config.Ressource;
    }
    
    public Ressource(){
        R=Res;
    }

    public double getR() {
        return R;
    }

    public void setR(double R) {
        this.R = R;
    }
    
    
    
    
}
