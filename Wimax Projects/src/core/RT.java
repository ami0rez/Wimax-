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
public class RT {
    
    private static int NR=2;
    private static int CDMAmin=1;
    private static int CDMAmax=10;

    public static int getNR() {
        return NR;
    }

    public static void setNR(int NR) {
        RT.NR = NR;
    }

    public static int getCDMAmin() {
        return CDMAmin;
    }

    public static void setCDMAmin(int CDMAmin) {
        RT.CDMAmin = CDMAmin;
    }

    public static int getCDMAmax() {
        return CDMAmax;
    }

    public static void setCDMAmax(int CDMAmax) {
        RT.CDMAmax = CDMAmax;
    }
    
    
}
