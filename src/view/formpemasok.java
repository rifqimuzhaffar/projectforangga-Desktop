package view;

import connectionDB.koneksi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class formpemasok extends javax.swing.JFrame {
    
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    protected void aktif(){
        tid.setEnabled(true);
        tnama.setEnabled(true);
        talamat.setEnabled(true);
        tnomorhp.setEnabled(true);
        
        tid.requestFocus();
    } 
    
    protected void kosong(){
        tid.setText("");
        tnama.setText("");
        talamat.setText("");
        tnomorhp.setText("");
    }
    
    protected void datatable(){
    Object [] Baris = {"ID","NAMA","ALAMAT","NOHP"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelpemasok.setModel(tabmode);            
    try {
    String sql = "Select * from tabelpemasok";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("id");
            String b = hasil.getString("nama");
            String c = hasil.getString("alamat");
            String d = hasil.getString("nomorhp");
            
            String[] data={a,b,c,d};
            tabmode.addRow(data);
        }
    }catch (Exception e){
        }
    }

    public formpemasok() {
        initComponents();
        datatable();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelutama = new javax.swing.JPanel();
        labelid = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        labelnama = new javax.swing.JLabel();
        labelalamat = new javax.swing.JLabel();
        talamat = new javax.swing.JTextField();
        tnomorhp = new javax.swing.JTextField();
        labelnomorhp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpemasok = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbersih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelutama.setBackground(new java.awt.Color(0, 255, 204));

        labelid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid.setText("ID");
        labelid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });

        tnama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });

        labelnama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelnama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama.setText("NAMA");
        labelnama.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelalamat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelalamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelalamat.setText("ALAMAT");
        labelalamat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        talamat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        talamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                talamatActionPerformed(evt);
            }
        });

        tnomorhp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tnomorhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnomorhpActionPerformed(evt);
            }
        });

        labelnomorhp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelnomorhp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnomorhp.setText("NOMOR HP");
        labelnomorhp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabelpemasok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelpemasok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelpemasok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelpemasok.setRowHeight(30);
        tabelpemasok.setRowMargin(2);
        tabelpemasok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpemasokMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpemasok);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATA PEMASOK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bsimpan.setBackground(new java.awt.Color(204, 204, 204));
        bsimpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/save-30-w11.png"))); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.setContentAreaFilled(false);
        bsimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan.setOpaque(true);
        bsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsimpanMouseExited(evt);
            }
        });
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bubah.setBackground(new java.awt.Color(204, 204, 204));
        bubah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/edit-30-w11.png"))); // NOI18N
        bubah.setText("UBAH");
        bubah.setContentAreaFilled(false);
        bubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bubah.setOpaque(true);
        bubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bubahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bubahMouseExited(evt);
            }
        });
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bhapus.setBackground(new java.awt.Color(204, 204, 204));
        bhapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/delete-30-w11.png"))); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.setContentAreaFilled(false);
        bhapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus.setOpaque(true);
        bhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bhapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bhapusMouseExited(evt);
            }
        });
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bbersih.setBackground(new java.awt.Color(204, 204, 204));
        bbersih.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bbersih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/clear-30-w11.png"))); // NOI18N
        bbersih.setText("BERSIH");
        bbersih.setContentAreaFilled(false);
        bbersih.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbersih.setOpaque(true);
        bbersih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbersihMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbersihMouseExited(evt);
            }
        });
        bbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelutamaLayout = new javax.swing.GroupLayout(panelutama);
        panelutama.setLayout(panelutamaLayout);
        panelutamaLayout.setHorizontalGroup(
            panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelutamaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelutamaLayout.createSequentialGroup()
                                .addComponent(labelnama, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelutamaLayout.createSequentialGroup()
                                .addComponent(labelalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelutamaLayout.createSequentialGroup()
                                .addComponent(labelnomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tnomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelutamaLayout.createSequentialGroup()
                                .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(bsimpan)
                        .addGap(80, 80, 80)
                        .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(bhapus)
                        .addGap(76, 76, 76)
                        .addComponent(bbersih)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelutamaLayout.setVerticalGroup(
            panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelutamaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelutamaLayout.createSequentialGroup()
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbersih, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelutama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelutama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaActionPerformed

    private void talamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_talamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatActionPerformed

    private void tnomorhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnomorhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnomorhpActionPerformed

    private void tabelpemasokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpemasokMouseClicked
        int bar = tabelpemasok.getSelectedRow();
        String a = tabmode.getValueAt (bar, 0).toString();
        String b = tabmode.getValueAt (bar, 1).toString();
        String c = tabmode.getValueAt (bar, 2).toString();
        String d = tabmode.getValueAt (bar, 3).toString();

        tid.setText(a);
        tnama.setText(b);
        talamat.setText(c);
        tnomorhp.setText(d);
    }//GEN-LAST:event_tabelpemasokMouseClicked

    private void bsimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpanMouseEntered
        bsimpan.setBackground(new Color(0,0,204));
        bsimpan.setForeground(Color.white);
    }//GEN-LAST:event_bsimpanMouseEntered

    private void bsimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpanMouseExited
        bsimpan.setBackground(new Color(204,204,204));
        bsimpan.setForeground(Color.black);
    }//GEN-LAST:event_bsimpanMouseExited

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "insert into tabelpemasok values (?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tid.getText());
            stat.setString(2, tnama.getText());
            stat.setString(3, talamat.getText());
            stat.setString(4, tnomorhp.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            tid.requestFocus();
            datatable();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bubahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubahMouseEntered
        // TODO add your handling code here:
        bubah.setBackground(new Color(0,0,204));
        bubah.setForeground(Color.white);
    }//GEN-LAST:event_bubahMouseEntered

    private void bubahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubahMouseExited
        // TODO add your handling code here:
        bubah.setBackground(new Color(204,204,204));
        bubah.setForeground(Color.black);
    }//GEN-LAST:event_bubahMouseExited

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "update tabelpemasok set nama=?,alamat=?,nomorhp=? where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tnama.getText());
            stat.setString(2, talamat.getText());
            stat.setString(3, tnomorhp.getText());

            stat.setString(4, tid.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
            kosong();
            tid.requestFocus();
            datatable();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
        }
    }//GEN-LAST:event_bubahActionPerformed

    private void bhapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapusMouseEntered
        // TODO add your handling code here:
        bhapus.setBackground(Color.red);
        bhapus.setForeground(Color.white);
    }//GEN-LAST:event_bhapusMouseEntered

    private void bhapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapusMouseExited
        // TODO add your handling code here:
        bhapus.setBackground(new Color(204,204,204));
        bhapus.setForeground(Color.black);
    }//GEN-LAST:event_bhapusMouseExited

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from tabelpemasok where id='"+tid.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                tid.requestFocus();
                datatable();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bbersihMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersihMouseEntered
        // TODO add your handling code here:
        bbersih.setBackground(new Color(0,0,204));
        bbersih.setForeground(Color.white);
    }//GEN-LAST:event_bbersihMouseEntered

    private void bbersihMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersihMouseExited
        // TODO add your handling code here:
        bbersih.setBackground(new Color(204,204,204));
        bbersih.setForeground(Color.black);
    }//GEN-LAST:event_bbersihMouseExited

    private void bbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersihActionPerformed
        // TODO add your handling code here:
        kosong();
        datatable();
    }//GEN-LAST:event_bbersihActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formpemasok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formpemasok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formpemasok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formpemasok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formpemasok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersih;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelalamat;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelnama;
    private javax.swing.JLabel labelnomorhp;
    private javax.swing.JPanel panelutama;
    private javax.swing.JTable tabelpemasok;
    private javax.swing.JTextField talamat;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnomorhp;
    // End of variables declaration//GEN-END:variables
}
