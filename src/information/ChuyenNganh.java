package information;

import java.io.Serializable;

public class ChuyenNganh implements Serializable{
	private String MaChuyenNganh;
	private String tenChuyenNganh;

	public ChuyenNganh(String maChuyenNganh, String tenChuyenNganh) {
		MaChuyenNganh = maChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
	}

	public String getMaChuyenNganh() {
		return MaChuyenNganh;
	}

	public void setMaChuyenNganh(String maChuyenNganh) {
		MaChuyenNganh = maChuyenNganh;
	}

	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}

	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}
}
