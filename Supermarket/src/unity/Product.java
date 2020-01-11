package unity;

import java.io.Serializable;

public class Product implements Serializable {

	private int num;
	private String name;
	private String type;
	private String date;
	private double price;
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(int num, String name, String type, String date, double price) {
		super();
		this.num = num;
		this.name = name;
		this.type = type;
		this.date = date;
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

}
