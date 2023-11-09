/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.repository;

import com.poly.database.DBConnect;
import com.poly.entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class NhanVienRepo {

    Connection con = null; // biên để kết nối
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null; // ket qua select

    public List<NhanVien> getAllNhanVien() {
        sql = "SELECT id ,username, ten, email, so_dien_thoai, gioi_tinh, trang_thai, ngay_sinh, dia_chi, ma_dinh_danh FROM nhan_vien";
        List<NhanVien> listNV = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(10),
                        rs.getString(5),
                        rs.getString(8),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(7)
                );
                listNV.add(nv);
            }

            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertNV(NhanVien nv) {
        sql = "INSERT INTO nhan_vien(username, ten, email, so_dien_thoai, gioi_tinh, trang_thai, ngay_sinh, dia_chi, ma_dinh_danh) values(?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getUsername());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getEmail());
            ps.setObject(4, nv.getSoDienThoai());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getTrangThai());
            ps.setObject(7, nv.getNgaySinh());
            ps.setObject(8, nv.getDiaChi());
            ps.setObject(9, nv.getMaDinhDanh());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int deleteNhanvien(int id) { // đối số truyền vào luôn là khóa chính
        sql = "DELETE FROM nhan_vien WHERE ID =?";
        try { // xóa đươc
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id); // ? thứ nhất : cột số 1 object
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//    public int updateSinhVien(NhanVien sv, int id) {
//        sql = "UPDATE SinhVien set NAME=? WHERE id=?";
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, sv.getName()); // dấu ? thứ nhất ở trên sql kia 
//            ps.setObject(2, id);
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//    public List<SinhVien> findName(String name) {
//        sql = "SELECT ID, NAME FROM SinhVien WHERE NAME LIKE ?";
//        List<SinhVien> listSV = new ArrayList<>();
//        try {
//            con = DBconnect.getConnection();
//            ps = con.prepareStatement(sql);
////            ps.setString(1, "%" + name + "%");
//            ps.setObject(1, name);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                SinhVien sv = new SinhVien(
//                        rs.getInt(1),rs.getString(name));
//                // get lấy tên cột or cột getString(name)
//                listSV.add(sv);
//            }
//            return listSV;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    
//    public List<SinhVien> Sortname(){
//        sql = "SELECT ID, NAME FROM SinhVien ORDER BY NAME DESC";
//        List<SinhVien> listSV = new ArrayList<>();
//        try {
//            con = DBconnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2)); // get lấy tên cột or cột getString(name)
//                listSV.add(sv);
//            }
//            return listSV;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
