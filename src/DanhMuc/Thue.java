package DanhMuc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import DanhMucBean.ChuyenManHinhController;
import FileGiaoDien.SinhVien;
import LayDanhSach.LayDungCu;
import LayDanhSach.LayDungCuMua;
import LayDanhSach.LayDungCuThue;
import information.infor_DungCu;
import information.infor_DungCuHocTapMua;
import information.infor_DungCuHocTapMuon;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Thue extends JPanel {
	JPanel panel;
	private JTextField SoLuong;
	private JTextField SoNgay;
	private JTextField DonGia;
	private JTable table;
	JComboBox TenDungCu;
	JButton DangKy;
	String B;
	private JButton btnHy;
	private DefaultTableModel tableModel;
	ArrayList<infor_DungCuHocTapMuon> list_DCThue;
	ArrayList<infor_DungCuHocTapMuon> list_DCThueXoa;
	/**
	 * Create the panel.
	 */
	
	public void GiaoDien() {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.setBounds(0, 0, 764, 596);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn D\u1EE5ng C\u1EE5 ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(75, 40, 162, 30);
		panel.add(lblNewLabel);
		
		TenDungCu = new JComboBox();
		TenDungCu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SetDonGia();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		TenDungCu.setFont(new Font("Arial", Font.BOLD, 13));
		TenDungCu.setBounds(247, 40, 259, 30);
		panel.add(TenDungCu);
		
		JLabel lblNewLabel_1 = new JLabel("S\u1ED1 L\u01B0\u1EE3ng Thu\u00EA");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(75, 109, 162, 30);
		panel.add(lblNewLabel_1);
		
		SoLuong = new JTextField();
		SoLuong.setFont(new Font("Arial", Font.BOLD, 13));
		SoLuong.setBounds(247, 110, 259, 30);
		panel.add(SoLuong);
		SoLuong.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("S\u1ED1 Ng\u00E0y Thu\u00EA");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(75, 178, 162, 30);
		panel.add(lblNewLabel_2);
		
		SoNgay = new JTextField();
		SoNgay.setFont(new Font("Arial", Font.BOLD, 13));
		SoNgay.setColumns(10);
		SoNgay.setBounds(247, 178, 259, 30);
		panel.add(SoNgay);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u0110\u01A1n Gi\u00E1");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(75, 239, 162, 30);
		panel.add(lblNewLabel_2_1);
		
		DonGia = new JTextField();
		DonGia.setEditable(false);
		DonGia.setFont(new Font("Arial", Font.BOLD, 13));;
		DonGia.setColumns(10);
		DonGia.setBounds(247, 239, 259, 30);
		panel.add(DonGia);
		
		DangKy = new JButton("ĐĂNG KÝ");
		DangKy.setFont(new Font("Arial", Font.BOLD, 13));
		DangKy.setBounds(302, 298, 127, 37);
		panel.add(DangKy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 388, 608, 134);
		panel.add(scrollPane);
		
		btnHy = new JButton("HỦY");
		btnHy.setFont(new Font("Arial", Font.BOLD, 13));
		btnHy.setBounds(302, 532, 127, 37);
		panel.add(btnHy);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setViewportView(table);
	}
	
	public void SetCombobox(JComboBox aBox, String TableName, int i) {
		
	}
	
	
	
	public void SetDonGia() throws Exception {
		ArrayList<infor_DungCu> dungCus = LayDungCu.list_inDungCu();
		for (infor_DungCu infor_DungCus : dungCus) {
			if(TenDungCu.getSelectedItem().equals(infor_DungCus.getTenDC())) {
				DonGia.setText(String.valueOf(infor_DungCus.getDonGia()));
			}
		}
	}
	
	public void setColumnTable() throws Exception {
		String[] arr = { "Mã Dụng Cụ", "Tên Dụng Cụ", "Số Lượng Thuê", "Số Ngày Thuê", "Tổng tiền" };
		tableModel = new DefaultTableModel(arr, 0);
		table.removeAll();
		
		list_DCThue = LayDungCuThue.list_inDungCuThue();
		ArrayList<infor_DungCu> dCus = LayDungCu.list_inDungCu();
		
		for (infor_DungCuHocTapMuon dcuThue : list_DCThue) {
			if(dcuThue.getMaSV().equals(SinhVien.User)) {
				float DonGia = 0f;
				for (infor_DungCu DCS : dCus) {
					if(DCS.getTenDC().equals(dcuThue.getTenDungCu())) {

						DonGia = DCS.getDonGia();
					}
				}
				Vector<String> vector = new Vector<String>();
				vector.add(dcuThue.getMaDungCu());
				vector.add(dcuThue.getTenDungCu());
				vector.add(String.valueOf(dcuThue.getSLThue()));
				vector.add(String.valueOf(dcuThue.getSoNgayThue()));
				vector.add(String.valueOf((dcuThue.getSoNgayThue() * dcuThue.getSLThue() * DonGia )/100));
				
				tableModel.addRow(vector);
			}
		}
		
		table.setModel(tableModel);
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
	
	public void DeleteTable() {
		try {
			list_DCThueXoa = LayDungCuThue.list_inDungCuThue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (infor_DungCuHocTapMuon dcuThueXoa : list_DCThueXoa) {
			if (dcuThueXoa.getMaDungCu().equals(B) && dcuThueXoa.getMaSV().equals(SinhVien.User)) {
				list_DCThueXoa.remove(dcuThueXoa);
				break;
			}
		}
		try {
			LuuFile("ListDungCuThue.txt", list_DCThueXoa);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			setColumnTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void InsertDuLieu() throws Exception {
		list_DCThue = LayDungCuThue.list_inDungCuThue();
		boolean check = true;
		for (infor_DungCuHocTapMuon dcThue : list_DCThue) {
			if (dcThue.getTenDungCu().equals(TenDungCu.getSelectedItem().toString()) && dcThue.getMaSV().equals(SinhVien.User)) {
				
				check = false;
			}
		}
		if (check == true) {
			ArrayList<infor_DungCu> dCus = LayDungCu.list_inDungCu();
			String maDC = null;
			for (infor_DungCu infor_DungCu : dCus) {
				if(infor_DungCu.getTenDC().equals(TenDungCu.getSelectedItem().toString())){
					maDC = infor_DungCu.getMaDC();
				}
			}
			System.out.println(maDC);
			infor_DungCuHocTapMuon dcuThue = new infor_DungCuHocTapMuon(maDC, 
					TenDungCu.getSelectedItem().toString(),
				    Integer.parseInt(SoLuong.getText()),
				    Integer.parseInt(SoNgay.getText()),
				    (Integer.parseInt(SoLuong.getText()) * Integer.parseInt(SoNgay.getText()))/100,
				    SinhVien.User
				    );
			list_DCThue.add(dcuThue);
			LuuFile("ListDungCuThue.txt", list_DCThue);
			setColumnTable();
		}
		else {
			JOptionPane.showMessageDialog(panel, "Đã trùng tên dụng cụ");
		}
	}
	
	public void LuuFile(String filename, ArrayList<infor_DungCuHocTapMuon> dungCuHocTapThue) throws Exception {
		FileOutputStream fs = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (infor_DungCuHocTapMuon dcuThue : dungCuHocTapThue) {
			os.writeObject(dcuThue);
		}
		fs.close();
		os.close();
	}
	public void DieuKien() {
		String errString = "";
		if(SoLuong.getText().trim().isEmpty() || SoNgay.getText().trim().isEmpty()) {
			errString +="Không được để trống !!!";
		}
		
		try {
			int x = Integer.parseInt(SoLuong.getText());
			if(x < 0) {
				errString += "\n Số lượng > 0";
			}
			int y = Integer.parseInt(SoNgay.getText());
			if(y< 0) {
				errString += "\n Số ngày > 0";
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			errString += "\nSố lượng và Số ngày là kiểu số";
		}
		if( errString != "") {
			JOptionPane.showMessageDialog(panel, errString);
		}
		else {
			try {
				InsertDuLieu();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Thue() {
		GiaoDien();
		SetCombobox();
		SetCombobox(TenDungCu, "DungCu" , 2);
		
		try {
			SetDonGia();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			setColumnTable();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TenDungCu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					SetDonGia();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		SKien1(table);
		btnHy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ViTri1 = table.getSelectedRow();
				if(ViTri1 < 0) {
					JOptionPane.showMessageDialog(panel, "Chọn Bảng");
				}
				else {
					DeleteTable();
				}
			}
		});
		DangKy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DieuKien();
			}
		});
		
	}
	public void SetCombobox() {
		try {
			ArrayList<infor_DungCu> list_DCu = LayDungCu.list_inDungCu();
			for (infor_DungCu dcu : list_DCu) {
				TenDungCu.addItem(dcu.getTenDC());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
