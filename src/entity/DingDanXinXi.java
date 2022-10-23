package entity;

/**
 * 订单信息类 
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class DingDanXinXi {
	private String id;// 编号
	private String mingcheng;// 名称
	private String shuliang;// 数量
	private String jaofuriqi;// 交付日期
	private String shouhuoren;// 收货人
	private String lianxifangshi;// 联系方式
	private String dizhi;// 地址
	private String zhuangtai;// 订单状态

	public DingDanXinXi() {
	}

	public DingDanXinXi(String id, String mingcheng, String shuliang, String jaofuriqi, String shouhuoren,
			String shlianxifangshi, String shdizhi, String zhuangtai) {
		super();
		this.id = id;
		this.mingcheng = mingcheng;
		this.shuliang = shuliang;
		this.jaofuriqi = jaofuriqi;
		this.shouhuoren = shouhuoren;
		this.lianxifangshi = shlianxifangshi;
		this.dizhi = shdizhi;
		this.zhuangtai = zhuangtai;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getShuliang() {
		return shuliang;
	}

	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}

	public String getJaofuriqi() {
		return jaofuriqi;
	}

	public void setJaofuriqi(String jaofuriqi) {
		this.jaofuriqi = jaofuriqi;
	}

	public String getShouhuoren() {
		return shouhuoren;
	}

	public void setShouhuoren(String shouhuoren) {
		this.shouhuoren = shouhuoren;
	}

	public String getShlianxifangshi() {
		return lianxifangshi;
	}

	public void setShlianxifangshi(String shlianxifangshi) {
		this.lianxifangshi = shlianxifangshi;
	}

	public String getShdizhi() {
		return dizhi;
	}

	public void setShdizhi(String shdizhi) {
		this.dizhi = shdizhi;
	}

	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
}
