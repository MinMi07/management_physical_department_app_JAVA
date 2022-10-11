package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ClassKoAdd.LopDK;
import information.infor_LopHoc;

public class ListLopDK {
	private static ArrayList<LopDK> list_lLopDK = new ArrayList<LopDK>();
	/*public static void main(String[] args) {
		list_lLopDK.add(new LopDK("L1", "KTPM01", "Bóng bàn", 14, "CNTT", "Nguyen Van A", "Khu A", 0));
		try {
			LuuFile("ListLopDK.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void LuuFile(String fileName) throws Exception {
		FileOutputStream fs = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (LopDK lopDK : list_lLopDK) {
			os.writeObject(lopDK);
		}
		fs.close();
		os.close();
	}*/
}
