/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.gui.lookup;

import com.SCI.centraltoko.Main;
import com.SCI.centraltoko.model.Produk;
import com.SCI.centraltoko.utility.UtilityTools;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.xml.ws.soap.Addressing;

/**
 *
 * @author yuzri
 */

public class ProdukLookDialog extends javax.swing.JDialog {
    
    private List<Produk> produks;
    private Produk selectedProduk;
    private boolean isOK=false;
    /**
     * Creates new form ProdukLookDialog
     */
    public ProdukLookDialog() {
        super(Main.getFrame(), true);
        initComponents();
         setLocationRelativeTo(null);
         tblProduk.setAutoCreateColumnsFromModel(false);
         tblProduk.getSelectionModel().addListSelectionListener(new TabelProdukListener());
    }

    public Produk showDialog(){
        produks=Main.getMasterService().semuaProduk();
        tblProduk.setModel(new TabelProduk());
        
        setVisible(true);
        if(isOK==false) selectedProduk=null;
        return selectedProduk;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        btnOK = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cari");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama", "Kode Produk", "Stok"
            }
        ));
        jScrollPane1.setViewportView(tblProduk);

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/SCI/centraltoko/icon/toolbar/Ok.png"))); // NOI18N
        btnOK.setToolTipText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/SCI/centraltoko/icon/toolbar/Cancel.png"))); // NOI18N
        btnBatal.setToolTipText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(350, Short.MAX_VALUE)
                .addComponent(btnOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatal)
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("IndexOfReplaceableByContains")
    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        for(int i=0; i< tblProduk.getRowCount();i++){
            String current=tblProduk.getValueAt(i, 0).toString();
            if(current.toLowerCase().indexOf(txtCari.getText().toLowerCase())>=0){
                tblProduk.getSelectionModel().setSelectionInterval(i, i);
                tblProduk.getColumnModel().getSelectionModel().setSelectionInterval(0, 0);
                UtilityTools.scroolTorect(tblProduk, i);
                break;
                
            }
        }
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        isOK=true;
        dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        selectedProduk=null;
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    /**
     * @param args the command line arguments
     */
   private class TabelProduk extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return produks.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Produk p =produks.get(rowIndex);
            switch(columnIndex){
                case 0 : return p.getNama();
                case 1 : return p.getId();
                case 2 : return p.getStok();
                default : return "";
            }
        }
       
   }
   
   private class TabelProdukListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(tblProduk.getSelectedRow()>=0){
                int indexTabel=tblProduk.convertRowIndexToModel(tblProduk.getSelectedRow());
                selectedProduk=produks.get(indexTabel);
            }
        }
       
   }
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
