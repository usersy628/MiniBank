package ex220318;

public class Account {

	private long money;
	private String type;
	private String date;
	private String id;
	private String name;
	private long tot;

	public long getTot() {
		return tot;
	}

	public void setTot(long tot) {
		this.tot = tot;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return "Account [money=" + money + ", type=" + type + ", date=" + date + ", id=" + id + ", name=" + name
//				+ ", tot=" + tot + "]";
//	}

}
