package frame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *系统管理员->产品信息类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class ChanPinXinxiJFrame {

	public JFrame frame;
	public JLabel background;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;

	public ChanPinXinxiJFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("产品信息");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		table = new JTable();

		btnNewButton = new JButton("\u65B0\u5EFA");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(14, 29, 113, 27);
		background.add(btnNewButton);

		btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(181, 29, 113, 27);
		background.add(btnNewButton_1);

		btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_2.setBounds(343, 29, 113, 27);
		background.add(btnNewButton_2);

		btnNewButton_3 = new JButton("\u68C0\u7D22");
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_3.setBounds(505, 29, 113, 27);
		background.add(btnNewButton_3);

		scrollPane = new JScrollPane();
		background.add(scrollPane);
		scrollPane.setBounds(20, 90, 594, 301);
	}
}
