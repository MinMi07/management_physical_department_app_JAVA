package information;

import java.io.Serializable;

public class LichHoc implements Serializable{
	private String Ngay;
	private String Ca;
	
	
	public LichHoc(String ngay, String ca) {
		this.Ngay = ngay;
		this.Ca = ca;
	}


	public LichHoc() {
		// TODO Auto-generated constructor stub
	}


	public String getNgay() {
		return Ngay;
	}


	public void setNgay(String ngay) {
		Ngay = ngay;
	}


	public String getCa() {
		return Ca;
	}


	public void setCa(String ca) {
		Ca = ca;
	}
	
	
	public String toString() {
		return Ngay + " " + Ca;
	}
}
