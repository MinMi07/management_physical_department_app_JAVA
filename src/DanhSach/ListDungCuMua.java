package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import information.infor_DungCu;
import information.infor_DungCuHocTapMua;

public class ListDungCuMua {
	private static ArrayList<infor_DungCuHocTapMua> list_inInfor_DungCuMua = new ArrayList<infor_DungCuHocTapMua>();
//
//	public static void main(String[] args) throws Exception {
//		list_inInfor_DungCuMua.add(new infor_DungCuHocTapMua("DC1", "VỢT CẦU LÔNG", 2, 200000, "3"));
//		LuuFile("ListDungCuMua.txt");
//	}
//
//	public static void LuuFile(String fileName) throws Exception {
//		FileOutputStream fs = new FileOutputStream(fileName);
//		ObjectOutputStream os = new ObjectOutputStream(fs);
//		for (infor_DungCuHocTapMua infor_DungCuM : list_inInfor_DungCuMua) {
//			os.writeObject(infor_DungCuM);
//		}
//		fs.close();
//		os.close();
//	}
}
