package entity;

/**
 * 用户类
 * @author 王瑞翔
 * @date 2021-01-14
 */
public class Users {
	private String ID;// 账号
	private String password;// 密码
	private String name;// 姓名
	private String phone;// 联系方式

	public Users() {
	}

	public Users(String iD, String password, String name, String phone) {
		super();
		ID = iD;
		this.password = password;
		this.name = name;
		this.phone = phone;
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

}
