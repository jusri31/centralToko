/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.utility;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


/**
 *
 * @author yuzri
 */
public class BagroundImage extends JDesktopPane {
    ImageIcon icon=new ImageIcon("src/com/SCI/centraltoko/icon/202.jpg");
    Image img = icon.getImage();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
   
        
        
    }

 
 
