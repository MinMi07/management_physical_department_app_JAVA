package information;

import java.io.Serializable;

public class infor_DungCuHocTapMuon implements Serializable{
	private String MaDungCu;
	private String TenDungCu;
	private int SLThue;
	private int SoNgayThue;
	private float TongTien;
	private String MaSV;

	

	public infor_DungCuHocTapMuon(String maDungCu, String tenDungCu, int sLThue, int soNgayThue, float tongTien,
			String maSV) {
		super();
		MaDungCu = maDungCu;
		TenDungCu = tenDungCu;
		SLThue = sLThue;
		SoNgayThue = soNgayThue;
		TongTien = tongTien;
		MaSV = maSV;
	}

	public String getMaDungCu() {
		return MaDungCu;
	}

	public void setMaDungCu(String maDungCu) {
		MaDungCu = maDungCu;
	}

	public String getTenDungCu() {
		return TenDungCu;
	}

	public void setTenDungCu(String tenDungCu) {
		TenDungCu = tenDungCu;
	}

	public int getSLThue() {
		return SLThue;
	}

	public void setSLThue(int sLThue) {
		SLThue = sLThue;
	}

	public int getSoNgayThue() {
		return SoNgayThue;
	}

	public void setSoNgayThue(int soNgayThue) {
		SoNgayThue = soNgayThue;
	}

	public float getTongTien() {
		return TongTien;
	}

	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
}
