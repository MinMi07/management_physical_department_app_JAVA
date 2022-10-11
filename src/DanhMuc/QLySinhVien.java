package DanhMuc;

import javax.swing.ComboBoxEditor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import ClassKoAdd.LopDK;
import DanhSach.ListKhoa;
import DanhSach.ListKhuVucHoc;
import LayDanhSach.LayChuyenNganh;
import LayDanhSach.LayGiaoVien;
import LayDanhSach.LayLopDK;
import LayDanhSach.LayLopHoc;
import LayDanhSach.LayMonHoc;
import information.ChuyenNganh;
import information.MonHoc;
import information.infor_LopHoc;
import information.infor_Teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class QLySinhVien extends JPanel {
	JPanel panel;
	private JTextField txt_MaLop;
	private JTable table;
	JButton xoa;
	String B;
	private DefaultTableModel tableModel;
	JComboBox cbx_TenLop, cbx_MonHoc, cbx_ChuyenNganh, cbx_Khoa, cbx_KhuVucHoc, cbx_GiangVien;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */

	public QLySinhVien() throws Exception {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 764, 557);
		add(panel);
		panel.setLayout(null);

		GiaoDien();
		setColumnTable();
		SetCombobox();

		JButton btn_Them = new JButton("THÊM");
		btn_Them.setFont(new Font("Arial", Font.BOLD, 12));
		btn_Them.setBounds(274, 318, 110, 26);
		panel.add(btn_Them);

		xoa = new JButton("XÓA");
		xoa.setFont(new Font("Arial", Font.BOLD, 12));
		xoa.setBounds(274, 521, 110, 26);
		panel.add(xoa);
		btn_Them.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					DieuKien();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		SKien1(table);
		xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ViTri1 = table.getSelectedRow();
				if (ViTri1 < 0) {
					JOptionPane.showMessageDialog(panel, "Chọn bảng");
				} else {
					try {
						ArrayList<LopDK> list_lLopDK = LayLopDK.list_lLopDK();
						for (LopDK lopDK : list_lLopDK) {
							if (lopDK.getMaLop().equals(B)) {
								list_lLopDK.remove(lopDK);
								break;
							}
						}
						LuuFile("ListLopDK.txt", list_lLopDK);
						setColumnTable();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public void DieuKien() throws Exception {
		String errString = "";
		if (txt_MaLop.getText().trim().isEmpty()) {
			errString += "Không được để trống";
		}

		if (errString != "") {
			JOptionPane.showMessageDialog(panel, errString);
		} else {
			InsertTable();
		}
	}

	public void GiaoDien() {
		JLabel lblNewLabel = new JLabel("M\u00E3 L\u1EDBp");
		lblNewLabel.setBounds(31, 34, 103, 20);
		panel.add(lblNewLabel);

		JLabel lblTnLp = new JLabel("T\u00EAn L\u1EDBp");
		lblTnLp.setBounds(31, 75, 69, 20);
		panel.add(lblTnLp);

		JLabel lblMnHc = new JLabel("M\u00F4n H\u1ECDc");
		lblMnHc.setBounds(31, 115, 69, 20);
		panel.add(lblMnHc);

		JLabel lblChuynNgnh = new JLabel("Chuy\u00EAn Ng\u00E0nh");
		lblChuynNgnh.setBounds(31, 155, 103, 20);
		panel.add(lblChuynNgnh);

		JLabel lblKhoa = new JLabel("Kh\u00F3a");
		lblKhoa.setBounds(31, 197, 103, 20);
		panel.add(lblKhoa);

		JLabel lblKhuVcHc = new JLabel("Khu V\u1EF1c H\u1ECDc");
		lblKhuVcHc.setBounds(31, 239, 137, 20);
		panel.add(lblKhuVcHc);

		JLabel lblGingVin = new JLabel("Gi\u1EA3ng Vi\u00EAn");
		lblGingVin.setBounds(31, 287, 103, 20);
		panel.add(lblGingVin);

		JButton btnNewButton_1 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_1.setBounds(523, 75, 110, 21);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_2.setBounds(523, 115, 110, 21);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_3.setBounds(523, 155, 110, 21);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_4.setBounds(523, 197, 110, 21);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_5.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_5.setBounds(523, 239, 110, 21);
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_6.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_6.setBounds(523, 287, 110, 21);
		panel.add(btnNewButton_6);

		cbx_TenLop = new JComboBox();
		cbx_TenLop.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_TenLop.setBounds(208, 75, 243, 21);
		panel.add(cbx_TenLop);

		cbx_MonHoc = new JComboBox();
		cbx_MonHoc.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_MonHoc.setBounds(208, 115, 243, 21);
		panel.add(cbx_MonHoc);

		cbx_ChuyenNganh = new JComboBox();
		cbx_ChuyenNganh.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_ChuyenNganh.setBounds(208, 155, 243, 21);
		panel.add(cbx_ChuyenNganh);

		cbx_Khoa = new JComboBox();
		cbx_Khoa.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_Khoa.setBounds(208, 197, 243, 21);
		panel.add(cbx_Khoa);

		cbx_KhuVucHoc = new JComboBox();
		cbx_KhuVucHoc.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_KhuVucHoc.setBounds(208, 239, 243, 21);
		panel.add(cbx_KhuVucHoc);

		cbx_GiangVien = new JComboBox();
		cbx_GiangVien.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_GiangVien.setBounds(208, 287, 243, 21);
		panel.add(cbx_GiangVien);

		txt_MaLop = new JTextField();
		txt_MaLop.setFont(new Font("Arial", Font.BOLD, 12));
		txt_MaLop.setBounds(208, 35, 243, 19);
		panel.add(txt_MaLop);
		txt_MaLop.setColumns(10);

		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setFont(new Font("Arial", Font.BOLD, 11));
		table.setBounds(31, 371, 695, 140);
		panel.add(table);

	}

	public void SKien1(JTable Jpanel) {
		Jpanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dModel = (DefaultTableModel) table.getModel();
				int ViTri1 = table.getSelectedRow();
				B = dModel.getValueAt(ViTri1, 0).toString();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	public void setColumnTable() throws Exception {
		String[] arr = { "Mã Lớp Học", "Tên Lớp Học", "Tên Môn Học", "Chuyên Ngành", "Khóa", "Khu Vực Học",
				"Giáo Viên" };
		tableModel = new DefaultTableModel(arr, 0);
		table.removeAll();
		tableModel.addRow(arr);
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

			tableModel.addRow(vector);
		}

		table.setModel(tableModel);

	}

	public void SetCombobox() {
		try {
			ArrayList<MonHoc> list_mHoc = LayMonHoc.list_moHoc();
			for (MonHoc monHoc : list_mHoc) {
				cbx_MonHoc.addItem(monHoc.getTenMonHoc());
			}
			ArrayList<ChuyenNganh> list_cChuyenNganh = LayChuyenNganh.list_chChuyenNganh();
			for (ChuyenNganh chuyenNganh : list_cChuyenNganh) {
				cbx_ChuyenNganh.addItem(chuyenNganh.getTenChuyenNganh());
			}

			ArrayList<infor_Teacher> list_tTeacher = LayGiaoVien.list_inInfor_Teacher();
			for (infor_Teacher infor_Teacher : list_tTeacher) {
				cbx_GiangVien.addItem(infor_Teacher.getTenGV());
			}

			ArrayList<Integer> list_Khoa = ListKhoa.list_khoa();
			for (Integer integer : list_Khoa) {
				cbx_Khoa.addItem(integer);
			}

			ArrayList<String> list_KhuVucHoc = ListKhuVucHoc.list_khoa();
			for (String string : list_KhuVucHoc) {
				cbx_KhuVucHoc.addItem(string);
			}

			ArrayList<infor_LopHoc> list_lLopHoc = LayLopHoc.list_lLopHoc();
			for (infor_LopHoc infor_LopHoc : list_lLopHoc) {
				cbx_TenLop.addItem(infor_LopHoc.getTenLop());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void InsertTable() throws Exception {
		ArrayList<LopDK> list_lLopDK = LayLopDK.list_lLopDK();
		boolean check = true;
		for (LopDK lopDK : list_lLopDK) {
			if (lopDK.getMaLop().equals(txt_MaLop.getText())) {
				JOptionPane.showMessageDialog(panel, "Đã trùng mã lớp");
				check = false;
			}
		}
		if (check == true) {
			LopDK aDk = new LopDK(txt_MaLop.getText(), cbx_TenLop.getSelectedItem().toString(),
					cbx_MonHoc.getSelectedItem().toString(), Integer.parseInt(cbx_Khoa.getSelectedItem().toString()),
					cbx_ChuyenNganh.getSelectedItem().toString(), cbx_GiangVien.getSelectedItem().toString(),
					cbx_KhuVucHoc.getSelectedItem().toString(), 0);
			list_lLopDK.add(aDk);
			LuuFile("ListLopDK.txt", list_lLopDK);
			setColumnTable();
		}
	}

	public void LuuFile(String filename, ArrayList<LopDK> listlLopDK) throws Exception {
		FileOutputStream fs = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (LopDK lopDK : listlLopDK) {
			os.writeObject(lopDK);
		}
		fs.close();
		os.close();
	}

}
