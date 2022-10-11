package FileGiaoDien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import DanhMuc.DangKyLichHoc;
import DanhMuc.NhapDiemGV;
import DanhMucBean.ChuyenManHinhController;
import DanhMucBean.DanhMucBean;
import information.TaiKhoan;
import information.infor_sinhvien;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class SinhVien extends JFrame {

	private JPanel contentPane;
	JPanel TrangChu, DangKyHocPhan, TheoDoiLichThi, DangKyDungCu, ThoiKhoaBieu, KetQuaHT;
	JLabel lblTrangChu, lblDangKyHocPhan, lblTheoDoiLichThi, lblDangKyDungCu, lblThoiKhoaBieu, lblKetQuaHT;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel jpnView;
	private static JLabel lbl_HoTen;
	public static String User;
	JButton btnNewButton;
	private ArrayList<infor_sinhvien> list_Infor_sinhvien;
	public void DanhMuc() {
		ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
		controller.setView(TrangChu, lblTrangChu);
		List<DanhMucBean> list = new ArrayList<>();
		
		list.add(new DanhMucBean("TrangChu", TrangChu, lblTrangChu));
		list.add(new DanhMucBean("DangKyLichHoc", DangKyHocPhan, lblDangKyHocPhan));
		list.add(new DanhMucBean("DangKyDungCu", DangKyDungCu, lblDangKyDungCu));
		list.add(new DanhMucBean("KetQuaHocTap", KetQuaHT, lblKetQuaHT));
		list.add(new DanhMucBean("ThoiKhoaBieuSV", ThoiKhoaBieu, lblThoiKhoaBieu));
		list.add(new DanhMucBean("TheoDoiLichThi", TheoDoiLichThi, lblTheoDoiLichThi));
		
		JPanel logo = new JPanel();
		logo.setBounds(0, 0, 356, 107);
		panel.add(logo);
		logo.setBackground(new Color(255, 127, 80));
		logo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  KHOA TH\u1EC2 CH\u1EA4T");
		lblNewLabel.setBounds(21, 24, 308, 72);
		logo.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(SinhVien.class.getResource("/Image/balltrang72.png")));
		lblNewLabel.setForeground(new Color(245, 245, 220));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		
		controller.SetEven(list);
	}
	
	
	
	public void GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1122, 722);
		
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 356, 675);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 101, 356, 574);
		panel.add(panel_2);
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setLayout(null);
		
		TrangChu  = new JPanel();
		TrangChu.setBackground(new Color(34, 139, 34));
		TrangChu.setBounds(35, 23, 284, 69);
		TrangChu.setBackground(new Color(76, 175, 80));
		panel_2.add(TrangChu);
		TrangChu.setLayout(null);
		
		lblTrangChu = new JLabel("  TRANG CH\u1EE6");
		lblTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrangChu.setIcon(new ImageIcon(SinhVien.class.getResource("/Image/iconmonstr-home-7-32 (1).png")));
		lblTrangChu.setFont(new Font("Arial", Font.BOLD, 20));
		lblTrangChu.setForeground(new Color(245, 255, 250));
		
		lblTrangChu.setBounds(10, 10, 194, 49);
		TrangChu.add(lblTrangChu);
		
		DangKyHocPhan = new JPanel();
		DangKyHocPhan.setBounds(35, 113, 284, 69);
		DangKyHocPhan.setBackground(new Color(76, 175, 80));
		panel_2.add(DangKyHocPhan);
		DangKyHocPhan.setLayout(null);
		
		lblDangKyHocPhan = new JLabel("  \u0110\u0102NG K\u00DD H\u1ECCC PH\u1EA6N");
		lblDangKyHocPhan.setIcon(new ImageIcon(SinhVien.class.getResource("/Image/KEY.png")));
		lblDangKyHocPhan.setHorizontalAlignment(SwingConstants.LEFT);
		lblDangKyHocPhan.setForeground(new Color(245, 255, 250));
		lblDangKyHocPhan.setFont(new Font("Arial", Font.BOLD, 20));
		lblDangKyHocPhan.setBounds(10, 10, 264, 59);
		DangKyHocPhan.add(lblDangKyHocPhan);
		
		DangKyDungCu = new JPanel();
		DangKyDungCu.setBounds(35, 202, 284, 69);
		DangKyDungCu.setBackground(new Color(76, 175, 80));
		panel_2.add(DangKyDungCu);
		DangKyDungCu.setLayout(null);
		
		lblDangKyDungCu = new JLabel("  \u0110\u0102NG K\u00DD D\u1EE4NG C\u1EE4");
		lblDangKyDungCu.setIcon(new ImageIcon(SinhVien.class.getResource("/Image/dungcu.png")));
		lblDangKyDungCu.setHorizontalAlignment(SwingConstants.LEFT);
		lblDangKyDungCu.setForeground(new Color(245, 255, 250));
		lblDangKyDungCu.setFont(new Font("Arial", Font.BOLD, 20));
		lblDangKyDungCu.setBounds(10, 10, 243, 59);
		DangKyDungCu.add(lblDangKyDungCu);
		
		TheoDoiLichThi = new JPanel();
		TheoDoiLichThi.setBounds(36, 291, 284, 69);
		TheoDoiLichThi.setBackground(new Color(76, 175, 80));
		panel_2.add(TheoDoiLichThi);
		TheoDoiLichThi.setLayout(null);
		
		lblTheoDoiLichThi = new JLabel("  THEO D\u00D5I L\u1ECACH THI");
		lblTheoDoiLichThi.setIcon(new ImageIcon(SinhVien.class.getResource("/Image/CALENDAR.png")));
		lblTheoDoiLichThi.setHorizontalAlignment(SwingConstants.LEFT);
		lblTheoDoiLichThi.setForeground(new Color(245, 255, 250));
		lblTheoDoiLichThi.setFont(new Font("Arial", Font.BOLD, 20));
		lblTheoDoiLichThi.setBounds(10, 10, 243, 59);
		TheoDoiLichThi.add(lblTheoDoiLichThi);
		
		KetQuaHT = new JPanel();
		KetQuaHT.setLayout(null);
		KetQuaHT.setBackground(new Color(76, 175, 80));
		KetQuaHT.setBounds(36, 380, 283, 69);
		panel_2.add(KetQuaHT);
		
		lblKetQuaHT = new JLabel("  K\u1EBET QU\u1EA2 H\u1ECCC T\u1EACP");
		lblKetQuaHT.setIcon(new ImageIcon(SinhVien.class.getResource("/Image/a.png")));
		lblKetQuaHT.setHorizontalAlignment(SwingConstants.LEFT);
		lblKetQuaHT.setForeground(new Color(245, 255, 250));
		lblKetQuaHT.setFont(new Font("Arial", Font.BOLD, 20));
		lblKetQuaHT.setBounds(10, 10, 243, 59);
		KetQuaHT.add(lblKetQuaHT);
		
		ThoiKhoaBieu = new JPanel();
		ThoiKhoaBieu.setLayout(null);
		ThoiKhoaBieu.setBackground(new Color(76, 175, 80));
		ThoiKhoaBieu.setBounds(36, 469, 284, 69);
		panel_2.add(ThoiKhoaBieu);
		
		lblThoiKhoaBieu = new JLabel("  TH\u1EDCI KH\u00D3A BI\u1EC2U");
		lblThoiKhoaBieu.setIcon(new ImageIcon(SinhVien.class.getResource("/Image/iconmonstr-time-9-32.png")));
		lblThoiKhoaBieu.setHorizontalAlignment(SwingConstants.LEFT);
		lblThoiKhoaBieu.setForeground(new Color(245, 255, 250));
		lblThoiKhoaBieu.setFont(new Font("Arial", Font.BOLD, 20));
		lblThoiKhoaBieu.setBounds(10, 10, 243, 59);
		ThoiKhoaBieu.add(lblThoiKhoaBieu);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(354, 0, 754, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lbl_HoTen = new JLabel("H\u1ECD V\u00E0 T\u00EAn");
		lbl_HoTen.setBounds(311, 10, 217, 53);
		panel_1.add(lbl_HoTen);
		lbl_HoTen.setIcon(new ImageIcon(SinhVien.class.getResource("/Image/iconmonstr-user-19-48.png")));
		lbl_HoTen.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnNewButton = new JButton("  THO\u00C1T");
		
		btnNewButton.setBounds(611, 19, 111, 25);
		panel_1.add(btnNewButton);
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		
		jpnView = new JPanel();
		jpnView.setBackground(Color.WHITE);
		jpnView.setBounds(354, 80, 754, 595);
		contentPane.add(jpnView);
	}
	public SinhVien(String User) {
		this.User = User;
		GiaoDien();
		DanhMuc();
		SetTK();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame aFrame = new DangNhap();
				aFrame.setVisible(true);
				setVisible(false);
			}
		});
	}
	
	public void SetTK() {
		try {
			docFile("ListSinhVien.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (infor_sinhvien infor_sinhvien : list_Infor_sinhvien) {
			if (infor_sinhvien.getMaSV().equals(User)) {
				lbl_HoTen.setText(infor_sinhvien.getHoTen());
			}
		}
	}
	
	public void docFile(String fileName) throws Exception {
		list_Infor_sinhvien = new ArrayList<infor_sinhvien>();
		FileInputStream fi = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			infor_sinhvien obj = (infor_sinhvien) ois.readObject();
			if (obj != null) {
				infor_sinhvien a = (infor_sinhvien) obj;
				list_Infor_sinhvien.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
	}
}