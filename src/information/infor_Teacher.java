package information;

import java.io.Serializable;

public class infor_Teacher implements Serializable{
	private String MaGV;
	private String TenGV;
	private String SoDT;
	private String DiaChi;
	private String Email;

	public infor_Teacher(String maGV, String tenGV, String soDT, String diaChi, String email) {
		super();
		MaGV = maGV;
		TenGV = tenGV;
		SoDT = soDT;
		DiaChi = diaChi;
		Email = email;
	}

	public String getMaGV() {
		return MaGV;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}

	public String getTenGV() {
		return TenGV;
	}

	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}

	public String getSoDT() {
		return SoDT;
	}

	public void setSoDT(String soDT) {
		SoDT = soDT;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
}
