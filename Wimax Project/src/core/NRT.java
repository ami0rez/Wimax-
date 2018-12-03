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
public class NRT {
    
    private static int NR=3;
    private static int CDMAmin=11;
    private static int CDMAmax=26;

    public static int getNR() {
        return NR;
    }

    public static void setNR(int NR) {
        NRT.NR = NR;
    }

    public static int getCDMAmin() {
        return CDMAmin;
    }

    public static void setCDMAmin(int CDMAmin) {
        NRT.CDMAmin = CDMAmin;
    }

    public static int getCDMAmax() {
        return CDMAmax;
    }

    public static void setCDMAmax(int CDMAmax) {
        NRT.CDMAmax = CDMAmax;
    }
    
    
}
