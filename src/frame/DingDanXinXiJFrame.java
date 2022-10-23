package frame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *用户->订单管理类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class DingDanXinXiJFrame {

	public JFrame frame;
	public JLabel background;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;

	public DingDanXinXiJFrame() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("订单信息");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 742, 435);
		frame.getContentPane().add(background);

		btnNewButton_1 = new JButton("\u4FEE\u6539");
		background.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(197, 32, 113, 27);

		btnNewButton = new JButton("\u65B0\u5EFA");
		background.add(btnNewButton);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(21, 32, 113, 27);

		scrollPane = new JScrollPane();
		background.add(scrollPane);
		scrollPane.setBounds(21, 85, 605, 305);

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

		btnNewButton_3 = new JButton("\u53D1\u5E03");
		background.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_3.setBounds(513, 32, 113, 27);

		btnNewButton_2 = new JButton("\u5220\u9664");
		background.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_2.setBounds(362, 32, 113, 27);
	}
}
