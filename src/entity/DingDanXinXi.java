package entity;

/**
 * ������Ϣ�� 
 * @author ������
 * @date 2021-01-14
 */
public class DingDanXinXi {
	private String id;// ���
	private String mingcheng;// ����
	private String shuliang;// ����
	private String jaofuriqi;// ��������
	private String shouhuoren;// �ջ���
	private String lianxifangshi;// ��ϵ��ʽ
	private String dizhi;// ��ַ
	private String zhuangtai;// ����״̬

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
