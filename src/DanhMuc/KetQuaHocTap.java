package DanhMuc;



import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import FileGiaoDien.SinhVien;
import LayDanhSach.LayLopDaDK;
import information.LopdaDK;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class KetQuaHocTap extends JPanel {

	private JPanel panel;
	private JTable table;

	/**
	 * Create the panel.
	 */

	public void GiaoDien() {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 764, 596);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 744, 497);
		panel.add(scrollPane);

		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setFont(new Font("Arial", Font.BOLD, 14));

		scrollPane.setViewportView(table);
	}

	public KetQuaHocTap() {
		GiaoDien();
		try {
			view1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void view1() throws Exception {
		String[] arr = { "Mã Lớp", "Tên Môn", "Điểm Hệ Số 1", "Điểm Hệ Số 2", "Điểm Thi", "Điểm Trung Bình",
				"Xếp Loại" };
		DefaultTableModel tableModel1 = new DefaultTableModel(arr, 0);
		table.removeAll();
		// lấy ra danh sách kết quả học tập của sinh viên có tài khoản đăng nhập đó
		ArrayList<LopdaDK> list_lLopdaDK = LayLopDaDK.list_lLopdaDK();
		for (LopdaDK lopdaDK : list_lLopdaDK) {
			if (lopdaDK.getMaSV().equals(SinhVien.User)) {
				Vector<String> vec1 = new Vector<>();
				vec1.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMaLop());
				vec1.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMonHoc());
				vec1.add(String.valueOf(lopdaDK.getDiem1()));
				vec1.add(String.valueOf(lopdaDK.getDiem2()));
				vec1.add(String.valueOf(lopdaDK.getDiemThi()));
				vec1.add(String.valueOf(lopdaDK.DiemTB()));
				vec1.add(lopdaDK.getHanhKiem());

				tableModel1.addRow(vec1);
			}
		}
		table.setModel(tableModel1);
	}

}
