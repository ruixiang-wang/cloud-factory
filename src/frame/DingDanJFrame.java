package frame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *系统管理员->订单管理类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class DingDanJFrame {

	public JFrame frame;
	public JLabel background;
	public JTable table;
	public JButton btnNewButton;
	public JScrollPane scrollPane;

	public DingDanJFrame() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("订单");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		btnNewButton = new JButton("\u751F\u4EA7");
		background.add(btnNewButton);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(264, 10, 113, 27);

		scrollPane = new JScrollPane();
		background.add(scrollPane);
		scrollPane.setBounds(10, 49, 616, 341);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5E8F\u53F7", "\u8BA2\u5355\u7F16\u53F7", "\u4EA7\u54C1\u540D",
						"\u8BA2\u8D2D\u6570\u91CF", "\u4EA4\u4ED8\u65E5\u671F", "\u6536\u8D27\u4EBA",
						"\u6536\u8D27\u4EBA\u8054\u7CFB\u65B9\u5F0F", "\u6536\u8D27\u5730\u5740",
						"\u8BA2\u5355\u72B6\u6001" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(8).setResizable(false);
		scrollPane.setViewportView(table);
	}
}
