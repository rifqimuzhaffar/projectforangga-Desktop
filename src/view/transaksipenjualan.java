package view;

import connectionDB.koneksi;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class transaksipenjualan extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode1;
    
    protected void aktif(){
        tid.setEnabled(true);
        tjumlah.setEnabled(true);
        tharga.setEnabled(true);
        
        tid.requestFocus();
    }
    
    protected void kosong(){
        tid.setText("");
        cbpetugas.setSelectedIndex(0);
        cbnamaobat.setSelectedIndex(0);
        tjumlah.setText("");
        tharga.setText("");
        ttotal.setText("");
    }
    
    protected void datatable1(){
    Object [] Baris = {"TANGGAL","ID","PETUGAS","NAMAOBAT","JUMLAH","HARGASATUAN","TOTALHARGA"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelpenjualan.setModel(tabmode);            
    try {
    String sql = "Select DATE_FORMAT(tgl, '%d-%m-%Y') AS myDate, id, petugas, nama_obat, jumlah, harga, total from tabelpenjualan";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("myDate");
            String b = hasil.getString("id");
            String c = hasil.getString("petugas");
            String d = hasil.getString("nama_obat");
            String e = hasil.getString("jumlah");
            String f = hasil.getString("harga");
            String g = hasil.getString("total");
            
            String[] data={a,b,c,d,e,f,g};
            tabmode.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    protected void datatable2(){
    Object [] Baris = {"TANGGAL","ID","PETUGAS","NAMAOBAT","JUMLAH","HARGASATUAN","TOTALHARGA"};
    tabmode = new DefaultTableModel(null, Baris);
    tabmode1 = new DefaultTableModel(null,Baris);
    tabelpenjualansementara.setModel(tabmode);
    tabelpenjualansementara.setModel(tabmode1);
    
    try {
    String sql = "Select DATE_FORMAT(tgl, '%d-%m-%Y') AS myDate, id, petugas, nama_obat, jumlah, harga, total from tabelpenjualansementara";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("myDate");
            String b = hasil.getString("id");
            String c = hasil.getString("petugas");
            String d = hasil.getString("nama_obat");
            String e = hasil.getString("jumlah");
            String f = hasil.getString("harga");
            String g = hasil.getString("total");
            
            String[] data={a,b,c,d,e,f,g};
            tabmode.addRow(data);
            tabmode1.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    public void petugas(){
        try{
            cbpetugas.removeAllItems();
            String sqlf = "select * from tabelpetugas";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sqlf);
            while(hasil.next()){
                cbpetugas.addItem(hasil.getString("nama"));
            }
            hasil.last();
            int jumlahdata = hasil.getRow();
            hasil.first();
        }catch(Exception e){
        }
    }
    
    public void namaObat(){
        try{
            cbnamaobat.removeAllItems();
            String sqlf = "select * from tabelobat";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sqlf);
            while(hasil.next()){
                cbnamaobat.addItem(hasil.getString("nama"));
            }
            hasil.last();
            int jumlahdata = hasil.getRow();
            hasil.first();
        }catch(Exception e){
        }
    }
    
    int totalhrg, jumlah, harga;
    protected boolean isInt(String value){
        try{
            Integer.valueOf(value);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public void total(){
        String txtJumlah = tjumlah.getText().trim();
        String txtHarga = tharga.getText().trim();
        
        jumlah = (isInt (txtJumlah)) ? Integer.valueOf(txtJumlah) : 0;
        harga = (isInt (txtHarga)) ? Integer.valueOf(txtHarga) : 0;
        
        totalhrg = jumlah * harga;
        ttotal.setText(String.valueOf(totalhrg));
    }
    
    public void tanggal(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        tgl.setText(dateFormat.format(currentDate));
    }
    
    public transaksipenjualan() {
        initComponents();
        datatable1();
        datatable2();
        petugas();
        namaObat();
        tanggal();
        ttotal.setEnabled(false);
        totalhrg = 0;
        jumlah = 0;
        harga = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelutama = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        labelid1 = new javax.swing.JLabel();
        labelid2 = new javax.swing.JLabel();
        ttotal = new javax.swing.JTextField();
        tharga = new javax.swing.JTextField();
        labelid3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpenjualan = new javax.swing.JTable();
        cbnamaobat = new javax.swing.JComboBox<>();
        cbpetugas = new javax.swing.JComboBox<>();
        labelid4 = new javax.swing.JLabel();
        labelid5 = new javax.swing.JLabel();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbersih = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelpenjualansementara = new javax.swing.JTable();
        bprint = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tgl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tjumlah = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelutama.setBackground(new java.awt.Color(0, 255, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DATA TRANSAKSI PEMBELIAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

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

        labelid1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelid1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid1.setText("PETUGAS");
        labelid1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelid2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelid2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid2.setText("JUMLAH");
        labelid2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ttotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttotalActionPerformed(evt);
            }
        });

        tharga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thargaActionPerformed(evt);
            }
        });
        tharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                thargaKeyReleased(evt);
            }
        });

        labelid3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelid3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid3.setText("NAMA OBAT");
        labelid3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabelpenjualan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelpenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelpenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelpenjualan.setRowHeight(30);
        tabelpenjualan.setRowMargin(2);
        tabelpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpenjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpenjualan);

        cbnamaobat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnamaobat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnamaobatActionPerformed(evt);
            }
        });

        cbpetugas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelid4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelid4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid4.setText("HARGA SATUAN");
        labelid4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelid5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelid5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid5.setText("TOTAL HARGA");
        labelid5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        tabelpenjualansementara.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelpenjualansementara.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelpenjualansementara.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelpenjualansementara.setRowHeight(30);
        tabelpenjualansementara.setRowMargin(2);
        tabelpenjualansementara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpenjualansementaraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelpenjualansementara);

        bprint.setBackground(new java.awt.Color(204, 204, 204));
        bprint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bprint.setText("PRINT");
        bprint.setContentAreaFilled(false);
        bprint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bprint.setOpaque(true);
        bprint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bprintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bprintMouseExited(evt);
            }
        });
        bprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        tgl.setBackground(new java.awt.Color(255, 0, 0));
        tgl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        tgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl.setText("TANGGAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tgl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA SEMUA PENJUALAN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BARANG YANG DIBELI PELANGGAN");

        tjumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjumlahActionPerformed(evt);
            }
        });
        tjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tjumlahKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelutamaLayout = new javax.swing.GroupLayout(panelutama);
        panelutama.setLayout(panelutamaLayout);
        panelutamaLayout.setHorizontalGroup(
            panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelutamaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addComponent(labelid1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbpetugas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelid, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tid))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelutamaLayout.createSequentialGroup()
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(123, 123, 123)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bubah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bbersih, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelid3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelid2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelid5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelid4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelutamaLayout.createSequentialGroup()
                                .addComponent(bprint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbnamaobat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tharga)
                            .addComponent(ttotal)
                            .addComponent(tjumlah))))
                .addGap(18, 18, 18)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(22, 22, 22))
        );
        panelutamaLayout.setVerticalGroup(
            panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelutamaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelid1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelid3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbnamaobat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelid2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelutamaLayout.createSequentialGroup()
                                .addComponent(labelid4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelid5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelutamaLayout.createSequentialGroup()
                                .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelutamaLayout.createSequentialGroup()
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bprint, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bbersih, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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

    private void ttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttotalActionPerformed

    private void thargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thargaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_thargaActionPerformed

    private void tabelpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpenjualanMouseClicked
        
    }//GEN-LAST:event_tabelpenjualanMouseClicked

    private void bsimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpanMouseEntered
        bsimpan.setBackground(new Color(0,0,204));
        bsimpan.setForeground(Color.white);
    }//GEN-LAST:event_bsimpanMouseEntered

    private void bsimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpanMouseExited
        bsimpan.setBackground(new Color(204,204,204));
        bsimpan.setForeground(Color.black);
    }//GEN-LAST:event_bsimpanMouseExited

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        //simpan ke tabel semua data penjuaan
        try{
            String sql = "insert into tabelpenjualan values (?,?,?,?,?,?,?)";
            String dateString = tgl.getText();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(dateString);
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setDate(1, new java.sql.Date(date.getTime()));
            stat.setString(2, tid.getText());
            stat.setString(3, cbpetugas.getSelectedItem().toString());
            stat.setString(4, cbnamaobat.getSelectedItem().toString());
            stat.setString(5, tjumlah.getText());
            stat.setString(6, tharga.getText());
            stat.setString(7, ttotal.getText());
            stat.executeUpdate();
            
            String sql1 = "insert into tabelpenjualansementara values (?,?,?,?,?,?,?)";
            String dateString1 = tgl.getText();
            DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = dateFormat1.parse(dateString1);
            PreparedStatement stat1 = conn.prepareStatement(sql1);
            stat1.setDate(1, new java.sql.Date(date1.getTime()));
            stat1.setString(2, tid.getText());
            stat1.setString(3, cbpetugas.getSelectedItem().toString());
            stat1.setString(4, cbnamaobat.getSelectedItem().toString());
            stat1.setString(5, tjumlah.getText());
            stat1.setString(6, tharga.getText());
            stat1.setString(7, ttotal.getText());
            stat1.executeUpdate();

            //ambil data stok obat
            String namaobat = cbnamaobat.getSelectedItem().toString();
            String sql2 = "SELECT stok FROM tabelobat WHERE nama = ?";
            PreparedStatement stat2 = conn.prepareStatement(sql2);
            stat2.setString(1, namaobat);
            ResultSet rs = stat2.executeQuery();

            int stokawal = 0;
            if (rs.next()){
                stokawal = rs.getInt("stok");
            }

            //jumlah obat keluar
            int jml = Integer.parseInt(tjumlah.getText());
            int stokmasuk = stokawal - jml;

            //update
            String sqlu = "UPDATE tabelobat SET stok = ? WHERE nama = ?";
            PreparedStatement stats = conn.prepareStatement(sqlu);
            stats.setInt(1, stokmasuk);
            stats.setString(2, namaobat);
            int rowsAffected = stats.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("stok update");
            } else {
                System.out.println("gagal");
            }
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            tid.requestFocus();
            datatable1();
            datatable2();
        }catch (SQLException | ParseException e){
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
            String sql = "update tabelpenjualansementara set petugas=?,nama_obat=?,jumlah=?,harga=?,total=? where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, cbpetugas.getSelectedItem().toString());
            stat.setString(2, cbnamaobat.getSelectedItem().toString());
            stat.setString(3, tjumlah.getText());
            stat.setString(4, tharga.getText());
            stat.setString(5, ttotal.getText());
            stat.setString(6, tid.getText());
            stat.executeUpdate();
            
            String sql2 = "update tabelpenjualan set petugas=?,nama_obat=?,jumlah=?,harga=?,total=? where id=?";
            PreparedStatement stat2 = conn.prepareStatement(sql2);
            stat2.setString(1, cbpetugas.getSelectedItem().toString());
            stat2.setString(2, cbnamaobat.getSelectedItem().toString());
            stat2.setString(3, tjumlah.getText());
            stat2.setString(4, tharga.getText());
            stat2.setString(5, ttotal.getText());
            stat2.setString(6, tid.getText());
            stat2.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
            kosong();
            tid.requestFocus();
            datatable1();
            datatable2();
            aktif();
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
            try {
                String sql="delete from tabelpenjualansementara where id='"+tid.getText()+"'";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                String sql2="delete from tabelpenjualan where id='"+tid.getText()+"'";
                PreparedStatement stat2 = conn.prepareStatement(sql2);
                stat2.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                tid.requestFocus();
                datatable1();
                datatable2();
                aktif();
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
        aktif();
        datatable1();
        datatable2();
    }//GEN-LAST:event_bbersihActionPerformed

    private void tabelpenjualansementaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpenjualansementaraMouseClicked
        // TODO add your handling code here:
        int bar = tabelpenjualansementara.getSelectedRow();
        String a = tabmode.getValueAt (bar, 1).toString();
        String b = tabmode.getValueAt (bar, 2).toString();
        String c = tabmode.getValueAt (bar, 3).toString();
        String d = tabmode.getValueAt (bar, 4).toString();
        String e = tabmode.getValueAt (bar, 5).toString();
        String f = tabmode.getValueAt (bar, 6).toString();

        tid.setText(a);
        cbpetugas.setSelectedItem(b);
        cbnamaobat.setSelectedItem(c);
        tjumlah.setText(d);
        tharga.setText(e);
        ttotal.setText(f);

        tjumlah.setEnabled(false);
    }//GEN-LAST:event_tabelpenjualansementaraMouseClicked

    private void bprintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bprintMouseEntered
        // TODO add your handling code here:
        bprint.setBackground(new Color(0,0,204));
        bprint.setForeground(Color.white);
    }//GEN-LAST:event_bprintMouseEntered

    private void bprintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bprintMouseExited
        // TODO add your handling code here:
        bprint.setBackground(new Color(204,204,204));
        bprint.setForeground(Color.black);
    }//GEN-LAST:event_bprintMouseExited

    private void bprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintActionPerformed
        // TODO add your handling code here:
        try {
            String namaFile = "src/Laporan/report1.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false); //coba
            JasperViewer.setDefaultLookAndFeelDecorated(true);
            
            String query = "DELETE FROM tabelpenjualansementara";
            PreparedStatement stat = conn.prepareStatement(query);

            stat.executeUpdate();
            datatable2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_bprintActionPerformed

    private void tjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tjumlahActionPerformed

    private void tjumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjumlahKeyReleased
        // TODO add your handling code here:
        total();
    }//GEN-LAST:event_tjumlahKeyReleased

    private void thargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thargaKeyReleased
        // TODO add your handling code here:
        total();
    }//GEN-LAST:event_thargaKeyReleased

    private void cbnamaobatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnamaobatActionPerformed
        // TODO add your handling code here:
        String sql = "select * from tabelobat where nama = '"+cbnamaobat.getSelectedItem().toString()+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String nama = hasil.getString("harga");
                tharga.setText(nama);
                tharga.setEnabled(false);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_cbnamaobatActionPerformed

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
            java.util.logging.Logger.getLogger(transaksipenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksipenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksipenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksipenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksipenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersih;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bprint;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JComboBox<String> cbnamaobat;
    private javax.swing.JComboBox<String> cbpetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelid1;
    private javax.swing.JLabel labelid2;
    private javax.swing.JLabel labelid3;
    private javax.swing.JLabel labelid4;
    private javax.swing.JLabel labelid5;
    private javax.swing.JPanel panelutama;
    private javax.swing.JTable tabelpenjualan;
    private javax.swing.JTable tabelpenjualansementara;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tjumlah;
    private javax.swing.JTextField ttotal;
    // End of variables declaration//GEN-END:variables
}
