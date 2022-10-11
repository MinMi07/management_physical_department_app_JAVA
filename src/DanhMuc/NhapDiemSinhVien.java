package DanhMuc;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutput;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JTextField;

import LayDanhSach.LayLopDaDK;
import information.LopdaDK;

import javax.swing.JButton;

public class NhapDiemSinhVien extends JPanel {

	JPanel panel;
	private String MaSV;
	private JTextField HS1;
	private JTextField HS2;
	private JTextField DiemThi;
	private String MaLop;
	JButton Nhap;
	/**
	 * Create the panel.
	 */
	public void DieuKien() {
		String errorString = "";
		if(HS1.getText().isEmpty() || HS2.getText().isEmpty() || DiemThi.getText().isEmpty() ) {
			errorString += "\n Hãy Nhập Thông Tin";
		}
		try {
			float x = Float.parseFloat(HS1.getText().toString());
			float y = Float.parseFloat(HS2.getText().toString());
			float z = Float.parseFloat(DiemThi.getText().toString());
			if(x < 0 || x > 10) {
				errorString += "\n0 <= Điểm HS 1 <= 10 ";
			}
			if(y < 0 || y > 10) {
				errorString += "\n0 <= Điểm HS 2 <= 10 ";
			}
			if(z < 0 || z > 10) {
				errorString += "\n0 <= Điểm Thi <= 10 ";
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			errorString += "\nNhấp điểm là kiểu số";
		}
		if(errorString != "") {
			JOptionPane.showMessageDialog(panel, errorString);
		}
		else {
			AddDiem();
			panel.removeAll();
			panel.setLayout(new BorderLayout());
			panel.add(new NhapDiemGV(MaLop));
			panel.validate();
			panel.repaint();
		}
	}
	public void GiaoDien() {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 764, 596);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110i\u1EC3m H\u1EC7 S\u1ED1 1");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(78, 112, 134, 22);
		panel.add(lblNewLabel);
		
		HS1 = new JTextField();
		HS1.setBounds(254, 108, 244, 33);
		panel.add(HS1);
		HS1.setColumns(10);
		
		JLabel lblimHS = new JLabel("\u0110i\u1EC3m H\u1EC7 S\u1ED1 2");
		lblimHS.setFont(new Font("Arial", Font.BOLD, 15));
		lblimHS.setBounds(78, 187, 134, 22);
		panel.add(lblimHS);
		
		JLabel lblimThi = new JLabel("\u0110i\u1EC3m Thi");
		lblimThi.setFont(new Font("Arial", Font.BOLD, 15));
		lblimThi.setBounds(78, 271, 134, 22);
		panel.add(lblimThi);
		
		HS2 = new JTextField();
		HS2.setColumns(10);
		HS2.setBounds(254, 183, 244, 33);
		panel.add(HS2);
		
		DiemThi = new JTextField();
		DiemThi.setColumns(10);
		DiemThi.setBounds(254, 260, 244, 33);
		panel.add(DiemThi);
		
		Nhap = new JButton("NH\u1EACP");
		Nhap.setFont(new Font("Arial", Font.BOLD, 15));
		Nhap.setBounds(315, 352, 146, 33);
		panel.add(Nhap);
	}
	
	public NhapDiemSinhVien(String MaSV, String MaLop) {
		this.MaLop = MaLop;
		this.MaSV = MaSV;
		GiaoDien();
		Nhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DieuKien();
				
			}
		});
	}
	
	public float DiemTrungBinh() {
		float x = Float.parseFloat(HS1.getText());
		float y = Float.parseFloat(HS2.getText());
		float z = Float.parseFloat(DiemThi.getText());
		return (x + y * 2) / 3 * 0.3f + z * 0.7f; 
	}
	public void AddDiem() {
		try {
			ArrayList<LopdaDK> lopdaDKs = LayLopDaDK.list_lLopdaDK();
			for (LopdaDK lopdaDK : lopdaDKs) {
				if(lopdaDK.getMaSV().equals(MaSV) && lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMaLop().equals(MaLop)) {
					lopdaDK.setDiem1(Float.parseFloat(HS1.getText()));
					lopdaDK.setDiem2(Float.parseFloat(HS2.getText()));
					lopdaDK.setDiemThi(Float.parseFloat(DiemThi.getText()));
					if(lopdaDK.DiemTB() < 4) {
						lopdaDK.setHanhKiem("Yếu");
					}
					else {
						if(lopdaDK.DiemTB() < 6) {
							lopdaDK.setHanhKiem("trung bình");
						}
						else {
							if(lopdaDK.DiemTB() < 8) {
								lopdaDK.setHanhKiem("khá");
							}
							else {
								lopdaDK.setHanhKiem("Gioi");
							}

						}
					}
				}
			}
			LuuFileDK("ListLopDaDK.txt", lopdaDKs);
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

}