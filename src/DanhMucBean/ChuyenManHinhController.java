package DanhMucBean;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DanhMuc.DangKyDungCu;
import DanhMuc.DangKyLichHoc;
import DanhMuc.DanhMucTrangChu;
import DanhMuc.KetQuaHocTap;
import DanhMuc.QLySinhVien;
import DanhMuc.QuanLyDiem;
import DanhMuc.TheoDoiLichThi;
import DanhMuc.ThoiKhoaBieu;
import DanhMuc.ThoiKhoaBieuSV;
import DanhMuc.ThongKe;

public class ChuyenManHinhController {
	private JPanel jpnRoot;
	private String kindSelected = "";
	private List<DanhMucBean> list;
	public ChuyenManHinhController(JPanel jpnRoot) {
		this.jpnRoot = jpnRoot;
	}
	
	public void setView(JPanel jpnItem, JLabel jlblItem) {
		kindSelected = "TrangChu";
		jpnItem.setBackground(new Color(96, 100, 191));
		jlblItem.setBackground(new Color(96, 100, 191));
		jpnRoot.removeAll();
		jpnRoot.setLayout(new BorderLayout());
		jpnRoot.add(new DanhMucTrangChu());
		jpnRoot.validate();
		jpnRoot.repaint();
	}
	
	public void SetEven(List<DanhMucBean> list) {
		this.list = list;
		for(DanhMucBean items: list) {
			items.getJlb().addMouseListener(new LabelEven(items.getKind(), items.getJpn(), items.getJlb()));
		}
	}
	
	class LabelEven implements MouseListener{

		private JPanel nodeJPanel;
		private String kind;
		private JPanel jpnItem;
		private JLabel jlbItemJLabel;
		
		public LabelEven(String kind, JPanel jpnItem, JLabel jlbItemJLabel) {
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItemJLabel = jlbItemJLabel;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (kind) {
			case "TrangChu":
				nodeJPanel = new DanhMucTrangChu();
				break;
			case "QLSV": 
				try {
					nodeJPanel = new QLySinhVien();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "ThoiKhoaBieu":
				try {
					nodeJPanel = new ThoiKhoaBieu();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "ThongKe": 
				nodeJPanel = new ThongKe();
				break;
			case "DangKyLichHoc" :
				nodeJPanel = new DangKyLichHoc();
				break;
			case "DangKyDungCu" :
				nodeJPanel = new DangKyDungCu();
				break;
			case "TheoDoiLichTHi":
				nodeJPanel = new TheoDoiLichThi();
				break;
			case "ThoiKhoaBieuSV" :
				nodeJPanel = new ThoiKhoaBieuSV();
				break;
			case "KetQuaHocTap" : 
				nodeJPanel = new KetQuaHocTap();
				break;
			case "QuanLyDiem":
				nodeJPanel = new QuanLyDiem();
				break;
			default:
				nodeJPanel = new DanhMucTrangChu();
				break;
			}
			jpnRoot.removeAll();
			jpnRoot.setLayout(new BorderLayout());
			jpnRoot.add(nodeJPanel);
			jpnRoot.validate();
			jpnRoot.repaint();
			setChangeBackground(kind);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			kindSelected = kind;
			jpnItem.setBackground(new Color(96, 100, 191));
			jlbItemJLabel.setBackground(new Color(96, 100, 191));
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			jpnItem.setBackground(new Color(96, 100, 191));
			jlbItemJLabel.setBackground(new Color(96, 100, 191));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(!kindSelected.equalsIgnoreCase(kind)) {
				jpnItem.setBackground(new Color(76, 175, 80));
				jlbItemJLabel.setBackground(new Color(76, 175, 80));
			}
		}
		
	}
	
	private void setChangeBackground(String kind) {
		for(DanhMucBean iteMucBean: list) {
			if(iteMucBean.getKind().equalsIgnoreCase(kind)) {
				iteMucBean.getJpn().setBackground(new Color(96, 100, 191));
				iteMucBean.getJlb().setBackground(new Color(96, 100, 191));
			}
			else {
				iteMucBean.getJpn().setBackground(new Color(76, 175, 80));
				iteMucBean.getJlb().setBackground(new Color(76, 175, 80));
			}
		}
	}
	
}
