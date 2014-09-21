/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.utility;


import com.SCI.centraltoko.gui.master.MainFrame;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.springframework.util.StringUtils;

/**
 *
 * @author yuzri
 */
public class UtilityTools {
    private static final String BAD_CHARS="`~!@#$%^&*()_+=\\|\"':;/?>.<,";
    
//    Membuat scrolPencaharian data Jtable
    public static void scroolTorect(JTable tabel,int nextRow){
        Rectangle currenVisible= tabel.getVisibleRect();
        Rectangle scroolTorect=tabel.getCellRect(nextRow,0, true);
        if(scroolTorect.getY()>currenVisible.getY() + currenVisible.getHeight()){
            scroolTorect.setLocation(0, (int)(scroolTorect.getY()+currenVisible.getHeight()-scroolTorect.getHeight()));
        }
         tabel.scrollRectToVisible(scroolTorect);
    }
    
//    Membuat batas input JTextFile
    private static void batasInput(JTextField textFIle,KeyEvent keyEven,int maxIsi){
        if(textFIle.getText().length()+1>maxIsi){
            keyEven.consume();
        }
    }
    
    public static void setMaxLength(final int maxChar,final JTextField txtField){
        txtField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                batasInput(txtField, e, maxChar);
            }
            
});
    }
    
//    Membatasi dan merubah ke huruf besar JtextField dan JTextArea
    private static void convertToUpperCase(final JTextField textField){
        textField.setText(textField.getText().toUpperCase());
    }
    private static void convertToUpperCase(final JTextArea textArea){
        textArea.setText(textArea.getText().toUpperCase());
    }
    public static void setAutoUpperCase(final JTextField textField){
        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if(Character.isLetter(e.getKeyChar())){
                    convertToUpperCase((JTextField)e.getSource());
                }
            }
            
});
    }
    public static void setAutoUpperCase(final JTextArea textArea){
        textArea.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
               if(Character.isLetter(e.getKeyChar())){
                   convertToUpperCase((JTextArea)e.getSource());
               }
            }
            
});
    }
//    Membuat Format Number
//            Format 
    public static String formatNumber(BigDecimal value){
        if(value==null || value.equals(BigDecimal.ZERO)){
            return "0";
        }else{
            NumberFormat formater= NumberFormat.getInstance();
            formater.setMaximumFractionDigits(0);
            formater.setMinimumFractionDigits(0);
            return formater.format(value.setScale(0, RoundingMode.HALF_EVEN));
        }
    }
    
    @SuppressWarnings("UnusedAssignment")
    public static String formatNumber(String txt){
        char thousandSeparator='.';
        char decimalSeparator=',';
        if(Locale.getDefault().equals(Locale.US)){
            thousandSeparator=',';
            decimalSeparator='.';
            
        }else if(Locale.getDefault().getCountry().equalsIgnoreCase("INDONESIA")
                && Locale.getDefault().getLanguage().equalsIgnoreCase("ID")){
             thousandSeparator='.';
             decimalSeparator=',';
        } 
        
        StringBuilder buider= new StringBuilder();
        boolean isDecimalSeparatorFOund=false;
        for(Character c: txt.toCharArray()){
            if(c !=thousandSeparator){
                buider.append(c);
                if(c==decimalSeparator){
                    isDecimalSeparatorFOund=true;
                }
            }
        }
        
        char[]arr=buider.toString().toCharArray();
        StringBuilder buider1=new StringBuilder();
        int maxIndex=arr.length-1;
        //Menagambil pecahan
        int i=0;
        int decimalSeparatorIndex=0;
        if(isDecimalSeparatorFOund){
            for(;i<=maxIndex;i++){
                char c=arr[maxIndex-i];
                if(c!=decimalSeparator){
                    buider1.append(c);
                }else{
                    isDecimalSeparatorFOund=false;
                    break;
                }
            }
            buider1.append(arr[maxIndex-i++]);
            decimalSeparatorIndex=i;
        }
        for(i=0;i<=maxIndex-decimalSeparatorIndex;i++){
            char c= arr[maxIndex-i- decimalSeparatorIndex];
            if(i!=0 && i%3==0){
                buider1.append(thousandSeparator);
                buider1.append(c);
            }else{
                buider1.append(c);
            }
        }
        StringBuilder buider2=new StringBuilder();
        char [] arr2=buider1.toString().toCharArray();
        maxIndex=arr2.length-1;
        for(i=0;i<=maxIndex;i++){
            char c=arr2[maxIndex-i];
            buider2.append(c);
        }
        return  buider2.toString();
    }
    
//    membuat control bad character
    private static class IntegerMasking implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            JTextField source=(JTextField)e.getSource();
            if(Locale.getDefault()==Locale.US){
                if(Character.isLetter(e.getKeyChar()) || BAD_CHARS.indexOf(e.getKeyChar())>=0){
                    if(e.getKeyChar()!='.' || source.getText().indexOf('.')>=0){
                        e.consume();
                    }
                }
            }else{
                if(Character.isLetter(e.getKeyChar()) || BAD_CHARS.indexOf(e.getKeyChar())>=0){
                    if(e.getKeyChar()!=',' || source.getText().indexOf(',')>=0){
                        e.consume();
                    }
                }
            }        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT){
                return;
            }
            if(e.getSource()instanceof JTextField){
                JTextField textField=(JTextField)e.getSource();
                int caretPosition=textField.getCaretPosition();
                int initialLenght=textField.getText()!=null ? textField.getText().length() :0;
                String formatedNumber=formatNumber(textField.getText());
                textField.setText(formatedNumber);
                if(formatedNumber.length()>initialLenght){
                    textField.setCaretPosition(caretPosition + 1);
                }
            }
            

        }
        
    }
    public static JTextField setCurrency(JTextField textField){
        textField.addKeyListener(new IntegerMasking());
        return textField;
    }
    
    
    //            Method ini akan menegambil text angka saja
   public static String getValueFromTextNumber(final JTextField textField ){
       final char [] txt =textField.getText().toCharArray();
       StringBuilder sb=new StringBuilder();
       @SuppressWarnings("UnusedAssignment")
       String tmp="";
       for(int i=0; i<txt.length;i++){
           tmp=String.valueOf(txt[i]);
           if (tmp.equals(".") || tmp.equals(",")){
               
           }else{
               sb.append(tmp);
           }
       }
       return sb.toString();
   }
   
//   Merubah Text menjadi BigDecimal
   public static BigDecimal parseNumberToBigDecimal(String text){
       if(!StringUtils.hasText(text))return BigDecimal.ZERO;
       try{
           BigDecimal number= new BigDecimal(NumberFormat.getInstance().parse(text).doubleValue());
           return number;
       }catch(ParseException ex){
           if(Locale.US==Locale.getDefault()){
               JOptionPane.showMessageDialog(null, "Region setting anda menggunakan US, pemisah ribuan adalah .(titik) dan pemisah pecahan ada;ah ,(koma) ");
           }else if(Locale.getDefault().getCountry().equalsIgnoreCase("INDONESIA")
                   && Locale.getDefault().getLanguage().equalsIgnoreCase("ID")){
               JOptionPane.showMessageDialog(null, "Region setting anda menggunakan Indonesia, pemisah ribuan adalah ,(koma) dan pemisah pecahan adalah .(titik)");
           } 
       }
       return null;
   }
//   filter hanya text
   public static void setNumericTextOnly(final JTextField textField){
       textField.addKeyListener(new KeyAdapter() {

           @Override
           public void keyTyped(KeyEvent e) {
               if(!Character.isDigit(e.getKeyChar()) || BAD_CHARS.indexOf(e.getKeyChar())> -1){
                   e.consume();
               }
           }
           
       
});
               
}
}