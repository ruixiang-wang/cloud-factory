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
 *用户->主界面类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class JingXiaoShangJFrame {

	public JFrame frame;
	public JLabel background;
	public JMenuItem mntmNewMenuItem;
	public JButton btnNewButton;

	public JingXiaoShangJFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("用户");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 40));
		btnNewButton.setBounds(225, 153, 160, 63);
		background.add(btnNewButton);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u8BA2\u5355\u7BA1\u7406");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("\u6211\u7684\u8BA2\u5355");
		mnNewMenu.add(mntmNewMenuItem);
	}
}
