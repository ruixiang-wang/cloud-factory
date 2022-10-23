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
 *系统管理员->设备信息类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class SheBeiXinXiJFrame {

	public JFrame frame;
	public JLabel background;
	public JScrollPane scrollPane;
	public JTable table;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;

	public SheBeiXinXiJFrame() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("设备信息");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		scrollPane = new JScrollPane();
		background.add(scrollPane);
		scrollPane.setBounds(18, 129, 608, 259);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5E8F\u53F7", "\u8BBE\u5907\u7F16\u53F7", "\u8BBE\u5907\u540D\u79F0",
						"\u8BBE\u5907\u7C7B\u578B", "\u8BBE\u5907\u89C4\u683C", "\u8BBE\u5907\u63CF\u8FF0",
						"\u8BBE\u5907\u72B6\u6001", "\u79DF\u7528\u72B6\u6001", "\u6240\u5C5E\u5DE5\u5382" }) {
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

		btnNewButton = new JButton("\u65B0\u5EFA");
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(10, 26, 113, 27);

		btnNewButton_1 = new JButton("\u4FEE\u6539");
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(175, 26, 113, 27);

		btnNewButton_2 = new JButton("\u5220\u9664");
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_2.setBounds(340, 26, 113, 27);

		btnNewButton_3 = new JButton("\u68C0\u7D22");
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_3.setBounds(501, 26, 113, 27);

		btnNewButton_4 = new JButton("\u8FDC\u7A0B\u5F00\u673A");
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_4.setBounds(100, 81, 142, 27);

		btnNewButton_5 = new JButton("\u8FDC\u7A0B\u5173\u673A");
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_5.setBounds(385, 81, 142, 27);
	}

}
