package unity;

public class Book {

	private int id;
	private String name;
	private String author;
	private String date;
	private double price;
	private int amount;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Book(int id, String name, String author, String date, double price, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.date = date;
		this.price = price;
		this.amount = amount;
	}

}
