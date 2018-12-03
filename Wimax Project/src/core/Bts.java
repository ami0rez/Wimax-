/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author MAACHOU & Amine
 */
public class Bts {
    
    public static ArrayList<Cycle> cycle;
    private static Ressource ressource;
    
    public static void addCycle(){
        Cycle.ids = 0;
        cycle=new ArrayList<Cycle>();
        
        for(int i=0;i<Config.NumberofCycles;i++){
            cycle.add(new Cycle());
        }
    }
    
    public static void runBts(){
        
        double k; //used to verifie ressource minus RT to se if all RT's will be given the ressource or not
        int n; //calculate the number of BE and NRT users.
        double p; //calculate the rate for BE and NRT
        //we give the ressource the number in Config class
        Ressource.getRessource();
        ressource=new Ressource();
          
        //we loop through every cycle we have created 
        for(int i=0;i<cycle.size();i++){ 
            
            
            
            System.out.println("        LE CYCLE : "+ (i+1)+"\n");
            System.out.println("        FILE D'ATTENTE :");
             
             //Part 1
            
             //if this cycle is not the first one add the previous cycle backoff to it.
            
             if(i>0){
                cycle.get(i).passBackoff(cycle.get(i-1));
            }
            
             //treat the collisions here
            cycle.get(i).Collision();
         
            System.out.println("\n\n        ALLOCATION RES :\n\n");
            
            //Part 2 will mostly be here
            
            
            
            k=ressource.getR();
            
            System.out.println(" La Ressource est de : "+ k);

            // if its not the first cycle.
            if(i!=0){
                cycle.get(i).addtoRes(cycle.get(i-1));
            }
            
                
            // Here we treat RT users they either get the ressource or get rejected. //
            k=cycle.get(i).RTressource(k);

            // Here we treat the BE and NRT        

            k=cycle.get(i).BEaNRTressource(k);
            
            //We add to the "temps de sejour".
            
            cycle.get(i).addingToTS();
            
            // Is TS of RT done ? is taillec of BE & NRT == 0 ?
            
            cycle.get(i).IsUserDone();

            Results.PrepareResults();
        }
    }

    public static ArrayList<Cycle> getCycle() {
        return cycle;
    }

    public static void setCycle(ArrayList<Cycle> cycle) {
        Bts.cycle = cycle;
    }
    
    
    
}
