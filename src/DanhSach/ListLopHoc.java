package DanhSach;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import information.MonHoc;
import information.infor_LopHoc;

public class ListLopHoc {
	private static ArrayList<infor_LopHoc> list_lLopHoc = new ArrayList<infor_LopHoc>();
	public static void main(String[] args) throws Exception {
		list_lLopHoc.add(new infor_LopHoc("L1", "KĨ THUẬT PHẦN MỀM 1", "KĨ THUẬT PHẦN MỀM", "NGUYỄN VĂN MỀM",1));
		list_lLopHoc.add(new infor_LopHoc("L2", "KĨ THUẬT PHẦN MỀM 2", "CÔNG NGHỆ THÔNG TIN", "NGUYỄN VĂN TIN",2));
		list_lLopHoc.add(new infor_LopHoc("L3", "DU LỊCH 1", "VĂN HÓA", "NGUYỄN VĂN TÍNH",2));
		list_lLopHoc.add(new infor_LopHoc("L4", "DU LỊCH 2", "DU LỊCH QUỐC TẾ", "NGUYỄN VĂN HỆ THỐNG",1));
	
		list_lLopHoc.add(new infor_LopHoc("L5", "NGOẠI NGỮ 1", "TIẾNG HÀN", "NGUYỄN VĂN MỀM B",3));
		list_lLopHoc.add(new infor_LopHoc("L6", "NGOẠI NGỮ 2", "TIẾNG ANH", "NGUYỄN VĂN TIN B",1));
		list_lLopHoc.add(new infor_LopHoc("L7", "THỰC PHẨM 1", "HÓA PHẨM", "NGUYỄN VĂN TÍNH B",1));
		list_lLopHoc.add(new infor_LopHoc("L8", "THỰC PHẨM 2", "CHĂN NUÔI", "NGUYỄN VĂN HỆ THỐNG B",2));
		LuuFile("ListLopHoc.txt");
	}
	
	public static void LuuFile(String fileName) throws Exception {
		FileOutputStream fs = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (infor_LopHoc monHoc : list_lLopHoc) {
			os.writeObject(monHoc);
		}
		fs.close();
		os.close();
	}
}
