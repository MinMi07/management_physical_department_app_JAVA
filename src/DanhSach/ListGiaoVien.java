package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import information.ChuyenNganh;
import information.infor_Teacher;

public class ListGiaoVien {
	private static ArrayList<infor_Teacher> list_inInfor_Teacher = new ArrayList<infor_Teacher>();

	/*public static void main(String[] args) throws Exception {
		list_inInfor_Teacher.add(new infor_Teacher("1", "Pham Van Quy", "012343646", "Ha Noi", "sf@gmail.com"));
		list_inInfor_Teacher.add(new infor_Teacher("2", "Nguyen Van Manh", "023443646", "Hai Duong", "dg@gmail.com"));
		list_inInfor_Teacher.add(new infor_Teacher("3", "Nguyen Thi Xuan", "023563646", "Ha Noi", "fh@gmail.com"));
		list_inInfor_Teacher.add(new infor_Teacher("4", "Phung Thi Loan", "028743646", "Thanh Hoa", "dg@gmail.com"));
		LuuFile("ListGiaoVien.txt");
	}

	public static void LuuFile(String fileName) throws Exception {
		FileOutputStream fs = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (infor_Teacher infor_Teacher : list_inInfor_Teacher) {
			os.writeObject(infor_Teacher);
		}
		fs.close();
		os.close();
	}*/
}
