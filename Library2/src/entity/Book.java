package entity;

import java.io.Serializable;

public class Book implements Serializable {

	private int id;
	private String name;
	private String auth;
	private String createTime;
	private double price;
	private int num;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Book(int id, String name, String auth, String createTime, double price, int num) {
		super();
		this.id = id;
		this.name = name;
		this.auth = auth;
		this.createTime = createTime;
		this.price = price;
		this.num = num;
	}

}
