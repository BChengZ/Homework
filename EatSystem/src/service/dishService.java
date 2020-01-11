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

import unity.Dish;

public class dishService {
	public static Document doc;
	public static Element root;

	static {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read("xml/dish.xml");
			root = doc.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeXml() {
		try {
			XMLWriter writer = new XMLWriter(new FileWriter("xml/dish.xml"));
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Dish> returnAll() {
		List<Dish> list = new ArrayList<Dish>();
		List<Element> eleList = root.elements("dish");
		Dish dish;
		for (Element ele : eleList) {
			String name = ele.elementText("name");
			String price = ele.elementText("price");
			String likeNum = ele.elementText("likeNum");
			dish = new Dish(name, Double.parseDouble(price), Integer.parseInt(likeNum));
			list.add(dish);
		}
		return list;
	}

	public void addLike(int choose) {
		List<Element> eleList = root.elements("dish");
		Element ele;
		ele = eleList.get(choose - 1);
		String tem = ele.element("likeNum").getText();// 取得点赞数
		int likeNum = Integer.parseInt(tem) + 1;
		ele.element("likeNum").setText(likeNum + "");
		writeXml();
	}

}
