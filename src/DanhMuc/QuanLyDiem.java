package DanhMuc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ClassKoAdd.SapXepLichHoc;
import FileGiaoDien.SinhVien;
import LayDanhSach.LaySapXepLichHoc;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;

public class QuanLyDiem extends JPanel {
	JPanel panel;
	private JTable table;
	JButton ChonLop;
	String A;
	ArrayList<SapXepLichHoc> arrayList;
	/**
	 * Create the panel.
	 */
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
				int Vitri= table.getSelectedRow();
				A = dModel.getValueAt(Vitri, 0).toString();
			}
		});
	}
	public void GiaoDien() {
		setLayout(null);
		setBounds(0, 0, 764, 556);
		panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 764, 557);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 64, 493, 392);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		ChonLop = new JButton("CHỌN LỚP");
		ChonLop.setFont(new Font("Arial", Font.BOLD, 12));
		ChonLop.setBounds(280, 475, 116, 36);
		panel.add(ChonLop);
	}
	public QuanLyDiem() {
		GiaoDien();
			try {
				setColumnTable1();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		SKien(table);
		ChonLop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int Vitri= table.getSelectedRow();
				if(Vitri  < 0) {
					JOptionPane.showMessageDialog(panel, "Chọn Cột Trong Bảng");
				}
				else {
				// TODO Auto-generated method stub
					panel.removeAll();
					panel.setLayout(new BorderLayout());
					panel.add(new NhapDiemGV(A));
					panel.validate();
					panel.repaint();
				}
				
			}
		});
		
		
	}
	public void setColumnTable1() throws Exception {
		String[] arr = { "Mã Lớp Học", "Tên Môn Học", "Thời Gian Học", "Giảng Viên", "Khu Vực Học", "Sĩ Số" };
		DefaultTableModel tableModel = new DefaultTableModel(arr, 0);
		table.removeAll();
		arrayList = LaySapXepLichHoc.list_sSapXepLichHoc();
		for (SapXepLichHoc sapXepLichHoc : arrayList) {
			Vector<String> vector = new Vector<String>();
			vector.add(sapXepLichHoc.getLopDaDK().getMaLop());
			vector.add(sapXepLichHoc.getLopDaDK().getMonHoc());
			vector.add(sapXepLichHoc.getThoiGianHoc());
			vector.add(sapXepLichHoc.getLopDaDK().getGiangVien());
			vector.add(sapXepLichHoc.getLopDaDK().getKhuVucHoc());
			vector.add(String.valueOf(sapXepLichHoc.getLopDaDK().getSiSo()));

			tableModel.addRow(vector);
		}

		table.setModel(tableModel);
	}
	
	
	
}