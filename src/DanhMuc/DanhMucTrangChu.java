package DanhMuc;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DanhMucTrangChu extends JPanel {

	/**
	 * Create the panel.
	 */
	public DanhMucTrangChu() {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 764, 596);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DanhMucTrangChu.class.getResource("/Image/APtgAtrcu1MgwwHeoy5KLT1UNRWMH5tDJrHKcbnDqC8.png")));
		lblNewLabel.setBounds(10, 10, 744, 576);
		panel.add(lblNewLabel);

	}
}
