package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entity.Book;

public class Test2 {
	public static void main(String[] args) throws Exception {
		Book book1 = new Book(1, "鬼吹灯", "天下霸唱", "2008-07-01", 12.8, 90);
		Book book2 = new Book(2, "魔戒", "天下霸唱", "2008-07-01", 26.4, 234);
		Book book3 = new Book(3, "哈利波特", "天下霸唱", "2008-07-01", 34.5, 24);
		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		FileOutputStream fos = new FileOutputStream("src/obj.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(books);
		oos.close();
		fos.close();
	}
}
