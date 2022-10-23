package frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *登录
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class DengluJFrame {

	public JFrame frame;
	public JLabel background;
	public JTextField textField;
	public JPasswordField passwordField;
	public JRadioButton rdbtnNewRadioButton;
	public JRadioButton rdbtnNewRadioButton_1;
	public JRadioButton rdbtnNewRadioButton_2;
	public JButton btnNewButton;
	public JButton btnNewButton_1;

	public DengluJFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("登录");

		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 20));
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();

		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 661, 413);
		frame.getContentPane().add(background);

		JLabel lblNewLabel = new JLabel("账号: ");
		lblNewLabel.setFont(new Font("思源宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(150, 84, 65, 34);
		background.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密码: ");
		lblNewLabel_1.setFont(new Font("思源宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(150, 148, 65, 34);
		background.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(229, 148, 270, 31);
		background.add(passwordField);

		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(230, 87, 269, 30);
		textField.setColumns(10);

		// 将身份选项分组，使得只能选择一种
		ButtonGroup buttonGroup = new ButtonGroup();

		rdbtnNewRadioButton_2 = new JRadioButton("云工厂");
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(453, 252, 73, 27);
		buttonGroup.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_1 = new JRadioButton("用户");
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(296, 252, 73, 27);
		buttonGroup.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton = new JRadioButton("管理员");
		frame.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(127, 252, 73, 27);
		buttonGroup.add(rdbtnNewRadioButton);

		btnNewButton_1 = new JButton("注册");
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 21));
		btnNewButton_1.setBounds(373, 326, 113, 27);

		btnNewButton = new JButton("登录");
		background.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 21));
		btnNewButton.setBounds(173, 326, 113, 27);
	}
}
