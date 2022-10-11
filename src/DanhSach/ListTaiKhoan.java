package DanhSach;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import information.TaiKhoan;

public class ListTaiKhoan {
	private static ArrayList<TaiKhoan> list_taiKhoan = new ArrayList<TaiKhoan>();

	/*public static void main(String[] args) throws Exception {
		list_taiKhoan.add(new TaiKhoan("1", "1", "GV"));
		list_taiKhoan.add(new TaiKhoan("2", "2", "GV"));
		list_taiKhoan.add(new TaiKhoan("3", "3", "SV"));
		list_taiKhoan.add(new TaiKhoan("4", "4", "SV"));
		list_taiKhoan.add(new TaiKhoan("5", "5", "SV"));
		list_taiKhoan.add(new TaiKhoan("6", "6", "SV"));
		LuuFile("ListTaiKhoan.txt");
		docFile("ListTaiKhoan.txt");*/

	}

//	public static void LuuFile(String fileName) throws Exception {
//		FileOutputStream fs = new FileOutputStream(fileName);
//		ObjectOutputStream os = new ObjectOutputStream(fs);
//		for (TaiKhoan taiKhoan : list_taiKhoan) {
//			os.writeObject(taiKhoan);
//		}
//		fs.close();
//		os.close();
//	}
//	public static void docFile(String fileName) throws Exception {
//		ArrayList<TaiKhoan> list_taiKhoan1 = new ArrayList<TaiKhoan>();
//		FileInputStream fi = new FileInputStream(fileName);
//		ObjectInputStream ois = new ObjectInputStream(fi);
//		while (fi.available() > 0) {
//			TaiKhoan obj = (TaiKhoan) ois.readObject();
//			if (obj != null) {
//				TaiKhoan a = (TaiKhoan) obj;
//				list_taiKhoan1.add(a);
//			} else {
//				break;
//			}
//
//			/*ois.close();
//			fi.close();*/
//		}
//		for (TaiKhoan taiKhoan : list_taiKhoan1) {
//			System.out.println(taiKhoan.getTK());
//		}
//	}


