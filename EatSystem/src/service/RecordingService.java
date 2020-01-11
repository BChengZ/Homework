package service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import unity.Dish;
import unity.Recording;

public class RecordingService {

	public static Document doc;
	public static Element root;

	static {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read("xml/recordings.xml");
			root = doc.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeXml() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		try {
			XMLWriter writer = new XMLWriter(new FileWriter("xml/recordings.xml"), format);
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Recording> returnAll() {
		List<Recording> list = new ArrayList<Recording>();
		List<Element> eleList = root.elements("recording");
		Recording recording;
		for (Element ele : eleList) {
			String person = ele.elementText("person");
			String dishName = ele.elementText("dishName");
			String amount = ele.elementText("amount");
			String address = ele.elementText("address");
			String status = ele.elementText("status");
			String price = ele.elementText("price");
			String time = ele.elementText("time");
			recording = new Recording(person, dishName, Integer.parseInt(amount), address, Integer.parseInt(status),
					Double.parseDouble(price), Integer.parseInt(time));
			list.add(recording);
		}
		return list;
	}

	// 删除订单
	public boolean delRecording(int choose) {
		boolean isSuccess = false;
		List<Element> eleList = root.elements("recording");
		Element ele;
		ele = eleList.get(choose - 1);
		String status = ele.elementText("status");
		if (status.equals("1")) {
			isSuccess = true;
			eleList.remove(choose - 1);
			writeXml();
		}
		return isSuccess;
	}

	// 签收订单
	public boolean checkRecording(int choose) {
		boolean isSuccess = false;
		List<Element> eleList = root.elements("recording");
		Element ele;
		ele = eleList.get(choose - 1);
		String status = ele.elementText("status");
		if (status.equals("0")) {
			isSuccess = true;
			ele.element("status").setText("1");
			writeXml();
		}
		return isSuccess;
	}

	// 生成新订单并写入xml中
	public boolean orderDish(int choose, int amount, int time, String address, String name) {
		boolean isFee = false;
		dishService ds = new dishService();
		List<Dish> list = ds.returnAll();
		Dish dish = list.get(choose - 1);
		String dishName = dish.getName();
		double dishPrice = dish.getPrice();
		double price = dishPrice * amount;// 总费用
		if (price < 50) {
			price += 10;
			isFee = true;
		}

		Element recordingEle = root.addElement("recording");

		Element personEle = recordingEle.addElement("person");
		personEle.setText(name);

		Element dishNameEle = recordingEle.addElement("dishName");
		dishNameEle.setText(dishName + "");

		Element amountEle = recordingEle.addElement("amount");
		amountEle.setText(amount + "");

		Element priceEle = recordingEle.addElement("price");
		priceEle.setText(price + "");

		Element addressEle = recordingEle.addElement("address");
		addressEle.setText(address);

		Element statusEle = recordingEle.addElement("status");
		statusEle.setText("0");

		Element timeEle = recordingEle.addElement("time");
		timeEle.setText(time + "");

		writeXml();

		return isFee;
	}

	public Recording showOrderResult() {
		Recording recording = null;
		List<Element> eleList = root.elements("recording");
		Element ele = eleList.get(eleList.size() - 1);
		String person = ele.elementText("person");
		String dishName = ele.elementText("dishName");
		String amount = ele.elementText("amount");
		String address = ele.elementText("address");
		String status = ele.elementText("status");
		String price = ele.elementText("price");
		String time = ele.elementText("time");
		recording = new Recording(person, dishName, Integer.parseInt(amount), address, Integer.parseInt(status),
				Double.parseDouble(price), Integer.parseInt(time));
		return recording;
	}

}
