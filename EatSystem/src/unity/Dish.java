package unity;

public class Dish {

	private String name;
	private double price;
	private int likeNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public Dish(String name, double price, int likeNum) {
		super();
		this.name = name;
		this.price = price;
		this.likeNum = likeNum;
	}

}
