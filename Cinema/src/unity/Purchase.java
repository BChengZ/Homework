package unity;

import java.io.Serializable;

public class Purchase implements Serializable {

	private String name;// 购买的电影名称
	private int num;// 购买的电影编号
	private double price;
	private String date;

	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public Purchase(String name, int num, double price, String date) {
		super();
		this.name = name;
		this.num = num;
		this.price = price;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
