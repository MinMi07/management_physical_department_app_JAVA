package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ClassKoAdd.LopDK;
import ClassKoAdd.SapXepLichHoc;
import information.LopdaDK;

public class ListLopDaDK {
	private static ArrayList<LopdaDK> list_lLopdaDK = new ArrayList<LopdaDK>();
	public static void main(String[] args) {
		/*SapXepLichHoc a=new SapXepLichHoc()
		
		ArrayList<LopdaDK> list_lLopdaDK = new ArrayList<LopdaDK>();
		
		
		try {
			LuuFile("ListLopDaDK.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void LuuFile(String fileName) throws Exception {
		FileOutputStream fs = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (LopdaDK lopdaDK : list_lLopdaDK) {
			os.writeObject(lopdaDK);
		}
		fs.close();
		os.close();
	}*/
}}