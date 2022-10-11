package information;

import java.io.Serializable;

public class MonHoc implements Serializable{
	private String MaMH;
	private String TenMonHoc;

	public MonHoc(String maMH, String tenMonHoc) {
		MaMH = maMH;
		TenMonHoc = tenMonHoc;
	}

	public String getMaMH() {
		return MaMH;
	}

	public void setMaMH(String maMH) {
		MaMH = maMH;
	}

	public String getTenMonHoc() {
		return TenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		TenMonHoc = tenMonHoc;
	}

}
