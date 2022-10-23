package frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *云工厂管理员注册界面类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class ZhuCeYunGongChangJFrame {

	public JFrame frame;
	public JLabel background;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JPasswordField passwordField;
	public JTextArea textArea;
	public JButton btnNewButton;
	public JButton btnNewButton_1;

	public ZhuCeYunGongChangJFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("云工厂管理员注册");
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
		lblNewLabel.setBounds(58, 27, 113, 25);
		background.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u767B\u5F55\u5BC6\u7801:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(58, 65, 113, 25);
		background.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u771F\u5B9E\u59D3\u540D:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(58, 108, 113, 25);
		background.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(58, 158, 113, 25);
		background.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u6CE8\u518C\u7C7B\u578B:");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(58, 204, 113, 25);
		background.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u5DE5\u5382\u540D\u79F0:");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(58, 250, 113, 25);
		background.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u5DE5\u5382\u7B80\u4ECB:");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(58, 304, 113, 25);
		background.add(lblNewLabel_6);

		textField = new JTextField();
		textField.setBounds(183, 18, 378, 34);
		background.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(183, 107, 378, 34);
		background.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(183, 157, 378, 34);
		background.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(183, 249, 378, 34);
		background.add(textField_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(185, 64, 376, 34);
		background.add(passwordField);

		textArea = new JTextArea();
		textArea.setBounds(185, 296, 376, 45);
		background.add(textArea);

		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton.setBounds(110, 350, 119, 40);
		background.add(btnNewButton);

		btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton_1.setBounds(398, 354, 119, 40);
		background.add(btnNewButton_1);

		JLabel lblNewLabel_4_1 = new JLabel("\u4E91\u5DE5\u5382");
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_4_1.setBounds(193, 204, 113, 25);
		background.add(lblNewLabel_4_1);
	}
}