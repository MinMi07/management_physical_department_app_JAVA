package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import ClassKoAdd.SapXepLichHoc;
import information.MonHoc;

public class LaySapXepLichHoc {
	public static ArrayList<SapXepLichHoc> list_sSapXepLichHoc() throws Exception {
		ArrayList<SapXepLichHoc> listsSapXepLichHoc = new ArrayList<SapXepLichHoc>();
		FileInputStream fi = new FileInputStream("ListSapXepLichHoc.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			SapXepLichHoc obj = (SapXepLichHoc) ois.readObject();
			if (obj != null) {
				SapXepLichHoc a = (SapXepLichHoc) obj;
				listsSapXepLichHoc.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listsSapXepLichHoc;
	}
}
