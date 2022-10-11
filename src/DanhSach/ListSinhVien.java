package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import information.TaiKhoan;
import information.infor_sinhvien;

public class ListSinhVien {
	private static ArrayList<infor_sinhvien> list_inInfor_sinhvien = new ArrayList<infor_sinhvien>();

	public static void main(String[] args) throws Exception {
		list_inInfor_sinhvien.add(
				new infor_sinhvien("1", "Nguyen Van A", "1/1/2001", "Nam", "012343646", "sf@gmail.com", 14, "CNTT"));
		list_inInfor_sinhvien.add(
				new infor_sinhvien("2", "Dinh Manh B", "1/1/2000", "Nam", "023443646", "dg@gmail.com", 13, "O to"));
		list_inInfor_sinhvien.add(
				new infor_sinhvien("3", "Nguyen Thi C", "2/3/2002", "Nu", "027843646", "tu@gmail.com", 15, "Du lich"));
		list_inInfor_sinhvien.add(
				new infor_sinhvien("4", "Pham Thi D", "5/6/2001", "Nu", "045643646", "tu@gmail.com", 14, "Du lich"));
		LuuFile("ListSinhVien.txt");
	}

	public static void LuuFile(String fileName) throws Exception {
		FileOutputStream fs = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (infor_sinhvien infor_sinhvien : list_inInfor_sinhvien) {
			os.writeObject(infor_sinhvien);
		}
		fs.close();
		os.close();
	}
}
