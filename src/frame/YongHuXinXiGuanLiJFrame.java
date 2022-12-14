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
 *系统管理员->用户管理类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class YongHuXinXiGuanLiJFrame {

	public JFrame frame;
	public JLabel background;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;

	public YongHuXinXiGuanLiJFrame() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("用户管理");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 114, 595, 276);
		background.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u5E8F\u53F7",
				"\u767B\u5F55\u8D26\u53F7", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F", "\u89D2\u8272\u540D\u79F0" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table);

		btnNewButton = new JButton("\u65B0\u5EFA");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(14, 42, 113, 27);
		background.add(btnNewButton);

		btnNewButton_1 = new JButton("\u68C0\u7D22");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(190, 42, 113, 27);
		background.add(btnNewButton_1);

		btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_2.setBounds(354, 42, 113, 27);
		background.add(btnNewButton_2);

		btnNewButton_3 = new JButton("\u5220\u9664");
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_3.setBounds(505, 42, 113, 27);
		background.add(btnNewButton_3);
	}
}
