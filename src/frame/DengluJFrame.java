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
 *��¼
 * @author ������
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
		frame = new JFrame("��¼");

		frame.getContentPane().setFont(new Font("����", Font.PLAIN, 20));
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		background = new JLabel();

		background.setIcon(new ImageIcon("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\pic\\background.jpg"));
		background.setBounds(0, 0, 661, 413);
		frame.getContentPane().add(background);

		JLabel lblNewLabel = new JLabel("�˺�: ");
		lblNewLabel.setFont(new Font("˼Դ����", Font.PLAIN, 25));
		lblNewLabel.setBounds(150, 84, 65, 34);
		background.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("����: ");
		lblNewLabel_1.setFont(new Font("˼Դ����", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(150, 148, 65, 34);
		background.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(229, 148, 270, 31);
		background.add(passwordField);

		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setBounds(230, 87, 269, 30);
		textField.setColumns(10);

		// �����ѡ����飬ʹ��ֻ��ѡ��һ��
		ButtonGroup buttonGroup = new ButtonGroup();

		rdbtnNewRadioButton_2 = new JRadioButton("�ƹ���");
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(453, 252, 73, 27);
		buttonGroup.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_1 = new JRadioButton("�û�");
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(296, 252, 73, 27);
		buttonGroup.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton = new JRadioButton("����Ա");
		frame.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(127, 252, 73, 27);
		buttonGroup.add(rdbtnNewRadioButton);

		btnNewButton_1 = new JButton("ע��");
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 21));
		btnNewButton_1.setBounds(373, 326, 113, 27);

		btnNewButton = new JButton("��¼");
		background.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("����", Font.BOLD, 21));
		btnNewButton.setBounds(173, 326, 113, 27);
	}
}
