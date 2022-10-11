package LayDanhSach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import information.infor_Teacher;

public class LayGiaoVien {
	public static ArrayList<infor_Teacher> list_inInfor_Teacher() throws Exception {
		ArrayList<infor_Teacher> listTeacher = new ArrayList<infor_Teacher>();
		listTeacher = new ArrayList<infor_Teacher>();
		FileInputStream fi = new FileInputStream("ListGiaoVien.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			infor_Teacher obj = (infor_Teacher) ois.readObject();
			if (obj != null) {
				infor_Teacher a = (infor_Teacher) obj;
				listTeacher.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
		return listTeacher;
	}
}
