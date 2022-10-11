package information;

import java.io.Serializable;

public class infor_LopHoc implements Serializable{
	private String MaLop;
	private String TenLop;
	private String ChuyenNganh;
	private String TenChuNhiem;
	private int Khoa;

	public infor_LopHoc(String maLop, String tenLop, String chuyenNganh, String tenChuNhiem, int khoa) {
		MaLop = maLop;
		TenLop = tenLop;
		ChuyenNganh = chuyenNganh;
		TenChuNhiem = tenChuNhiem;
		Khoa = khoa;
	}

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}

	public String getChuyenNganh() {
		return ChuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		ChuyenNganh = chuyenNganh;
	}

	public String getTenChuNhiem() {
		return TenChuNhiem;
	}

	public void setTenChuNhiem(String tenChuNhiem) {
		TenChuNhiem = tenChuNhiem;
	}

	public int getKhoa() {
		return Khoa;
	}

	public void setKhoa(int khoa) {
		Khoa = khoa;
	}
}
