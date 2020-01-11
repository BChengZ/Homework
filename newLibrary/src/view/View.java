package view;

import java.util.List;
import java.util.Scanner;

import service.GiveawayService;
import service.bookService;
import unity.Book;
import unity.Giveaway;

public class View {

	public static void main(String[] args) {
		View v = new View();
		v.welcome();

	}

	Scanner input = new Scanner(System.in);
	bookService bs = new bookService();
	GiveawayService gs = new GiveawayService();

	public void welcome() {
		System.out.println("欢迎光临图书馆");
		System.out.print("请选择进行操作(1.查看图书  2.结账  3.退出):");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			showAllBook();
			break;
		case 2:
			checkTotal();
			break;
		default:
			System.out.println("已退出");
			System.exit(1);
		}
		welcome();

	}

	public void showAllBook() {
		System.out.println("书号\t书名\t作者\t发布日期\t价格\t库存");
		List<Book> list = bs.returnAll();
		for (Book book : list) {
			System.out.println(book.getId() + "\t" + book.getName() + "\t" + book.getAuthor() + "\t" + book.getDate()
					+ "\t" + book.getPrice() + "\t" + book.getAmount());
		}
	}

	public double buyBook() {
		double cost = 0;
		showAllBook();
		System.out.println("请输入欲购买的图书信息：");
		System.out.print("请输入图书ID：");
		int purchaseID = input.nextInt();
		System.out.print("请输入图书数量：");
		int purchaseAmount = input.nextInt();
		cost = bs.bookTotal(purchaseID, purchaseAmount);
		System.out.println("小记:" + cost + "元");
		return cost;
	}

	public double buyGiveaway() {
		double cost = 0;
		List<Giveaway> list = gs.returnAll();
		System.out.println("购买赠品>>");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + "、" + list.get(i).getName() + "\t" + list.get(i).getPrice() + "元");
		}
		System.out.println("4、不需要");
		System.out.print("请选择：");
		int choose = input.nextInt();
		if (choose < 4) {
			Giveaway giveaway = gs.returnGiveaway(choose);
			System.out.println("副赠品：");
			System.out.println(giveaway.getName() + "\t" + giveaway.getPrice() + "元");
			cost = giveaway.getPrice();
			return cost;
		}
		return cost;

	}

	public void checkTotal() {
		double cost1 = buyBook();
		double cost2 = buyGiveaway();
		double total = cost1 + cost2;
		System.out.println("总价格为：" + total + "元");
	}

}
