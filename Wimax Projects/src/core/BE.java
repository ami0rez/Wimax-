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
public class BE {
    
    private static int NR=4;
    private static int CDMAmin=27;
    private static int CDMAmax=31;

    public static int getNR() {
        return NR;
    }

    public static void setNR(int NR) {
        BE.NR = NR;
    }

    public static int getCDMAmin() {
        return CDMAmin;
    }

    public static void setCDMAmin(int CDMAmin) {
        BE.CDMAmin = CDMAmin;
    }

    public static int getCDMAmax() {
        return CDMAmax;
    }

    public static void setCDMAmax(int CDMAmax) {
        BE.CDMAmax = CDMAmax;
    }
    
    
}
