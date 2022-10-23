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
 *云工厂管理员->我的设备类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class MySheBeiJFrame {

	public JFrame frame;
	public JLabel background;
	public JTable table;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_4_1;
	public JButton btnNewButton_4_2;
	public JButton btnNewButton_4_3;
	public JScrollPane scrollPane;

	public MySheBeiJFrame() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("我的设备");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		btnNewButton = new JButton("\u65B0\u5EFA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(14, 13, 113, 27);
		background.add(btnNewButton);

		btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton_1.setBounds(183, 13, 113, 27);
		background.add(btnNewButton_1);

		btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_2.setBounds(343, 13, 113, 27);
		background.add(btnNewButton_2);

		btnNewButton_3 = new JButton("\u68C0\u7D22");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_3.setBounds(498, 13, 113, 27);
		background.add(btnNewButton_3);

		scrollPane = new JScrollPane();
		background.add(scrollPane);
		scrollPane.setBounds(18, 105, 597, 286);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5E8F\u5217", "\u8BBE\u5907\u7F16\u53F7", "\u8BBE\u5907\u540D\u79F0",
						"\u8BBE\u5907\u7C7B\u578B", "\u8BBE\u5907\u89C4\u683C", "\u8BBE\u5907\u63CF\u8FF0",
						"\u8BBE\u5907\u72B6\u6001", "\u8BBE\u5907\u6765\u6E90", "\u6240\u5C5E\u5DE5\u5382" }) {
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

		btnNewButton_4 = new JButton("\u8FDC\u7A0B\u5F00\u673A");
		background.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_4.setBounds(18, 60, 115, 27);

		btnNewButton_4_1 = new JButton("\u8FDC\u7A0B\u5173\u673A");
		background.add(btnNewButton_4_1);
		btnNewButton_4_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_4_1.setBounds(181, 60, 115, 27);

		btnNewButton_4_2 = new JButton("\u79DF\u7528\u8BBE\u5907");
		background.add(btnNewButton_4_2);
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_4_2.setBounds(343, 60, 115, 27);

		btnNewButton_4_3 = new JButton("\u914D\u7F6E\u4EA7\u54C1");
		background.add(btnNewButton_4_3);
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4_3.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_4_3.setBounds(498, 60, 115, 27);
	}

}
