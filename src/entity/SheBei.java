package entity;

/**
 * 设备类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class SheBei {
	private String ID;//编号
	private String mingcheng;//名称
	private String leixing;//类型
	private String guige;//规格
	private String miaoshu;//描述
	private boolean shebeizhuangtai;//设备状态（是否启用）
	private boolean zuyongzhuangtai;//租用状态（是否被租用）
	private String suoshuGC;//所属工厂

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
