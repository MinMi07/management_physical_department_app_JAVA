package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import information.infor_DungCu;
import information.infor_DungCuHocTapMua;

public class LayDungCuMua {
	public static ArrayList<infor_DungCuHocTapMua> list_inDungCuMua() throws Exception {
		ArrayList<infor_DungCuHocTapMua> listDungCuMua = new ArrayList<infor_DungCuHocTapMua>();
		FileInputStream fi = new FileInputStream("ListDungCuMua.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			infor_DungCuHocTapMua obj = (infor_DungCuHocTapMua) ois.readObject();
			if (obj != null) {
				infor_DungCuHocTapMua a = (infor_DungCuHocTapMua) obj;
				listDungCuMua.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listDungCuMua;
	}
}
