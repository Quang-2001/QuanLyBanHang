package entity;

import java.time.LocalDate;
import java.util.Date;


public class LinhKien {
	private String maLinhkien;
	private String tenLinhkien;
	private Loai loai;
	private int soLuong;
	private double donGiaNhap;
	private double donGiaBan;
	private Date ngayNhap;
	
	
	public String getMaLinhkien() {
		return maLinhkien;
	}
	public void setMaLinhkien(String maLinhkien) {
		this.maLinhkien = maLinhkien;
	}
	public String getTenLinhkien() {
		return tenLinhkien;
	}
	public void setTenLinhkien(String tenLinhkien) {
		this.tenLinhkien = tenLinhkien;
	}
	public Loai getLoai() {
		return loai;
	}
	public void setLoai(Loai loai) {
		this.loai = loai;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGiaNhap() {
		return donGiaNhap;
	}
	public void setDonGiaNhap(double donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}
	public double getDonGiaBan() {
		return donGiaBan;
	}
	public void setDonGiaBan(double donGiaBan) {
		this.donGiaBan = donGiaBan;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public LinhKien(String maLinhkien, String tenLinhkien, Loai loai, int soLuong, double donGiaNhap, double donGiaBan,
			Date ngayNhap) {
		setMaLinhkien(maLinhkien);
		setDonGiaBan(donGiaBan);
		setDonGiaNhap(donGiaNhap);
		setLoai(loai);
		setNgayNhap(ngayNhap);
		setSoLuong(soLuong);
		setTenLinhkien(tenLinhkien);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLinhkien == null) ? 0 : maLinhkien.hashCode());
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
		LinhKien other = (LinhKien) obj;
		if (maLinhkien == null) {
			if (other.maLinhkien != null)
				return false;
		} else if (!maLinhkien.equals(other.maLinhkien))
			return false;
		return true;
	}
	public LinhKien() {
		
	}
	@Override
	public String toString() {
		return "LinhKien [maLinhkien=" + maLinhkien + ", tenLinhkien=" + tenLinhkien + ", loai=" + loai + ", soLuong="
				+ soLuong + ", donGiaNhap=" + donGiaNhap + ", donGiaBan=" + donGiaBan + ", ngayNhap=" + ngayNhap + "]";
	}
	
}
