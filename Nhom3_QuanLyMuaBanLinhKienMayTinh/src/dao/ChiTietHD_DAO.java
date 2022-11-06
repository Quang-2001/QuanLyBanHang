package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHD;

public class ChiTietHD_DAO {
	public ArrayList<ChiTietHD> getAllChiTietHD() {
		ArrayList<ChiTietHD> dsCTHD = new ArrayList<ChiTietHD>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from ChiTietHD";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maHD=rs.getString(1);
				String maLK=rs.getString(2);	
				int soLuong=rs.getInt(3);
				double donGia = rs.getDouble(4);
				double giamGia = rs.getDouble(5);
				double thanhTien = rs.getDouble(6);
				ChiTietHD cthd = new ChiTietHD(maHD, maLK,soLuong , donGia, giamGia,thanhTien);
				dsCTHD.add(cthd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsCTHD;
	}
	public boolean create(ChiTietHD cthd) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into"+" ChiTietHD values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, cthd.getMaHD());
			stmt.setString(2, cthd.getMaLinhKien());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setDouble(4, cthd.getDonGia());
			stmt.setDouble(5, cthd.getGiamGia());
			stmt.setDouble(6, cthd.getThanhTien());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return n>0;
	}
	public boolean delete(String maHD, String maLK) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			String str = "delete from ChiTietHD where maHD = ? and maLinhKien = ?";
			stmt=con.prepareStatement(str);
			stmt.setString(1,maHD);
			stmt.setString(2,maLK);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean update(ChiTietHD cthd) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update ChiTietHD set soLuong=?, donGia=?, giamGia=?, thanhTien=? where maHD = ? and maLinhKien = ?");
			stmt.setInt(1, cthd.getSoLuong());
			stmt.setDouble(2, cthd.getDonGia());
			stmt.setDouble(3, cthd.getGiamGia());
			stmt.setDouble(4, cthd.getThanhTien());
			stmt.setString(5, cthd.getMaHD());
			stmt.setString(6, cthd.getMaLinhKien());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public ArrayList<ChiTietHD> getChiTietHDTheoMaHD(String maHD) {
		ArrayList<ChiTietHD> dsCTHD = new ArrayList<ChiTietHD>();
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="Select * from ChiTietHD where maHD = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				String mahd=rs.getString(1);
				String maLK=rs.getString(2);	
				int soLuong=rs.getInt(3);
				double donGia = rs.getDouble(4);
				double giamGia = rs.getDouble(5);
				double thanhTien = rs.getDouble(6);
				ChiTietHD cthd = new ChiTietHD(mahd, maLK,soLuong , donGia, giamGia,thanhTien);
				dsCTHD.add(cthd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return dsCTHD;
	}

}
