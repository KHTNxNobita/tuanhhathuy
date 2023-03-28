/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frm;

import Hasaki.Main;
import static Hasaki.Main.frmTC;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class HoaDonJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonJPanel
     */
    public HoaDonJPanel() {
        initComponents();
        LayDuLieuHoaDon();
    }
public void LayDuLieuHoaDon (){
    String cautruyvan = "";
        cautruyvan = "select * from HOADON ";
        ResultSet rs = Main.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Trị giá", "Ngày lập", "Phương thức thanh toán"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblHoaDon.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                c++;
                item[0] = c;
                item[1] = rs.getString("MADH");
                item[2] = rs.getString("MAKH");
                item[3] = rs.getString("MANV");
                item[4] = rs.getString("TRIGIA");
                item[5] = rs.getString("NGAYLAP");
                item[6] = rs.getString("PTTT");
                
            
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
 }
public void LayDuLieuChiTietHoaDon (String MaDH){
   
    String cautruyvan = "";
        cautruyvan = "select * from CTHOADON where MADH= '"+MaDH+"'";
        ResultSet rs = Main.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã hóa đơn", "Mã mặt hàng", "Số lượng", "Giá bán", "Thành tiền"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblCTHD.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[6];
                c++;
                item[0] = c;
                item[1] = rs.getString("MADH");
                item[2] = rs.getString("MAMH");
                item[3] = rs.getInt("SL");
                item[4] = rs.getFloat("DGBAN");
                item[5] = rs.getFloat("THANHTIEN");
                
            
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
 } 
 public boolean KiemTraNhapHoaDon(int ts) {
        boolean kiemtra = false;
          String MaDH,MaKH,MaNV,TriGia,NgayLap,PTTT;
        MaDH=txtMaDH.getText();
        MaKH=txtMaKH.getText();
        MaNV=txtMaNV.getText();
        TriGia=txtTriGia.getText();
        NgayLap=txtNgayLap.getText();
        PTTT=txtPTTT.getText();
        String  ThongBao = "";
        
        if (MaDH.equals("") && ts == 1) {
            ThongBao += "Bạn Chưa nhập mã đơn hàng\n";
            lblMaDH_HD.setForeground(Color.red);
        }
        if (MaKH.equals("")) {
            ThongBao += "Bạn chưa nhập mã khách hàng\n";
            lblMaKH.setForeground(Color.red);
            
        }
         if (MaNV.equals("")) {
            ThongBao += "Bạn chưa nhập mã nhân viên\n";
            lblMaNV.setForeground(Color.red);
            
        }
        if (TriGia.equals("")) {
            ThongBao += "Bạn chưa nhập trị giá\n";
            lblTriGia.setForeground(Color.red);
        }
        if (NgayLap.equals("")) {
            lblNgayLap.setForeground(Color.red);
            ThongBao += "Bạn chưa nhập ngày lập\n";
        }
        if (PTTT.equals("")) {
            lblPTTT.setForeground(Color.red);
            ThongBao += "Bạn chưa nhập phương thức thanh toán \n";
           
        }
       
        if (ThongBao.equals("")) {
            kiemtra = true;
            lblMaKH.setForeground(Color.black);
            lblMaDH_HD.setForeground(Color.black);
            lblTriGia.setForeground(Color.black);
            lblMaNV.setForeground(Color.black);
            lblNgayLap.setForeground(Color.black);
            lblPTTT.setForeground(Color.black);
            
        } else {
            kiemtra = false;
            frmTC.ThongBao(ThongBao, "LỖI NHẬP LIỆU", 2);
        }
        return kiemtra;
    }
public boolean KiemTraNhapChiTietHoaDon(int ts) {
        boolean kiemtra = false;
          String MaMH,SL,DGBan,TT;
       
        MaMH=txtMaMH.getText();
        SL=txtSL.getText();
        DGBan=txtGiaBan.getText();
        TT=txtThanhTien.getText();
        
        String  ThongBao = "";
        
        
        
        if (MaMH.equals("")) {
            ThongBao += "Bạn chưa nhập mã mặt hàng\n";
            lblMaMH.setForeground(Color.red);
            
        }
         if (SL.equals("")) {
            ThongBao += "Bạn chưa nhập số lượng\n";
            lblSL.setForeground(Color.red);
            
        }
        if (DGBan.equals("")) {
            ThongBao += "Bạn chưa nhập trị giá\n";
            lblGiaBan.setForeground(Color.red);
        }
        if (TT.equals("")) {
            lblThanhTien.setForeground(Color.red);
            ThongBao += "Bạn chưa nhập thành tiền\n";
        }
        
       
        if (ThongBao.equals("")) {
            kiemtra = true;
            lblMaMH.setForeground(Color.black);
            lblMaDH_CTHD.setForeground(Color.black);
            lblSL.setForeground(Color.black);
            lblGiaBan.setForeground(Color.black);
            lblThanhTien.setForeground(Color.black);
            
            
        } else {
            kiemtra = false;
            frmTC.ThongBao(ThongBao, "LỖI NHẬP LIỆU", 2);
        }
        return kiemtra;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblMaDH_HD = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblTriGia = new javax.swing.JLabel();
        lblNgayLap = new javax.swing.JLabel();
        lblPTTT = new javax.swing.JLabel();
        txtMaDH = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtTriGia = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        txtPTTT = new javax.swing.JTextField();
        btnThemHD = new javax.swing.JButton();
        btnSuaHD = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        btnResetHD = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        RadMaKH = new javax.swing.JRadioButton();
        RadMaNV = new javax.swing.JRadioButton();
        btnTimHD = new javax.swing.JButton();
        txtTimHD = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblMaDH_CTHD = new javax.swing.JLabel();
        lblMaMH = new javax.swing.JLabel();
        lblSL = new javax.swing.JLabel();
        lblGiaBan = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        txtMaDH_CTHD = new javax.swing.JTextField();
        txtMaMH = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        btnThemCTHD = new javax.swing.JButton();
        btnSuaCTHD = new javax.swing.JButton();
        btnXoaCTHD = new javax.swing.JButton();
        btnResetCTHD = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("HÓA ĐƠN");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Mã khách hàng", "Mã nhân viên", "Trị giá hóa đơn", "Ngày lập", "Phương thức thanh toán"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("CHI TIẾT HÓA ĐƠN");

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Mã mặt hàng", "Số Lượng ", "Giá bán", "Thành tiền"
            }
        ));
        tblCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTHD);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMaDH_HD.setText("Mã đơn hàng");

        lblMaKH.setText("Mã Khách hàng");

        lblMaNV.setText("Mã nhân viên");

        lblTriGia.setText("Trị giá ");

        lblNgayLap.setText("Ngày lập");

        lblPTTT.setText("Phương thức ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaDH_HD)
                    .addComponent(lblMaKH)
                    .addComponent(lblMaNV)
                    .addComponent(lblTriGia)
                    .addComponent(lblNgayLap)
                    .addComponent(lblPTTT))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaDH)
                    .addComponent(txtMaKH)
                    .addComponent(txtMaNV)
                    .addComponent(txtTriGia)
                    .addComponent(txtNgayLap)
                    .addComponent(txtPTTT))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaDH_HD)
                    .addComponent(txtMaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKH)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNV)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTriGia)
                    .addComponent(txtTriGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayLap)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPTTT)
                    .addComponent(txtPTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btnThemHD.setText("Thêm");
        btnThemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDActionPerformed(evt);
            }
        });

        btnSuaHD.setText("Sửa");
        btnSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDActionPerformed(evt);
            }
        });

        btnXoaHD.setText("Xóa");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });

        btnResetHD.setText("Reset");
        btnResetHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetHDActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Tìm kiếm");

        RadMaKH.setText("Mã Khách hàng ");

        RadMaNV.setText("Mã nhân viên");

        btnTimHD.setText("Tìm");
        btnTimHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RadMaKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimHD)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RadMaNV)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(txtTimHD, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadMaKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadMaNV))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnTimHD)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(txtTimHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMaDH_CTHD.setText("Mã đơn hàng");

        lblMaMH.setText("Mã mặt hàng");

        lblSL.setText("Số lượng");

        lblGiaBan.setText("Giá bán");

        lblThanhTien.setText("Thành tiền :");

        txtMaDH_CTHD.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaDH_CTHD)
                    .addComponent(lblMaMH)
                    .addComponent(lblSL)
                    .addComponent(lblGiaBan)
                    .addComponent(lblThanhTien))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaDH_CTHD)
                    .addComponent(txtMaMH)
                    .addComponent(txtSL)
                    .addComponent(txtGiaBan)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaDH_CTHD)
                    .addComponent(txtMaDH_CTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaMH)
                    .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSL)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGiaBan)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThanhTien)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        btnThemCTHD.setText("Thêm");
        btnThemCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTHDActionPerformed(evt);
            }
        });

        btnSuaCTHD.setText("Sửa");
        btnSuaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTHDActionPerformed(evt);
            }
        });

        btnXoaCTHD.setText("Xóa");
        btnXoaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTHDActionPerformed(evt);
            }
        });

        btnResetCTHD.setText("Reset");
        btnResetCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCTHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnThemCTHD)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnSuaCTHD)
                                        .addGap(54, 54, 54)
                                        .addComponent(btnXoaCTHD)
                                        .addGap(70, 70, 70)
                                        .addComponent(btnResetCTHD)))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnThemHD)
                                                .addGap(41, 41, 41)
                                                .addComponent(btnSuaHD)
                                                .addGap(58, 58, 58)
                                                .addComponent(btnXoaHD)
                                                .addGap(59, 59, 59)
                                                .addComponent(btnResetHD)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)))
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThemHD)
                                    .addComponent(btnSuaHD)
                                    .addComponent(btnXoaHD)
                                    .addComponent(btnResetHD))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemCTHD)
                            .addComponent(btnSuaCTHD)
                            .addComponent(btnXoaCTHD)
                            .addComponent(btnResetCTHD)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
         int viTriDongVuaBam = tblHoaDon.getSelectedRow();
        txtMaDH.setText(tblHoaDon.getValueAt(viTriDongVuaBam, 1).toString());
        txtMaKH.setText(tblHoaDon.getValueAt(viTriDongVuaBam, 2).toString());
        txtMaNV.setText(tblHoaDon.getValueAt(viTriDongVuaBam, 3).toString());
        txtTriGia.setText(tblHoaDon.getValueAt(viTriDongVuaBam, 4).toString());
        txtNgayLap.setText(tblHoaDon.getValueAt(viTriDongVuaBam, 5).toString());
        txtPTTT.setText(tblHoaDon.getValueAt(viTriDongVuaBam, 6).toString());
        
       
        LayDuLieuChiTietHoaDon(txtMaDH.getText());
        if(tblCTHD.getRowCount()>0)
        {
             txtMaDH_CTHD.setText(tblCTHD.getValueAt(0, 1).toString());
        txtMaMH.setText(tblCTHD.getValueAt(0, 2).toString());
        txtSL.setText(tblCTHD.getValueAt(0, 3).toString());
        txtGiaBan.setText(tblCTHD.getValueAt(0, 4).toString());
        txtThanhTien.setText(tblCTHD.getValueAt(0, 5).toString());
        }
        else 
        {
             txtMaDH_CTHD.setText(txtMaDH.getText());
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDMouseClicked
        // TODO add your handling code here:
         int viTriDongVuaBam = tblCTHD.getSelectedRow();
        txtMaDH_CTHD.setText(tblCTHD.getValueAt(viTriDongVuaBam, 1).toString());
        txtMaMH.setText(tblCTHD.getValueAt(viTriDongVuaBam, 2).toString());
        txtSL.setText(tblCTHD.getValueAt(viTriDongVuaBam, 3).toString());
        txtGiaBan.setText(tblCTHD.getValueAt(viTriDongVuaBam, 4).toString());
        txtThanhTien.setText(tblCTHD.getValueAt(viTriDongVuaBam, 5).toString());
        LayDuLieuChiTietHoaDon(txtMaDH.getText());
    }//GEN-LAST:event_tblCTHDMouseClicked

    private void btnThemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDActionPerformed
        // TODO add your handling code here:
        String MaDH,MaKH,MaNV,TriGia,NgayLap,PTTT;
        MaDH=txtMaDH.getText();
        MaNV=txtMaNV.getText();
        MaKH=txtMaKH.getText();
        TriGia=txtTriGia.getText();
        NgayLap=txtNgayLap.getText();
        PTTT=txtPTTT.getText();
        
        String cautruyvan = "INSERT into HOADON(MADH,MAKH,MANV,TRIGIA,NGAYLAP,PTTT) Values('" + MaDH + "','" + MaKH + "','" + MaNV + "','" + TriGia + "',Convert(datetime,'" + NgayLap + "'),N'" + PTTT + "')";
        
        boolean kiemtra = KiemTraNhapHoaDon(0);
        if (kiemtra) {
            Main.connection.ExcuteQueryUpdateDB(cautruyvan);
            Main.frmTC.infoBox("Thêm Thành Công !!!", "Thông báo");
            System.out.println("Đã Thêm Thành Công");
            System.out.println(cautruyvan);
        } else {
            System.out.println("Thất Bại");
        }
         LayDuLieuHoaDon();
    }//GEN-LAST:event_btnThemHDActionPerformed

    private void btnSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDActionPerformed
        // TODO add your handling code here:
         String MaDH,MaKH,MaNV,TriGia,NgayLap,PTTT;
        MaDH=txtMaDH.getText();
        MaKH=txtMaKH.getText();
         MaNV=txtMaNV.getText();
        TriGia=txtTriGia.getText();
        NgayLap=txtNgayLap.getText();
        PTTT=txtPTTT.getText();
         String cautruyvan = "Update HOADON SET MAKH='" + MaKH + "', MANV='" + MaNV + "',TRIGIA='" + TriGia + "',NGAYLAP=Convert(datetime,'" + NgayLap + "'),PTTT=N'" + PTTT + "'WHERE MADH='"+MaDH+"'";
        
        boolean kiemtra = KiemTraNhapHoaDon(0);
        if (kiemtra) {
            Main.connection.ExcuteQueryUpdateDB(cautruyvan);
            Main.frmTC.infoBox(" Sửa Thành Công !!!", "Thông báo");
            System.out.println("Đã sửa Thành Công");
            System.out.println(cautruyvan);
        } else {
            System.out.println("Thất Bại");
        }
         LayDuLieuHoaDon();
    }//GEN-LAST:event_btnSuaHDActionPerformed

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
        // TODO add your handling code here:
        String MaDH=txtMaDH.getText();
         String cautruyvan = "delete HOADON where MADH='" + MaDH+"';";
         Main.frmTC.infoBox("Lỗi Xóa hóa đơn  !!!", "Thông báo");
        boolean kiemtra = KiemTraNhapHoaDon(0);
        if (kiemtra) {
            Main.connection.ExcuteQueryUpdateDB(cautruyvan);
            Main.frmTC.infoBox("Xóa Thành Công !!!", "Thông báo");
            System.out.println("Đã xóa Thành Công");
            System.out.println(cautruyvan);
        } else {
            System.out.println("Thất Bại");
        }
         LayDuLieuHoaDon();
    }//GEN-LAST:event_btnXoaHDActionPerformed

    private void btnResetHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetHDActionPerformed
        // TODO add your handling code here:
        txtMaDH.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtTriGia.setText("");
        txtNgayLap.setText("");
        txtPTTT.setText("");
        LayDuLieuHoaDon();
    }//GEN-LAST:event_btnResetHDActionPerformed

    private void btnTimHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimHDActionPerformed
        // TODO add your handling code here:
        if(RadMaKH.isSelected())
        {
             String cautruyvan="Select * from HOADON where MAKH='"+txtTimHD.getText()+"'" ;
              ResultSet rs = Main.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Trị giá", "Ngày lập", "Phương thức thanh toán"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblHoaDon.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                c++;
                item[0] = c;
                item[1] = rs.getString("MADH");
                item[2] = rs.getString("MAKH");
                item[3] = rs.getString("MANV");
                item[4] = rs.getString("TRIGIA");
                item[5] = rs.getString("NGAYLAP");
                item[6] = rs.getString("PTTT");
                
            
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
       
               
        }else if(RadMaNV.isSelected()) { 
              String cautruyvan="Select * from HOADON where MANV='"+txtTimHD.getText()+"'" ;
              ResultSet rs = Main.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Trị giá", "Ngày lập", "Phương thức thanh toán"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblHoaDon.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                c++;
                item[0] = c;
                item[1] = rs.getString("MADH");
                item[2] = rs.getString("MAKH");
                item[3] = rs.getString("MANV");
                item[4] = rs.getString("TRIGIA");
                item[5] = rs.getString("NGAYLAP");
                item[6] = rs.getString("PTTT");
                
            
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

                    
         }
    }//GEN-LAST:event_btnTimHDActionPerformed

    private void btnThemCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTHDActionPerformed
        // TODO add your handling code here:
         String MaDH ,MaMH,SL,DGBan,TT;
       MaDH=txtMaDH_CTHD.getText();
        MaMH=txtMaMH.getText();
        SL=txtSL.getText();
        DGBan=txtGiaBan.getText();
        TT=txtThanhTien.getText();
         String cautruyvan = "INSERT into CTHOADON(MADH,MAMH,SL,DGBAN,THANHTIEN) Values('" + MaDH + "','" + MaMH + "','" + SL + "','" + DGBan + "','" + TT + "')";
        
        boolean kiemtra = KiemTraNhapHoaDon(0);
        if (kiemtra) {
            Main.connection.ExcuteQueryUpdateDB(cautruyvan);
            Main.frmTC.infoBox("Thêm Thành Công !!!", "Thông báo");
            System.out.println("Đã Thêm Thành Công");
            System.out.println(cautruyvan);
        } else {
            System.out.println("Thất Bại");
        }
         LayDuLieuChiTietHoaDon(MaDH);
    }//GEN-LAST:event_btnThemCTHDActionPerformed

    private void btnSuaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTHDActionPerformed
        // TODO add your handling code here:
         String MaDH ,MaMH,SL,DGBan,TT;
       MaDH=txtMaDH_CTHD.getText();
        MaMH=txtMaMH.getText();
        SL=txtSL.getText();
        DGBan=txtGiaBan.getText();
        TT=txtThanhTien.getText();
         String cautruyvan = " update  CTHOADON SET MAMH='" + MaMH + "',SL='" + SL + "',DGBAN='" + DGBan + "',THANHTIEN='" + TT + "' WHERE MADH='"+MaDH+"'";
        
        boolean kiemtra = KiemTraNhapHoaDon(0);
        if (kiemtra) {
            Main.connection.ExcuteQueryUpdateDB(cautruyvan);
            Main.frmTC.infoBox(" Sửa Thành Công !!!", "Thông báo");
            System.out.println("Đã sửa Thành Công");
            System.out.println(cautruyvan);
        } else {
            System.out.println("Thất Bại");
        }
         LayDuLieuChiTietHoaDon(MaDH);
    }//GEN-LAST:event_btnSuaCTHDActionPerformed

    private void btnXoaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTHDActionPerformed
        // TODO add your handling code here:
         String MaDH=txtMaDH.getText();
         String cautruyvan = "delete CTHOADON where MADH='" + MaDH+"';";
         Main.frmTC.infoBox("Lỗi xóa chi tiết hoán đơn !!!", "Thông báo");
        boolean kiemtra = KiemTraNhapHoaDon(0);
        if (kiemtra) {
            Main.connection.ExcuteQueryUpdateDB(cautruyvan);
            Main.frmTC.infoBox("Xóa Thành Công !!!", "Thông báo");
            System.out.println("Đã xóa Thành Công");
            System.out.println(cautruyvan);
        } else {
            System.out.println("Thất Bại");
        }
         LayDuLieuChiTietHoaDon(MaDH);
    }//GEN-LAST:event_btnXoaCTHDActionPerformed

    private void btnResetCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCTHDActionPerformed
        // TODO add your handling code here:
         txtMaDH_CTHD.setText("" );
        txtMaMH.setText("");
        txtSL.setText("");
        txtGiaBan.setText("");
        txtThanhTien.setText("");
        LayDuLieuHoaDon();
    }//GEN-LAST:event_btnResetCTHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadMaKH;
    private javax.swing.JRadioButton RadMaNV;
    private javax.swing.JButton btnResetCTHD;
    private javax.swing.JButton btnResetHD;
    private javax.swing.JButton btnSuaCTHD;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnThemCTHD;
    private javax.swing.JButton btnThemHD;
    private javax.swing.JButton btnTimHD;
    private javax.swing.JButton btnXoaCTHD;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblMaDH_CTHD;
    private javax.swing.JLabel lblMaDH_HD;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblMaMH;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblPTTT;
    private javax.swing.JLabel lblSL;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTriGia;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaDH;
    private javax.swing.JTextField txtMaDH_CTHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaMH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtPTTT;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimHD;
    private javax.swing.JTextField txtTriGia;
    // End of variables declaration//GEN-END:variables
}
