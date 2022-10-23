package frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *用户注册界面类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class ZhuCeJingXiaoShangJFrame {

	public JFrame frame;
	public JLabel background;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JPasswordField passwordField;
	public JButton btnNewButton;
	public JButton btnNewButton_1;

	public ZhuCeJingXiaoShangJFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("用户注册");
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 650, 450);
		frame.getContentPane().add(background);

		JLabel lblNewLabel = new JLabel("\u767B\u5F55\u8D26\u53F7:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(66, 37, 113, 25);
		background.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u767B\u5F55\u5BC6\u7801:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(66, 92, 113, 25);
		background.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u771F\u5B9E\u59D3\u540D:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(66, 150, 113, 25);
		background.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(66, 206, 113, 25);
		background.add(lblNewLabel_3);

		btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton_1.setBounds(374, 313, 119, 40);
		background.add(btnNewButton_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(193, 28, 378, 34);
		background.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 141, 378, 34);
		background.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(193, 197, 378, 34);
		background.add(textField_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(193, 83, 376, 34);
		background.add(passwordField);

		JLabel lblNewLabel_4 = new JLabel("\u6CE8\u518C\u7C7B\u578B:");
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(66, 256, 113, 25);

		JLabel lblNewLabel_4_1 = new JLabel("\u7ECF\u9500\u5546");
		frame.getContentPane().add(lblNewLabel_4_1);
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_4_1.setBounds(205, 256, 113, 25);

		btnNewButton = new JButton("\u786E\u5B9A");
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton.setBounds(140, 313, 119, 40);
	}
}
