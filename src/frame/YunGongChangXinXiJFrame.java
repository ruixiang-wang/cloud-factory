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
 *系统管理员->工厂信息类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class YunGongChangXinXiJFrame {

	public JFrame frame;
	public JLabel background;
	public JTable table;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JScrollPane scrollPane;

	public YunGongChangXinXiJFrame() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("云工厂信息");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		btnNewButton_1 = new JButton("\u5F00\u542F");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(248, 37, 113, 27);
		background.add(btnNewButton_1);

		scrollPane = new JScrollPane();
		background.add(scrollPane);
		scrollPane.setBounds(18, 100, 596, 289);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5E8F\u53F7", "\u5DE5\u5382\u540D\u79F0", "\u5DE5\u5382\u7B80\u4ECB",
						"\u8D1F\u8D23\u4EBA", "\u8054\u7CFB\u65B9\u5F0F", "\u767B\u5F55\u8D26\u53F7",
						"\u5DE5\u5382\u72B6\u6001" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(table);

		btnNewButton = new JButton("\u68C0\u7D22");
		background.add(btnNewButton);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(56, 36, 113, 27);

		btnNewButton_2 = new JButton("\u5173\u505C");
		background.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(450, 36, 113, 27);
	}
}
