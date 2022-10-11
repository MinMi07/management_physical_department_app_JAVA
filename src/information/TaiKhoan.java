package information;

import java.io.Serializable;

public class TaiKhoan implements Serializable{
	private String TK;
	private String MK;
	private String VaiTro;

	public TaiKhoan(String tK, String mK, String vaiTro) {
		TK = tK;
		MK = mK;
		VaiTro = vaiTro;
	}

	public String getTK() {
		return TK;
	}

	public void setTK(String tK) {
		TK = tK;
	}

	public String getMK() {
		return MK;
	}

	public void setMK(String mK) {
		MK = mK;
	}

	public String getVaiTro() {
		return VaiTro;
	}

	public void setVaiTro(String vaiTro) {
		VaiTro = vaiTro;
	}

}
