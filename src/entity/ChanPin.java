package entity;

/**
 * 产品类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class ChanPin {
	private String ID;// 编号
	private String mingcheng;// 名称
	private String leibie;// 类别
	private String guige;// 规格
	private String miaoshu;// 描述

	public ChanPin() {
	}

	public ChanPin(String iD, String mingcheng, String leibie, String guige, String miaoshu) {
		super();
		ID = iD;
		this.mingcheng = mingcheng;
		this.leibie = leibie;
		this.guige = guige;
		this.miaoshu = miaoshu;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getLeibie() {
		return leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getMiaoshu() {
		return miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
}
