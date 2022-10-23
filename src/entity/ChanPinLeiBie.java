package entity;

/**
 * 产品类别类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class ChanPinLeiBie {
	private String leibie;// 类别

	public ChanPinLeiBie() {
	}

	public ChanPinLeiBie(String leibie) {
		super();
		this.leibie = leibie;
	}

	public String getLeibie() {
		return leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

}
