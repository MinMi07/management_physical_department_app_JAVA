package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import information.LopdaDK;

public class LayLopDaDK {
	public static ArrayList<LopdaDK> list_lLopdaDK() throws Exception {
		ArrayList<LopdaDK> listlLopdaDK = new ArrayList<LopdaDK>();
		FileInputStream fi = new FileInputStream("ListLopDaDK.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			LopdaDK obj = (LopdaDK) ois.readObject();
			if (obj != null) {
				LopdaDK a = (LopdaDK) obj;
				listlLopdaDK.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listlLopdaDK;
	}
}
