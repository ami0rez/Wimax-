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
public class OCycle {
    public static int ids=0;
    public int CycleId;
    
    public String Users ;
    
    public String UsersBE ;
    public String UsersNRT ;
    public String UsersRT ;
    
    //those who Have the ressource.
    public String UsersBEres ;
    public String UsersNRTres ;
    public String UsersRTres ;
    
    
    //in ressource and to be propagated to the next cycle ressource.
    public String UsersBEpropa ;
    public String UsersNRTpropa ;
    public String UsersRTpropa ;
    
    //those who are Done . (y)
    public String UsersBEdone ;
    public String UsersNRTdone ;
    public String UsersRTdone ;
    
    //those in the backoff of this cycle.
    public String UsersBEbackoff ;
    public String UsersNRTbackoff ;
    public String UsersRTbackoff ;
    
    //those abondoned in the first part.
    public String UsersBEabandon ;
    public String UsersNRTabandon ;
    public String UsersRTabandon ;
    
    //Stats ..?
    public String UsersBEstart ;
    public String UsersNRTstart ;
    public String UsersRTstart ;
    
    // Those who failed in the second part.
    public String UsersRTechec ;
    public int beAfterBO,rtAfterBO,nrtAfterBO;

    public static int getIds() {
        return ids;
    }

    public int getCycleId() {
        return CycleId;
    }



    public String getUsers() {
        return Users;
    }

    public String getUsersBE() {
        return UsersBE;
    }

    public String getUsersNRT() {
        return UsersNRT;
    }

    public String getUsersRT() {
        return UsersRT;
    }

    public String getUsersBEres() {
        return UsersBEres;
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

    
    public String getUsersNRTres() {
        return UsersNRTres;
    }

    public String getUsersRTres() {
        return UsersRTres;
    }

    public String getUsersBEpropa() {
        return UsersBEpropa;
    }

    public String getUsersNRTpropa() {
        return UsersNRTpropa;
    }

    public String getUsersRTpropa() {
        return UsersRTpropa;
    }

    public String getUsersBEdone() {
        return UsersBEdone;
    }

    public String getUsersNRTdone() {
        return UsersNRTdone;
    }

    public String getUsersRTdone() {
        return UsersRTdone;
    }

    public String getUsersBEbackoff() {
        return UsersBEbackoff;
    }

    public String getUsersNRTbackoff() {
        return UsersNRTbackoff;
    }

    public String getUsersRTbackoff() {
        return UsersRTbackoff;
    }

    public String getUsersBEabandon() {
        return UsersBEabandon;
    }

    public String getUsersNRTabandon() {
        return UsersNRTabandon;
    }

    public String getUsersRTabandon() {
        return UsersRTabandon;
    }

    public String getUsersBEstart() {
        return UsersBEstart;
    }

    public String getUsersNRTstart() {
        return UsersNRTstart;
    }

    public String getUsersRTstart() {
        return UsersRTstart;
    }

    public String getUsersRTechec() {
        return UsersRTechec;
    }
    
    
    
}
