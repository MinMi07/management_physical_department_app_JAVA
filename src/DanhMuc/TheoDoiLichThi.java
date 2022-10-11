package DanhMuc;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TheoDoiLichThi extends JPanel {

	/**
	 * Create the panel.
	 */
	public TheoDoiLichThi() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1128, 856);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ch\u00E1o M\u1EEBng \u0111\u1EBFn v\u1EDBi free fire");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(-18, -19, 764, 630);
		
		panel.add(lblNewLabel);
	}

}
