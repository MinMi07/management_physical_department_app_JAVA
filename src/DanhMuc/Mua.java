package DanhMuc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ClassKoAdd.LopDK;
import FileGiaoDien.SinhVien;
import LayDanhSach.LayDungCu;
import LayDanhSach.LayDungCuMua;
import LayDanhSach.LayLopDK;
import information.infor_DungCu;
import information.infor_DungCuHocTapMua;

public class Mua extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel panel;
	private JTextField SoLuong;
	private JTextField DonGia;
	private JTable table;
	JComboBox TenDungCu;
	JButton Huy;
	JButton DangKy;
	String B;
	private DefaultTableModel tableModel;
	ArrayList<infor_DungCuHocTapMua> list_DCMua;
	ArrayList<infor_DungCuHocTapMua> list_DCMuaXoa;
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
		TenDungCu.setFont(new Font("Arial", Font.BOLD, 13));
		TenDungCu.setBounds(247, 40, 259, 30);
		panel.add(TenDungCu);
		
		
		JLabel lblNewLabel_1 = new JLabel("S\u1ED1 L\u01B0\u1EE3ng");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(75, 109, 162, 30);
		panel.add(lblNewLabel_1);
		
		SoLuong = new JTextField();
		SoLuong.setFont(new Font("Arial", Font.BOLD, 13));
		SoLuong.setBounds(247, 109, 259, 30);
		panel.add(SoLuong);
		SoLuong.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u0110\u01A1n Gi\u00E1");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(75, 179, 162, 30);
		panel.add(lblNewLabel_2_1);
		
		DonGia = new JTextField();
		DonGia.setEditable(false);
		DonGia.setFont(new Font("Arial", Font.BOLD, 13));
		DonGia.setColumns(10);
		DonGia.setBounds(247, 179, 259, 30);
		panel.add(DonGia);
		
		DangKy = new JButton("\u0110\u0102NG k\u00DD");
		DangKy.setFont(new Font("Arial", Font.BOLD, 13));
		DangKy.setBounds(302, 245, 127, 37);
		panel.add(DangKy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 334, 608, 183);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
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
		String[] arr = { "Mã Dụng Cụ", "Tên Dụng Cụ", "Số Lượng Mua", "Tổng tiền" };
		tableModel = new DefaultTableModel(arr, 0);
		table.removeAll();
		
		list_DCMua = LayDungCuMua.list_inDungCuMua();
		ArrayList<infor_DungCu> dCus = LayDungCu.list_inDungCu();
		for (infor_DungCuHocTapMua dcuMua : list_DCMua) {
			if(dcuMua.getMaSV().equals(SinhVien.User)) {
				float DonGia = 0f;
				for (infor_DungCu DCSC : dCus) {
					if(DCSC.getTenDC().equals(dcuMua.getTenDungCu())) {

						DonGia = DCSC.getDonGia();
					}
				}
				Vector<String> vector = new Vector<String>();
				vector.add(dcuMua.getMaDungCu());
				vector.add(dcuMua.getTenDungCu());
				vector.add(String.valueOf(dcuMua.getSLMua()));
				vector.add(String.valueOf(dcuMua.getSLMua() * DonGia));
				
				tableModel.addRow(vector);
			}
		}
		
		table.setModel(tableModel);
	}
	public void SetCombobox(JComboBox aBox, String TableName, int i) {
		
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
			list_DCMuaXoa = LayDungCuMua.list_inDungCuMua();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (infor_DungCuHocTapMua dcuMuaXoa : list_DCMuaXoa) {
			if (dcuMuaXoa.getMaDungCu().equals(B) && dcuMuaXoa.getMaSV().equals(SinhVien.User)) {
				list_DCMuaXoa.remove(dcuMuaXoa);
				break;
			}
		}
		try {
			LuuFile("ListDungCuMua.txt", list_DCMuaXoa);
			
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
		list_DCMua = LayDungCuMua.list_inDungCuMua();
		boolean check = true;
		for (infor_DungCuHocTapMua dcuMua : list_DCMua) {
			if (dcuMua.getTenDungCu().equals(TenDungCu.getSelectedItem().toString()) && dcuMua.getMaSV().equals(SinhVien.User)) {
				
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
			//System.out.println(maDC);
			infor_DungCuHocTapMua dcuMua = new infor_DungCuHocTapMua(maDC, 
					TenDungCu.getSelectedItem().toString(),
				    Integer.parseInt(SoLuong.getText()),
				    Float.parseFloat(DonGia.getText()) * Integer.parseInt(SoLuong.getText()),
				    SinhVien.User
				    );
			list_DCMua.add(dcuMua);
			LuuFile("ListDungCuMua.txt", list_DCMua);
			setColumnTable();
		}
		else {
			JOptionPane.showMessageDialog(panel, "Đã trùng tên dụng cụ");
		}
	}
	
	
	public void LuuFile(String filename, ArrayList<infor_DungCuHocTapMua> dungCuHocTapMuas) throws Exception {
		FileOutputStream fs = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		for (infor_DungCuHocTapMua dcuMua : dungCuHocTapMuas) {
			os.writeObject(dcuMua);
		}
		fs.close();
		os.close();
	}



	public void DieuKien() {
		String errString = "";
		if(SoLuong.getText().trim().isEmpty()) {
			errString +="Không được để trống !!!";
		}
		try {
			int x = Integer.parseInt(SoLuong.getText());
			if(x < 0) {
				errString += "Số Lượng > 0";
			}
		}
		catch (Exception e) {
			errString += "\nSố lượng là Kiểu số";
			// TODO: handle exception
		}
		if(errString != "") {
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
	
	public Mua() {
		GiaoDien();
		SetCombobox();
		try {
			setColumnTable();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		SetCombobox(TenDungCu, "DungCu", 2);
		try {
			SetDonGia();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Huy = new JButton("HỦY");
		Huy.setFont(new Font("Arial", Font.BOLD, 15));
		Huy.setBounds(302, 535, 127, 37);
		panel.add(Huy);
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
			try {
				setColumnTable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		DangKy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DieuKien();
			}
		});
		SKien1(table);
		Huy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ViTri1 = table.getSelectedRow();
				if(ViTri1 < 0) {
					JOptionPane.showMessageDialog(panel,"Chọn đối tượng bảng!!!");
				}
				DeleteTable();
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
