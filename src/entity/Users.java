package entity;

/**
 * �û���
 * @author ������
 * @date 2021-01-14
 */
public class Users {
	private String ID;// �˺�
	private String password;// ����
	private String name;// ����
	private String phone;// ��ϵ��ʽ

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
