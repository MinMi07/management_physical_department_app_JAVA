package information;

import java.io.Serializable;
import java.util.ArrayList;

import ClassKoAdd.LopDK;
import ClassKoAdd.SapXepLichHoc;

public class LopdaDK implements Serializable {
	private String MaSV;
	private SapXepLichHoc list_sSapXepLichHoc;
	private float Diem1;
	private float Diem2;
	private float DiemThi;
	private String HanhKiem;
	public float DiemTB() {
		return (Diem1 + Diem2 * 2 + DiemThi * 7) / 10; 
	}
	public LopdaDK(String maSV, SapXepLichHoc list_sSapXepLichHoc, float diem1, float diem2, float diemThi,
			String hanhKiem) {
		MaSV = maSV;
		this.list_sSapXepLichHoc = list_sSapXepLichHoc;
		Diem1 = diem1;
		Diem2 = diem2;
		DiemThi = diemThi;
		HanhKiem = hanhKiem;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public SapXepLichHoc getList_sSapXepLichHoc() {
		return list_sSapXepLichHoc;
	}

	public void setList_sSapXepLichHoc(SapXepLichHoc list_sSapXepLichHoc) {
		this.list_sSapXepLichHoc = list_sSapXepLichHoc;
	}

	public float getDiem1() {
		return Diem1;
	}

	public void setDiem1(float f) {
		Diem1 = f;
	}

	public float getDiem2() {
		return Diem2;
	}

	public void setDiem2(float diem2) {
		Diem2 = diem2;
	}

	public float getDiemThi() {
		return DiemThi;
	}

	public void setDiemThi(float diemThi) {
		DiemThi = diemThi;
	}

	public String getHanhKiem() {
		return HanhKiem;
	}

	public void setHanhKiem(String hanhKiem) {
		HanhKiem = hanhKiem;
	}

}
