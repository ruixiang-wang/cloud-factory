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
 * 数据与用户交互类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class Controller {
	private static ArrayList<XiTongGuanLiYuan> xiTongGuanLiYuans;//系统管理员列表
	private static ArrayList<Users> users;//用户列表
	private static ArrayList<YunGongChangGuanLiYuan> ygCguanliyuans;//云工厂管理员列表
	private static ArrayList<ChanPin> chanPins;//产品列表
	private static ArrayList<SheBei> sheBeis;//设备列表
	private static ArrayList<DingDanXinXi> dingDanXinXis;//订单列表
	private static ArrayList<ChanPinLeiBie> chanPinLeiBies;//产品类别列表
	private static ArrayList<SheBeiLeiBie> sheBeiLeiBies;//设备类别列表
	
	@SuppressWarnings("unused")
	private static XiTongGuanLiYuan nowguanliyuan = new XiTongGuanLiYuan();//当前系统管理员
	@SuppressWarnings("unused")
	private static Users nowjingxiaoshang = new Users();//当前用户
	private static YunGongChangGuanLiYuan nowyungongchang = new YunGongChangGuanLiYuan();//当前云工厂管理员
	
	/*
	 * 构造函数初始化
	 */
	public Controller() {
		xiTongGuanLiYuans = new ArrayList<>();
		//系统管理员账号：555；密码：555
		xiTongGuanLiYuans.add(new XiTongGuanLiYuan("555", "555", "xiaoming", "555"));
		users = new ArrayList<>();
		ygCguanliyuans = new ArrayList<>();
		chanPins = new ArrayList<>();
		sheBeis = new ArrayList<>();
		dingDanXinXis = new ArrayList<>();
		chanPinLeiBies = new ArrayList<>();
		sheBeiLeiBies = new ArrayList<>();
//		ShuJuDuXie.read1(xiTongGuanLiYuans);
		//读入文件信息
		ShuJuDuXie.read2(users);
		ShuJuDuXie.read3(ygCguanliyuans);
		ShuJuDuXie.read4(sheBeis);
		ShuJuDuXie.read5(chanPins);
		ShuJuDuXie.read6(dingDanXinXis);
		ShuJuDuXie.read7(chanPinLeiBies);
		ShuJuDuXie.read8(sheBeiLeiBies);
	}

	
	/*
	 * 登录窗口中的监听器 -> DengluJFrame
	 */
	public static void dengLu() {
		DengluJFrame window = new DengluJFrame();
		
		// 登录按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = window.textField.getText();
				String string = new String(window.passwordField.getPassword());
				//用户名或密码或身份为空时不能登录
				if (text.isEmpty() || string == null || (!window.rdbtnNewRadioButton.isSelected()
						&& !window.rdbtnNewRadioButton_1.isSelected() && !window.rdbtnNewRadioButton_2.isSelected())) {
					JOptionPane.showMessageDialog(window.frame, "用户名或密码或身份不能为空！");
					return;//用来终止程序继续进行
				}
				//系统管理员登录时：遍历系统管理员列表判断密码是否正确
				if (window.rdbtnNewRadioButton.isSelected()) {
					for (XiTongGuanLiYuan xiTongGuanLiYuan : xiTongGuanLiYuans) {
						if (xiTongGuanLiYuan.getID().equals(text) && xiTongGuanLiYuan.getPassword().equals(string)) {
							window.frame.dispose();
							nowguanliyuan = xiTongGuanLiYuan;//给当前系统管理员初始化赋值
							guanLiYuan();
							return;
						}
					}
					JOptionPane.showMessageDialog(window.frame, "登录名或密码错误！");
				}
				//用户登录时：遍历用户列表判断密码是否正确
				if (window.rdbtnNewRadioButton_1.isSelected()) {
					for (Users users : Controller.users) {
						if (users.getID().equals(text) && users.getPassword().equals(string)) {
							window.frame.dispose();
							nowjingxiaoshang = users;//给当前用户初始化赋值
							jingXiaoShang();
							return;
						}
					}
					JOptionPane.showMessageDialog(window.frame, "登录名或密码错误！");
				}
				//云工厂管理员登录时：遍历云工厂管理员列表判断密码是否正确
				if (window.rdbtnNewRadioButton_2.isSelected()) {
					for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
						if (ygCguanliyuan.getID().equals(text) && ygCguanliyuan.getPassword().equals(string)) {
							window.frame.dispose();
							nowyungongchang = ygCguanliyuan;//给当前云工厂管理员初始化赋值
							yunGongChang();
							return;
						}
					}
					JOptionPane.showMessageDialog(window.frame, "登录名或密码错误！");
				}
			}
		});
		
		// 注册按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//当选择注册系统管理员时，不能注册
				if (window.rdbtnNewRadioButton.isSelected()) {
					JOptionPane.showMessageDialog(window.frame, "不可注册系统管理员！");
					return;
				}
				//当选择注册用户时
				if (window.rdbtnNewRadioButton_1.isSelected()) {
					window.frame.dispose();
					zhuceJXS();
					return;
				}
				//当选择注册云工厂管理员时
				if (window.rdbtnNewRadioButton_2.isSelected()) {
					window.frame.dispose();
					zhuceYGC();
					return;
				}
				//当未选择注册类别时
				JOptionPane.showMessageDialog(window.frame, "请选择注册身份！");
			}
		});
		
		//初始化完成后显示登录窗口
		window.frame.setVisible(true);
	}

	
	/*
	 * 云工厂管理员注册窗口的监听器 ->ZhuCeYunGongChangJFrame
	 */
	public static void zhuceYGC() {
		ZhuCeYunGongChangJFrame window = new ZhuCeYunGongChangJFrame();
		
		//确认按钮
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
				JOptionPane.showMessageDialog(window.frame, "注册成功，即将返回登录界面！");
				window.frame.dispose();
				//注册成功返回登录界面
				dengLu();
			}
		});
		
		//返回按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.frame.dispose();
				dengLu();
			}
		});
		
		//初始化完成后显示云工厂注册窗口
		window.frame.setVisible(true);
	}

	
	/*
	 * 用户注册窗口的监听器 -> ZhuCeJingXiaoShangJFrame
	 */
	public static void zhuceJXS() {
		ZhuCeJingXiaoShangJFrame window = new ZhuCeJingXiaoShangJFrame();
		
		//确认按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = window.textField.getText();
				String text2 = window.textField_1.getText();
				String text3 = window.textField_2.getText();
				String string = new String(window.passwordField.getPassword());
				users.add(new Users(text, string, text2, text3));
				JOptionPane.showMessageDialog(window.frame, "注册成功，即将返回登录界面！");
				window.frame.dispose();
				//注册成功返回登录界面
				dengLu();
			}
		});
		
		//返回按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.frame.dispose();
				dengLu();
			}
		});
		
		//初始化完成后显示用户注册窗口
		window.frame.setVisible(true);
	}

	
	/*
	 * 系统管理员主窗口的监听器 -> GuanLiYuanJFrame
	 */
	public static void guanLiYuan() {
		GuanLiYuanJFrame window = new GuanLiYuanJFrame();
		
		//菜单：系统设置->用户信息管理
		window.mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				yongHuXinXi();
			}
		});
		
		//菜单：云工厂->工厂信息管理
		window.mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				yunGongChangXinXi();
			}
		});
		
		//菜单：产品管理->产品类别管理
		window.mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chanPinLeiBie();
			}
		});
		
		//菜单：产品管理->产品信息管理
		window.mntmNewMenuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chanPinXinXi();
			}
		});
		
		//菜单：产能中心->设备类型管理
		window.mntmNewMenuItem_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sheBeiLeiBie();
			}
		});
		
		//菜单：产能中心->设备信息管理
		window.mntmNewMenuItem_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sheBeiXinXi();
			}
		});
		
		//菜单：订单管理->订单信息管理
		window.mntmNewMenuItem_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dingDanXianShi();
			}
		});
		
		//退出按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//将所有列表中的信息存入文件
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
		
		//初始化完成后显示系统管理员主页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 用户主窗口的监听器 -> JingXiaoShangJFrame
	 */
	public static void jingXiaoShang() {
		JingXiaoShangJFrame window = new JingXiaoShangJFrame();
		
		//菜单：订单管理->订单信息管理
		window.mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dingDanXinXi();
			}
		});
		
		//退出按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//将所有列表中的信息存入文件
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
		
		//初始化完成后显示用户主页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 云工厂管理员主窗口的监听器 -> YunGongChangJFrame
	 */
	public static void yunGongChang() {
		YunGongChangJFrame window = new YunGongChangJFrame();
		
		//菜单：我的工厂->我的设备
		window.mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mySheBei();
			}
		});
		
		//菜单：订单管理->订单信息
		window.mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dingDanXianShi();
			}
		});
		
		//退出按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//将所有列表中的信息存入文件
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
		
		//初始化完成后显示云工厂管理员主页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 系统管理员.产品类别.产品类别管理窗口 -> ChanPinleibieJFrame
	 */
	public static void chanPinLeiBie() {
		ChanPinleibieJFrame window = new ChanPinleibieJFrame();
		xianShiLeiBie(window, chanPinLeiBies);
		
		//新建按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入新建类别");
				if (showInputDialog.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "信息不能为空");
				} else {
					chanPinLeiBies.add(new ChanPinLeiBie(showInputDialog));
					//显示修改后的ArrayList
					xianShiLeiBie(window, chanPinLeiBies);
				}

			}
		});
		
		//修改按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要修改的内容");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入修改后的内容");
					chanPinLeiBies.get(selectedRow).setLeibie(showInputDialog);
					//显示修改后的ArrayList
					xianShiLeiBie(window, chanPinLeiBies);
				}
			}
		});
		
		//删除按钮
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要删除的内容");
				} else {
					chanPinLeiBies.remove(selectedRow);
					//显示修改后的ArrayList
					xianShiLeiBie(window, chanPinLeiBies);
				}
			}
		});
		
		//检索按钮
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "请输入类别");
				//创建新的ArrayList
				ArrayList<ChanPinLeiBie> c = new ArrayList<>();
				for (ChanPinLeiBie chanpin : chanPinLeiBies) {
					if (chanpin.getLeibie().equals(showInputDialog)) {
						c.add(chanpin);
					}
				}
				//显示修改后的ArrayList
				xianShiLeiBie(window, c);
			}
		});
		
		//初始化完成后显示系统管理员的产品类别管理页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示产品类别信息
	 * 为chanPinLeiBie()方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiLeiBie(ChanPinleibieJFrame window, ArrayList<ChanPinLeiBie> chanpins) {
		//储存全部产品的数组
		Object[][] objects = new Object[chanpins.size()][2];
		int i = 0;
		//将所有产品的类别存入数组
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
		
		//设置表头和列宽
		window.table.setModel(new DefaultTableModel(objects, new String[] { "\u5E8F\u53F7", "\u7C7B\u522B\u540D\u79F0" }) {
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		//将表格添加到滚动界面
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * 系统管理员.产品类别.产品信息管理窗口 -> ChanPinleibieJFrame
	 */
	public static void chanPinXinXi() {
		ChanPinXinxiJFrame window = new ChanPinXinxiJFrame();
		xianShiChanPin(window, chanPins);
		
		//新建按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入编号");
				String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "输入名称");
				String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "输入类别");
				String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "输入规格");
				String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "输入描述");
				if (showInputDialog.isEmpty() || showInputDialog2.isEmpty() || showInputDialog3.isEmpty()
						|| showInputDialog4.isEmpty() || showInputDialog5.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "信息不能为空");
				} else {
					chanPins.add(new ChanPin(showInputDialog, showInputDialog2, showInputDialog3, showInputDialog4,
							showInputDialog5));
				}
				//显示新的ArrayList
				xianShiChanPin(window, chanPins);
			}
		});
		
		//修改按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				int selectedColumn = window.table.getSelectedColumn();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要修改的内容");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入修改后的内容");
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
					//显示新的ArrayList
					xianShiChanPin(window, chanPins);
				}
			}
		});
		
		//删除按钮
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要删除的内容");
				} else {
					chanPins.remove(selectedRow);
					//显示新的ArrayList
					xianShiChanPin(window, chanPins);
				}
			}
		});
		
		//检索按钮
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "请输入名称");
				ArrayList<ChanPin> c = new ArrayList<>();
				for (ChanPin chanPin : chanPins) {
					if (chanPin.getMingcheng().equals(showInputDialog)) {
						c.add(chanPin);
					}
				}
				//显示新的ArrayList
				xianShiChanPin(window, c);
			}
		});
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示产品信息
	 * 为chanPinXinXi()方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiChanPin(ChanPinXinxiJFrame window, ArrayList<ChanPin> chanPins) {
		//储存产品信息的数组
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
		
		//设置表头和列宽
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
		//将表格加入滚动框
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 *  云工厂管理员.我的设备 -> MySheBeiJFrame
	 */
	public static void mySheBei() {
		MySheBeiJFrame window = new MySheBeiJFrame();
		xianShiMySheBei(window, sheBeis);
		
		//新建按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入编号");
				String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "输入名称");
				String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "输入类型");
				String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "输入规格");
				String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "输入描述");
				String showInputDialog6 = JOptionPane.showInputDialog(window.frame, "输入所属工厂");
				if (showInputDialog.isEmpty() || showInputDialog2.isEmpty() || showInputDialog3.isEmpty()
						|| showInputDialog4.isEmpty() || showInputDialog5.isEmpty() || showInputDialog.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "信息不能为空");
				} else {
					sheBeis.add(new SheBei(showInputDialog, showInputDialog2, showInputDialog3, showInputDialog4,
							showInputDialog5, false, false, showInputDialog6));
				}
				//显示新的ArrayList
				xianShiMySheBei(window, sheBeis);
			}
		});
		
		//修改按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				int selectedColumn = window.table.getSelectedColumn();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要修改的内容");
				} else {
					//获取设备编号
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入修改后的内容");
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
					//显示新的ArrayList
					xianShiMySheBei(window, sheBeis);
				}
			}
		});
		
		//删除按钮
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要删除的内容");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							sheBeis.remove(sheBei);
						}
					}
					//显示新的ArrayList
					xianShiMySheBei(window, sheBeis);
				}
			}
		});
		
		//检索按钮
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "请输入名称");
				ArrayList<SheBei> c = new ArrayList<>();
				for (SheBei sheBei : sheBeis) {
					if (sheBei.getMingcheng().equals(showInputDialog)) {
						c.add(sheBei);
					}
				}
				//显示新的ArrayList
				xianShiMySheBei(window, c);
			}
		});
		
		//远程开机按钮
		window.btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要开机的设备");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							if (sheBei.isShebeizhuangtai()) {
								JOptionPane.showMessageDialog(window.frame, "该设备已开启");
							} else {
								sheBei.setShebeizhuangtai(true);
								JOptionPane.showMessageDialog(window.frame, "设备开启成功");
								//显示新的ArrayList
								xianShiMySheBei(window, sheBeis);
							}
						}
					}
				}
			}
		});
		
		//远程关机按钮
		window.btnNewButton_4_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要关机的设备");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							if (!sheBei.isShebeizhuangtai()) {
								JOptionPane.showMessageDialog(window.frame, "该设备已关机");
							} else {
								sheBei.setShebeizhuangtai(false);
								JOptionPane.showMessageDialog(window.frame, "设备关机成功");
								xianShiMySheBei(window, sheBeis);
							}
						}
					}
				}
			}
		});
		
		//设置租用状态按钮
		window.btnNewButton_4_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要租用的设备");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (SheBei sheBei : sheBeis) {
						if (sheBei.getID().equals(valueAt)) {
							if (sheBei.isZuyongzhuangtai()) {
								JOptionPane.showMessageDialog(window.frame, "该设备已租用");
							} else {
								sheBei.setZuyongzhuangtai(true);
								JOptionPane.showMessageDialog(window.frame, "设备租用成功");
								xianShiMySheBei(window, sheBeis);
							}
						}
					}
				}
			}
		});
		
		//配置产品按钮
		window.btnNewButton_4_3.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要配置产品的设备");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入产品名称");
					String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "输入产品产能(件/时)");
				}
			}
		});
		
		//初始化完成后显示云工厂管理员的我的设备页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示自己工厂的设备信息
	 * 为mySheBei()方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiMySheBei(MySheBeiJFrame window, ArrayList<SheBei> sheBeis) {

		int i = 0;
		//获取属于自己工厂的设备
		ArrayList<SheBei> shebeis2 = new ArrayList<>();
		for (SheBei sheBei : sheBeis) {
			if (sheBei.getSuoshuGC().equals(nowyungongchang.getMingcheng())) {
				shebeis2.add(sheBei);
			}
		}
		//储存自己工厂设备的数组
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
						objects[i][j] = "闲置中";
					} else {
						objects[i][j] = "已关闭";
					}
				}
				if (j == 7) {
					if (sheBei.isZuyongzhuangtai()) {
						objects[i][j] = "租用设备";
					} else {
						objects[i][j] = "自有设备";
					}
				}
				if (j == 8) {
					objects[i][j] = sheBei.getSuoshuGC();
				}
			}
			++i;
		}

		//设置表头和列宽
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
		//将表格添加到滚动框
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * 系统管理员.产能中心.设备类别管理窗口 -> ChanPinleibieJFrame
	 */
	public static void sheBeiLeiBie() {
		SheBeiLeiBieJFrame window = new SheBeiLeiBieJFrame();
		xianShiSheBeiLeiBie(window, sheBeiLeiBies);
		
		//新建按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入新建类别");
				if (showInputDialog.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "信息不能为空");
				} else {
					sheBeiLeiBies.add(new SheBeiLeiBie(showInputDialog));
					//显示修改后的ArrayList
					xianShiSheBeiLeiBie(window, sheBeiLeiBies);
				}

			}
		});
		
		//修改按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要修改的内容");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入修改后的内容");
					sheBeiLeiBies.get(selectedRow).setLeibie(showInputDialog);
					//显示修改后的ArrayList
					xianShiSheBeiLeiBie(window, sheBeiLeiBies);
				}
			}
		});
		
		//删除按钮
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要删除的内容");
				} else {
					sheBeiLeiBies.remove(selectedRow);
					//显示修改后的ArrayList
					xianShiSheBeiLeiBie(window, sheBeiLeiBies);
				}
			}
		});
		
		//检索按钮
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "请输入类别");
				ArrayList<SheBeiLeiBie> c = new ArrayList<>();
				for (SheBeiLeiBie shebei : sheBeiLeiBies) {
					if (shebei.getLeibie().equals(showInputDialog)) {
						c.add(shebei);
					}
				}
				//显示修改后的ArrayList
				xianShiSheBeiLeiBie(window, c);
			}
		});
		
		//初始化完成后显示系统管理员的设备类别管理页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示设备类别信息
	 * 为sheBeiLeiBie()方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiSheBeiLeiBie(SheBeiLeiBieJFrame window, ArrayList<SheBeiLeiBie> shebeis) {
		//储存设备类型的数组
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
		
		//设置表头和列宽
		window.table.setModel(new DefaultTableModel(objects, new String[] { "\u5E8F\u53F7", "\u7C7B\u522B\u540D\u79F0" }) {
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		window.table.getColumnModel().getColumn(0).setResizable(false);
		window.table.getColumnModel().getColumn(1).setResizable(false);
		//将表格加入滚动框
		window.scrollPane.setViewportView(window.table);
	}


	/*
	 * 系统管理员.产能中心.设备信息管理窗口 -> ChanPinleibieJFrame
	 */
	public static void sheBeiXinXi() {
		SheBeiXinXiJFrame window = new SheBeiXinXiJFrame();
		xianShiSheBei(window, sheBeis);
		
		//新建按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入编号");
				String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "输入名称");
				String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "输入类型");
				String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "输入规格");
				String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "输入描述");
				String showInputDialog6 = JOptionPane.showInputDialog(window.frame, "输入所属工厂的名字");
				if (showInputDialog.isEmpty() || showInputDialog2.isEmpty() || showInputDialog3.isEmpty()
						|| showInputDialog4.isEmpty() || showInputDialog5.isEmpty() || showInputDialog.isEmpty()) {
					JOptionPane.showMessageDialog(window.frame, "信息不能为空");
				} else {
					sheBeis.add(new SheBei(showInputDialog, showInputDialog2, showInputDialog3, showInputDialog4,
							showInputDialog5, false, false, showInputDialog6));
				}
				//显示修改后的ArrayList
				xianShiSheBei(window, sheBeis);
			}
		});
		
		//修改按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				int selectedColumn = window.table.getSelectedColumn();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要修改的内容");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入修改后的内容");
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
					//显示修改后的ArrayList
					xianShiSheBei(window, sheBeis);
				}
			}
		});
		
		//删除按钮
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要删除的内容");
				} else {
					sheBeis.remove(selectedRow);
					//显示修改后的ArrayList
					xianShiSheBei(window, sheBeis);
				}
			}
		});
		
		//检索按钮
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "请输入名称");
				ArrayList<SheBei> c = new ArrayList<>();
				for (SheBei sheBei : sheBeis) {
					if (sheBei.getMingcheng().equals(showInputDialog)) {
						c.add(sheBei);
					}
				}
				//显示修改后的ArrayList
				xianShiSheBei(window, c);
			}
		});
		
		//远程开机按钮
		window.btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要开机的设备！");
				} else {
					if (sheBeis.get(selectedRow).isShebeizhuangtai()) {
						JOptionPane.showMessageDialog(window.frame, "该设备已开启！");
					} else {
						sheBeis.get(selectedRow).setShebeizhuangtai(true);
						JOptionPane.showMessageDialog(window.frame, "设备开启成功！");
					}
				}
			}
		});
		
		//远程关机按钮
		window.btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要关机的设备！");
				} else {
					if (!sheBeis.get(selectedRow).isShebeizhuangtai()) {
						JOptionPane.showMessageDialog(window.frame, "该设备已关机！");
					} else {
						sheBeis.get(selectedRow).setShebeizhuangtai(false);
						JOptionPane.showMessageDialog(window.frame, "设备关机成功！");
					}
				}
			}
		});
		
		//初始化完成后显示系统管理员的设备信息管理页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示设备信息
	 * 为sheBeiXinXi(方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiSheBei(SheBeiXinXiJFrame window, ArrayList<SheBei> sheBeis) {
		//储存设备信息的数组
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
						//状态为true时是"闲置中"
						objects[i][j] = "闲置中";
					} else {
						objects[i][j] = "已关闭";
					}
				}
				if (j == 7) {
					if (sheBei.isZuyongzhuangtai()) {
						//状态为true时是"租用设备"
						objects[i][j] = "租用设备";
					} else {
						objects[i][j] = "自有设备";
					}
				}
				if (j == 8) {
					objects[i][j] = sheBei.getSuoshuGC();
				}
			}
			++i;
		}
		
		//设置表头和列宽
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
		//将表格加入滚动框
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * 系统管理员.云工厂信息窗口 -> YunGongChangXinXiJFrame
	 */
	public static void yunGongChangXinXi() {
		YunGongChangXinXiJFrame window = new YunGongChangXinXiJFrame();
		xianShiYGC(window, ygCguanliyuans);
		
		//搜索按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//按姓名搜索
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入工厂名称");
				//创建新的ArrayList存放姓名一致的云工厂信息
				ArrayList<YunGongChangGuanLiYuan> y = new ArrayList<>();
				for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
					if (ygCguanliyuan.getMingcheng().equals(showInputDialog)) {
						y.add(ygCguanliyuan);
					}
				}
				//显示新的ArrayList中的数据
				xianShiYGC(window, y);
			}
		});
		
		//开启按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取所选择的行号
				int selectedRow = window.table.getSelectedRow();
				//未选择时
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请先选择工厂！");
				} else {
					//已经开启时
					if (ygCguanliyuans.get(selectedRow).isZhuangtai()) {
						JOptionPane.showMessageDialog(window.frame, "该工厂已经开启！");
					} else {
						ygCguanliyuans.get(selectedRow).setZhuangtai(true);
						JOptionPane.showMessageDialog(window.frame, "工厂开启成功！");
						xianShiYGC(window, ygCguanliyuans);
					}
				}
			}
		});
		
		//关停按钮
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取所选择的行号
				int selectedRow = window.table.getSelectedRow();
				//未选择时
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请先选择工厂！");
				} else {
					//已经关闭时
					if (!ygCguanliyuans.get(selectedRow).isZhuangtai()) {
						JOptionPane.showMessageDialog(window.frame, "该工厂已经关闭！");
					} else {
						ygCguanliyuans.get(selectedRow).setZhuangtai(false);
						JOptionPane.showMessageDialog(window.frame, "工厂关闭成功！");
						xianShiYGC(window, ygCguanliyuans);
					}
				}
			}
		});
		
		//初始化完成后显示系统管理员的工厂信息页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示云工厂信息
	 * 为yunGongChangXinXi()方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiYGC(YunGongChangXinXiJFrame window, ArrayList<YunGongChangGuanLiYuan> ygCguanliyuans) {
		//储存所有云工厂的数组
		Object[][] objects = new Object[ygCguanliyuans.size()][7];
		int i = 0;//初始化数组的行角标
		//将云工厂存入数组
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
						objects[i][j] = "开启";
					} else {
						objects[i][j] = "关闭";
					}

				}
			}
			++i;
		}
		
		//设置表头和列宽
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
	 * 系统管理员.用户管理窗口 -> YongHuXinXiGuanLiJFrame
	 */
	public static void yongHuXinXi() {
		YongHuXinXiGuanLiJFrame window = new YongHuXinXiGuanLiJFrame();
		//将用户存入JTable并显示
		xianShiYongHu(window, ygCguanliyuans, users, xiTongGuanLiYuans);
		
		//新建按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入新建角色(云工厂、用户)");
				//创建云工厂管理员时
				if (showInputDialog.equals("云工厂")) {
					String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "账号");
					String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "密码");
					String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "姓名");
					String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "联系方式");
					String showInputDialog6 = JOptionPane.showInputDialog(window.frame, "名称");
					String showInputDialog7 = JOptionPane.showInputDialog(window.frame, "简介");
					//为空则不能注册
					if (showInputDialog2.isEmpty() || showInputDialog3.isEmpty() || showInputDialog4.isEmpty()
							|| showInputDialog5.isEmpty() || showInputDialog6.isEmpty() || showInputDialog7.isEmpty()) {
						JOptionPane.showMessageDialog(window.frame, "注册信息不能为空");
					} else {
						ygCguanliyuans.add(new YunGongChangGuanLiYuan(showInputDialog2, showInputDialog3,
								showInputDialog4, showInputDialog5, showInputDialog6, showInputDialog7, false));
					}
				}
				//创建用户时
				if (showInputDialog.equals("用户")) {
					String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "账号");
					String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "密码");
					String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "姓名");
					String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "联系方式");
					//为空则不能注册
					if (showInputDialog2.isEmpty() || showInputDialog3.isEmpty() || showInputDialog4.isEmpty()
							|| showInputDialog5.isEmpty()) {
						JOptionPane.showMessageDialog(window.frame, "注册信息不能为空");
					} else {
						users.add(new Users(showInputDialog2, showInputDialog3, showInputDialog4,
								showInputDialog5));
					}
				}
	
				//将所有用户再次放入JTable
				xianShiYongHu(window, ygCguanliyuans, users, xiTongGuanLiYuans);
			}
		});
		
		//检索按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//按照姓名查询
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入姓名");
				//创建新的ArrayList
				ArrayList<YunGongChangGuanLiYuan> y = new ArrayList<>();
				ArrayList<Users> j = new ArrayList<>();
				ArrayList<XiTongGuanLiYuan> x = new ArrayList<>();
				//判断是否如查询姓名相等
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
				//显示新的ArrayList中的数据
				xianShiYongHu(window, y, j, x);
			}
		});
		
		//修改按钮
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取所选择的行号和列号
				int selectedRow = window.table.getSelectedRow();
				int selectedColumn = window.table.getSelectedColumn();
				//未选中时
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "先选择需要修改的内容");
				} else {
					//获取所选行的姓名
					Object valueAt = window.table.getValueAt(selectedRow, 2);
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入修改后的内容");
					//所选为云工厂管理员时（通过姓名搜索）
					for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
						if (ygCguanliyuan.getName().equals(valueAt)) {
							if (selectedColumn == 1) {
								//第二列修改账号
								ygCguanliyuan.setID(showInputDialog);
							} else if (selectedColumn == 2) {
								//第三列修改姓名
								ygCguanliyuan.setName(showInputDialog);
							} else if (selectedColumn == 3) {
								//第四列修改联系方式
								ygCguanliyuan.setPhone(showInputDialog);
							} else {
								//其余不能修改
								JOptionPane.showMessageDialog(window.frame, "不可修改");
							}
						}
					}
					//所选为用户时（通过姓名搜索）
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
									JOptionPane.showMessageDialog(window.frame, "不可修改");
								}
							}
						}
					}
					//所选为系统管理员时（通过姓名搜索）
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
									JOptionPane.showMessageDialog(window.frame, "不可修改");
								}
							}
						}
					}
					//显示更改后的数据
					xianShiYongHu(window, ygCguanliyuans, users, xiTongGuanLiYuans);
				}
			}
		});
		
		//删除按钮
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取所选行号
				int selectedRow = window.table.getSelectedRow();
				//未选择时
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "先选择需要删除的内容");
				} else {
					//获取所选行的姓名
					Object valueAt = window.table.getValueAt(selectedRow, 2);
					//所选为云工厂管理员时（通过姓名搜索）
					for (YunGongChangGuanLiYuan ygCguanliyuan : ygCguanliyuans) {
						if (ygCguanliyuan.getName().equals(valueAt)) {
							ygCguanliyuans.remove(ygCguanliyuan);
						}
					}
					//所选为用户时（通过姓名搜索）
					for (Users users : Controller.users) {
						if (users.getName().equals(valueAt)) {
							Controller.users.remove(users);
						}
					}
					//所选为系统管理员时（通过姓名搜索）
					for (XiTongGuanLiYuan xiTongGuanLiYuan : xiTongGuanLiYuans) {
						if (xiTongGuanLiYuan.getName().equals(valueAt)) {
							xiTongGuanLiYuans.remove(xiTongGuanLiYuan);
						}
					}
					//显示更改后的数据
					xianShiYongHu(window, ygCguanliyuans, users, xiTongGuanLiYuans);
				}
			}
		});
		
		//初始化完成后显示系统管理员的用户管理页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示用户信息
	 * 为yongHuXinXi()方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiYongHu(YongHuXinXiGuanLiJFrame window, ArrayList<YunGongChangGuanLiYuan> ygCguanliyuans,
									 ArrayList<Users> users, ArrayList<XiTongGuanLiYuan> xiTongGuanLiYuans) {
		//储存所有用户的数组
		Object[][] objects = new Object[ygCguanliyuans.size() + users.size() + xiTongGuanLiYuans.size()][5];
		//初始化行数角标
		int i = 0;
		//将云工厂管理员存入数组
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
					objects[i][j] = "云工厂管理员";
				}
			}
			++i;
		}
		//将用户存入数组
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
					objects[i][j] = "用户管理员";
				}
			}
			++i;
		}
		//将系统管理员存入数组
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
					objects[i][j] = "超级管理员";
				}
			}
			++i;
		}

		//设置表头和列宽
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
		//把表格放入滚动条
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * 系统管理员.订单信息管理 || 云工厂管理员.订单信息管理 -> DingDanJFrame
	 */
	public static void dingDanXianShi() {
		DingDanJFrame window = new DingDanJFrame();
		xianShiDingDan1(window, dingDanXinXis);
		
		//生产按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				//未选择
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要生产的订单");
				} else {
					//获取订单编号
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入设备名称");
					String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "输入开始时间(格式：年-月-日)");
					String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "输入结束时间(格式：年-月-日)");
					for (DingDanXinXi dingDanXinXi : dingDanXinXis) {
						//符合条件时（根据订单编号搜索）
						if (dingDanXinXi.getId().equals(valueAt)) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
							String format = dateFormat.format(new Date());
							if (format.equals(showInputDialog3)) {
								dingDanXinXi.setZhuangtai("已完工");
							} else {
								dingDanXinXi.setZhuangtai("正在生产");
							}
						}
					}
					//显示新的ArrayList
					xianShiDingDan1(window, dingDanXinXis);
				}
			}
		});
		
		//初始化完成后显示系统管理员的订单管理页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示订单信息的方法一
	 * 为dingDanXianShi()方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiDingDan1(DingDanJFrame window, ArrayList<DingDanXinXi> dingDanXinXis) {
		//储存订单信息的数组
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
		
		//设置表头和列宽
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
		//将表格加入到滚动框
		window.scrollPane.setViewportView(window.table);
	}

	
	/*
	 * 用户.订单信息管理 -> DingDanXinXiJFrame
	 */
	public static void dingDanXinXi() {
		DingDanXinXiJFrame window = new DingDanXinXiJFrame();
		xianShiDingDan2(window, dingDanXinXis);
		
		//新建按钮
		window.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入订单单编号");
				String showInputDialog2 = JOptionPane.showInputDialog(window.frame, "输入产品名");
				String showInputDialog3 = JOptionPane.showInputDialog(window.frame, "输入订购数量");
				String showInputDialog4 = JOptionPane.showInputDialog(window.frame, "输入交付日期");
				String showInputDialog5 = JOptionPane.showInputDialog(window.frame, "输入收货人");
				String showInputDialog6 = JOptionPane.showInputDialog(window.frame, "输入收货人联系方式");
				String showInputDialog7 = JOptionPane.showInputDialog(window.frame, "输入收货地址");
				dingDanXinXis.add(new DingDanXinXi(showInputDialog, showInputDialog2, showInputDialog3,
						showInputDialog4, showInputDialog5, showInputDialog6, showInputDialog7, "未生产"));
				//显示新的ArrayList
				xianShiDingDan2(window, dingDanXinXis);
			}
		});
		
		//修改按钮
		window.btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedColumn = window.table.getSelectedColumn();
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要修改的内容");
				} else {
					String showInputDialog = JOptionPane.showInputDialog(window.frame, "输入修改后的内容");
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
					//显示新的ArrayList
					xianShiDingDan2(window, dingDanXinXis);
				}
			}
		});
		
		//删除按钮
		window.btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要删除的内容");
				} else {
					dingDanXinXis.remove(selectedRow);
					//显示新的ArrayList
					xianShiDingDan2(window, dingDanXinXis);
				}
			}
		});
		
		//发布订单按钮
		window.btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = window.table.getSelectedRow();
				//未选中
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(window.frame, "请选择要发布的订单");
				} else {
					Object valueAt = window.table.getValueAt(selectedRow, 1);
					for (DingDanXinXi dingDanXinXi : dingDanXinXis) {
						if (dingDanXinXi.getId().equals(valueAt)) {
							dingDanXinXi.setZhuangtai("发布");
							JOptionPane.showMessageDialog(window.frame, "发布成功");
						}
					}
					//显示新的ArrayList
					xianShiDingDan2(window, dingDanXinXis);
				}
			}
		});
		
		//初始化完成后用户的订单管理页面
		window.frame.setVisible(true);
	}

	
	/*
	 * 在表格中显示订单信息的方法二
	 * 为dingDanXinXi()方法提供便利
	 */
	@SuppressWarnings("serial")
	public static void xianShiDingDan2(frame.DingDanXinXiJFrame window, ArrayList<DingDanXinXi> dingDanXinXis) {
		//储存订单信息的数组
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
		
		//设置表头和列宽
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
		//将表格添加到滚动框
		window.scrollPane.setViewportView(window.table);
	}
}
