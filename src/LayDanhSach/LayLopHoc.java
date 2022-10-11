package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import ClassKoAdd.LopDK;
import information.infor_LopHoc;

public class LayLopHoc {
	public static ArrayList<infor_LopHoc> list_lLopHoc() throws Exception {
		ArrayList<infor_LopHoc> listlLopHoc = new ArrayList<infor_LopHoc>();
		FileInputStream fi = new FileInputStream("ListLopHoc.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			infor_LopHoc obj = (infor_LopHoc) ois.readObject();
			if (obj != null) {
				infor_LopHoc a = (infor_LopHoc) obj;
				listlLopHoc.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listlLopHoc;
	}
}
