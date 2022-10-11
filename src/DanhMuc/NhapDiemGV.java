package DanhMuc;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.plaf.synth.SynthProgressBarUI;
import javax.swing.table.DefaultTableModel;

import FileGiaoDien.SinhVien;
import LayDanhSach.LayLopDaDK;
import LayDanhSach.LaySinhVien;
import information.LopdaDK;
import information.infor_sinhvien;

import javax.swing.JScrollPane;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import java.util.PrimitiveIterator.OfDouble;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NhapDiemGV extends JPanel {
	JPanel panel;
	JButton QuayLai;
	JButton NhapDiem;
	private JTable table;
	private String MaLop;
	private  String A;
	ArrayList<LopdaDK> list;
	DefaultTableModel tableModel1 ;
	/**
	 * 
	 * Create the panel.
	 */
	
	public void GiaoDien() {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 764, 596);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 71, 554, 412);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		QuayLai = new JButton("QUAY LAI");
		
		QuayLai.setFont(new Font("Arial", Font.BOLD, 12));
		QuayLai.setBounds(86, 514, 98, 37);
		panel.add(QuayLai);
		
		NhapDiem = new JButton("NH\u1EACP \u0110I\u00CAM");
		NhapDiem.setFont(new Font("Arial", Font.BOLD, 12));
		NhapDiem.setBounds(511, 514, 134, 37);
		panel.add(NhapDiem);
	}
	
	public NhapDiemGV(String MaLop) {
		this.MaLop = MaLop;
		GiaoDien();
		
		try {
			setColumnTable();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SKien(table);
		NhapDiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int vitri = table.getSelectedRow();
				if(vitri  < 0) {
					JOptionPane.showMessageDialog(panel, "Chọn Cột Trong Bảng");
				}
				else {
					panel.removeAll();
					panel.setLayout(new BorderLayout());
					panel.add(new NhapDiemSinhVien(A, MaLop));
					panel.validate();
					panel.repaint();
				}
			}
		});
		QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setLayout(new BorderLayout());
				panel.add(new QuanLyDiem());
				panel.validate();
				panel.repaint();
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
				DefaultTableModel dModel = (DefaultTableModel) table.getModel();
				int vitri = table.getSelectedRow();
				A = dModel.getValueAt(vitri, 0).toString();
			}
		});
	}
	
	public void setColumnTable() throws SQLException {
		String[] arr = { "Mã SV", "Tên SV", "Hệ Số 1", "Hệ Số 2", "Điểm Thi"};
		tableModel1 = new DefaultTableModel(arr, 0);
		table.removeAll();
		try {
			list = LayLopDaDK.list_lLopdaDK();
			for (LopdaDK lopdaDK : list) {
				if(lopdaDK.getList_sSapXepLichHoc().getLopDaDK().getMaLop().equals(MaLop)) {
					
					Vector<String> vector = new Vector<String>();
					vector.add(lopdaDK.getMaSV());
					ArrayList<infor_sinhvien> lInfor_sinhviens;
					lInfor_sinhviens = LaySinhVien.list_Infor_sinhviens();
					String TenSV = null;
					for (infor_sinhvien sv : lInfor_sinhviens) {
						if(sv.getMaSV().equals(lopdaDK.getMaSV())) {
							TenSV = sv.getHoTen();
						}
					}
					vector.add(TenSV);
					
					vector.add(String.valueOf(lopdaDK.getDiem1()));
					vector.add(String.valueOf(lopdaDK.getDiem2()));
					vector.add(String.valueOf(lopdaDK.getDiemThi()));
					tableModel1.addRow(vector);
				}
			}
			table.setModel(tableModel1);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}