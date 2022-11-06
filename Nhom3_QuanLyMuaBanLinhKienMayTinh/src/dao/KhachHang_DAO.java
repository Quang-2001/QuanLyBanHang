package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);	
				String diaChi=rs.getString(3);
				String sdt=rs.getString(4);
				String email=rs.getString(5);
				KhachHang kh=new KhachHang(maKH, tenKH, diaChi, sdt, email);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}

	public boolean create(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into"+" KhachHang values(?, ?, ?, ?, ?)");
			stmt.setString(1, kh.getMaKhach());
			stmt.setString(2, kh.getTenKhach());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getDienThoai());
			stmt.setString(5, kh.getEmail());
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
	
	public boolean delete(String maKH) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			String str = "delete from KhachHang where maKhach = ?";
			stmt=con.prepareStatement(str);
			stmt.setString(1,maKH);
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
	public KhachHang getKhachHangTheoMaKH(String maKH) {
		KhachHang kh = null;
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="Select * from KhachHang where maKhach = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs=statement.executeQuery();
			 if (rs.next() == false) {
				  return kh;
			 }
			 else {
				 String makh=rs.getString(1);
					String tenKH=rs.getString(2);	
					String diaChi=rs.getString(3);
					String sdt=rs.getString(4);
					String email=rs.getString(5);
					kh=new KhachHang(makh, tenKH, diaChi, sdt, email);
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
		}return kh;
	}
	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update KhachHang set tenKhach=?, diaChi= ?, dienThoai= ?, email=? where maKhach= ?");
			stmt.setString(1, kh.getTenKhach());
			stmt.setString(2, kh.getDiaChi());
			stmt.setString(3, kh.getDienThoai());
			stmt.setString(4, kh.getEmail());
			stmt.setString(5, kh.getMaKhach());
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
	public KhachHang getKhachHangTheoSDT(String SDT) {
		KhachHang kh = null;
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="Select * from KhachHang where dienThoai = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, SDT);
			ResultSet rs=statement.executeQuery();
			 if (rs.next() == false) {
				  return kh;
			 }
			 else {
				 String makh=rs.getString(1);
					String tenKH=rs.getString(2);	
					String diaChi=rs.getString(3);
					String sdt=rs.getString(4);
					String email=rs.getString(5);
					kh=new KhachHang(makh, tenKH, diaChi, sdt, email);
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
		}return kh;
	}
	public int getMaKH() {
		int ma = 1;
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="select max( CONVERT(int , SUBSTRING(maKhach,3 , 5))) from KhachHang";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			 if (rs.next() == false) {
				  return ma;
			 }
			 else {
				 	ma = rs.getInt(1);
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
		}
		return ma + 1;
	}
}
