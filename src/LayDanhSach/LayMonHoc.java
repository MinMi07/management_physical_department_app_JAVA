package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import information.ChuyenNganh;
import information.MonHoc;

public class LayMonHoc {
	public static ArrayList<MonHoc> list_moHoc() throws Exception {
		ArrayList<MonHoc> listmoHoc = new ArrayList<MonHoc>();
		FileInputStream fi = new FileInputStream("ListMonHoc.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			MonHoc obj = (MonHoc) ois.readObject();
			if (obj != null) {
				MonHoc a = (MonHoc) obj;
				listmoHoc.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listmoHoc;
	}
}
