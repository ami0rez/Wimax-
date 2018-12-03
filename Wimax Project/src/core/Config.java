/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author MAACHOU & Amine
 */
public class Config {
    public static int NumberofCycles = 2;
    public static int NumberofUsers = 15;
    public static double Ressource = 950;
    
    public static double TailleBE = 500;
    public static double TailleNRT = 500;
    public static double TailleRT = 10;
    
    public static int DelaiRT=4;
    
    public static String[] choices = new String[]{
            "CycleId", "Users",
            "UsersBE","UsersRT","UsersNRT", 
            "UsersBEres", "UsersRTres", "UsersNRTres",
            "UsersBEpropa", "UsersRTpropa", "UsersNRTpropa",
            "UsersBEdone", "UsersRTdone", "UsersNRTdone",
            "UsersBEbackoff", "UsersRTbackoff", "UsersNRTbackoff",
            "UsersBEabandon", "UsersRTabandon", "UsersNRTabandon",
            "UsersBEstart", "UsersRTstart", "UsersNRTstart",
            "UsersRTechec"
        };
    
}
