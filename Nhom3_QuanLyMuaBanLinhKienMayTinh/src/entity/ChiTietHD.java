package entity;

public class ChiTietHD {
	private String maHD;
	private String maLinhKien;
	private int soLuong;
	private double donGia;
	private double giamGia;
	private double thanhTien;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaLinhKien() {
		return maLinhKien;
	}
	public void setMaLinhKien(String maLinhKien) {
		this.maLinhKien = maLinhKien;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public ChiTietHD(String maHD, String maLinhKien, int soLuong, double donGia, double giamGia, double thanhTien) {
		super();
		setDonGia(donGia);
		setGiamGia(giamGia);
		setMaHD(maHD);
		setMaLinhKien(maLinhKien);
		setSoLuong(soLuong);
		setThanhTien(thanhTien);
	}
	@Override
	public String toString() {
		return "ChiTietHD [maHD=" + maHD + ", maLinhKien=" + maLinhKien + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ ", giamGia=" + giamGia + ", thanhTien=" + thanhTien + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
		result = prime * result + ((maLinhKien == null) ? 0 : maLinhKien.hashCode());
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
		ChiTietHD other = (ChiTietHD) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		if (maLinhKien == null) {
			if (other.maLinhKien != null)
				return false;
		} else if (!maLinhKien.equals(other.maLinhKien))
			return false;
		return true;
	}
	
	
}
