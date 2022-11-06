package entity;

import java.sql.Date;

public class HoaDon {
	private String maHD;
	private String maNhanVien;
	private String maKhach;
	private Date ngayBan;
	private double tongTien;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaKhach() {
		return maKhach;
	}
	public void setMaKhach(String maKhach) {
		this.maKhach = maKhach;
	}
	public Date getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}
	public HoaDon(String maHD, String maNhanVien, String maKhach, Date ngayBan, double tongTien) {
		super();
		setMaHD(maHD);
		setMaKhach(maKhach);
		setMaNhanVien(maNhanVien);
		setNgayBan(ngayBan);
		setTongTien(tongTien);
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maNhanVien=" + maNhanVien + ", maKhach=" + maKhach + ", ngayBan=" + ngayBan
				+ ", tongTien=" + tongTien + "]";
	}
	
	
}
