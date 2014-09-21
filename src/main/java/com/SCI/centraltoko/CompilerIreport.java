/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

/**
 *
 * @author yuzri
 */
public class CompilerIreport {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main (String [] args){
        try{
            JasperCompileManager.compileReportToFile("src/reports/monthPembelianReport.jrxml","src/reports/monthPembelianReport.jasper");
//            JasperCompileManager.compileReportToFile("src/reports/monthPenjualanReport.jrxml","src/reports/monthPenjualanReport.jasper");
                    
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }
}
