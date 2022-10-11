package information;

import java.io.Serializable;

public class infor_DungCuHocTapMua implements Serializable{
	private String MaDungCu;
	private String TenDungCu;
	private int SLMua;
	private float TongTien;
	private String maSV;
	public infor_DungCuHocTapMua(String maDungCu, String tenDungCu, int sLMua, float tongTien, String maSV) {
		super();
		MaDungCu = maDungCu;
		TenDungCu = tenDungCu;
		SLMua = sLMua;
		TongTien = tongTien;
		this.maSV = maSV;
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
	public int getSLMua() {
		return SLMua;
	}
	public void setSLMua(int sLMua) {
		SLMua = sLMua;
	}
	public float getTongTien() {
		return TongTien;
	}
	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	

}
