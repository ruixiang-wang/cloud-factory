package entity;

/**
 * �ƹ�������Ա��
 * @author ������
 * @date 2021-01-14
 */
public class YunGongChangGuanLiYuan {
	private String ID;//�˺�
	private String password;//����
	private String name;//����
	private String phone;//��ϵ��ʽ
	private String mingcheng;//����
	private String jianjie;//�������
	private boolean zhuangtai;//����״̬��������رգ�

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
