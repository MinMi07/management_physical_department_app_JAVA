package ClassKoAdd;

import java.io.Serializable;

public class LopDK implements Serializable{
	private String MaLop;
	private String TenLop;
	private String MonHoc;
	private int Khoa;
	private String ChuyenNganh;
	private String GiangVien;
	private String KhuVucHoc;
	private int SiSo;

	public LopDK(String maLop, String tenLop, String monHoc, int khoa, String chuyenNganh, String giangVien,
			String khuVucHoc, int siSo) {
		MaLop = maLop;
		TenLop = tenLop;
		MonHoc = monHoc;
		Khoa = khoa;
		ChuyenNganh = chuyenNganh;
		GiangVien = giangVien;
		KhuVucHoc = khuVucHoc;
		SiSo = siSo;
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

	public String getMonHoc() {
		return MonHoc;
	}

	public void setMonHoc(String monHoc) {
		MonHoc = monHoc;
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

	public String getGiangVien() {
		return GiangVien;
	}

	public void setGiangVien(String giangVien) {
		GiangVien = giangVien;
	}

	public String getKhuVucHoc() {
		return KhuVucHoc;
	}

	public void setKhuVucHoc(String khuVucHoc) {
		KhuVucHoc = khuVucHoc;
	}

	public int getSiSo() {
		return SiSo;
	}

	public void setSiSo(int siSo) {
		SiSo = siSo;
	}
}
