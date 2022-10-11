package DanhMuc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ClassKoAdd.LopDK;
import ClassKoAdd.SapXepLichHoc;
import DanhMucBean.SetLichHoc;
import LayDanhSach.LayLopDK;
import LayDanhSach.LayLopDaDK;
import information.LichHoc;
import information.LopdaDK;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ThoiKhoaBieu extends JPanel {
	JPanel panel;
	private JTable tb_LopHoc;
	private JTable tb_LichHoc;
	private DefaultTableModel tableModel;
	JButton btnNewButton;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private ArrayList<SapXepLichHoc> list_sSapXepLichHoc;

	/**
	 * Create the panel.
	 */
	public ThoiKhoaBieu() throws Exception {
		GiaoDien();
		setColumnTable();

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InsertDuLieu();
				try {
					LuuFile("ListSapXepLichHoc.txt", list_sSapXepLichHoc);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void setColumnTable() throws Exception {
		String[] arr = { "Mã Lớp Học", "Tên Lớp Học", "Tên Môn Học", "Chuyên Ngành", "Khóa", "Khu Vực Học", "Giáo Viên",
				"Sĩ Số" };
		tableModel = new DefaultTableModel(arr, 0);
		tb_LopHoc.removeAll();
		ArrayList<LopDK> list_lLopDK = LayLopDK.list_lLopDK();
		for (LopDK lopDK : list_lLopDK) {
			Vector<String> vector = new Vector<String>();
			vector.add(lopDK.getMaLop());
			vector.add(lopDK.getTenLop());
			vector.add(lopDK.getMonHoc());
			vector.add(lopDK.getChuyenNganh());
			vector.add(String.valueOf(lopDK.getKhoa()));
			vector.add(lopDK.getKhuVucHoc());
			vector.add(lopDK.getGiangVien());
			vector.add(String.valueOf(lopDK.getSiSo()));

			tableModel.addRow(vector);
		}
		tb_LopHoc.setModel(tableModel);
	}

	public void setColumnTable1() throws Exception {
		String[] arr = { "Mã Lớp Học", "Tên Môn Học", "Thời Gian Học", "Giảng Viên", "Khu Vực Học", "Sĩ Số" };
		tableModel = new DefaultTableModel(arr, 0);
		tb_LichHoc.removeAll();
		for (SapXepLichHoc sapXepLichHoc : list_sSapXepLichHoc) {
			Vector<String> vector = new Vector<String>();
			vector.add(sapXepLichHoc.getLopDaDK().getMaLop());
			vector.add(sapXepLichHoc.getLopDaDK().getMonHoc());
			vector.add(sapXepLichHoc.getThoiGianHoc());
			vector.add(sapXepLichHoc.getLopDaDK().getGiangVien());
			vector.add(sapXepLichHoc.getLopDaDK().getKhuVucHoc());
			vector.add(String.valueOf(sapXepLichHoc.getLopDaDK().getSiSo()));

			tableModel.addRow(vector);
		}

		tb_LichHoc.setModel(tableModel);
	}

	public void InsertDuLieu() {
		try {
			ArrayList<LopDK> list_lLopDK = LayLopDK.list_lLopDK();
			Collections.sort(list_lLopDK, new Comparator<LopDK>() {
				@Override
				public int compare(LopDK o1, LopDK o2) {
					// TODO Auto-generated method stub
					return o1.getGiangVien().compareTo(o2.getGiangVien());
				}
			});
			list_sSapXepLichHoc = new ArrayList<SapXepLichHoc>();
			List<LichHoc> list_lLichHoc = SetLichHoc.lichHocs();
			int i = 0;
			for (int j = 0; j < list_lLopDK.size(); j++) {
				SapXepLichHoc a;
				if (i <= list_lLichHoc.size()) {
					a = new SapXepLichHoc(list_lLichHoc.get(i).toString(), list_lLopDK.get(j));
					i++;
				} else {
					i = 0;
					a = new SapXepLichHoc(list_lLichHoc.get(i).toString(), list_lLopDK.get(j));
					i++;
				}
				list_sSapXepLichHoc.add(a);
			}
			
			setColumnTable1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void GiaoDien() {

		setLayout(null);
		setBounds(0, 0, 764, 558);
		panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 764, 557);
		add(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("S\u1EAFp X\u1EBFp L\u1ECBch H\u1ECDc ");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(270, 252, 205, 35);
		panel.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 26, 525, 193);
		panel.add(scrollPane);

		tb_LopHoc = new JTable();
		tb_LopHoc.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tb_LopHoc);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(99, 316, 525, 155);
		panel.add(scrollPane_1);

		tb_LichHoc = new JTable();
		tb_LichHoc.setDefaultEditor(Object.class, null);
		scrollPane_1.setViewportView(tb_LichHoc);
	}
	
	public void LuuFile(String filename, ArrayList<SapXepLichHoc> listsSapXepLichHoc) throws Exception {
		FileOutputStream fs = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (SapXepLichHoc sapXepLichHoc : listsSapXepLichHoc) {
			os.writeObject(sapXepLichHoc);
		}
		fs.close();
		os.close();
	}
}
