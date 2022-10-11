package information;

import java.io.Serializable;

public class infor_DungCu implements Serializable{
	private String MaDC;
	private String TenDC;
	private float DonGia;

	public infor_DungCu(String maDC, String tenDC, float donGia) {
		MaDC = maDC;
		TenDC = tenDC;
		DonGia = donGia;
	}

	public String getMaDC() {
		return MaDC;
	}

	public void setMaDC(String maDC) {
		MaDC = maDC;
	}

	public String getTenDC() {
		return TenDC;
	}

	public void setTenDC(String tenDC) {
		TenDC = tenDC;
	}

	public float getDonGia() {
		return DonGia;
	}

	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
}
