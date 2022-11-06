package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LinhKien;
import entity.Loai;
public class Loai_DAO {
	public ArrayList<Loai> getAllLoai() {
		ArrayList<Loai> dsL = new ArrayList<Loai>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Loai";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maL=rs.getString(1);
				String tenL=rs.getString(2);	
				Loai l = new Loai(maL, tenL);
				dsL.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsL;
	}
	public boolean create(Loai l) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into"+" Loai values(?, ?)");
			stmt.setString(1, l.getMaLoai());
			stmt.setString(2, l.getTenLoai());
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
	public boolean delete(String maL) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			String str = "delete from Loai where maLoai = ?";
			stmt=con.prepareStatement(str);
			stmt.setString(1,maL);
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
	public boolean update(Loai l) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update Loai set tenLoai=? where maLoai= ?");
			stmt.setString(1, l.getTenLoai());
			stmt.setString(2, l.getMaLoai());
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
	
	public Loai getLoaiTheoMaL(String maL) {
		Loai l = null;
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="Select * from Loai where maLoai = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, maL);
			ResultSet rs=statement.executeQuery();
			 if (rs.next() == false) {
				  return l;
			 }
			 else {
				String mal=rs.getString(1);
				String tenL=rs.getString(2);
				l=new Loai(mal, tenL);
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
		}return l;
	}
}
