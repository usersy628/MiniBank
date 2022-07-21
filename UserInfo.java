package ex220318;

public class UserInfo {
	private String name;
	private String id;
	private String pw;
	private String eMail;
	private long total; // 개인잔고
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", id=" + id + ", pw=" + pw + ", eMail=" + eMail + ", total=" + total
				+ ", address=" + address + "]";
	}

}
