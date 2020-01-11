package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import entity.Book;

public class BookService {

	public List<Book> findBooks() throws IOException, ClassNotFoundException {
		List<Book> books = null;
		FileInputStream fis = new FileInputStream("src/obj.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		books = (List<Book>) ois.readObject();
		ois.close();
		fis.close();
		return books;
	}

	public Book updateBookNum(int id, int num) throws IOException, ClassNotFoundException {
		List<Book> books = this.findBooks();
		for (Book book : books) {
			if (book.getId() == id && book.getNum() >= num) {
				book.setNum(book.getNum() - num);
				FileOutputStream fos = new FileOutputStream("src/obj.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(books);
				oos.close();
				fos.close();
				return book;
			}
		}
		return null;

	}

}
