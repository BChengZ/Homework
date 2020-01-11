package unity;

public class Recording {

	private String person;
	private String dishName;
	private int amount;
	private String address;
	private int status;
	private double price;
	private int time;// 送餐时间
	
	

	public Recording(String person, String dishName, int amount, String address, int status, double price, int time) {
		super();
		this.person = person;
		this.dishName = dishName;
		this.amount = amount;
		this.address = address;
		this.status = status;
		this.price = price;
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
