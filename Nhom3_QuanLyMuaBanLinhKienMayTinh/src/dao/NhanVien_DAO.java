package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				boolean gioitinh = rs.getBoolean(3);
				Date ngaysinh = rs.getDate(4);
				String diaChi=rs.getString(5);
				String sdt=rs.getString(6);
				String email=rs.getString(7);
				double luong = rs.getDouble(8);
				NhanVien nv=new NhanVien(maNV, tenNV, gioitinh,ngaysinh, diaChi, sdt, email,luong);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}

	public boolean create(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into"+" NhanVien values(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setBoolean(3,nv.isGioiTinh());
			stmt.setDate(4,   nv.getNgaySinh());
			stmt.setString(5, nv.getDiaChi());
			stmt.setString(6, nv.getDienThoai());
			stmt.setString(7, nv.getEmail());
			stmt.setDouble(8, nv.getLuong());
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
	
	public boolean delete(String maNV) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			String str = "delete from NhanVien where maNhanVien = ?";
			stmt=con.prepareStatement(str);
			stmt.setString(1,maNV);
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
	public NhanVien getNhanVienTheoMaNV(String maNV) {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="Select * from NhanVien where maNhanVien = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs=statement.executeQuery();
			 if (rs.next() == false) {
				  return nv;
			 }
			 else {
				 	String manv=rs.getString(1);
					String tenNV=rs.getString(2);
					boolean gioitinh = rs.getBoolean(3);
					Date ngaysinh = rs.getDate(4);
					String diaChi=rs.getString(5);
					String sdt=rs.getString(6);
					String email=rs.getString(7);
					double luong = rs.getDouble(8);
					nv=new NhanVien(manv, tenNV, gioitinh,ngaysinh, diaChi, sdt, email,luong);
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
		}return nv;
	}
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update NhanVien set tenNhanVien=?, gioiTinh=?, ngaySinh=?, diaChi= ?, dienThoai= ?, email=?, luong=? where maNhanVien= ?");
			stmt.setString(1, nv.getTenNhanVien());
			stmt.setBoolean(2,nv.isGioiTinh());
			stmt.setDate(3,   nv.getNgaySinh());
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getDienThoai());
			stmt.setString(6, nv.getEmail());
			stmt.setDouble(7, nv.getLuong());
			stmt.setString(8, nv.getMaNhanVien());
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
	public NhanVien getNhanVienTheoSDT(String SDT) {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="Select * from NhanVien where dienThoai = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, SDT);
			ResultSet rs=statement.executeQuery();
			 if (rs.next() == false) {
				  return nv;
			 }
			 else {
				 	String manv=rs.getString(1);
					String tenNV=rs.getString(2);
					boolean gioitinh = rs.getBoolean(3);
					Date ngaysinh = rs.getDate(4);
					String diaChi=rs.getString(5);
					String sdt=rs.getString(6);
					String email=rs.getString(7);
					double luong = rs.getDouble(8);
					nv=new NhanVien(manv, tenNV, gioitinh,ngaysinh, diaChi, sdt, email,luong);
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
		}return nv;
	}
	public ArrayList<NhanVien> getNhanVienTheoGT(int x) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		PreparedStatement statement=null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien where gioiTinh = ?" ;
			statement=con.prepareStatement(sql);
			statement.setInt(1,x);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				boolean gioitinh = rs.getBoolean(3);
				Date ngaysinh = rs.getDate(4);
				String diaChi=rs.getString(5);
				String sdt=rs.getString(6);
				String email=rs.getString(7);
				double luong = rs.getDouble(8);
				NhanVien nv=new NhanVien(maNV, tenNV, gioitinh,ngaysinh, diaChi, sdt, email,luong);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
}
