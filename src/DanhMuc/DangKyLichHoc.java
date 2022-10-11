package DanhMuc;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ClassKoAdd.LopDK;
import ClassKoAdd.SapXepLichHoc;
import DanhMucBean.SetLichHoc;
import FileGiaoDien.SinhVien;
import LayDanhSach.LayLopDK;
import LayDanhSach.LayLopDaDK;
import LayDanhSach.LaySapXepLichHoc;
import information.LichHoc;
import information.LopdaDK;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class DangKyLichHoc extends JPanel {
	private JTable Table_LichHoc;
	JButton Huy;
	private JTable tbl_LichDK;
	int i = 1001;
	JButton btnDangKy;
	String A;
	String B;
	String tGHocString;
	String tenMonString;
	JPanel panel;
	ArrayList<LopdaDK> list_lLopdaDK;
	ArrayList<SapXepLichHoc> list_sSapXepLichHoc;

	/**
	 * Create the panel.
	 */
	public DangKyLichHoc() {
		GiaoDien();
		try {
//			try {
//				list_sSapXepLichHoc=LaySapXepLichHoc.list_sSapXepLichHoc();
//				LopdaDK a = new LopdaDK("4", list_sSapXepLichHoc.get(0), 0f, 0f, 0f, "");
//				list_lLopdaDK = new ArrayList<LopdaDK>();
//				list_lLopdaDK.add(a);
//				LuuFileDK("ListLopDaDK.txt", list_lLopdaDK);
//			} catch (Exception e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
			setColumnTable1();
			setColumnTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SKien(Table_LichHoc);
		SKien1(tbl_LichDK);
		btnDangKy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ViTri = Table_LichHoc.getSelectedRow();
				if (ViTri < 0) {
					JOptionPane.showMessageDialog(panel, "Chọn Bảng");
				} else {
					InsertDuLieu(A);
				}
			}
		});

		Huy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ViTri1 = tbl_LichDK.getSelectedRow();
				if (ViTri1 < 0) {
					JOptionPane.showMessageDialog(panel, "Chọn Bảng");
				} else {
					try {
						list_lLopdaDK = LayLopDaDK.list_lLopdaDK();
						for (LopdaDK lopDK : list_lLopdaDK) {
							if (lopDK.getList_sSapXepLichHoc().getLopDaDK().getMaLop().equals(B) && lopDK.getMaSV().equals(SinhVien.User)) {
								list_lLopdaDK.remove(lopDK);
								break;
							}
						}
						LuuFileDK("ListLopDaDK.txt", list_lLopdaDK);
						setColumnTable();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public void SKien(JTable Jpanel) {
		Jpanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dModel = (DefaultTableModel) Table_LichHoc.getModel();
				int ViTri = Table_LichHoc.getSelectedRow();
				A = dModel.getValueAt(ViTri, 0).toString();
				tGHocString = dModel.getValueAt(ViTri, 2).toString();
				tenMonString = dModel.getValueAt(ViTri, 1).toString();
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

	public void SKien1(JTable Jpanel) {
		Jpanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dModel = (DefaultTableModel) tbl_LichDK.getModel();
				int ViTri1 = tbl_LichDK.getSelectedRow();
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

	public void DeleteTable() {

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
		scrollPane.setBounds(56, 43, 645, 157);
		panel.add(scrollPane);

		Table_LichHoc = new JTable();
		Table_LichHoc.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(Table_LichHoc);

		btnDangKy = new JButton("ĐĂNG KÝ");
		btnDangKy.setFont(new Font("Arial", Font.BOLD, 13));
		btnDangKy.setBounds(283, 230, 154, 33);
		panel.add(btnDangKy);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(56, 295, 645, 86);
		panel.add(scrollPane_1);

		tbl_LichDK = new JTable();
		tbl_LichDK.setDefaultEditor(Object.class, null);
		scrollPane_1.setViewportView(tbl_LichDK);

		Huy = new JButton("HỦY");
		Huy.setFont(new Font("Arial", Font.BOLD, 13));
		Huy.setBounds(283, 437, 154, 33);
		panel.add(Huy);
	}

	public void setColumnTable1() throws SQLException {
		String[] arr = { "Mã Lớp Học", "Tên Môn Học", "Thời Gian Học", "Giảng Viên", "Khu Vực Học", "Sĩ Số" };
		DefaultTableModel tableModel = new DefaultTableModel(arr, 0);
		Table_LichHoc.removeAll();
		try {
			list_sSapXepLichHoc = LaySapXepLichHoc.list_sSapXepLichHoc();
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

			Table_LichHoc.setModel(tableModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setColumnTable() throws SQLException {
		String[] arr = { "Mã Lớp Học", "Tên Môn Học", "Giảng Viên", "Khu Vực Học", "Thời Gian Học", "Sĩ Số" };
		DefaultTableModel tableModel1 = new DefaultTableModel(arr, 0);
		tbl_LichDK.removeAll();
		try {
			list_lLopdaDK = LayLopDaDK.list_lLopdaDK();
			if(list_lLopdaDK != null) {
			for (LopdaDK lopdaDK : list_lLopdaDK) {
				if(lopdaDK.getMaSV().equals(SinhVien.User)) {
					Vector<String> vector = new Vector<String>();
					vector.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMaLop());
					vector.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMonHoc());
					vector.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getGiangVien());
					vector.add(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getKhuVucHoc());
					vector.add(lopdaDK.getList_sSapXepLichHoc().getThoiGianHoc());
					vector.add(String.valueOf(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getSiSo()));
					tableModel1.addRow(vector);
				}
			}
			tbl_LichDK.setModel(tableModel1);
		}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DeletetDuLieu(String s) {

	}

	public void InsertDuLieu(String s) {
		try {
			list_lLopdaDK = LayLopDaDK.list_lLopdaDK();
			System.out.println(list_lLopdaDK.get(0).getMaSV());
			boolean check = true;
			for (LopdaDK lopdaDK : list_lLopdaDK) {
				if (lopdaDK.getMaSV().equals(SinhVien.User)
						&& lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMaLop().equals(A)) {
					check = false;
				} else {
					if (lopdaDK.getMaSV().equals(SinhVien.User)
							&& lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMonHoc().equals(tenMonString)) {
						check = false;
					} else 
						if (lopdaDK.getMaSV().equals(SinhVien.User)
								&& lopdaDK.getList_sSapXepLichHoc().getThoiGianHoc().equals(tGHocString)) {
							check = false;
						} 
				}
			}
			if(check == true) {
			for (SapXepLichHoc sapXepLichHoc : list_sSapXepLichHoc) {
					if (sapXepLichHoc.getLopDaDK().getMaLop().equals(A)) {
						sapXepLichHoc.getLopDaDK().setSiSo(sapXepLichHoc.getLopDaDK().getSiSo() + 1);
						LopdaDK a = new LopdaDK(SinhVien.User, sapXepLichHoc, 0f, 0f, 0f, "");
						list_lLopdaDK.add(a);
						System.out.println("dathem");
						LuuFileDK("ListLopDaDK.txt", list_lLopdaDK);
						LuuFileSX("ListSapXepLichHoc.txt", list_sSapXepLichHoc);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(panel, "Không thể thêm");
			}
			setColumnTable();
			setColumnTable1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void LuuFileDK(String filename, ArrayList<LopdaDK> listlLopdaDK) throws Exception {
		FileOutputStream fs = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (LopdaDK lopdaDK : listlLopdaDK) {
			os.writeObject(lopdaDK);
		}
		fs.close();
		os.close();
	}

	public void LuuFileSX(String filename, ArrayList<SapXepLichHoc> listsSapXepLichHoc) throws Exception {
		FileOutputStream fs = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (SapXepLichHoc sapXepLichHoc : listsSapXepLichHoc) {
			os.writeObject(sapXepLichHoc);
		}
		fs.close();
		os.close();
	}

}