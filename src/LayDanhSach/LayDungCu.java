package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import information.infor_DungCu;
import information.infor_Teacher;

public class LayDungCu {
	public static ArrayList<infor_DungCu> list_inDungCu() throws Exception {
		ArrayList<infor_DungCu> listDungCu = new ArrayList<infor_DungCu>();
		FileInputStream fi = new FileInputStream("ListDungCu.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			infor_DungCu obj = (infor_DungCu) ois.readObject();
			if (obj != null) {
				infor_DungCu a = (infor_DungCu) obj;
				listDungCu.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listDungCu;
	}
}
