package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import information.infor_DungCu;

public class ListDungCu {
	private static ArrayList<infor_DungCu> list_inInfor_DungCu = new ArrayList<infor_DungCu>();

//	public static void main(String[] args) throws Exception {
//		list_inInfor_DungCu.add(new infor_DungCu("DC1", "VỢT CẦU LÔNG", 100000));
//		list_inInfor_DungCu.add(new infor_DungCu("DC2", "VỢT BÓNG BÀN", 200000));
//		list_inInfor_DungCu.add(new infor_DungCu("DC3", "BÓNG RỔ", 300000));
//		list_inInfor_DungCu.add(new infor_DungCu("DC4", "CẦU LÔNG", 400000));
//		LuuFile("ListDungCu.txt");
//	}
//
//	public static void LuuFile(String fileName) throws Exception {
//		FileOutputStream fs = new FileOutputStream(fileName);
//		ObjectOutputStream os = new ObjectOutputStream(fs);
//		for (infor_DungCu infor_DungCu : list_inInfor_DungCu) {
//			os.writeObject(infor_DungCu);
//		}
//		fs.close();
//		os.close();
//	}
}
