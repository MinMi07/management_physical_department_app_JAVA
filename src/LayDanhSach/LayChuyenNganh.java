package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import information.ChuyenNganh;
import information.infor_DungCu;

public class LayChuyenNganh {
	public static ArrayList<ChuyenNganh> list_chChuyenNganh() throws Exception {
		ArrayList<ChuyenNganh> listChuyenNganh = new ArrayList<ChuyenNganh>();
		FileInputStream fi = new FileInputStream("ListChuyenNganh.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			ChuyenNganh obj = (ChuyenNganh) ois.readObject();
			if (obj != null) {
				ChuyenNganh a = (ChuyenNganh) obj;
				listChuyenNganh.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listChuyenNganh;
	}
}
