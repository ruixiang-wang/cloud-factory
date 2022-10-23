package frame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *系统管理员->主界面类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class GuanLiYuanJFrame {

	public JFrame frame;
	public JLabel background;
	public JMenuItem mntmNewMenuItem;
	public JMenuItem mntmNewMenuItem_1;
	public JMenuItem mntmNewMenuItem_2;
	public JMenuItem mntmNewMenuItem_3;
	public JMenuItem mntmNewMenuItem_4;
	public JMenuItem mntmNewMenuItem_5;
	public JMenuItem mntmNewMenuItem_6;
	public JButton btnNewButton;

	public GuanLiYuanJFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("系统管理员");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// 叉号无法关闭
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		btnNewButton = new JButton("\u9000\u51FA");
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 40));
		btnNewButton.setBounds(225, 153, 160, 63);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("\u7528\u6237\u7BA1\u7406");
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("\u4E91\u5DE5\u5382");
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem_1 = new JMenuItem("\u4E91\u5DE5\u5382\u4FE1\u606F");
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("\u4EA7\u54C1\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_2 = new JMenuItem("\u4EA7\u54C1\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_2.add(mntmNewMenuItem_2);

		mntmNewMenuItem_3 = new JMenuItem("\u4EA7\u54C1\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_3 = new JMenu("\u4EA7\u80FD\u4E2D\u5FC3");
		menuBar.add(mnNewMenu_3);

		mntmNewMenuItem_4 = new JMenuItem("\u8BBE\u5907\u7C7B\u578B\u7BA1\u7406");
		mnNewMenu_3.add(mntmNewMenuItem_4);

		mntmNewMenuItem_5 = new JMenuItem("\u8BBE\u5907\u7BA1\u7406");
		mnNewMenu_3.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_4 = new JMenu("\u8BA2\u5355\u7BA1\u7406");
		menuBar.add(mnNewMenu_4);

		mntmNewMenuItem_6 = new JMenuItem("\u8BA2\u5355\u57FA\u672C\u4FE1\u606F");
		mnNewMenu_4.add(mntmNewMenuItem_6);
	}
}
