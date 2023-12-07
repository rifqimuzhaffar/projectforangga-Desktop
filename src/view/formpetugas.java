package view;

import connectionDB.koneksi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class formpetugas extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    protected void aktif(){
        tid.setEnabled(true);
        tnama.setEnabled(true);
        tusername.setEnabled(true);
        tpassword.setEnabled(true);
        talamat.setEnabled(true);
        tnomorhp.setEnabled(true);
        
        tid.requestFocus();
    }
    
    protected void kosong(){
        tid.setText("");
        tnama.setText("");
        tusername.setText("");
        tpassword.setText("");
        talamat.setText("");
        tnomorhp.setText("");
    }
    
    protected void datatable(){
    Object [] Baris = {"ID","NAMA","USERNAME","PASSOWRD","ALAMAT","NOHP"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelpetugas.setModel(tabmode);            
    try {
    String sql = "Select * from tabelpetugas";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("id");
            String b = hasil.getString("nama");
            String c = hasil.getString("username");
            String d = hasil.getString("password");
            String e = hasil.getString("alamat");
            String f = hasil.getString("nomorhp");
            
            String[] data={a,b,c,d,e,f};
            tabmode.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    public formpetugas() {
        initComponents();
        datatable();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelutama = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpetugas = new javax.swing.JTable();
        labelnama = new javax.swing.JLabel();
        tnama = new javax.swing.JTextField();
        labelusername = new javax.swing.JLabel();
        tusername = new javax.swing.JTextField();
        labelpassword = new javax.swing.JLabel();
        tpassword = new javax.swing.JTextField();
        talamat = new javax.swing.JTextField();
        labelalamat = new javax.swing.JLabel();
        tnomorhp = new javax.swing.JTextField();
        labelnomorhp = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbersih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelutama.setBackground(new java.awt.Color(0, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA PETUGAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        tabelpetugas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelpetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabelpetugas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelpetugas.setRowHeight(30);
        tabelpetugas.setRowMargin(2);
        tabelpetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpetugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpetugas);

        labelnama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelnama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama.setText("NAMA");
        labelnama.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });

        labelusername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelusername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelusername.setText("USERNAME");
        labelusername.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tusername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tusernameActionPerformed(evt);
            }
        });

        labelpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelpassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelpassword.setText("PASSWORD");
        labelpassword.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpasswordActionPerformed(evt);
            }
        });

        talamat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        talamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                talamatActionPerformed(evt);
            }
        });

        labelalamat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelalamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelalamat.setText("ALAMAT");
        labelalamat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelutamaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addComponent(labelnama, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addComponent(labelusername, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tusername, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addComponent(labelpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addComponent(labelalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addComponent(labelnomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tnomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bsimpan))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(panelutamaLayout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(bhapus)
                .addGap(80, 80, 80)
                .addComponent(bbersih)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelutamaLayout.setVerticalGroup(
            panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelutamaLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelusername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tusername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbersih, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
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

    private void tabelpetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpetugasMouseClicked
        int bar = tabelpetugas.getSelectedRow();
        String a = tabmode.getValueAt (bar, 0).toString();
        String b = tabmode.getValueAt (bar, 1).toString();
        String c = tabmode.getValueAt (bar, 2).toString();
        String d = tabmode.getValueAt (bar, 3).toString();
        String e = tabmode.getValueAt (bar, 4).toString();
        String f = tabmode.getValueAt (bar, 5).toString();
        
        tid.setText(a);
        tnama.setText(b);
        tusername.setText(c);
        tpassword.setText(d);
        talamat.setText(e);
        tnomorhp.setText(f);
    }//GEN-LAST:event_tabelpetugasMouseClicked

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaActionPerformed

    private void tusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tusernameActionPerformed

    private void tpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpasswordActionPerformed

    private void talamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_talamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatActionPerformed

    private void tnomorhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnomorhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnomorhpActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void bsimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpanMouseEntered
        bsimpan.setBackground(new Color(0,0,204));
        bsimpan.setForeground(Color.white);
    }//GEN-LAST:event_bsimpanMouseEntered

    private void bsimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpanMouseExited
        bsimpan.setBackground(new Color(204,204,204));
        bsimpan.setForeground(Color.black);
    }//GEN-LAST:event_bsimpanMouseExited

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "insert into tabelpetugas values (?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tid.getText());
            stat.setString(2, tnama.getText());
            stat.setString(3, tusername.getText());
            stat.setString(4, tpassword.getText());
            stat.setString(5, talamat.getText());
            stat.setString(6, tnomorhp.getText());
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
            String sql = "update tabelpetugas set nama=?,username=?,password=?,alamat=?,nomorhp=? where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tnama.getText());
            stat.setString(2, tusername.getText());
            stat.setString(3, tpassword.getText());
            stat.setString(4, talamat.getText());
            stat.setString(5, tnomorhp.getText());
            
            stat.setString(6, tid.getText());
            
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
                String sql="delete from tabelpetugas where id='"+tid.getText()+"'";
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
            java.util.logging.Logger.getLogger(formpetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formpetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formpetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formpetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formpetugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersih;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelalamat;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelnama;
    private javax.swing.JLabel labelnomorhp;
    private javax.swing.JLabel labelpassword;
    private javax.swing.JLabel labelusername;
    private javax.swing.JPanel panelutama;
    private javax.swing.JTable tabelpetugas;
    private javax.swing.JTextField talamat;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnomorhp;
    private javax.swing.JTextField tpassword;
    private javax.swing.JTextField tusername;
    // End of variables declaration//GEN-END:variables
}
