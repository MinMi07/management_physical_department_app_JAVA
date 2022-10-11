package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import information.ChuyenNganh;
import information.MonHoc;

public class ListChuyenNganh {
	private static ArrayList<ChuyenNganh> list_chChuyenNganh = new ArrayList<ChuyenNganh>();

	/*public static void main(String[] args) throws Exception {
		list_chChuyenNganh.add(new ChuyenNganh("CN01", "CNTT"));
		list_chChuyenNganh.add(new ChuyenNganh("CN02", "Điện"));
		list_chChuyenNganh.add(new ChuyenNganh("CN03", "Dệt may"));
		list_chChuyenNganh.add(new ChuyenNganh("CN04", "Kế toán"));
		LuuFile("ListChuyenNganh.txt");
	}

	public static void LuuFile(String fileName) throws Exception {
		FileOutputStream fs = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (ChuyenNganh chuyenNganh : list_chChuyenNganh) {
			os.writeObject(chuyenNganh);
		}
		fs.close();
		os.close();
	}*/
}
