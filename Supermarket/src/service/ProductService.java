package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import unity.Product;

public class ProductService {
	public static Document doc;
	public static Element root;
	static {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read("src/products.xml");
			root = doc.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	ArrayList<Product> list = new ArrayList<Product>();

	public List<Product> returnAll() {
		List<Product> list = new ArrayList<Product>();
		List<Element> elmList = root.elements("product");
		Product product;
		for (Element element : elmList) {
			String num = element.attributeValue("id");
			String name = element.element("name").getText();
			String type = element.element("type").getText();
			String date = element.element("date").getText();
			String price = element.element("price").getText();
			product = new Product(Integer.parseInt(num), name, type, date, Double.parseDouble(price));
			list.add(product);
		}
		return list;
	}

	public Product purchase(int num) {
		List<Product> list = this.returnAll();
		for (Product product : list) {
			if (product.getNum() == num) {
				return product;
			}
		}
		return null;
	}

	public void writeLedger(Product product) throws FileNotFoundException, IOException {
		ObjectOutputStream oos;
		oos = new ObjectOutputStream(new FileOutputStream("src/ledger.txt"));
		list.add(product);
		oos.writeObject(list);
	}

	public List<Product> readLedger() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois;
		ois = new ObjectInputStream(new FileInputStream("src/ledger.txt"));
		ArrayList<Product> list = (ArrayList<Product>) ois.readObject();
		return list;
	}

}
