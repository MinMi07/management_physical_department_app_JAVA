package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import information.MonHoc;
import information.infor_DungCu;

public class ListMonHoc {
	private static ArrayList<MonHoc> list_monHoc = new ArrayList<MonHoc>();

	/*public static void main(String[] args) throws Exception {
		list_monHoc.add(new MonHoc("MH1", "Bong chuyen"));
		list_monHoc.add(new MonHoc("MH2", "Bong ro"));
		list_monHoc.add(new MonHoc("MH3", "Cau long"));
		list_monHoc.add(new MonHoc("MH4", "Aerobic"));
		list_monHoc.add(new MonHoc("MH5", "Bong ban"));
		LuuFile("ListMonHoc.txt");
	}

	public static void LuuFile(String fileName) throws Exception {
		FileOutputStream fs = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (MonHoc monHoc : list_monHoc) {
			os.writeObject(monHoc);
		}
		fs.close();
		os.close();
	}*/
}
