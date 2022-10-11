package DanhMuc;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ClassKoAdd.LopDK;
import LayDanhSach.LayDungCuMua;
import LayDanhSach.LayDungCuThue;
import LayDanhSach.LayLopDK;
import LayDanhSach.LayLopDaDK;
import LayDanhSach.LaySinhVien;
import information.LopdaDK;
import information.infor_DungCuHocTapMua;
import information.infor_DungCuHocTapMuon;
import information.infor_sinhvien;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;

public class ThongKe extends JPanel {
	JPanel panel;
	private JTextField TK_Lop;
	private JTextField TK_SV;
	private JTextField TienThue;
	private JTextField TienMua;
	private JTextField TongTien;

	/**
	 * Create the panel.
	 */

	public void GIaoDien() {
		setLayout(null);
		setBounds(0, 0, 764, 556);
		panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 764, 557);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u1ED5ng S\u1ED1 L\u1EDBp");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(68, 53, 121, 28);
		panel.add(lblNewLabel);

		TK_Lop = new JTextField();
		TK_Lop.setEditable(false);
		TK_Lop.setFont(new Font("Arial", Font.BOLD, 15));
		TK_Lop.setBounds(237, 55, 253, 28);
		panel.add(TK_Lop);
		TK_Lop.setColumns(10);

		JLabel lblTngSinhVin = new JLabel("T\u1ED5ng Sinh Vi\u00EAn");
		lblTngSinhVin.setFont(new Font("Arial", Font.BOLD, 15));
		lblTngSinhVin.setBounds(68, 104, 121, 28);
		panel.add(lblTngSinhVin);

		TK_SV = new JTextField();
		TK_SV.setFont(new Font("Arial", Font.BOLD, 15));
		TK_SV.setEditable(false);
		TK_SV.setColumns(10);
		TK_SV.setBounds(237, 104, 253, 28);
		panel.add(TK_SV);

		TienThue = new JTextField();
		TienThue.setFont(new Font("Arial", Font.BOLD, 15));
		TienThue.setEditable(false);
		TienThue.setColumns(10);
		TienThue.setBounds(237, 167, 253, 28);
		panel.add(TienThue);

		TienMua = new JTextField();
		TienMua.setFont(new Font("Arial", Font.BOLD, 15));
		TienMua.setEditable(false);
		TienMua.setColumns(10);
		TienMua.setBounds(237, 231, 253, 28);
		panel.add(TienMua);

		TongTien = new JTextField();
		TongTien.setFont(new Font("Arial", Font.BOLD, 15));
		TongTien.setEditable(false);
		TongTien.setColumns(10);
		TongTien.setBounds(237, 295, 253, 28);
		panel.add(TongTien);

		JLabel lblTngTinThu = new JLabel("T\u1ED5ng Ti\u1EC1n Thu\u00EA DC");
		lblTngTinThu.setFont(new Font("Arial", Font.BOLD, 15));
		lblTngTinThu.setBounds(68, 167, 159, 28);
		panel.add(lblTngTinThu);

		JLabel lblTngTinMua = new JLabel("T\u1ED5ng Ti\u1EC1n Mua DC");
		lblTngTinMua.setFont(new Font("Arial", Font.BOLD, 15));
		lblTngTinMua.setBounds(68, 231, 159, 28);
		panel.add(lblTngTinMua);

		JLabel lblTngTin = new JLabel("T\u1ED5ng Ti\u1EC1n ");
		lblTngTin.setFont(new Font("Arial", Font.BOLD, 15));
		lblTngTin.setBounds(68, 295, 159, 28);
		panel.add(lblTngTin);
	}

	public void SetThongKe() {
		try {
			ArrayList<LopDK> list_lLopDK = LayLopDK.list_lLopDK();
			TK_Lop.setText(String.valueOf(list_lLopDK.size()));

			ArrayList<infor_sinhvien> list_iInfor_sinhvien = LaySinhVien.list_Infor_sinhviens();
			TK_SV.setText(String.valueOf(list_iInfor_sinhvien.size()));

			ArrayList<infor_DungCuHocTapMuon> list_iInfor_DungCuHocTapMuon = LayDungCuThue.list_inDungCuThue();
			float SumMuon = 0;
			for (infor_DungCuHocTapMuon infor_DungCuHocTapMuon : list_iInfor_DungCuHocTapMuon) {
				SumMuon += infor_DungCuHocTapMuon.getTongTien();
			}
			TienThue.setText(String.valueOf(SumMuon));

			ArrayList<infor_DungCuHocTapMua> list_iInfor_DungCuHocTapMua = LayDungCuMua.list_inDungCuMua();
			float SumMua = 0;
			for (infor_DungCuHocTapMua infor_DungCuHocTapMua : list_iInfor_DungCuHocTapMua) {
				SumMua += infor_DungCuHocTapMua.getTongTien();
			}
			TienMua.setText(String.valueOf(SumMua));

			ArrayList<LopdaDK> list_lLopdaDK = LayLopDaDK.list_lLopdaDK();
			float TongTien = SumMua + SumMuon + list_lLopdaDK.size() * 330000;
			this.TongTien.setText(String.valueOf(TongTien));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ThongKe() {
		GIaoDien();
		SetThongKe();

	}
}
