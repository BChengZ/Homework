package service;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import unity.Giveaway;

public class GiveawayService {

	public static Document doc;
	public static Element root;

	static {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read("xml/Giveaway.xml");
			root = doc.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Giveaway> returnAll() {
		List<Giveaway> list = new ArrayList<Giveaway>();
		List<Element> eleList = root.elements("giveaway");
		Giveaway giveaway;
		for (Element ele : eleList) {
			String name = ele.elementText("name");
			String price = ele.elementText("price");
			giveaway = new Giveaway(name, Double.parseDouble(price));
			list.add(giveaway);
		}
		return list;
	}

	public Giveaway returnGiveaway(int choose) {
		Giveaway giveaway = null;
		List<Giveaway> list = returnAll();
		giveaway = list.get(choose - 1);
		return giveaway;

	}

}
