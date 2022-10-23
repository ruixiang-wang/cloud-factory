package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import entity.ChanPin;
import entity.ChanPinLeiBie;
import entity.DingDanXinXi;
import entity.Users;
import entity.SheBei;
import entity.SheBeiLeiBie;
import entity.XiTongGuanLiYuan;
import entity.YunGongChangGuanLiYuan;
import frame.ChanPinleibieJFrame;
import frame.ChanPinXinxiJFrame;

import frame.DingDanJFrame;
import frame.DingDanXinXiJFrame;
import frame.GuanLiYuanJFrame;
import frame.JingXiaoShangJFrame;
import frame.MySheBeiJFrame;
import frame.SheBeiLeiBieJFrame;
import frame.SheBeiXinXiJFrame;
import frame.YongHuXinXiGuanLiJFrame;
import frame.YunGongChangJFrame;
import frame.YunGongChangXinXiJFrame;
import frame.ZhuCeJingXiaoShangJFrame;
import frame.ZhuCeYunGongChangJFrame;
import until.ShuJuDuXie;
import frame.DengluJFrame;


/**
 * �������û�������
 * @author ������
 * @date 2021-01-14
 */
public class Controller {
	private static ArrayList<XiTongGuanLiYuan> xiTongGuanLiYuans;//ϵͳ����Ա�б�
	private static ArrayList<Users> users;//�û��б�
	private static ArrayList<YunGongChangGuanLiYuan> ygCguanliyuans;//�ƹ�������Ա�б�
	private static ArrayList<ChanPin> chanPins;//��Ʒ�б�
	private static ArrayList<SheBei> sheBeis;//�豸�б�
	private static ArrayList<DingDanXinXi> dingDanXinXis;//�����б�
	private static ArrayList<ChanPinLeiBie> chanPinLeiBies;//��Ʒ����б�
	private static ArrayList<SheBeiLeiBie> sheBeiLeiBies;//�豸����б�
	
	@SuppressWarnings("unused")
	private static XiTongGuanLiYuan nowguanliyuan = new XiTongGuanLiYuan();//��ǰϵͳ����Ա
	@SuppressWarnings("unused")
	private static Users nowjingxiaoshang = new Users();//��ǰ�û�
	private static YunGongChangGuanLiYuan nowyungongchang = new YunGongChangGuanLiYuan();//��ǰ�ƹ�������Ա
	
	/*
	 * ���캯����ʼ��
	 */
	public Controller() {
		xiTongGuanLiYuans = new ArrayList<>();
		//ϵͳ����Ա�˺ţ�555�����룺555
		xiTongGuanLiYuans.add(new XiTongGuanLiYuan("555", "555", "xiaoming", "555"));
		users = new ArrayList<>();
		ygCguanliyuans = new ArrayList<>();
		chanPins = new ArrayList<>();
		sheBeis = new ArrayList<>();
		dingDanXinXis = new ArrayList<>();
		chanPinLeiBies = new ArrayList<>();
		sheBeiLeiBies = new ArrayList<>();
//		ShuJuDuXie.read1(xiTongGuanLiYuans);
		//�����ļ���Ϣ
		ShuJuDuXie.read2(users);
		ShuJuDuXie.read3(ygCguanliyuans);
		ShuJuDuXie.read4(sheBeis);
		ShuJuDuXie.read5(chanPins);
		ShuJuDuXie.read6(dingDanXinXis);
		ShuJuDuXie.read7(chanPinLeiBies);
		ShuJuDuXie.read8(sheBeiLeiBies);
	}

	
	/*
	 * ��¼�����еļ����� -> DengluJFrame
	 */
	public static void dengLu() {
		DengluJFrame window = new DengluJFrame();
		
		// ��¼��ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = window.textField.getText();
				String string = new String(window.passwordField.getPassword());
				//�û�������������Ϊ��ʱ���ܵ�¼
				if (text.isEmpty() || string == null || (!window.rdbtnNewRadioButton.isSelected()
						&& !window.rdbtnNewRadioButton_1.isSelected() && !window.rdbtnNewRadioButton_2.isSelected())) {
					JOptionPane.showMessageDialog(window.frame, "�û������������ݲ���Ϊ�գ�");
					return;//������ֹ�����������
				}
				//ϵͳ����Ա��¼ʱ������ϵͳ����Ա�б��ж������Ƿ���ȷ
				if (window.rdbtnNewRadioButton.isSelected()) {
					for (XiTongGuanLiYuan xiTongGuanLiYuan : xiTongGuanLiYuans) {
						if (xiTongGuanLiYuan.getID().equals(text) && xiTongGuanLiYuan.getPassword().equals(string)) {
							window.frame.dispose();
							nowguanliyuan = xiTongGuanLiYuan;//����ǰϵͳ����Ա��ʼ����ֵ
							guanLiYuan();
							return;
						}
					}
					JOptionPane.showMessageDialog(window.frame, "��¼�����������");
				}
				//�û���¼ʱ�������û��б��ж������Ƿ���ȷ
				if (window.rdbtnNewRadioButton_1.isSelected()) {
					for (Users users : Controller.users) {
						if (users.getID().equals(text) && users.getPassword().equals(string)) {
							window.frame.dispose();
							nowjingxiaoshang = users;//����ǰ�û���ʼ����ֵ
							jingXiaoShang();
							return;
						}
					}
					JOptionPane.showMessageDialog(window.frame, "��¼�����������");
				}
				//�ƹ�������Ա��¼ʱ�������ƹ�������Ա�б��ж������Ƿ���ȷ
				if (window.rdbtnNewRadioButton_2.isSelected()) {
					for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
						if (ygCguanliyuan.getID().equals(text) && ygCguanliyuan.getPassword().equals(string)) {
							window.frame.dispose();
							nowyungongchang = ygCguanliyuan;//����ǰ�ƹ�������Ա��ʼ����ֵ
							yunGongChang();
							return;
						}
					}
					JOptionPane.showMessageDialog(window.frame, "��¼�����������");
				}
			}
		});
		
		// ע�ᰴť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ѡ��ע��ϵͳ����Աʱ������ע��
				if (window.rdbtnNewRadioButton.isSelected()) {
					JOptionPane.showMessageDialog(window.frame, "����ע��ϵͳ����Ա��");
					return;
				}
				//��ѡ��ע���û�ʱ
				if (window.rdbtnNewRadioButton_1.isSelected()) {
					window.frame.dispose();
					zhuceJXS();
					return;
				}
				//��ѡ��ע���ƹ�������Աʱ
				if (window.rdbtnNewRadioButton_2.isSelected()) {
					window.frame.dispose();
					zhuceYGC();
					return;
				}
				//��δѡ��ע�����ʱ
				JOptionPane.showMessageDialog(window.frame, "��ѡ��ע����ݣ�");
			}
		});
		
		//��ʼ����ɺ���ʾ��¼����
		window.frame.setVisible(true);
	}

	
	/*
	 * �ƹ�������Աע�ᴰ�ڵļ����� ->ZhuCeYunGongChangJFrame
	 */
	public static void zhuceYGC() {
		ZhuCeYunGongChangJFrame window = new ZhuCeYunGongChangJFrame();
		
		//ȷ�ϰ�ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = window.textField.getText();
				String text1 = window.textField_1.getText();
				String text2 = window.textField_2.getText();
				String text3 = window.textField_3.getText();
				String string = new String(window.passwordField.getPassword());
				String text4 = window.textArea.getText();
				ygCguanliyuans.add(new YunGongChangGuanLiYuan(text, string, text1, text2, text3, text4, false));
				JOptionPane.showMessageDialog(window.frame, "ע��ɹ����������ص�¼���棡");
				window.frame.dispose();
				//ע��ɹ����ص�¼����
				dengLu();
			}
		});
		
		//���ذ�ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.frame.dispose();
				dengLu();
			}
		});
		
		//��ʼ����ɺ���ʾ�ƹ���ע�ᴰ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �û�ע�ᴰ�ڵļ����� -> ZhuCeJingXiaoShangJFrame
	 */
	public static void zhuceJXS() {
		ZhuCeJingXiaoShangJFrame window = new ZhuCeJingXiaoShangJFrame();
		
		//ȷ�ϰ�ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = window.textField.getText();
				String text2 = window.textField_1.getText();
				String text3 = window.textField_2.getText();
				String string = new String(window.passwordField.getPassword());
				users.add(new Users(text, string, text2, text3));
				JOptionPane.showMessageDialog(window.frame, "ע��ɹ����������ص�¼���棡");
				window.frame.dispose();
				//ע��ɹ����ص�¼����
				dengLu();
			}
		});
		
		//���ذ�ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.frame.dispose();
				dengLu();
			}
		});
		
		//��ʼ����ɺ���ʾ�û�ע�ᴰ��
		window.frame.setVisible(true);
	}

	
	/*
	 * ϵͳ����Ա�����ڵļ����� -> GuanLiYuanJFrame
	 */
	public static void guanLiYuan() {
		GuanLiYuanJFrame window = new GuanLiYuanJFrame();
		
		//�˵���ϵͳ����->�û���Ϣ����
		window.mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				yongHuXinXi();
			}
		});
		
		//�˵����ƹ���->������Ϣ����
		window.mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				yunGongChangXinXi();
			}
		});
		
		//�˵�����Ʒ����->��Ʒ������
		window.mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chanPinLeiBie();
			}
		});
		
		//�˵�����Ʒ����->��Ʒ��Ϣ����
		window.mntmNewMenuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chanPinXinXi();
			}
		});
		
		//�˵�����������->�豸���͹���
		window.mntmNewMenuItem_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sheBeiLeiBie();
			}
		});
		
		//�˵�����������->�豸��Ϣ����
		window.mntmNewMenuItem_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sheBeiXinXi();
			}
		});
		
		//�˵�����������->������Ϣ����
		window.mntmNewMenuItem_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dingDanXianShi();
			}
		});
		
		//�˳���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�������б��е���Ϣ�����ļ�
				ShuJuDuXie.write1(xiTongGuanLiYuans);
				ShuJuDuXie.write2(users);
				ShuJuDuXie.write3(ygCguanliyuans);
				ShuJuDuXie.write4(sheBeis);
				ShuJuDuXie.write5(chanPins);
				ShuJuDuXie.write6(dingDanXinXis);
				ShuJuDuXie.write7(chanPinLeiBies);
				ShuJuDuXie.write8(sheBeiLeiBies);
				System.exit(0);
			}
		});
		
		//��ʼ����ɺ���ʾϵͳ����Ա��ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �û������ڵļ����� -> JingXiaoShangJFrame
	 */
	public static void jingXiaoShang() {
		JingXiaoShangJFrame window = new JingXiaoShangJFrame();
		
		//�˵�����������->������Ϣ����
		window.mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dingDanXinXi();
			}
		});
		
		//�˳���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�������б��е���Ϣ�����ļ�
				ShuJuDuXie.write1(xiTongGuanLiYuans);
				ShuJuDuXie.write2(users);
				ShuJuDuXie.write3(ygCguanliyuans);
				ShuJuDuXie.write4(sheBeis);
				ShuJuDuXie.write5(chanPins);
				ShuJuDuXie.write6(dingDanXinXis);
				ShuJuDuXie.write7(chanPinLeiBies);
				ShuJuDuXie.write8(sheBeiLeiBies);
				System.exit(0);
			}
		});
		
		//��ʼ����ɺ���ʾ�û���ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ƹ�������Ա�����ڵļ����� -> YunGongChangJFrame
	 */
	public static void yunGongChang() {
		YunGongChangJFrame window = new YunGongChangJFrame();
		
		//�˵����ҵĹ���->�ҵ��豸
		window.mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mySheBei();
			}
		});
		
		//�˵�����������->������Ϣ
		window.mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dingDanXianShi();
			}
		});
		
		//�˳���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�������б��е���Ϣ�����ļ�
				ShuJuDuXie.write1(xiTongGuanLiYuans);
				ShuJuDuXie.write2(users);
				ShuJuDuXie.write3(ygCguanliyuans);
				ShuJuDuXie.write4(sheBeis);
				ShuJuDuXie.write5(chanPins);
				ShuJuDuXie.write6(dingDanXinXis);
				ShuJuDuXie.write7(chanPinLeiBies);
				ShuJuDuXie.write8(sheBeiLeiBies);
				System.exit(0);
			}
		});
		
		//��ʼ����ɺ���ʾ�ƹ�������Ա��ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * ϵͳ����Ա.��Ʒ���.��Ʒ�������� -> ChanPinleibieJFrame
	 */
	public static void chanPinLeiBie() {
		ChanPinleibieJFrame window = new ChanPinleibieJFrame();
		xianShiLeiBie(window, chanPinLeiBies);
		
		//�½���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����½����");
				if (showInputDialog.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "��Ϣ����Ϊ��");
				} else {
					chanPinLeiBies.add(new ChanPinLeiBie(showInputDialog));
					//��ʾ�޸ĺ��ArrayList
					xianShiLeiBie(window, chanPinLeiBies);
				}

			}
		});
		
		//�޸İ�ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�޸ĵ�����");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����޸ĺ������");
					chanPinLeiBies.get(selectedRow).setLeibie(showInputDialog);
					//��ʾ�޸ĺ��ArrayList
					xianShiLeiBie(window, chanPinLeiBies);
				}
			}
		});
		
		//ɾ����ť
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫɾ��������");
				} else {
					chanPinLeiBies.remove(selectedRow);
					//��ʾ�޸ĺ��ArrayList
					xianShiLeiBie(window, chanPinLeiBies);
				}
			}
		});
		
		//������ť
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "���������");
				//�����µ�ArrayList
				ArrayList<ChanPinLeiBie> c = new ArrayList<>();
				for (ChanPinLeiBie chanpin : chanPinLeiBies) {
					if (chanpin.getLeibie().equals(showInputDialog)) {
						c.add(chanpin);
					}
				}
				//��ʾ�޸ĺ��ArrayList
				xianShiLeiBie(window, c);
			}
		});
		
		//��ʼ����ɺ���ʾϵͳ����Ա�Ĳ�Ʒ������ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ��Ʒ�����Ϣ
	 * ΪchanPinLeiBie()�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiLeiBie(ChanPinleibieJFrame window, ArrayList<ChanPinLeiBie> chanpins) {
		//����ȫ����Ʒ������
		Object[][] objects = new Object[chanpins.size()][2];
		int i = 0;
		//�����в�Ʒ������������
		for (ChanPinLeiBie chanpin : chanpins) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = chanpin.getLeibie();
				}
			}
			++i;
		}
		
		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects, new String[] { "\u5E8F\u53F7", "\u7C7B\u522B\u540D\u79F0" }) {
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		//�������ӵ���������
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * ϵͳ����Ա.��Ʒ���.��Ʒ��Ϣ������ -> ChanPinleibieJFrame
	 */
	public static void chanPinXinXi() {
		ChanPinXinxiJFrame window = new ChanPinXinxiJFrame();
		xianShiChanPin(window, chanPins);
		
		//�½���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "������");
				String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "��������");
				String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "�������");
				String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "������");
				String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "��������");
				if (showInputDialog.isEmpty() || showInputDialog2.isEmpty() || showInputDialog3.isEmpty()
						|| showInputDialog4.isEmpty() || showInputDialog5.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "��Ϣ����Ϊ��");
				} else {
					chanPins.add(new ChanPin(showInputDialog, showInputDialog2, showInputDialog3, showInputDialog4,
							showInputDialog5));
				}
				//��ʾ�µ�ArrayList
				xianShiChanPin(window, chanPins);
			}
		});
		
		//�޸İ�ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				int selectedColumn = window.table.getSelectedColumn();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�޸ĵ�����");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����޸ĺ������");
					if (selectedColumn == 1) {
						chanPins.get(selectedRow).setID(showInputDialog);
					}
					if (selectedColumn == 2) {
						chanPins.get(selectedRow).setMingcheng(showInputDialog);
					}
					if (selectedColumn == 3) {
						chanPins.get(selectedRow).setLeibie(showInputDialog);
					}
					if (selectedColumn == 4) {
						chanPins.get(selectedRow).setGuige(showInputDialog);
					}
					if (selectedColumn == 5) {
						chanPins.get(selectedRow).setMiaoshu(showInputDialog);
					}
					//��ʾ�µ�ArrayList
					xianShiChanPin(window, chanPins);
				}
			}
		});
		
		//ɾ����ť
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫɾ��������");
				} else {
					chanPins.remove(selectedRow);
					//��ʾ�µ�ArrayList
					xianShiChanPin(window, chanPins);
				}
			}
		});
		
		//������ť
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "����������");
				ArrayList<ChanPin> c = new ArrayList<>();
				for (ChanPin chanPin : chanPins) {
					if (chanPin.getMingcheng().equals(showInputDialog)) {
						c.add(chanPin);
					}
				}
				//��ʾ�µ�ArrayList
				xianShiChanPin(window, c);
			}
		});
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ��Ʒ��Ϣ
	 * ΪchanPinXinXi()�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiChanPin(ChanPinXinxiJFrame window, ArrayList<ChanPin> chanPins) {
		//�����Ʒ��Ϣ������
		Object[][] objects = new Object[chanPins.size()][6];
		int i = 0;
		for (ChanPin chanPin : chanPins) {
			for (int j = 0; j < 6; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = chanPin.getID();
				}
				if (j == 2) {
					objects[i][j] = chanPin.getMingcheng();
				}
				if (j == 3) {
					objects[i][j] = chanPin.getLeibie();
				}
				if (j == 4) {
					objects[i][j] = chanPin.getGuige();
				}
				if (j == 5) {
					objects[i][j] = chanPin.getMiaoshu();
				}
			}
			++i;
		}
		
		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects,
				new String[] { "\u5E8F\u53F7", "\u4EA7\u54C1\u7F16\u53F7", "\u4EA7\u54C1\u540D\u79F0",
						"\u4EA7\u54C1\u7C7B\u522B", "\u4EA7\u54C1\u89C4\u683C", "\u4EA7\u54C1\u63CF\u8FF0" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		window.table.getColumnModel().getColumn(2).setResizable(false);
		window.table.getColumnModel().getColumn(3).setResizable(false);
		window.table.getColumnModel().getColumn(4).setResizable(false);
		window.table.getColumnModel().getColumn(5).setResizable(false);
		//�������������
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 *  �ƹ�������Ա.�ҵ��豸 -> MySheBeiJFrame
	 */
	public static void mySheBei() {
		MySheBeiJFrame window = new MySheBeiJFrame();
		xianShiMySheBei(window, sheBeis);
		
		//�½���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "������");
				String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "��������");
				String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "��������");
				String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "������");
				String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "��������");
				String showInputDialog6 = JOptionPane.showInputDialog(window.frame, "������������");
				if (showInputDialog.isEmpty() || showInputDialog2.isEmpty() || showInputDialog3.isEmpty()
						|| showInputDialog4.isEmpty() || showInputDialog5.isEmpty() || showInputDialog.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "��Ϣ����Ϊ��");
				} else {
					sheBeis.add(new SheBei(showInputDialog, showInputDialog2, showInputDialog3, showInputDialog4,
							showInputDialog5, false, false, showInputDialog6));
				}
				//��ʾ�µ�ArrayList
				xianShiMySheBei(window, sheBeis);
			}
		});
		
		//�޸İ�ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				int selectedColumn = window.table.getSelectedColumn();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�޸ĵ�����");
				} else {
					//��ȡ�豸���
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����޸ĺ������");
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							if (selectedColumn == 1) {
								sheBei.setID(showInputDialog);
							}
							if (selectedColumn == 2) {
								sheBei.setMingcheng(showInputDialog);
							}
							if (selectedColumn == 3) {
								sheBei.setLeixing(showInputDialog);
							}
							if (selectedColumn == 4) {
								sheBei.setHuige(showInputDialog);
							}
							if (selectedColumn == 5) {
								sheBei.setMiaoshu(showInputDialog);
							}
							if (selectedColumn == 8) {
								sheBei.setSuoshuGC(showInputDialog);
							}
						}
					}
					//��ʾ�µ�ArrayList
					xianShiMySheBei(window, sheBeis);
				}
			}
		});
		
		//ɾ����ť
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫɾ��������");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							sheBeis.remove(sheBei);
						}
					}
					//��ʾ�µ�ArrayList
					xianShiMySheBei(window, sheBeis);
				}
			}
		});
		
		//������ť
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "����������");
				ArrayList<SheBei> c = new ArrayList<>();
				for (SheBei sheBei : sheBeis) {
					if (sheBei.getMingcheng().equals(showInputDialog)) {
						c.add(sheBei);
					}
				}
				//��ʾ�µ�ArrayList
				xianShiMySheBei(window, c);
			}
		});
		
		//Զ�̿�����ť
		window.btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�������豸");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							if (sheBei.isShebeizhuangtai()) {
								JOptionPane.showMessageDialog(window.frame, "���豸�ѿ���");
							} else {
								sheBei.setShebeizhuangtai(true);
								JOptionPane.showMessageDialog(window.frame, "�豸�����ɹ�");
								//��ʾ�µ�ArrayList
								xianShiMySheBei(window, sheBeis);
							}
						}
					}
				}
			}
		});
		
		//Զ�̹ػ���ť
		window.btnNewButton_4_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�ػ����豸");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							if (!sheBei.isShebeizhuangtai()) {
								JOptionPane.showMessageDialog(window.frame, "���豸�ѹػ�");
							} else {
								sheBei.setShebeizhuangtai(false);
								JOptionPane.showMessageDialog(window.frame, "�豸�ػ��ɹ�");
								xianShiMySheBei(window, sheBeis);
							}
						}
					}
				}
			}
		});
		
		//��������״̬��ť
		window.btnNewButton_4_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ���õ��豸");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							if (sheBei.isZuyongzhuangtai()) {
								JOptionPane.showMessageDialog(window.frame, "���豸������");
							} else {
								sheBei.setZuyongzhuangtai(true);
								JOptionPane.showMessageDialog(window.frame, "�豸���óɹ�");
								xianShiMySheBei(window, sheBeis);
							}
						}
					}
				}
			}
		});
		
		//���ò�Ʒ��ť
		window.btnNewButton_4_3.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ���ò�Ʒ���豸");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����Ʒ����");
					String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "�����Ʒ����(��/ʱ)");
				}
			}
		});
		
		//��ʼ����ɺ���ʾ�ƹ�������Ա���ҵ��豸ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ�Լ��������豸��Ϣ
	 * ΪmySheBei()�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiMySheBei(MySheBeiJFrame window, ArrayList<SheBei> sheBeis) {

		int i = 0;
		//��ȡ�����Լ��������豸
		ArrayList<SheBei> shebeis2 = new ArrayList<>();
		for (SheBei sheBei : sheBeis) {
			if (sheBei.getSuoshuGC().equals(nowyungongchang.getMingcheng())) {
				shebeis2.add(sheBei);
			}
		}
		//�����Լ������豸������
		Object[][] objects = new Object[shebeis2.size()][9];
		for (SheBei sheBei : shebeis2) {

			for (int j = 0; j < 9; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = sheBei.getID();
				}
				if (j == 2) {
					objects[i][j] = sheBei.getMingcheng();
				}
				if (j == 3) {
					objects[i][j] = sheBei.getLeixing();
				}
				if (j == 4) {
					objects[i][j] = sheBei.getHuige();
				}
				if (j == 5) {
					objects[i][j] = sheBei.getMiaoshu();
				}
				if (j == 6) {
					if (sheBei.isShebeizhuangtai()) {
						objects[i][j] = "������";
					} else {
						objects[i][j] = "�ѹر�";
					}
				}
				if (j == 7) {
					if (sheBei.isZuyongzhuangtai()) {
						objects[i][j] = "�����豸";
					} else {
						objects[i][j] = "�����豸";
					}
				}
				if (j == 8) {
					objects[i][j] = sheBei.getSuoshuGC();
				}
			}
			++i;
		}

		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects,
				new String[] { "\u5E8F\u5217", "\u8BBE\u5907\u7F16\u53F7", "\u8BBE\u5907\u540D\u79F0",
						"\u8BBE\u5907\u7C7B\u578B", "\u8BBE\u5907\u89C4\u683C", "\u8BBE\u5907\u63CF\u8FF0",
						"\u8BBE\u5907\u72B6\u6001", "\u8BBE\u5907\u6765\u6E90", "\u6240\u5C5E\u5DE5\u5382" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		window.table.getColumnModel().getColumn(2).setResizable(false);
		window.table.getColumnModel().getColumn(3).setResizable(false);
		window.table.getColumnModel().getColumn(4).setResizable(false);
		window.table.getColumnModel().getColumn(5).setResizable(false);
		window.table.getColumnModel().getColumn(6).setResizable(false);
		window.table.getColumnModel().getColumn(7).setResizable(false);
		window.table.getColumnModel().getColumn(8).setResizable(false);
		//�������ӵ�������
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * ϵͳ����Ա.��������.�豸�������� -> ChanPinleibieJFrame
	 */
	public static void sheBeiLeiBie() {
		SheBeiLeiBieJFrame window = new SheBeiLeiBieJFrame();
		xianShiSheBeiLeiBie(window, sheBeiLeiBies);
		
		//�½���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����½����");
				if (showInputDialog.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "��Ϣ����Ϊ��");
				} else {
					sheBeiLeiBies.add(new SheBeiLeiBie(showInputDialog));
					//��ʾ�޸ĺ��ArrayList
					xianShiSheBeiLeiBie(window, sheBeiLeiBies);
				}

			}
		});
		
		//�޸İ�ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�޸ĵ�����");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����޸ĺ������");
					sheBeiLeiBies.get(selectedRow).setLeibie(showInputDialog);
					//��ʾ�޸ĺ��ArrayList
					xianShiSheBeiLeiBie(window, sheBeiLeiBies);
				}
			}
		});
		
		//ɾ����ť
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫɾ��������");
				} else {
					sheBeiLeiBies.remove(selectedRow);
					//��ʾ�޸ĺ��ArrayList
					xianShiSheBeiLeiBie(window, sheBeiLeiBies);
				}
			}
		});
		
		//������ť
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "���������");
				ArrayList<SheBeiLeiBie> c = new ArrayList<>();
				for (SheBeiLeiBie shebei : sheBeiLeiBies) {
					if (shebei.getLeibie().equals(showInputDialog)) {
						c.add(shebei);
					}
				}
				//��ʾ�޸ĺ��ArrayList
				xianShiSheBeiLeiBie(window, c);
			}
		});
		
		//��ʼ����ɺ���ʾϵͳ����Ա���豸������ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ�豸�����Ϣ
	 * ΪsheBeiLeiBie()�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiSheBeiLeiBie(SheBeiLeiBieJFrame window, ArrayList<SheBeiLeiBie> shebeis) {
		//�����豸���͵�����
		Object[][] objects = new Object[shebeis.size()][2];
		int i = 0;
		for (SheBeiLeiBie shebei : shebeis) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = shebei.getLeibie();
				}

			}
			++i;
		}
		
		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects, new String[] { "\u5E8F\u53F7", "\u7C7B\u522B\u540D\u79F0" }) {
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		//�������������
		window.scrollPane.setViewportView(window.table);
	}


	/*
	 * ϵͳ����Ա.��������.�豸��Ϣ������ -> ChanPinleibieJFrame
	 */
	public static void sheBeiXinXi() {
		SheBeiXinXiJFrame window = new SheBeiXinXiJFrame();
		xianShiSheBei(window, sheBeis);
		
		//�½���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "������");
				String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "��������");
				String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "��������");
				String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "������");
				String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "��������");
				String showInputDialog6 = JOptionPane.showInputDialog(window.frame, "������������������");
				if (showInputDialog.isEmpty() || showInputDialog2.isEmpty() || showInputDialog3.isEmpty()
						|| showInputDialog4.isEmpty() || showInputDialog5.isEmpty() || showInputDialog.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "��Ϣ����Ϊ��");
				} else {
					sheBeis.add(new SheBei(showInputDialog, showInputDialog2, showInputDialog3, showInputDialog4,
							showInputDialog5, false, false, showInputDialog6));
				}
				//��ʾ�޸ĺ��ArrayList
				xianShiSheBei(window, sheBeis);
			}
		});
		
		//�޸İ�ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				int selectedColumn = window.table.getSelectedColumn();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�޸ĵ�����");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����޸ĺ������");
					if (selectedColumn == 1) {
						sheBeis.get(selectedRow).setID(showInputDialog);
					}
					if (selectedColumn == 2) {
						sheBeis.get(selectedRow).setMingcheng(showInputDialog);
					}
					if (selectedColumn == 3) {
						sheBeis.get(selectedRow).setLeixing(showInputDialog);
					}
					if (selectedColumn == 4) {
						sheBeis.get(selectedRow).setHuige(showInputDialog);
					}
					if (selectedColumn == 5) {
						sheBeis.get(selectedRow).setMiaoshu(showInputDialog);
					}
					if (selectedColumn == 8) {
						sheBeis.get(selectedRow).setSuoshuGC(showInputDialog);
					}
					//��ʾ�޸ĺ��ArrayList
					xianShiSheBei(window, sheBeis);
				}
			}
		});
		
		//ɾ����ť
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫɾ��������");
				} else {
					sheBeis.remove(selectedRow);
					//��ʾ�޸ĺ��ArrayList
					xianShiSheBei(window, sheBeis);
				}
			}
		});
		
		//������ť
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "����������");
				ArrayList<SheBei> c = new ArrayList<>();
				for (SheBei sheBei : sheBeis) {
					if (sheBei.getMingcheng().equals(showInputDialog)) {
						c.add(sheBei);
					}
				}
				//��ʾ�޸ĺ��ArrayList
				xianShiSheBei(window, c);
			}
		});
		
		//Զ�̿�����ť
		window.btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�������豸��");
				} else {
					if (sheBeis.get(selectedRow).isShebeizhuangtai()) {
						JOptionPane.showMessageDialog(window.frame, "���豸�ѿ�����");
					} else {
						sheBeis.get(selectedRow).setShebeizhuangtai(true);
						JOptionPane.showMessageDialog(window.frame, "�豸�����ɹ���");
					}
				}
			}
		});
		
		//Զ�̹ػ���ť
		window.btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�ػ����豸��");
				} else {
					if (!sheBeis.get(selectedRow).isShebeizhuangtai()) {
						JOptionPane.showMessageDialog(window.frame, "���豸�ѹػ���");
					} else {
						sheBeis.get(selectedRow).setShebeizhuangtai(false);
						JOptionPane.showMessageDialog(window.frame, "�豸�ػ��ɹ���");
					}
				}
			}
		});
		
		//��ʼ����ɺ���ʾϵͳ����Ա���豸��Ϣ����ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ�豸��Ϣ
	 * ΪsheBeiXinXi(�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiSheBei(SheBeiXinXiJFrame window, ArrayList<SheBei> sheBeis) {
		//�����豸��Ϣ������
		Object[][] objects = new Object[sheBeis.size()][9];
		int i = 0;
		for (SheBei sheBei : sheBeis) {
			for (int j = 0; j < 9; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = sheBei.getID();
				}
				if (j == 2) {
					objects[i][j] = sheBei.getMingcheng();
				}
				if (j == 3) {
					objects[i][j] = sheBei.getLeixing();
				}
				if (j == 4) {
					objects[i][j] = sheBei.getHuige();
				}
				if (j == 5) {
					objects[i][j] = sheBei.getMiaoshu();
				}
				if (j == 6) {
					if (sheBei.isShebeizhuangtai()) {
						//״̬Ϊtrueʱ��"������"
						objects[i][j] = "������";
					} else {
						objects[i][j] = "�ѹر�";
					}
				}
				if (j == 7) {
					if (sheBei.isZuyongzhuangtai()) {
						//״̬Ϊtrueʱ��"�����豸"
						objects[i][j] = "�����豸";
					} else {
						objects[i][j] = "�����豸";
					}
				}
				if (j == 8) {
					objects[i][j] = sheBei.getSuoshuGC();
				}
			}
			++i;
		}
		
		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects,
				new String[] { "\u5E8F\u5217", "\u8BBE\u5907\u7F16\u53F7", "\u8BBE\u5907\u540D\u79F0",
						"\u8BBE\u5907\u7C7B\u578B", "\u8BBE\u5907\u89C4\u683C", "\u8BBE\u5907\u63CF\u8FF0",
						"\u8BBE\u5907\u72B6\u6001", "\u8BBE\u5907\u6765\u6E90", "\u6240\u5C5E\u5DE5\u5382" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		window.table.getColumnModel().getColumn(2).setResizable(false);
		window.table.getColumnModel().getColumn(3).setResizable(false);
		window.table.getColumnModel().getColumn(4).setResizable(false);
		window.table.getColumnModel().getColumn(5).setResizable(false);
		window.table.getColumnModel().getColumn(6).setResizable(false);
		window.table.getColumnModel().getColumn(7).setResizable(false);
		window.table.getColumnModel().getColumn(8).setResizable(false);
		//�������������
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * ϵͳ����Ա.�ƹ�����Ϣ���� -> YunGongChangXinXiJFrame
	 */
	public static void yunGongChangXinXi() {
		YunGongChangXinXiJFrame window = new YunGongChangXinXiJFrame();
		xianShiYGC(window, ygCguanliyuans);
		
		//������ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//����������
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "���빤������");
				//�����µ�ArrayList�������һ�µ��ƹ�����Ϣ
				ArrayList<YunGongChangGuanLiYuan> y = new ArrayList<>();
				for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
					if (ygCguanliyuan.getMingcheng().equals(showInputDialog)) {
						y.add(ygCguanliyuan);
					}
				}
				//��ʾ�µ�ArrayList�е�����
				xianShiYGC(window, y);
			}
		});
		
		//������ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ��ѡ����к�
				int selectedRow = window.table.getSelectedRow();
				//δѡ��ʱ
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "����ѡ�񹤳���");
				} else {
					//�Ѿ�����ʱ
					if (ygCguanliyuans.get(selectedRow).isZhuangtai()) {
						JOptionPane.showMessageDialog(window.frame, "�ù����Ѿ�������");
					} else {
						ygCguanliyuans.get(selectedRow).setZhuangtai(true);
						JOptionPane.showMessageDialog(window.frame, "���������ɹ���");
						xianShiYGC(window, ygCguanliyuans);
					}
				}
			}
		});
		
		//��ͣ��ť
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ��ѡ����к�
				int selectedRow = window.table.getSelectedRow();
				//δѡ��ʱ
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "����ѡ�񹤳���");
				} else {
					//�Ѿ��ر�ʱ
					if (!ygCguanliyuans.get(selectedRow).isZhuangtai()) {
						JOptionPane.showMessageDialog(window.frame, "�ù����Ѿ��رգ�");
					} else {
						ygCguanliyuans.get(selectedRow).setZhuangtai(false);
						JOptionPane.showMessageDialog(window.frame, "�����رճɹ���");
						xianShiYGC(window, ygCguanliyuans);
					}
				}
			}
		});
		
		//��ʼ����ɺ���ʾϵͳ����Ա�Ĺ�����Ϣҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ�ƹ�����Ϣ
	 * ΪyunGongChangXinXi()�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiYGC(YunGongChangXinXiJFrame window, ArrayList<YunGongChangGuanLiYuan> ygCguanliyuans) {
		//���������ƹ���������
		Object[][] objects = new Object[ygCguanliyuans.size()][7];
		int i = 0;//��ʼ��������нǱ�
		//���ƹ�����������
		for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
			for (int j = 0; j < 7; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = ygCguanliyuan.getMingcheng();
				}
				if (j == 2) {
					objects[i][j] = ygCguanliyuan.getJianjie();
				}
				if (j == 3) {
					objects[i][j] = ygCguanliyuan.getName();
				}
				if (j == 4) {
					objects[i][j] = ygCguanliyuan.getPhone();
				}
				if (j == 5) {
					objects[i][j] = ygCguanliyuan.getID();
				}
				if (j == 6) {
					if (ygCguanliyuan.isZhuangtai()) {
						objects[i][j] = "����";
					} else {
						objects[i][j] = "�ر�";
					}

				}
			}
			++i;
		}
		
		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects,
				new String[] { "\u5E8F\u53F7", "\u5DE5\u5382\u540D\u79F0", "\u5DE5\u5382\u7B80\u4ECB",
						"\u8D1F\u8D23\u4EBA", "\u8054\u7CFB\u65B9\u5F0F", "\u767B\u5F55\u8D26\u53F7",
						"\u5DE5\u5382\u72B6\u6001" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		window.table.getColumnModel().getColumn(2).setPreferredWidth(100);
		window.table.getColumnModel().getColumn(3).setResizable(false);
		window.table.getColumnModel().getColumn(4).setResizable(false);
		window.table.getColumnModel().getColumn(5).setResizable(false);
		window.table.getColumnModel().getColumn(6).setResizable(false);
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * ϵͳ����Ա.�û������� -> YongHuXinXiGuanLiJFrame
	 */
	public static void yongHuXinXi() {
		YongHuXinXiGuanLiJFrame window = new YongHuXinXiGuanLiJFrame();
		//���û�����JTable����ʾ
		xianShiYongHu(window, ygCguanliyuans, users, xiTongGuanLiYuans);
		
		//�½���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����½���ɫ(�ƹ������û�)");
				//�����ƹ�������Աʱ
				if (showInputDialog.equals("�ƹ���")) {
					String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "�˺�");
					String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "����");
					String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "����");
					String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "��ϵ��ʽ");
					String showInputDialog6 = JOptionPane.showInputDialog(window.frame, "����");
					String showInputDialog7 = JOptionPane.showInputDialog(window.frame, "���");
					//Ϊ������ע��
					if (showInputDialog2.isEmpty() || showInputDialog3.isEmpty() || showInputDialog4.isEmpty()
							|| showInputDialog5.isEmpty() || showInputDialog6.isEmpty() || showInputDialog7.isEmpty()) {
						JOptionPane.showMessageDialog(window.frame, "ע����Ϣ����Ϊ��");
					} else {
						ygCguanliyuans.add(new YunGongChangGuanLiYuan(showInputDialog2, showInputDialog3,
								showInputDialog4, showInputDialog5, showInputDialog6, showInputDialog7, false));
					}
				}
				//�����û�ʱ
				if (showInputDialog.equals("�û�")) {
					String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "�˺�");
					String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "����");
					String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "����");
					String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "��ϵ��ʽ");
					//Ϊ������ע��
					if (showInputDialog2.isEmpty() || showInputDialog3.isEmpty() || showInputDialog4.isEmpty()
							|| showInputDialog5.isEmpty()) {
						JOptionPane.showMessageDialog(window.frame, "ע����Ϣ����Ϊ��");
					} else {
						users.add(new Users(showInputDialog2, showInputDialog3, showInputDialog4,
								showInputDialog5));
					}
				}
	
				//�������û��ٴη���JTable
				xianShiYongHu(window, ygCguanliyuans, users, xiTongGuanLiYuans);
			}
		});
		
		//������ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//����������ѯ
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "��������");
				//�����µ�ArrayList
				ArrayList<YunGongChangGuanLiYuan> y = new ArrayList<>();
				ArrayList<Users> j = new ArrayList<>();
				ArrayList<XiTongGuanLiYuan> x = new ArrayList<>();
				//�ж��Ƿ����ѯ�������
				for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
					if (ygCguanliyuan.getName().equals(showInputDialog)) {
						y.add(ygCguanliyuan);
					}
				}
				for (Users users : Controller.users) {
					if (users.getName().equals(showInputDialog)) {
						j.add(users);
					}
				}
				for (XiTongGuanLiYuan xiTongGuanLiYuan : xiTongGuanLiYuans) {
					if (xiTongGuanLiYuan.getName().equals(showInputDialog)) {
						x.add(xiTongGuanLiYuan);
					}
				}
				//��ʾ�µ�ArrayList�е�����
				xianShiYongHu(window, y, j, x);
			}
		});
		
		//�޸İ�ť
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ��ѡ����кź��к�
				int selectedRow = window.table.getSelectedRow();
				int selectedColumn = window.table.getSelectedColumn();
				//δѡ��ʱ
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ����Ҫ�޸ĵ�����");
				} else {
					//��ȡ��ѡ�е�����
					Object valueAt = window.table.getValueAt(selectedRow, 2);
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����޸ĺ������");
					//��ѡΪ�ƹ�������Աʱ��ͨ������������
					for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
						if (ygCguanliyuan.getName().equals(valueAt)) {
							if (selectedColumn == 1) {
								//�ڶ����޸��˺�
								ygCguanliyuan.setID(showInputDialog);
							} else if (selectedColumn == 2) {
								//�������޸�����
								ygCguanliyuan.setName(showInputDialog);
							} else if (selectedColumn == 3) {
								//�������޸���ϵ��ʽ
								ygCguanliyuan.setPhone(showInputDialog);
							} else {
								//���಻���޸�
								JOptionPane.showMessageDialog(window.frame, "�����޸�");
							}
						}
					}
					//��ѡΪ�û�ʱ��ͨ������������
					for (Users users : Controller.users) {
						if (users.getName().equals(valueAt)) {
							if (users.getName().equals(valueAt)) {
								if (selectedColumn == 1) {
									users.setID(showInputDialog);
								} else if (selectedColumn == 2) {
									users.setName(showInputDialog);
								} else if (selectedColumn == 3) {
									users.setPhone(showInputDialog);
								} else {
									JOptionPane.showMessageDialog(window.frame, "�����޸�");
								}
							}
						}
					}
					//��ѡΪϵͳ����Աʱ��ͨ������������
					for (XiTongGuanLiYuan xiTongGuanLiYuan : xiTongGuanLiYuans) {
						if (xiTongGuanLiYuan.getName().equals(valueAt)) {
							if (xiTongGuanLiYuan.getName().equals(valueAt)) {
								if (selectedColumn == 1) {
									xiTongGuanLiYuan.setID(showInputDialog);
								} else if (selectedColumn == 2) {
									xiTongGuanLiYuan.setName(showInputDialog);
								} else if (selectedColumn == 3) {
									xiTongGuanLiYuan.setPhone(showInputDialog);
								} else {
									JOptionPane.showMessageDialog(window.frame, "�����޸�");
								}
							}
						}
					}
					//��ʾ���ĺ������
					xianShiYongHu(window, ygCguanliyuans, users, xiTongGuanLiYuans);
				}
			}
		});
		
		//ɾ����ť
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ��ѡ�к�
				int selectedRow = window.table.getSelectedRow();
				//δѡ��ʱ
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ����Ҫɾ��������");
				} else {
					//��ȡ��ѡ�е�����
					Object valueAt = window.table.getValueAt(selectedRow, 2);
					//��ѡΪ�ƹ�������Աʱ��ͨ������������
					for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
						if (ygCguanliyuan.getName().equals(valueAt)) {
							ygCguanliyuans.remove(ygCguanliyuan);
						}
					}
					//��ѡΪ�û�ʱ��ͨ������������
					for (Users users : Controller.users) {
						if (users.getName().equals(valueAt)) {
							Controller.users.remove(users);
						}
					}
					//��ѡΪϵͳ����Աʱ��ͨ������������
					for (XiTongGuanLiYuan xiTongGuanLiYuan : xiTongGuanLiYuans) {
						if (xiTongGuanLiYuan.getName().equals(valueAt)) {
							xiTongGuanLiYuans.remove(xiTongGuanLiYuan);
						}
					}
					//��ʾ���ĺ������
					xianShiYongHu(window, ygCguanliyuans, users, xiTongGuanLiYuans);
				}
			}
		});
		
		//��ʼ����ɺ���ʾϵͳ����Ա���û�����ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ�û���Ϣ
	 * ΪyongHuXinXi()�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiYongHu(YongHuXinXiGuanLiJFrame window, ArrayList<YunGongChangGuanLiYuan> ygCguanliyuans,
									 ArrayList<Users> users, ArrayList<XiTongGuanLiYuan> xiTongGuanLiYuans) {
		//���������û�������
		Object[][] objects = new Object[ygCguanliyuans.size() + users.size() + xiTongGuanLiYuans.size()][5];
		//��ʼ�������Ǳ�
		int i = 0;
		//���ƹ�������Ա��������
		for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = ygCguanliyuan.getID();
				}
				if (j == 2) {
					objects[i][j] = ygCguanliyuan.getName();
				}
				if (j == 3) {
					objects[i][j] = ygCguanliyuan.getPhone();
				}
				if (j == 4) {
					objects[i][j] = "�ƹ�������Ա";
				}
			}
			++i;
		}
		//���û���������
		for (Users jingXiaoShang : users) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = jingXiaoShang.getID();
				}
				if (j == 2) {
					objects[i][j] = jingXiaoShang.getName();
				}
				if (j == 3) {
					objects[i][j] = jingXiaoShang.getPhone();
				}
				if (j == 4) {
					objects[i][j] = "�û�����Ա";
				}
			}
			++i;
		}
		//��ϵͳ����Ա��������
		for (XiTongGuanLiYuan xiTongGuanLiYuan : xiTongGuanLiYuans) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = xiTongGuanLiYuan.getID();
				}
				if (j == 2) {
					objects[i][j] = xiTongGuanLiYuan.getName();
				}
				if (j == 3) {
					objects[i][j] = xiTongGuanLiYuan.getPhone();
				}
				if (j == 4) {
					objects[i][j] = "��������Ա";
				}
			}
			++i;
		}

		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects, new String[] { "\u5E8F\u53F7", "\u767B\u5F55\u8D26\u53F7",
				"\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F", "\u89D2\u8272\u540D\u79F0" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		window.table.getColumnModel().getColumn(2).setResizable(false);
		window.table.getColumnModel().getColumn(3).setResizable(false);
		window.table.getColumnModel().getColumn(4).setResizable(false);
		//�ѱ����������
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * ϵͳ����Ա.������Ϣ���� || �ƹ�������Ա.������Ϣ���� -> DingDanJFrame
	 */
	public static void dingDanXianShi() {
		DingDanJFrame window = new DingDanJFrame();
		xianShiDingDan1(window, dingDanXinXis);
		
		//������ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				//δѡ��
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�����Ķ���");
				} else {
					//��ȡ�������
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����豸����");
					String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "���뿪ʼʱ��(��ʽ����-��-��)");
					String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "�������ʱ��(��ʽ����-��-��)");
					for (DingDanXinXi dingDanXinXi : dingDanXinXis) {
						//��������ʱ�����ݶ������������
						if (dingDanXinXi.getId().equals(valueAt)) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
							String format = dateFormat.format(new Date());
							if (format.equals(showInputDialog3)) {
								dingDanXinXi.setZhuangtai("���깤");
							} else {
								dingDanXinXi.setZhuangtai("��������");
							}
						}
					}
					//��ʾ�µ�ArrayList
					xianShiDingDan1(window, dingDanXinXis);
				}
			}
		});
		
		//��ʼ����ɺ���ʾϵͳ����Ա�Ķ�������ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ������Ϣ�ķ���һ
	 * ΪdingDanXianShi()�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiDingDan1(DingDanJFrame window, ArrayList<DingDanXinXi> dingDanXinXis) {
		//���涩����Ϣ������
		Object[][] objects = new Object[dingDanXinXis.size()][9];
		int i = 0;
		for (DingDanXinXi dingDanXinXi : dingDanXinXis) {
			for (int j = 0; j < 9; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = dingDanXinXi.getId();
				}
				if (j == 2) {
					objects[i][j] = dingDanXinXi.getMingcheng();
				}
				if (j == 3) {
					objects[i][j] = dingDanXinXi.getShuliang();
				}
				if (j == 4) {
					objects[i][j] = dingDanXinXi.getJaofuriqi();
				}
				if (j == 5) {
					objects[i][j] = dingDanXinXi.getShouhuoren();
				}
				if (j == 6) {
					objects[i][j] = dingDanXinXi.getShlianxifangshi();
				}
				if (j == 7) {
					objects[i][j] = dingDanXinXi.getShdizhi();
				}
				if (j == 8) {
					objects[i][j] = dingDanXinXi.getZhuangtai();
				}
			}
			++i;
		}
		
		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects,
				new String[] { "\u5E8F\u53F7", "\u8BA2\u5355\u7F16\u53F7", "\u4EA7\u54C1\u540D",
						"\u8BA2\u8D2D\u6570\u91CF", "\u4EA4\u4ED8\u65E5\u671F", "\u6536\u8D27\u4EBA",
						"\u6536\u8D27\u4EBA\u8054\u7CFB\u65B9\u5F0F", "\u6536\u8D27\u5730\u5740",
						"\u8BA2\u5355\u72B6\u6001" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		window.table.getColumnModel().getColumn(2).setResizable(false);
		window.table.getColumnModel().getColumn(3).setResizable(false);
		window.table.getColumnModel().getColumn(4).setResizable(false);
		window.table.getColumnModel().getColumn(5).setResizable(false);
		window.table.getColumnModel().getColumn(6).setResizable(false);
		window.table.getColumnModel().getColumn(7).setResizable(false);
		window.table.getColumnModel().getColumn(8).setResizable(false);
		//�������뵽������
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * �û�.������Ϣ���� -> DingDanXinXiJFrame
	 */
	public static void dingDanXinXi() {
		DingDanXinXiJFrame window = new DingDanXinXiJFrame();
		xianShiDingDan2(window, dingDanXinXis);
		
		//�½���ť
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "���붩�������");
				String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "�����Ʒ��");
				String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "���붩������");
				String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "���뽻������");
				String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "�����ջ���");
				String showInputDialog6 = JOptionPane.showInputDialog(window.frame, "�����ջ�����ϵ��ʽ");
				String showInputDialog7 = JOptionPane.showInputDialog(window.frame, "�����ջ���ַ");
				dingDanXinXis.add(new DingDanXinXi(showInputDialog, showInputDialog2, showInputDialog3,
						showInputDialog4, showInputDialog5, showInputDialog6, showInputDialog7, "δ����"));
				//��ʾ�µ�ArrayList
				xianShiDingDan2(window, dingDanXinXis);
			}
		});
		
		//�޸İ�ť
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedColumn = window.table.getSelectedColumn();
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�޸ĵ�����");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "�����޸ĺ������");
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (DingDanXinXi dingDanXinXi : dingDanXinXis) {
						if (dingDanXinXi.getId().equals(valueAt)) {
							if (selectedColumn == 1) {
								dingDanXinXi.setId(showInputDialog);
							}
							if (selectedColumn == 2) {
								dingDanXinXi.setMingcheng(showInputDialog);
							}
							if (selectedColumn == 3) {
								dingDanXinXi.setShuliang(showInputDialog);
							}
							if (selectedColumn == 4) {
								dingDanXinXi.setJaofuriqi(showInputDialog);
							}
							if (selectedColumn == 5) {
								dingDanXinXi.setShouhuoren(showInputDialog);
							}
							if (selectedColumn == 6) {
								dingDanXinXi.setShlianxifangshi(showInputDialog);
							}
							if (selectedColumn == 7) {
								dingDanXinXi.setShdizhi(showInputDialog);
							}
						}
					}
					//��ʾ�µ�ArrayList
					xianShiDingDan2(window, dingDanXinXis);
				}
			}
		});
		
		//ɾ����ť
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫɾ��������");
				} else {
					dingDanXinXis.remove(selectedRow);
					//��ʾ�µ�ArrayList
					xianShiDingDan2(window, dingDanXinXis);
				}
			}
		});
		
		//����������ť
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				//δѡ��
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "��ѡ��Ҫ�����Ķ���");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (DingDanXinXi dingDanXinXi : dingDanXinXis) {
						if (dingDanXinXi.getId().equals(valueAt)) {
							dingDanXinXi.setZhuangtai("����");
							JOptionPane.showMessageDialog(window.frame, "�����ɹ�");
						}
					}
					//��ʾ�µ�ArrayList
					xianShiDingDan2(window, dingDanXinXis);
				}
			}
		});
		
		//��ʼ����ɺ��û��Ķ�������ҳ��
		window.frame.setVisible(true);
	}

	
	/*
	 * �ڱ������ʾ������Ϣ�ķ�����
	 * ΪdingDanXinXi()�����ṩ����
	 */
	@SuppressWarnings("serial")
	public static void xianShiDingDan2(frame.DingDanXinXiJFrame window, ArrayList<DingDanXinXi> dingDanXinXis) {
		//���涩����Ϣ������
		Object[][] objects = new Object[dingDanXinXis.size()][9];
		int i = 0;
		for (DingDanXinXi dingDanXinXi : dingDanXinXis) {
			for (int j = 0; j < 9; j++) {
				if (j == 0) {
					objects[i][j] = i + 1;
				}
				if (j == 1) {
					objects[i][j] = dingDanXinXi.getId();
				}
				if (j == 2) {
					objects[i][j] = dingDanXinXi.getMingcheng();
				}
				if (j == 3) {
					objects[i][j] = dingDanXinXi.getShuliang();
				}
				if (j == 4) {
					objects[i][j] = dingDanXinXi.getJaofuriqi();
				}
				if (j == 5) {
					objects[i][j] = dingDanXinXi.getShouhuoren();
				}
				if (j == 6) {
					objects[i][j] = dingDanXinXi.getShlianxifangshi();
				}
				if (j == 7) {
					objects[i][j] = dingDanXinXi.getShdizhi();
				}
				if (j == 8) {
					objects[i][j] = dingDanXinXi.getZhuangtai();
				}
			}
			++i;
		}
		
		//���ñ�ͷ���п�
		window.table.setModel(new DefaultTableModel(objects,
				new String[] { "\u5E8F\u53F7", "\u8BA2\u5355\u7F16\u53F7", "\u4EA7\u54C1\u540D",
						"\u8BA2\u8D2D\u6570\u91CF", "\u4EA4\u4ED8\u65E5\u671F", "\u6536\u8D27\u4EBA",
						"\u6536\u8D27\u4EBA\u8054\u7CFB\u65B9\u5F0F", "\u6536\u8D27\u5730\u5740",
						"\u8BA2\u5355\u72B6\u6001" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		window.table.getColumnModel().getColumn(2).setResizable(false);
		window.table.getColumnModel().getColumn(3).setResizable(false);
		window.table.getColumnModel().getColumn(4).setResizable(false);
		window.table.getColumnModel().getColumn(5).setResizable(false);
		window.table.getColumnModel().getColumn(6).setResizable(false);
		window.table.getColumnModel().getColumn(7).setResizable(false);
		window.table.getColumnModel().getColumn(8).setResizable(false);
		//�������ӵ�������
		window.scrollPane.setViewportView(window.table);
	}
}
