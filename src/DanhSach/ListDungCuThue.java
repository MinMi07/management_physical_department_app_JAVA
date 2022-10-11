package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import information.infor_DungCuHocTapMuon;

public class ListDungCuThue {
	private static ArrayList<infor_DungCuHocTapMuon> list_inInfor_DungCuThue = new ArrayList<infor_DungCuHocTapMuon>();

	public static void main(String[] args) throws Exception {
		list_inInfor_DungCuThue.add(new infor_DungCuHocTapMuon("DC1", "VỢT CẦU LÔNG", 2, 3, 6000, "3"));
		LuuFile("ListDungCuThue.txt");
	}

	public static void LuuFile(String fileName) throws Exception {
		FileOutputStream fs = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (infor_DungCuHocTapMuon infor_DungCuThue : list_inInfor_DungCuThue) {
			os.writeObject(infor_DungCuThue);
		}
		fs.close();
		os.close();
	}
}
