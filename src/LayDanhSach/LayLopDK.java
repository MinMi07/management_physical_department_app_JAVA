package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import ClassKoAdd.LopDK;
import information.MonHoc;

public class LayLopDK {
	public static ArrayList<LopDK> list_lLopDK() throws Exception {
		ArrayList<LopDK> listlLopDK = new ArrayList<LopDK>();
		FileInputStream fi = new FileInputStream("ListLopDK.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			LopDK obj = (LopDK) ois.readObject();
			if (obj != null) {
				LopDK a = (LopDK) obj;
				listlLopDK.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listlLopDK;
	}
}
