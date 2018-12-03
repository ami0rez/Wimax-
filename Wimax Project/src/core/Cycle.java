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
public class Cycle {
   
    public static int ids=0;
    private int id;
    
    private ArrayList<User> Users =new ArrayList<User>();
    
    private ArrayList<User> UsersBE =new ArrayList<User>();
    private ArrayList<User> UsersNRT =new ArrayList<User>();
    private ArrayList<User> UsersRT =new ArrayList<User>();
    
    
    
    
    //those who Have the ressource.
    private ArrayList<User> UsersBEres =new ArrayList<User>();
    private ArrayList<User> UsersNRTres =new ArrayList<User>();
    private ArrayList<User> UsersRTres =new ArrayList<User>();
    
    
    //in ressource and to be propagated to the next cycle ressource.
    private ArrayList<User> UsersBEpropa =new ArrayList<User>();
    private ArrayList<User> UsersNRTpropa =new ArrayList<User>();
    private ArrayList<User> UsersRTpropa =new ArrayList<User>();
    
    //those who are Done . (y)
    private ArrayList<User> UsersBEdone =new ArrayList<User>();
    private ArrayList<User> UsersNRTdone =new ArrayList<User>();
    private ArrayList<User> UsersRTdone =new ArrayList<User>();
    
    //those in the backoff of this cycle.
    private ArrayList<User> UsersBEbackoff =new ArrayList<User>();
    private ArrayList<User> UsersNRTbackoff =new ArrayList<User>();
    private ArrayList<User> UsersRTbackoff =new ArrayList<User>();
    
    //those abondoned in the first part.
    private ArrayList<User> UsersBEabandon =new ArrayList<User>();
    private ArrayList<User> UsersNRTabandon =new ArrayList<User>();
    private ArrayList<User> UsersRTabandon =new ArrayList<User>();
    
    //Stats ..?
    private ArrayList<User> UsersBEstat1 =new ArrayList<User>();
    private ArrayList<User> UsersNRTstat1 =new ArrayList<User>();
    private ArrayList<User> UsersRTstat1 =new ArrayList<User>();
    
    // Those who failed in the second part.
    private ArrayList<User> UsersRTechec =new ArrayList<User>();
    
    private int beAfterBO,rtAfterBO,nrtAfterBO;
    
    public Cycle(){
        id=ids;
        ids=++ids;
        
        int nu = (int)(Math.random()*Config.NumberofUsers)+1;
        // for testing refine this 
        
        for(int i=0;i<nu;i++){
            this.addUser(new User());
        }
        
    }
    
    public void addUser(User u){
        
        if(u.getClasse().equals("BE")){
            UsersBE.add(u);    
            UsersBEstat1.add(u);    
        }
        if(u.getClasse().equals("NRT")){
            UsersNRT.add(u);    
            UsersNRTstat1.add(u);  
        }
        if(u.getClasse().equals("RT")){
            UsersRT.add(u);    
            UsersRTstat1.add(u);    
        }     
        
        //this will be usefull for stats
        Users.add(u);

    }
    
    public void Collision(){
        
        System.out.println("***********BE***********");
        this.CollisionBE();
        System.out.println("***********RT***********");
        this.CollisionRT();
        System.out.println("***********NRT***********");
        this.CollisionNRT();
        

    }
    public void CollisionBE(){
        ArrayList<Integer> ae=new ArrayList<Integer>();
        boolean flag=false;
        
        for(int i=0;i<UsersBE.size();i++){
            System.out.println("__________________\nLOOP :"+i+",   sizeBE "+UsersBE.size());
            //System.out.println("ae before j : "+ae.size());
            for(int j=i+1;j<UsersBE.size();j++){
                System.out.println("*loop j :"+j);
                if(UsersBE.get(i).getCDMA()==UsersBE.get(j).getCDMA()){
                    
                    System.out.println("same cdma between "+i+" and "+j);
                    if(!flag){
                        ae.add(i);
                        flag=true;
                    }
                    ae.add(j);
                }
            }
            if(!ae.isEmpty()){
                System.out.println("-------\ncollision detected for "+i);
                System.out.println("collision size :"+ae.size());
                for(int p=ae.size()-1;p>=0;p--){
                    
                    System.out.println("<??>  :"+p);
                    UsersBE.get(ae.get(p)).setMaxCollision(UsersBE.get(ae.get(p)).getMaxCollision()-1);
                    
                    if(UsersBE.get(ae.get(p)).getMaxCollision()>0){
                        UsersBEbackoff.add(UsersBE.get(ae.get(p)));
                    }
                    else{
                        UsersBEabandon.add(UsersBE.get(ae.get(p)));
                    }
                    UsersBE.remove(UsersBE.get(ae.get(p)));
                }
                ae.clear();
                i=i-1; //reverification ;)
                
            }
            System.out.println("after dealing with collison UsersBE.size = "+UsersBE.size());
            flag=false;
        }
        
        System.out.println("BE "+UsersBE.size()+ " : "+UsersBE);
        System.out.println("Collision BE "+UsersBEbackoff.size() +" : "+UsersBEbackoff);
        System.out.println("Abandonné BE "+UsersBEabandon.size()+ " : "+UsersBEabandon);
    
    }
    public void CollisionRT(){
        ArrayList<Integer> ae=new ArrayList<Integer>();
        boolean flag=false;
        
        for(int i=0;i<UsersRT.size();i++){
            System.out.println("++++++++loop i :"+i+"  ; sizeRT "+UsersRT.size());
            System.out.println("ae before j : "+ae.size());
            for(int j=i+1;j<UsersRT.size();j++){
                System.out.println("*loop j :"+j);
                if(UsersRT.get(i).getCDMA()==UsersRT.get(j).getCDMA()){
                    
                    if(!flag){
                        ae.add(i);
                        flag=true;
                    }
                    ae.add(j);
                }
            }
            if(!ae.isEmpty()){
                System.out.println(!ae.isEmpty());
                System.out.println("<!>  :"+ae.size());
                for(int p=ae.size()-1;p>=0;p--){
                    
                    System.out.println("<??>  :"+p);
                    UsersRT.get(ae.get(p)).setMaxCollision(UsersRT.get(ae.get(p)).getMaxCollision()-1);
                    
                    if(UsersRT.get(ae.get(p)).getMaxCollision()>0){
                        UsersRTbackoff.add(UsersRT.get(ae.get(p)));
                    }
                    else{
                        UsersRTabandon.add(UsersRT.get(ae.get(p)));
                    }
                    UsersRT.remove(UsersRT.get(ae.get(p)));
                }
                ae.clear();
                i=i-1;
                
            }
            System.out.println(UsersRT.size());
            flag=false;
        }
        
        System.out.println("RT : "+UsersRT.size()+" : "+UsersRT);
        System.out.println("Collision RT "+UsersRTbackoff.size()+" : "+UsersRTbackoff);
        System.out.println("Abandonné RT "+UsersRTabandon.size()+" : "+UsersRTabandon);
    }
    public void CollisionNRT(){
        ArrayList<Integer> ae=new ArrayList<Integer>();
        boolean flag=false;
        
        for(int i=0;i<UsersNRT.size();i++){
            System.out.println("++++++++loop i :"+i+"  ; sizeNRT "+UsersNRT.size());
            System.out.println("ae before j : "+ae.size());
            for(int j=i+1;j<UsersNRT.size();j++){
                System.out.println("*loop j :"+j);
                if(UsersNRT.get(i).getCDMA()==UsersNRT.get(j).getCDMA()){
                    
                    if(!flag){
                        ae.add(i);
                        flag=true;
                    }
                    ae.add(j);
                }
            }
            if(!ae.isEmpty()){
                System.out.println(!ae.isEmpty());
                System.out.println("<!>  :"+ae.size());
                for(int p=ae.size()-1;p>=0;p--){
                    
                    System.out.println("<??>  :"+p);
                    UsersNRT.get(ae.get(p)).setMaxCollision(UsersNRT.get(ae.get(p)).getMaxCollision()-1);
                    
                    if(UsersNRT.get(ae.get(p)).getMaxCollision()>0){
                        UsersNRTbackoff.add(UsersNRT.get(ae.get(p)));
                    }
                    else{
                        UsersNRTabandon.add(UsersNRT.get(ae.get(p)));
                    }
                    
                    UsersNRT.remove(UsersNRT.get(ae.get(p)));
                }
                ae.clear();
                i=i-1;
                
            }
            System.out.println(UsersNRT.size());
            flag=false;
        }
        
        System.out.println("NRT : "+UsersNRT.size()+" : "+UsersNRT);
        System.out.println("Collision NRT "+UsersNRTbackoff.size()+" : "+UsersNRTbackoff);
        System.out.println("Abandonné NRT "+UsersNRTabandon.size()+" : "+UsersNRTabandon);
    
    }
    
    public void passBackoff(Cycle cyc){
        // this cycle will add to itself the BackOff & change the CDMA of the previous cycle.
        cyc.changeCDMA();
        UsersBE.addAll(cyc.getUsersBEbackoff());
        UsersRT.addAll(cyc.getUsersRTbackoff());
        UsersNRT.addAll(cyc.getUsersNRTbackoff());
        
        beAfterBO = UsersBE.size();
        rtAfterBO = UsersRT.size();
        nrtAfterBO = UsersNRT.size();

        
        System.out.println();
    }
    
    public void changeCDMA(){
   
        for(int i=0;i<UsersBEbackoff.size();i++){
            UsersBEbackoff.get(i).chooseCDMA();
        }
        
        for(int i=0;i<UsersRTbackoff.size();i++){
            UsersRTbackoff.get(i).chooseCDMA();
        }
        
        for(int i=0;i<UsersNRTbackoff.size();i++){
            UsersNRTbackoff.get(i).chooseCDMA();
        }
    
    }
    
    public void addingToTS(){
       
        for(int i=0;i<UsersBEres.size();i++){
            UsersBEres.get(i).addTempsSejour();
        }
        
        for(int i=0;i<UsersRTres.size();i++){
            UsersRTres.get(i).addTempsSejour();
        }
        
        for(int i=0;i<UsersNRTres.size();i++){
            UsersNRTres.get(i).addTempsSejour();
        }    
    }
    public double RTressource(double k){
         
        System.out.println("RT from previous cycle : "+UsersRTres.size());
        System.out.println(UsersRTres);
        k=k-UsersRTres.size()*Config.TailleRT;
            
        for(int j=0;j<UsersRT.size();j++){ 
                    
            //checking if we have enough ressource to give to a RT user
            if(k>=Config.TailleRT){   
                UsersRTres.add(UsersRT.get(j));       
                k=k-(Config.TailleRT);
            }
            // else we pass RT to "UsersRTechec"
            else{
                UsersRTechec.add(UsersRT.get(j));
                UsersRT.remove(UsersRT.get(j));
                System.out.println(" Echec * 2 RT");
            }       
               
        }               
        System.out.println("RT of this Cycle + Previous Ones :"+UsersRTres.size());
        System.out.println(" Ressource left is :" + k);
        return k;
    }
    public double BEaNRTressource(double k){
    
                int n=UsersBE.size()+UsersBEres.size()+UsersNRT.size()+UsersNRTres.size();
                double p=k/n;
                
                // WHAT IF taillec IS SMALLER THAN the rate !!!!????
                // who cares
                
                for(int j=0;j<UsersBEres.size();j++){
                    //setting the rate to those already in the ressource ( those that got the ressource from previrous cycles)
                    UsersBEres.get(j).setRate(p);
                }
                for(int j=0;j<UsersNRTres.size();j++){
                    //setting the rate to those already in the ressource ( those that got the ressource from previrous cycles)
                    UsersNRTres.get(j).setRate(p);
                }
                
                for(int j=0;j<UsersBE.size();j++){  
                    // everytime i set the rate it is automaticaly substracted from 'taillec'
                    UsersBE.get(j).setRate(p);
                    UsersBEres.add(UsersBE.get(j));
                }
                for(int j=0;j<UsersNRT.size();j++){
                    // everytime i set the rate it is automaticaly substracted from 'taillec'
                    UsersNRT.get(j).setRate(p);
                    UsersNRTres.add(UsersNRT.get(j));
                }    
                
                // Change the K and Change what s above .
                
                System.out.println("Size BE & NRT : "+n+" ; Le debit est de : "+ p);
                return k;  
    }
    
    public void IsUserDone(){
    
            // TS of RT = 4 ?
            for(int j=0;j<UsersRTres.size();j++){
                if(Config.DelaiRT==UsersRTres.get(j).getTempsSejour()){
                    UsersRTdone.add(UsersRTres.get(j));
                }
                else{
                    UsersRTpropa.add(UsersRTres.get(j));
                }
            }
            
            //BE & NRT taillec = 0 
            
            for(int j=0;j<UsersBEres.size();j++){
                if(UsersBEres.get(j).getTaillec()==0){
                    UsersBEdone.add(UsersBEres.get(j));
                }
                else{
                    UsersBEpropa.add(UsersBEres.get(j));
                }
            }
            
            for(int j=0;j<UsersNRTres.size();j++){
                if(UsersNRTres.get(j).getTaillec()==0){
                    UsersNRTdone.add(UsersNRTres.get(j));
                }
                else{
                    UsersNRTpropa.add(UsersNRTres.get(j));
                }
            }            
    }

    public void addtoRes(Cycle c){
        //System.out.println(c.getUsersBEpropa());
        UsersRTres.addAll(c.getUsersRTpropa());
        UsersBEres.addAll(c.getUsersBEpropa());
        UsersNRTres.addAll(c.getUsersNRTpropa());
    }
    public static int getIds() {
        return ids;
    }

    public int getBeAfterBO() {
        return beAfterBO;
    }

    public int getRtAfterBO() {
        return rtAfterBO;
    }

    public int getNrtAfterBO() {
        return nrtAfterBO;
    }
    
    public static void setIds(int ids) {
        Cycle.ids = ids;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<User> getUsersBE() {
        return UsersBE;
    }
    public void setUsersBE(ArrayList<User> UsersBE) {
        this.UsersBE = UsersBE;
    }
    public ArrayList<User> getUsersNRT() {
        return UsersNRT;
    }
    public void setUsersNRT(ArrayList<User> UsersNRT) {
        this.UsersNRT = UsersNRT;
    }
    public ArrayList<User> getUsersRT() {
        return UsersRT;
    }
    public void setUsersRT(ArrayList<User> UsersRT) {
        this.UsersRT = UsersRT;
    }
    public ArrayList<User> getUsersBEbackoff() {
        return UsersBEbackoff;
    }
    public void setUsersBEbackoff(ArrayList<User> UsersBEbackoff) {
        this.UsersBEbackoff = UsersBEbackoff;
    }
    public ArrayList<User> getUsersNRTbackoff() {
        return UsersNRTbackoff;
    }
    public void setUsersNRTbackoff(ArrayList<User> UsersNRTbackoff) {
        this.UsersNRTbackoff = UsersNRTbackoff;
    }
    public ArrayList<User> getUsersRTbackoff() {
        return UsersRTbackoff;
    }
    public void setUsersRTbackoff(ArrayList<User> UsersRTbackoff) {
        this.UsersRTbackoff = UsersRTbackoff;
    }
    public ArrayList<User> getUsersBEabandon() {
        return UsersBEabandon;
    }
    public void setUsersBEabandon(ArrayList<User> UsersBEabandon) {
        this.UsersBEabandon = UsersBEabandon;
    }
    public ArrayList<User> getUsersNRTabandon() {
        return UsersNRTabandon;
    }
    public void setUsersNRTabandon(ArrayList<User> UsersNRTabandon) {
        this.UsersNRTabandon = UsersNRTabandon;
    }
    public ArrayList<User> getUsersRTabandon() {
        return UsersRTabandon;
    }
    public void setUsersRTabandon(ArrayList<User> UsersRTabandon) {
        this.UsersRTabandon = UsersRTabandon;
    }
    public ArrayList<User> getUsersBEres() {
        return UsersBEres;
    }
    public void setUsersBEres(ArrayList<User> UsersBEres) {
        this.UsersBEres = UsersBEres;
    }
    public ArrayList<User> getUsersNRTres() {
        return UsersNRTres;
    }
    public void setUsersNRTres(ArrayList<User> UsersNRTres) {
        this.UsersNRTres = UsersNRTres;
    }
    public ArrayList<User> getUsersRTres() {
        return UsersRTres;
    }
    public void setUsersRTres(ArrayList<User> UsersRTres) {
        this.UsersRTres = UsersRTres;
    }
    public ArrayList<User> getUsersBEstat1() {
        return UsersBEstat1;
    }
    public void setUsersBEstat1(ArrayList<User> UsersBEstat1) {
        this.UsersBEstat1 = UsersBEstat1;
    }
    public ArrayList<User> getUsersNRTstat1() {
        return UsersNRTstat1;
    }
    public void setUsersNRTstat1(ArrayList<User> UsersNRTstat1) {
        this.UsersNRTstat1 = UsersNRTstat1;
    }
    public ArrayList<User> getUsersRTstat1() {
        return UsersRTstat1;
    }
    public ArrayList<User> getUsersRTechec() {
        return UsersRTechec;
    }
    public void setUsersRTechec(ArrayList<User> UsersRTechec) {
        this.UsersRTechec = UsersRTechec;
    }
    public ArrayList<User> getUsers() {
        return Users;
    }
    public void setUsers(ArrayList<User> Users) {
        this.Users = Users;
    }
    public ArrayList<User> getUsersBEdone() {
        return UsersBEdone;
    }
    public void setUsersBEdone(ArrayList<User> UsersBEdone) {
        this.UsersBEdone = UsersBEdone;
    }
    public ArrayList<User> getUsersNRTdone() {
        return UsersNRTdone;
    }
    public void setUsersNRTdone(ArrayList<User> UsersNRTdone) {
        this.UsersNRTdone = UsersNRTdone;
    }
    public ArrayList<User> getUsersRTdone() {
        return UsersRTdone;
    }
    public void setUsersRTdone(ArrayList<User> UsersRTdone) {
        this.UsersRTdone = UsersRTdone;
    }
    public ArrayList<User> getUsersBEpropa() {
        return UsersBEpropa;
    }
    public void setUsersBEpropa(ArrayList<User> UsersBEpropa) {
        this.UsersBEpropa = UsersBEpropa;
    }
    public ArrayList<User> getUsersNRTpropa() {
        return UsersNRTpropa;
    }
    public void setUsersNRTpropa(ArrayList<User> UsersNRTpropa) {
        this.UsersNRTpropa = UsersNRTpropa;
    }
    public ArrayList<User> getUsersRTpropa() {
        return UsersRTpropa;
    }
    public void setUsersRTpropa(ArrayList<User> UsersRTpropa) {
        this.UsersRTpropa = UsersRTpropa;
    }
     
}
