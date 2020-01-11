package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import entity.Book;
import entity.Gift;
import service.BookService;
import service.GiftService;

public class Test {
	public static void main(String[] args) {
		System.out.println("******图书管理系统******");
		Test test = new Test();
		try {
			test.show();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private BookService bookService = new BookService();
	private GiftService giftService = new GiftService();
	private Scanner input = new Scanner(System.in);

	private void show() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("编号\t名称\t库存");
		List<Book> list = bookService.findBooks();
		for (Book book : list) {
			System.out.println(book.getId() + "\t" + book.getName() + "\t" + book.getNum());
		}
		System.out.print("请选择操作（1.查看 2.结账 3.退出）");
		int type = input.nextInt();
		switch (type) {
		case 1:
			show();
			break;
		case 2:
			buy();
			break;
		case 3:
			System.out.println("已退出！");
			System.exit(1);
			;
		}
		show();
	}

	public void buy() throws ClassNotFoundException, IOException {
		System.out.print("请输入编号：");
		int id = input.nextInt();
		System.out.print("请输入数量：");
		int num = input.nextInt();
		Book book = bookService.updateBookNum(id, num);
		if (book != null) {
			List<Gift> gifts = giftService.getGiftList();
			for (Gift gift : gifts) {
				System.out.println(gift.getId() + "." + gift.getName() + "  " + gift.getPrice() + "元\t");
			}
			System.out.println("4.不需要");
			int type = input.nextInt();
			Gift gift = giftService.getGiftById(type);
			StringBuffer sbf = new StringBuffer();
			sbf.append(book.getName() + ":" + book.getPrice() + "\n");
			sbf.append("数量：" + num + "\n");
			sbf.append("小记：" + (num * book.getPrice()) + "\n");
			sbf.append("------------\n");
			if (gift != null) {
				sbf.append("附赠品：" + gift.getName() + ":" + gift.getPrice());
				sbf.append("\n------------\n");
				sbf.append("总价格为" + (num * book.getPrice() + gift.getPrice()));
			} else {
				sbf.append("无购买附赠品\n");
				sbf.append("总价格为：" + (num * book.getPrice()) + "\n");
			}
			System.out.println(sbf.toString());
			this.write(sbf.toString());
			System.out.println("购买成功！");
		} else {
			System.out.println("购买失败！");
		}
	}

	public void write(String str) throws IOException {
		FileWriter fw = new FileWriter("src/xiaopiao" + System.currentTimeMillis() + ".txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.close();
		fw.close();
	}

}
