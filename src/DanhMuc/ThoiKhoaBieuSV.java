package DanhMuc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ClassKoAdd.SapXepLichHoc;
import DanhSach.ListLopDaDK;
import FileGiaoDien.SinhVien;
import LayDanhSach.LayLopDaDK;
import information.LopdaDK;

import java.awt.Color;
import java.awt.Font;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class ThoiKhoaBieuSV extends JPanel {
	JPanel panel;
	JTable Table_LichHoc;
	ArrayList<LopdaDK> list;
	/**
	 * Create the panel.
	 */
	public ThoiKhoaBieuSV() {
		GiaoDien();
		try {
			setColumnTable1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void GiaoDien() {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 764, 596);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 43, 645, 497);
		panel.add(scrollPane);
		
		Table_LichHoc = new JTable();
		Table_LichHoc.setDefaultEditor(Object.class, null);
		Table_LichHoc.setFont(new Font("Arial", Font.BOLD, 14));
		
		scrollPane.setViewportView(Table_LichHoc);
	}
	
	public void setColumnTable1() throws Exception {
		String[] arr = { "Mã Lớp Học", "Tên Môn Học", "Thời Gian Học", "Giảng Viên", "Khu Vực Học", "Sĩ Số" };
		DefaultTableModel tableModel = new DefaultTableModel(arr, 0);
		Table_LichHoc.removeAll();
		list = LayLopDaDK.list_lLopdaDK();
		for (LopdaDK lopdaDK : list) {
			if(lopdaDK.getMaSV().equals(SinhVien.User)) {
			Vector<String> vector = new Vector<String>();
			vector.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMaLop());
			vector.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMonHoc());
			vector.add(lopdaDK.getList_sSapXepLichHoc().getThoiGianHoc());
			vector.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getGiangVien());
			vector.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getKhuVucHoc());
			vector.add(String.valueOf(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getSiSo()));

			tableModel.addRow(vector);
			}
		}

		Table_LichHoc.setModel(tableModel);
	}
	
	
}