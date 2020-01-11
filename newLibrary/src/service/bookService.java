package service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import unity.Book;
import unity.Giveaway;
import unity.Book;

public class bookService {

	public static Document doc;
	public static Element root;

	static {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read("xml/book.xml");
			root = doc.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeXml() {
		try {
			XMLWriter writer = new XMLWriter(new FileWriter("xml/Book.xml"));
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Book> returnAll() {
		List<Book> list = new ArrayList<Book>();
		List<Element> eleList = root.elements("book");
		Book book;
		for (Element ele : eleList) {
			String id = ele.elementText("id");
			String name = ele.elementText("name");
			String author = ele.elementText("author");
			String date = ele.elementText("date");
			String price = ele.elementText("price");
			String amount = ele.elementText("amount");
			book = new Book(Integer.parseInt(id), name, author, date, Double.parseDouble(price),
					Integer.parseInt(amount));
			list.add(book);
		}
		return list;
	}

	public double bookTotal(int purchaseID, int purchaseAmount) {
		double total = 0;
		List<Book> list = returnAll();
		for (Book book : list) {
			if (book.getId() == purchaseID) {
				total = book.getPrice() * purchaseAmount;
				reduceAmount(purchaseID, purchaseAmount);
				break;
			}
		}
		return total;
	}

	public void reduceAmount(int purchaseID, int purchaseAmount) {
		List<Element> eleList = root.elements("book");
		for (Element ele : eleList) {
			if (ele.element("id").getText().equals(purchaseID + "")) {
				String temAmount = ele.element("amount").getText();
				int amount = Integer.parseInt(temAmount) - purchaseAmount;
				ele.element("amount").setText(amount + "");
				writeXml();
				break;
			}
		}

	}


}
