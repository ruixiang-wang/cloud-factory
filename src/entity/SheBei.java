package entity;

/**
 * �豸��
 * @author ������
 * @date 2021-01-14
 */
public class SheBei {
	private String ID;//���
	private String mingcheng;//����
	private String leixing;//����
	private String guige;//���
	private String miaoshu;//����
	private boolean shebeizhuangtai;//�豸״̬���Ƿ����ã�
	private boolean zuyongzhuangtai;//����״̬���Ƿ����ã�
	private String suoshuGC;//��������

	public SheBei() {
	}

	public SheBei(String iD, String mingcheng, String leixing, String huige, String miaoshu, boolean shebeizhuangtai,
			boolean zuyongzhuangtai, String suoshuGC) {
		super();
		ID = iD;
		this.mingcheng = mingcheng;
		this.leixing = leixing;
		this.guige = huige;
		this.miaoshu = miaoshu;
		this.shebeizhuangtai = shebeizhuangtai;
		this.zuyongzhuangtai = zuyongzhuangtai;
		this.suoshuGC = suoshuGC;
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

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getHuige() {
		return guige;
	}

	public void setHuige(String huige) {
		this.guige = huige;
	}

	public String getMiaoshu() {
		return miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	public boolean isShebeizhuangtai() {
		return shebeizhuangtai;
	}

	public void setShebeizhuangtai(boolean shebeizhuangtai) {
		this.shebeizhuangtai = shebeizhuangtai;
	}

	public boolean isZuyongzhuangtai() {
		return zuyongzhuangtai;
	}

	public void setZuyongzhuangtai(boolean zuyongzhuangtai) {
		this.zuyongzhuangtai = zuyongzhuangtai;
	}

	public String getSuoshuGC() {
		return suoshuGC;
	}

	public void setSuoshuGC(String suoshuGC) {
		this.suoshuGC = suoshuGC;
	}
}
