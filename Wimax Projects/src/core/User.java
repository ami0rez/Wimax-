/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author MAACHOU
 */
public class User {
    
    private static int ids=0;
    //private static String[] classes=new String[]{"BE","RT","NRT"};
    private static String[] classes=new String[]{"BE","RT","NRT"};
    
    private int id;
    private int cycleIn;
    private String classe;
    private int maxCollision;
    private int CDMA;
    
    //parti 2
    
    private double taille;     // keep this as it is for stats
    private double taillec;    // decrement this 
    private int tempsSejour;
    private double rate;
    private ArrayList<Double> Rate=new ArrayList<Double>();
    
    public User(){
        
        id=ids;
        ids=++ids;
        
        //cycleIn=cycleIn;
        classe=classes[(int)(Math.random()*3)];
        
        this.chooseMaxCollision();
        this.chooseCDMA();
        this.chooseTetTS();
        
    }
    
    public void chooseCDMA(){
        if(this.classe.equals("RT")){
              this.CDMA=RT.getCDMAmin()+(int)(Math.random()*(RT.getCDMAmax()-RT.getCDMAmin()+1));
        }    
        if(this.classe.equals("BE")){
              this.CDMA=BE.getCDMAmin()+(int)(Math.random()*(BE.getCDMAmax()-BE.getCDMAmin()+1));
        }      
        if(this.classe.equals("NRT")){
              this.CDMA=NRT.getCDMAmin()+(int)(Math.random()*(NRT.getCDMAmax()-NRT.getCDMAmin()+1));
        }            
    }
    
    public void chooseTetTS(){
        
        if(this.classe.equals("RT")){
              taille=Config.TailleRT;
              taillec=Config.TailleRT;
        }   
        if(this.classe.equals("BE")){
              taille=Config.TailleBE;
              taillec=Config.TailleBE;
        }      
        if(this.classe.equals("NRT")){
              taille=Config.TailleNRT;
              taillec=Config.TailleNRT;      
        }    
        
        this.tempsSejour=0;
    }
    
    public void chooseMaxCollision(){
        
        if(this.classe.equals("BE")){
              this.maxCollision=BE.getNR();
        }   
        if(this.classe.equals("RT")){
              this.maxCollision=RT.getNR();
        }
        if(this.classe.equals("NRT")){
              this.maxCollision=NRT.getNR();
        }       
        
    }
    
    public String toString(){
        return "*** c: "+cycleIn+" ; id : "+id+" ; classe : "+classe+" ; maxCollision : "+maxCollision+" ; CDMA : "+CDMA;    
    }
    
    public void setRate(double rate) {
        
        rate = rate>=0?rate:-rate;
        if(rate<taillec){
             this.rate = rate; 
             taillec=taillec-rate; 
        }
        else{
            this.rate=taillec;  
            taillec=0; 
        }  
        Rate.add(this.rate); // array of rates , if you can find the history in another way delete this.
    }

    public static int getIds() {
        return ids;
    }
    public static void setIds(int ids) {
        User.ids = ids;
    }
    public static String[] getClasses() {
        return classes;
    }
    public static void setClasses(String[] classes) {
        User.classes = classes;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCycleIn() {
        return cycleIn;
    }
    public void setCycleIn(int cycleIn) {
        this.cycleIn = cycleIn;
    }
    public String getClasse() {
        return classe;
    }
    public void setClasse(String classe) {
        this.classe = classe;
    }
    public int getMaxCollision() {
        return maxCollision;
    }
    public void setMaxCollision(int maxCollision) {
        this.maxCollision = maxCollision;
    }
    public int getCDMA() {
        return CDMA;
    }
    public void setCDMA(int CDMA) {
        this.CDMA = CDMA;
    }
    public double getTaille() {
        return taille;
    }
    public void setTaille(double taille) {
        this.taille = taille;
    }
    public double getTaillec() {
        return taillec;
    }
    public void setTaillec(double taillec) {
        this.taillec = taillec;
    }
    public int getTempsSejour() {
        return tempsSejour;
    }
    public void setTempsSejour(int tempsSejour) {
        this.tempsSejour = tempsSejour;
    }
    public void addTempsSejour() {
        this.tempsSejour = this.tempsSejour+1;
    }
    public double getRate() {
        return rate;
    }
    
}
