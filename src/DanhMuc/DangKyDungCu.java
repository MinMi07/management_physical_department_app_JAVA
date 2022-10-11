package DanhMuc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;

import DanhSach.ListKhoa;
import DanhSach.ListKhuVucHoc;
import LayDanhSach.LayChuyenNganh;
import LayDanhSach.LayDungCu;
import LayDanhSach.LayGiaoVien;
import LayDanhSach.LayLopHoc;
import LayDanhSach.LayMonHoc;
import information.ChuyenNganh;
import information.MonHoc;
import information.infor_DungCu;
import information.infor_LopHoc;
import information.infor_Teacher;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;

public class DangKyDungCu extends JPanel {

	private JPanel panel;
	private JTextField SoLuong;
	private JTextField textField;
	private JTable table;
	JPanel ThueDungCu;
	JPanel MuaDungCu;
	/**
	 * Create the panel.
	 */
	public void GiaoDien() {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		panel = new JPanel();
		panel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.setBounds(0, 0, 764, 596);
		add(panel);
		panel.setLayout(null);
		
		MuaDungCu = new JPanel();
		MuaDungCu.setBackground(new Color(255, 127, 80));
		MuaDungCu.setBounds(189, 63, 376, 179);
		panel.add(MuaDungCu);
		MuaDungCu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mua D\u1EE5ng C\u1EE5");
		lblNewLabel.setBounds(32, 26, 300, 142);
		MuaDungCu.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setBackground(new Color(250, 128, 114));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(DangKyDungCu.class.getResource("/Image/Mua111.png")));
		
		ThueDungCu = new JPanel();
		ThueDungCu.setLayout(null);
		ThueDungCu.setBackground(new Color(50, 205, 50));
		ThueDungCu.setBounds(189, 293, 376, 179);
		panel.add(ThueDungCu);
		
		JLabel lblThuDngC = new JLabel("Thu\u00EA D\u1EE5ng C\u1EE5");
		lblThuDngC.setIcon(new ImageIcon(DangKyDungCu.class.getResource("/Image/Thue.png")));
		lblThuDngC.setForeground(new Color(255, 255, 240));
		lblThuDngC.setFont(new Font("Arial", Font.BOLD, 20));
		lblThuDngC.setBackground(new Color(250, 128, 114));
		lblThuDngC.setBounds(44, 27, 322, 142);
		ThueDungCu.add(lblThuDngC);
		
	}
	
	public void EventMua() {
		MuaDungCu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				panel.removeAll();
				panel.setLayout(new BorderLayout());
				panel.add(new Mua());
				panel.validate();
				panel.repaint();
			}
		});
	}
	
	
	public void EventThue() {
		ThueDungCu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				panel.removeAll();
				panel.setLayout(new BorderLayout());
				panel.add(new Thue());
				panel.validate();
				panel.repaint();
			}
		});
	}
	public DangKyDungCu() {
		GiaoDien();
		
		EventMua();
		EventThue();
	}
}
