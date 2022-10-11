package information;

import java.io.Serializable;

public class infor_sinhvien implements Serializable{
	private String MaSV;
	private String HoTen;
	private String NgaySinh;
	private String GioiTinh;
	private String SDT;
	private String Email;
	private int Khoa;
	private String ChuyenNganh;

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getKhoa() {
		return Khoa;
	}

	public void setKhoa(int khoa) {
		Khoa = khoa;
	}

	public String getChuyenNganh() {
		return ChuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		ChuyenNganh = chuyenNganh;
	}

	public infor_sinhvien(String maSV, String hoTen, String ngaySinh, String gioiTinh, String sDT, String email,
			int khoa, String chuyenNganh) {
		MaSV = maSV;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		SDT = sDT;
		Email = email;
		Khoa = khoa;
		ChuyenNganh = chuyenNganh;
	}
}
