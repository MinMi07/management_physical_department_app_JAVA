package FileGiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DanhMuc.ThoiKhoaBieu;
import DanhMucBean.ChuyenManHinhController;
import DanhMucBean.DanhMucBean;
import information.infor_Teacher;
import information.infor_sinhvien;

import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangChuGV extends JFrame {

	private JPanel contentPane;
	private JLabel Trangchu;
	private JPanel TrangChu;
	JPanel QLDiem;
	JPanel jpnView;
	JLabel lblQLyLop;
	JPanel QuanLiLop;
	JPanel ThongKe;
	JPanel LichHoc;
	JLabel lblLichHoc;
	JLabel lblThongKe;
	JLabel lbl_HoTen;
	JLabel lblQuanLyDiem;
	JButton btnNewButton;
	private String User;
	private ChuyenManHinhController controller;
	private ArrayList<infor_Teacher> list_teTeacher;

	public void GiaoDien() {
		setBounds(100, 100, 1096, 666);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

		JPanel logo = new JPanel();
		logo.setBounds(0, -1, 310, 125);
		contentPane.add(logo);
		logo.setBackground(new Color(255, 127, 80));
		logo.setLayout(null);

		JLabel lblNewLabel = new JLabel("  KHOA TH\u1EC2 CH\u1EA4T");
		lblNewLabel.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/balltrang.png")));
		lblNewLabel.setForeground(new Color(245, 245, 220));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 287, 100);
		logo.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, -1, 310, 647);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 122, 310, 515);
		panel.add(panel_2);
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setLayout(null);

		TrangChu = new JPanel();
		TrangChu.setBackground(new Color(34, 139, 34));
		TrangChu.setBounds(35, 10, 209, 72);
		TrangChu.setBackground(new Color(76, 175, 80));
		panel_2.add(TrangChu);
		TrangChu.setLayout(null);

		Trangchu = new JLabel("  TRANG CH\u1EE6");
		Trangchu.setHorizontalAlignment(SwingConstants.LEFT);
		Trangchu.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/iconmonstr-home-7-32 (1).png")));
		Trangchu.setFont(new Font("Arial", Font.BOLD, 17));
		Trangchu.setForeground(new Color(245, 255, 250));

		Trangchu.setBounds(10, 10, 189, 59);
		TrangChu.add(Trangchu);

		QuanLiLop = new JPanel();
		QuanLiLop.setBounds(35, 106, 209, 79);
		QuanLiLop.setBackground(new Color(76, 175, 80));
		panel_2.add(QuanLiLop);
		QuanLiLop.setLayout(null);

		lblQLyLop = new JLabel("  QU\u1EA2N L\u00DD L\u1EDAP");

		lblQLyLop.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/QLY32.png")));
		lblQLyLop.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLyLop.setForeground(new Color(245, 255, 250));
		lblQLyLop.setFont(new Font("Arial", Font.BOLD, 17));
		lblQLyLop.setBounds(10, 10, 164, 59);
		QuanLiLop.add(lblQLyLop);

		LichHoc = new JPanel();
		LichHoc.setBounds(35, 215, 209, 65);
		LichHoc.setBackground(new Color(76, 175, 80));
		panel_2.add(LichHoc);
		LichHoc.setLayout(null);

		lblLichHoc = new JLabel("  L\u1ECACH H\u1ECCC");
		lblLichHoc.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/CALENDAR.png")));
		lblLichHoc.setHorizontalAlignment(SwingConstants.LEFT);
		lblLichHoc.setForeground(new Color(245, 255, 250));
		lblLichHoc.setFont(new Font("Arial", Font.BOLD, 17));
		lblLichHoc.setBounds(10, 0, 158, 59);
		LichHoc.add(lblLichHoc);

		ThongKe = new JPanel();
		ThongKe.setBounds(35, 306, 209, 72);
		ThongKe.setBackground(new Color(76, 175, 80));
		panel_2.add(ThongKe);
		ThongKe.setLayout(null);

		lblThongKe = new JLabel("  TH\u1ED0NG K\u00CA");
		lblThongKe.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/ThongKe.png")));
		lblThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongKe.setForeground(new Color(245, 255, 250));
		lblThongKe.setFont(new Font("Arial", Font.BOLD, 20));
		lblThongKe.setBounds(10, 10, 176, 59);
		ThongKe.add(lblThongKe);

		QLDiem = new JPanel();
		QLDiem.setLayout(null);
		QLDiem.setBackground(new Color(76, 175, 80));
		QLDiem.setBounds(35, 407, 209, 72);
		panel_2.add(QLDiem);

		lblQuanLyDiem = new JLabel("  QU\u1EA2N L\u00DD \u0110I\u1EC2M ");
		lblQuanLyDiem.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/iconmonstr-clipboard-6-32.png")));
		lblQuanLyDiem.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuanLyDiem.setForeground(new Color(245, 255, 250));
		lblQuanLyDiem.setFont(new Font("Arial", Font.BOLD, 20));
		lblQuanLyDiem.setBounds(10, 10, 210, 59);
		QLDiem.add(lblQuanLyDiem);

		jpnView = new JPanel();
		jpnView.setBounds(308, 67, 774, 579);
		contentPane.add(jpnView);
	}

	public void DanhMuc() {
		controller = new ChuyenManHinhController(jpnView);
		controller.setView(TrangChu, Trangchu);
		List<DanhMucBean> list = new ArrayList<>();
		list.add(new DanhMucBean("TrangChu", TrangChu, Trangchu));
		list.add(new DanhMucBean("QLSV", QuanLiLop, lblQLyLop));
		list.add(new DanhMucBean("ThoiKhoaBieu", LichHoc, lblLichHoc));
		list.add(new DanhMucBean("ThongKe", ThongKe, lblThongKe));
		list.add(new DanhMucBean("QuanLyDiem", QLDiem, lblQuanLyDiem));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(308, -1, 774, 71);
		contentPane.add(panel);
		panel.setLayout(null);

		lbl_HoTen = new JLabel("H\u1ECD V\u00E0 T\u00EAn");
		lbl_HoTen.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/iconmonstr-user-19-48.png")));
		lbl_HoTen.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_HoTen.setBounds(364, 5, 159, 56);
		panel.add(lbl_HoTen);

		btnNewButton = new JButton("THO\u00C1T");

		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(627, 17, 103, 32);
		panel.add(btnNewButton);
		controller.SetEven(list);
	}

	public TrangChuGV(String User) throws SQLException {
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
			docFile("ListGiaoVien.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (infor_Teacher infor_teacher : list_teTeacher) {
			if (infor_teacher.getMaGV().equals(User)) {
				lbl_HoTen.setText(infor_teacher.getTenGV());
			}
		}
	}

	public void docFile(String fileName) throws Exception {
		list_teTeacher = new ArrayList<infor_Teacher>();
		FileInputStream fi = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fi);
		while (fi.available() > 0) {
			infor_Teacher obj = (infor_Teacher) ois.readObject();
			if (obj != null) {
				infor_Teacher a = (infor_Teacher) obj;
				list_teTeacher.add(a);
			} else {
				break;
			}
		}
		fi.close();
		ois.close();
	}
}
