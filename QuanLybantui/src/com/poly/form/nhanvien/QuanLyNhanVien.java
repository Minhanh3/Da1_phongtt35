package com.poly.form.nhanvien;

import com.formdev.flatlaf.FlatClientProperties;
import com.poly.entity.NhanVien;
import java.security.Timestamp;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.application.repository.NhanVienRepo;

public class QuanLyNhanVien extends javax.swing.JPanel {

    private NhanVienRepo service = new NhanVienRepo();
    private DefaultTableModel mol = new DefaultTableModel();
    int index = -1;

    public QuanLyNhanVien() {
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        filltable(service.getAllNhanVien());
    }

    void filltable(List<NhanVien> list) {
        mol = (DefaultTableModel) tblqlnhanvien.getModel();
        mol.setRowCount(0);
        for (NhanVien n : list) {
            mol.addRow(n.todataRow());
        }
    }

    void showdata(int index) {
        NhanVien nv = service.getAllNhanVien().get(index);

        txtusername.setText(nv.getUsername());
        txtdiachi.setText(nv.getDiaChi());
        txtemail.setText(nv.getEmail());
        txtmaddanh.setText(nv.getMaDinhDanh());
        txtngaysinh.setText(nv.getNgaySinh());
        txtsdt.setText(nv.getSoDienThoai());
        txttennv.setText(nv.getTen());

        if (nv.getGioiTinh().equals("Nam")) {
            this.rdonam.setSelected(true);
        } else {
            this.rdonu.setSelected(true);
        }
        if (nv.getTrangThai().equals("Đang Làm")) {
            this.rdodanglam.setSelected(true);
        } else {
            this.rdonghilam.setSelected(true);
        }
        datetime.setText(nv.getThoiGianTao() + "");
        datesua.setText(nv.getThoiGianSua() + "");
    }

    NhanVien readForm() {
        String username = txtusername.getText().trim();
        String name = txttennv.getText().trim();
        String email = txtemail.getText().trim();
        String sdt = txtsdt.getText().trim();
        String gt = rdonam.isSelected() ? "Nam" : "Nữ";
        String status = rdodanglam.isSelected() ? "Đang Làm" : "Nghỉ Làm";
        String year = txtngaysinh.getText().trim();
        String madd = txtmaddanh.getText().trim();
        String diachi = txtdiachi.getText().trim();

        Date thoiGianTao = new Date(); // Lấy thời gian hiện tại
        Date thoiGianSua = new Date();
        return new NhanVien(username, name, madd, sdt, year, email, gt, diachi, status, thoiGianTao, thoiGianSua);
    }

    void clearForm() {
        txtusername.setText("");
        txttennv.setText("");
        txtdiachi.setText("");
        txtemail.setText("");
        txtmaddanh.setText("");
        txtngaysinh.setText("");
        rdonam.setSelected(true);
        rdodanglam.setSelected(true);
        txtsdt.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        lb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblqlnhanvien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txttennv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtmaddanh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtngaysinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdiachi = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        rdodanglam = new javax.swing.JRadioButton();
        rdonghilam = new javax.swing.JRadioButton();
        datetime = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        datesua = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnfixnv = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btndeletenv = new javax.swing.JButton();
        btndeletenv1 = new javax.swing.JButton();
        btnsreach = new javax.swing.JButton();

        lb.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Quản Lý Nhân Viên");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nhập ( Tên , Email , Sdt )");

        tblqlnhanvien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblqlnhanvien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblqlnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "UserName", "Ho&Ten", "Email", "Số Điện Thoại", "Giới Tính", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblqlnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblqlnhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblqlnhanvien);
        if (tblqlnhanvien.getColumnModel().getColumnCount() > 0) {
            tblqlnhanvien.getColumnModel().getColumn(0).setResizable(false);
            tblqlnhanvien.getColumnModel().getColumn(1).setResizable(false);
            tblqlnhanvien.getColumnModel().getColumn(2).setResizable(false);
            tblqlnhanvien.getColumnModel().getColumn(3).setResizable(false);
            tblqlnhanvien.getColumnModel().getColumn(4).setResizable(false);
            tblqlnhanvien.getColumnModel().getColumn(5).setResizable(false);
            tblqlnhanvien.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Lọc :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Giới Tính");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Trạng Thái :");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Tất Cả");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Đang Làm");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Nghỉ Làm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(153, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("* UserName");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("* Tên Nhân Viên");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("* Mã Định Danh ( CMT , CCCD )");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("* Ngày Sinh");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("* Số Điện Thoại");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("* Địa Chỉ Cụ Thể");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("* Email");

        txtdiachi.setColumns(20);
        txtdiachi.setRows(5);
        jScrollPane3.setViewportView(txtdiachi);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("* Giới Tính");

        buttonGroup1.add(rdonam);
        rdonam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdonam.setSelected(true);
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdonu.setText("Nữ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("* Trạng Thái");

        buttonGroup3.add(rdodanglam);
        rdodanglam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdodanglam.setSelected(true);
        rdodanglam.setText("Đang Làm");

        buttonGroup3.add(rdonghilam);
        rdonghilam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdonghilam.setText("Nghỉ Làm");

        datetime.setText("               ");

        jLabel14.setText("Thời Gian tạo");

        jLabel15.setText("Thời Gian Sửa :");

        datesua.setText("                 ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdonu)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdodanglam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdonghilam)))
                                .addGap(129, 183, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtusername)
                                    .addComponent(txttennv)
                                    .addComponent(txtmaddanh))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7)
                                            .addComponent(txtsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                            .addComponent(txtngaysinh)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(rdonam)
                                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(datesua)
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(datetime)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(datesua)
                        .addComponent(jLabel14)
                        .addComponent(datetime))
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmaddanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(rdonam)))
                        .addGap(18, 18, 18)
                        .addComponent(rdonu)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdodanglam)
                            .addComponent(rdonghilam))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnfixnv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnfixnv.setText("Sửa Nhân Viên");
        btnfixnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfixnvActionPerformed(evt);
            }
        });

        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnadd.setText("Thêm Nhân Viên");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btndeletenv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndeletenv.setText("Xóa Nhân Viên");
        btndeletenv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletenvActionPerformed(evt);
            }
        });

        btndeletenv1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndeletenv1.setText("Xóa Form");
        btndeletenv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletenv1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnfixnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndeletenv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndeletenv1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnfixnv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btndeletenv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btndeletenv1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsreach.setText("Tìm Kiếm");
        btnsreach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsreachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsreach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnsreach)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblqlnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblqlnhanvienMouseClicked
        index = tblqlnhanvien.getSelectedRow();
        showdata(index);
    }//GEN-LAST:event_tblqlnhanvienMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        int confirmResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm?", "Xác nhận thêm Nhân Viên", JOptionPane.YES_NO_OPTION);
        if (confirmResult == JOptionPane.YES_OPTION) {
            NhanVien nv = readForm();
            if (service.insertNV(nv) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
                filltable(service.getAllNhanVien());

                // Lấy thời gian tạo và thời gian sửa từ đối tượng nv
                Date thoiGianTao = nv.getThoiGianTao();
//                Date thoiGianSua = nv.getThoiGianSua();

                // Định dạng ngày giờ
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                // Set giá trị vào label
//                datesua.setText(dateFormat.format(thoiGianSua));
                datetime.setText(dateFormat.format(thoiGianTao));
            } else {
                JOptionPane.showMessageDialog(this, "Thêm Thất Bại");
            }
        } else {
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnfixnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfixnvActionPerformed
        int confirmResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn Sửa?", "Xác nhận Sửa Nhân Viên", JOptionPane.YES_NO_OPTION);
        if (confirmResult == JOptionPane.YES_OPTION) {
            index = tblqlnhanvien.getSelectedRow();
            int id = Integer.parseInt(tblqlnhanvien.getValueAt(index, 0).toString());
            NhanVien nv = readForm();
            if (service.updateSinhVien(nv, id) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                filltable(service.getAllNhanVien());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa Thất Bại");
            }
        } else {
            // Không thực hiện thêm bản ghi
            // ... 
        }
    }//GEN-LAST:event_btnfixnvActionPerformed

    private void btndeletenvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletenvActionPerformed
        int confirmResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn Xóa?", "Xác nhận Xóa Nhân Viên", JOptionPane.YES_NO_OPTION);
        if (confirmResult == JOptionPane.YES_OPTION) {
            index = tblqlnhanvien.getSelectedRow();
            int id = Integer.parseInt(tblqlnhanvien.getValueAt(index, 0).toString());
            if (service.deleteNhanvien(id) > 0) {
                JOptionPane.showMessageDialog(this, "Xóa Thành Công");
                filltable(service.getAllNhanVien());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa Thất Bại");
            }
        } else {
            // Không thực hiện thêm bản ghi
            // ... 
        }
    }//GEN-LAST:event_btndeletenvActionPerformed

    private void btndeletenv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletenv1ActionPerformed
        clearForm();
    }//GEN-LAST:event_btndeletenv1ActionPerformed

    private void btnsreachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsreachActionPerformed
//        String nameToSearch = txttimkiem.getText(); // Lấy tên cần tìm từ TextField
//        List<NhanVien> listNhanVien = service.findNhanVienByName(nameToSearch);
//
//        if (listNhanVien != null && !listNhanVien.isEmpty()) {
//            // Hiển thị danh sách các nhân viên tìm được trong bảng
//            DefaultTableModel model = (DefaultTableModel) tblqlnhanvien.getModel();
//            model.setRowCount(0); // Xóa hết dữ liệu cũ trong bảng
//
//            for (NhanVien nv : listNhanVien) {
//                model.addRow(new Object[]{
//                    nv.getId(),
//                    nv.getUsername(),
//                    nv.getTen(),
//                    nv.getEmail(),
//                    nv.getSoDienThoai(),
//                    nv.getGioiTinh(),
//                    nv.getTrangThai(),
//                    nv.getNgaySinh(),
//                    nv.getDiaChi(),
//                    nv.getMaDinhDanh()
//                });
//            }
//        } else {
//            // Hiển thị thông báo không tìm thấy nhân viên
//            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên có tên chứa: " + nameToSearch);
//        }


    }//GEN-LAST:event_btnsreachActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndeletenv;
    private javax.swing.JButton btndeletenv1;
    private javax.swing.JButton btnfixnv;
    private javax.swing.JButton btnsreach;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel datesua;
    private javax.swing.JLabel datetime;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb;
    private javax.swing.JRadioButton rdodanglam;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonghilam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tblqlnhanvien;
    private javax.swing.JTextArea txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmaddanh;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttennv;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
