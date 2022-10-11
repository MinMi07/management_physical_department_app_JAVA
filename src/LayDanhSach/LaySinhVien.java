package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import information.MonHoc;
import information.infor_sinhvien;

public class LaySinhVien {
	public static ArrayList<infor_sinhvien> list_Infor_sinhviens() throws Exception {
		ArrayList<infor_sinhvien> listsSinhvien = new ArrayList<infor_sinhvien>();
		FileInputStream fi = new FileInputStream("ListSinhVien.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			infor_sinhvien obj = (infor_sinhvien) ois.readObject();
			if (obj != null) {
				infor_sinhvien a = (infor_sinhvien) obj;
				listsSinhvien.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listsSinhvien;
	}
}
