package ClassKoAdd;

import java.io.Serializable;

public class SapXepLichHoc implements Serializable{
	private String ThoiGianHoc;
	private LopDK LopDaDK;

	public SapXepLichHoc(String thoiGianHoc, LopDK lopDaDK) {
		ThoiGianHoc = thoiGianHoc;
		LopDaDK = lopDaDK;
	}

	public String getThoiGianHoc() {
		return ThoiGianHoc;
	}

	public void setThoiGianHoc(String thoiGianHoc) {
		ThoiGianHoc = thoiGianHoc;
	}

	public LopDK getLopDaDK() {
		return LopDaDK;
	}

	public void setLopDaDK(LopDK lopDaDK) {
		LopDaDK = lopDaDK;
	}
}
