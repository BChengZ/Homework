package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import service.ProductService;
import unity.Product;

public class viewTest {
	ProductService ps = new ProductService();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		viewTest vt = new viewTest();
		vt.welcome();
	}

	public void welcome() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("--自助超市贩卖系统--");
		System.out.println("1.浏览商品信息");
		System.out.println("2.选购商品");
		System.out.println("3.查看购买记录");
		System.out.println("4.退出");
		System.out.print("请输入编号：");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			showAll();
			break;
		case 2:
			purchase();
			break;
		case 3:
			showLedge();
			break;
		default:
			System.out.println("已退出");
			System.exit(1);
			break;
		}
		welcome();
	}

	public void showAll() {
		System.out.println("编号\t商品名称\t商品类型\t生产日期\t单价");
		List<Product> list = ps.returnAll();
		for (Product product : list) {
			System.out.println(product.getNum() + "\t" + product.getName() + "\t" + product.getType() + "\t"
					+ product.getDate() + "\t" + product.getPrice());
		}
	}

	public void purchase() throws FileNotFoundException, IOException {
		showAll();
		System.out.print("请输入商品编号：");
		int num = input.nextInt();
		System.out.print("请输入商品数量：");
		int amount = input.nextInt();
		Product product = ps.purchase(num);
		product.setAmount(amount);
		System.out.println("===================");
		System.out.println("已购买" + amount + "件" + product.getName());
		ps.writeLedger(product);
	}

	public void showLedge() throws FileNotFoundException, ClassNotFoundException, IOException {
		List<Product> list = ps.readLedger();
		for (Product product : list) {
			System.out.println("--------小票-------");
			System.out.println("商品名称：" + product.getName());
			System.out.println("商品价格：¥" + product.getPrice());
			System.out.println("总价：¥" + product.getPrice() * product.getAmount());
		}

	}

}
