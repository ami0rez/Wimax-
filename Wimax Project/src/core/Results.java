/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author Amine & Oussama
 */
public class Results {
    
    public static ArrayList<OCycle> cycles = new ArrayList<>();
    
    public static void PrepareResults(){
        cycles.clear();
        for(Cycle c:Bts.cycle) {
            OCycle oc = new OCycle();
            
            oc.CycleId = c.getId();
            
            oc.Users = c.getUsers().size()+"";
            
            
            oc.UsersBE = c.getUsersBE().size()+"";
            oc.UsersRT = c.getUsersRT().size()+"";
            oc.UsersNRT = c.getUsersNRT().size()+"";
            
            
            oc.UsersBEres = c.getUsersBEres().size()+"";
            oc.UsersRTres = c.getUsersRTres().size()+"";
            oc.UsersNRTres = c.getUsersNRTres().size()+"";
            
            
            oc.UsersBEpropa = c.getUsersBEpropa().size()+"";
            oc.UsersRTpropa = c.getUsersRTpropa().size()+"";
            oc.UsersNRTpropa = c.getUsersNRTpropa().size()+"";
            
            
            oc.UsersBEdone = c.getUsersBEdone().size()+"";
            oc.UsersRTdone = c.getUsersRTdone().size()+"";
            oc.UsersNRTdone = c.getUsersNRTdone().size()+"";
            
            
            oc.UsersBEbackoff = c.getUsersBEbackoff().size()+"";
            oc.UsersRTbackoff = c.getUsersRTbackoff().size()+"";
            oc.UsersNRTbackoff = c.getUsersNRTbackoff().size()+"";
            
            
            oc.UsersBEabandon = c.getUsersBEabandon().size()+"";
            oc.UsersRTabandon = c.getUsersRTabandon().size()+"";
            oc.UsersNRTabandon = c.getUsersNRTabandon().size()+"";
            
            
            oc.UsersBEstart = c.getUsersBEstat1().size()+"";
            oc.UsersRTstart = c.getUsersRTstat1().size()+"";
            oc.UsersNRTstart = c.getUsersNRTstat1().size()+"";

            oc.UsersRTechec = c.getUsersRTechec().size()+"";
            
            oc.beAfterBO = c.getBeAfterBO();
            oc.rtAfterBO = c.getRtAfterBO();
            oc.nrtAfterBO = c.getNrtAfterBO();
            
            cycles.add(oc);
        };
    }
    
    public static int getVal(String str,int cycle){
        OCycle c = cycles.get(cycle);
        int x = getId(str);
        switch(x){
            case 0:
                return c.getCycleId();
            case 1:
                return Integer.parseInt(c.getUsers());
            case 2:
                return Integer.parseInt(c.getUsersBE());
            case 3:
                return Integer.parseInt(c.getUsersRT());
            case 4:
                return Integer.parseInt(c.getUsersNRT());
            case 5:
                return Integer.parseInt(c.getUsersBEres());
            case 6:
                return Integer.parseInt(c.getUsersRTres());
            case 7:
                return Integer.parseInt(c.getUsersNRTres());
            case 8:
                return Integer.parseInt(c.getUsersBEpropa());
            case 9:
                return Integer.parseInt(c.getUsersRTpropa());
            case 10:
                return Integer.parseInt(c.getUsersNRTpropa());
            case 11:
                return Integer.parseInt(c.getUsersBEdone());
            case 12:
                return Integer.parseInt(c.getUsersRTdone());
            case 13:
                return Integer.parseInt(c.getUsersNRTdone());
            case 14:
                return Integer.parseInt(c.getUsersBEbackoff());
            case 15:
                return Integer.parseInt(c.getUsersRTbackoff());
            case 16:
                return Integer.parseInt(c.getUsersNRTbackoff());
            case 17:
                return Integer.parseInt(c.getUsersBEabandon());
            case 18:
                return Integer.parseInt(c.getUsersRTabandon());
            case 19:
                return Integer.parseInt(c.getUsersNRTabandon());
            case 20:
                return Integer.parseInt(c.getUsersBEstart());
            case 21:
                return Integer.parseInt(c.getUsersRTstart());
            case 22:
                return Integer.parseInt(c.getUsersNRTstart());
            case 23:
                return Integer.parseInt(c.getUsersRTechec());
            default:
                return -1;              
        }
    }
    
    private static int getId(String str){
        int index = -1;
        for (int i=0;i<Config.choices.length;i++) {
            if (Config.choices[i].equals(str)) {
            index = i;
            break;
            }
        }
        return index;
   }
}
 