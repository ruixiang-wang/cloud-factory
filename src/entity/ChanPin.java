package entity;

/**
 * ��Ʒ��
 * @author ������
 * @date 2021-01-14
 */
public class ChanPin {
	private String ID;// ���
	private String mingcheng;// ����
	private String leibie;// ���
	private String guige;// ���
	private String miaoshu;// ����

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
