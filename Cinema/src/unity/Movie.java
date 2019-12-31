package unity;

import java.io.Serializable;

//一、 需要先准备5部上线电影信息，内容包括电影名称、电影内部编号、电影主演、电影导演、电影票价、电影上映日期。
public class Movie {

	private String name;
	private int num;
	private String actor;
	private String director;
	private double price;
	private String date;

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String name, int num, String actor, String director, double price, String date) {
		super();
		this.name = name;
		this.num = num;
		this.actor = actor;
		this.director = director;
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

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
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
