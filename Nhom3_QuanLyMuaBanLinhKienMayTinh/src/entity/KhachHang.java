package entity;

public class KhachHang {
	private String maKhach;
	private String tenKhach;
	private String diaChi;
	private String dienThoai;
	private String email;
	public String getMaKhach() {
		return maKhach;
	}
	public void setMaKhach(String maKhach) {
		this.maKhach = maKhach;
	}
	public String getTenKhach() {
		return tenKhach;
	}
	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public KhachHang(String maKhach, String tenKhach, String diaChi, String dienThoai, String email) {
		super();
		setDiaChi(diaChi);
		setDienThoai(dienThoai);
		setEmail(email);
		setMaKhach(maKhach);
		setTenKhach(tenKhach);
	}
	public KhachHang() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKhach == null) ? 0 : maKhach.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKhach == null) {
			if (other.maKhach != null)
				return false;
		} else if (!maKhach.equals(other.maKhach))
			return false;
		return true;
	}
	
}
