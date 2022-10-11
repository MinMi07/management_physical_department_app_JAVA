package LayDanhSach;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import information.infor_DungCuHocTapMua;
import information.infor_DungCuHocTapMuon;

public class LayDungCuThue {
	public static ArrayList<infor_DungCuHocTapMuon> list_inDungCuThue() throws Exception {
		ArrayList<infor_DungCuHocTapMuon> list_inDungCuThue = new ArrayList<infor_DungCuHocTapMuon>();
		FileInputStream fi = new FileInputStream("ListDungCuThue.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			infor_DungCuHocTapMuon obj = (infor_DungCuHocTapMuon) ois.readObject();
			if (obj != null) {
				infor_DungCuHocTapMuon a = (infor_DungCuHocTapMuon) obj;
				list_inDungCuThue.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return list_inDungCuThue;
	}
}
