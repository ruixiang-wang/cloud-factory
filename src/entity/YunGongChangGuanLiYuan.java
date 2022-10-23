package entity;

/**
 * 云工厂管理员类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class YunGongChangGuanLiYuan {
	private String ID;//账号
	private String password;//密码
	private String name;//姓名
	private String phone;//联系方式
	private String mingcheng;//名称
	private String jianjie;//工厂简介
	private boolean zhuangtai;//工厂状态（开启或关闭）

	public YunGongChangGuanLiYuan() {
	}

	public YunGongChangGuanLiYuan(String iD, String password, String name, String phone, String mingcheng,
			String jianjie, boolean zhuangtai) {
		super();
		ID = iD;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.mingcheng = mingcheng;
		this.jianjie = jianjie;
		this.zhuangtai = zhuangtai;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public boolean isZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(boolean zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

}
