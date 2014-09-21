/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko;

import com.SCI.centraltoko.gui.master.MainFrame;
import com.SCI.centraltoko.service.Laporan;
import com.SCI.centraltoko.service.MasterService;
import com.SCI.centraltoko.service.TransaksiSevice;
import java.util.logging.Level;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author yuzri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static MasterService masterService;
    private static TransaksiSevice transaksiService;
    private static MainFrame mainFrame;
    private static Laporan laporan;
    
    public static MasterService getMasterService(){
        return masterService;
    }
    
    public static TransaksiSevice getTransaksiService(){
        return transaksiService;
    }
    
    public static Laporan getLaporan(){
        return laporan;
    }
    
    public static MainFrame getFrame(){
        return mainFrame;
    }
    
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        // TODO code application logic here
//        Memasang LookAndFeel
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }catch(InstantiationException ex){
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IllegalAccessException ex){
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }catch(UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
//        Membuat tread
        try{
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                   
                   ApplicationContext applicationContext=new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
                   masterService=(MasterService)applicationContext.getBean("masterService");
                   transaksiService=(TransaksiSevice) applicationContext.getBean("transaksiSevice");
                   laporan=(Laporan)applicationContext.getBean("laporan" );
                    
                    mainFrame=new MainFrame();
                    
                    mainFrame.setVisible(true);
                  
                }
            });
        }catch(Exception ex){
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
        
}
    
}
