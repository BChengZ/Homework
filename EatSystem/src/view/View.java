package view;

import java.util.List;
import java.util.Scanner;

import service.RecordingService;
import service.dishService;
import unity.Dish;
import unity.Recording;

public class View {

	public static void main(String[] args) {
		View v = new View();
		v.welcome();
	}

	Scanner input = new Scanner(System.in);
	dishService ds = new dishService();
	RecordingService rs = new RecordingService();

	public void welcome() {
		System.out.println("欢迎使用吃货联盟订餐系统");
		System.out.println("************************");
		System.out.println("1.我要订餐");
		System.out.println("2.查看餐袋");
		System.out.println("3.签收订单");
		System.out.println("4.删除订单");
		System.out.println("5.我要点赞");
		System.out.println("6.退出系统");
		System.out.println("************************");
		System.out.print("请选择：");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			order();
			break;
		case 2:
			showAllRecording();
			break;
		case 3:
			checkRecording();
			break;
		case 4:
			delRecording();
			break;
		case 5:
			addLikeNum();
			break;
		case 6:
			System.out.println("已退出！");
			System.exit(1);
		}
		System.out.print("输入0返回：");
		if (input.nextInt() == 0) {
			welcome();
		}
	}

	public void showAllDish() {
		List<Dish> list = ds.returnAll();
		System.out.println("序号\t菜名\t单价\t	点赞数");
		Dish dish;
		for (int i = 0; i < list.size(); i++) {
			dish = list.get(i);
			System.out.println((i + 1) + "\t" + dish.getName() + "\t" + dish.getPrice() + "\t" + dish.getLikeNum());
		}
	}

	public void showAllRecording() {
		List<Recording> list = rs.returnAll();
		System.out.println("序号\t订餐人\t餐品信息\t送餐时间\t送餐地址    \t总金额\t订单状态");
		Recording recording;
		for (int i = 0; i < list.size(); i++) {
			recording = list.get(i);
			String status = null;
			if (recording.getStatus() == 1) {
				status = "已完成";
			} else if (recording.getStatus() == 0) {
				status = "未完成";
			}
			System.out.println(
					(i + 1) + "\t" + recording.getPerson() + "\t" + recording.getDishName() + "\t" + recording.getTime()
							+ "点\t" + recording.getAddress() + "\t" + recording.getPrice() + "元\t" + status);
		}
	}

	public void addLikeNum() {
		System.out.println("****我要点赞****");
		showAllDish();
		System.out.print("请选择您要点赞的菜品序号：");
		int choose = input.nextInt();
		ds.addLike(choose);
		showAllDish();
	}

	public void delRecording() {
		System.out.println("****删除订单****");
		showAllRecording();
		System.out.print("请输入要删除的订单号：");
		int choose = input.nextInt();
		boolean isSuccess = rs.delRecording(choose);
		if (isSuccess) {
			System.out.println("删除成功！");
		} else {
			System.out.println("您选择的订单未签收，不能删除！");
		}
	}

	public void checkRecording() {
		System.out.println("****签收订单****");
		showAllRecording();
		System.out.print("请输入要签收的订单号：");
		int choose = input.nextInt();
		boolean isSuccess = rs.checkRecording(choose);
		if (isSuccess) {
			System.out.println("签收成功！");
		} else {
			System.out.println("无法执行操作！");
		}
	}

	public void order() {
		System.out.println("****我要订餐****");
		System.out.print("请输入订餐人姓名：");
		String name = input.next();
		showAllDish();
		System.out.print("请选择您要点的菜品编号：");
		int choose = input.nextInt();
		System.out.print("请选择您需要的份数:");
		int amount = input.nextInt();
		System.out.print("请输入送餐时间(10-20点间的整点)：");
		int time = input.nextInt();
		System.out.print("请输入送餐地址：");
		String address = input.next();
		boolean isFee = rs.orderDish(choose, amount, time, address, name);
		int fee = 0;// 邮费
		System.out.println("订餐成功！");
		if (isFee) {
			fee = 10;
		}
		Recording recording = rs.showOrderResult();
		System.out.println("您订的是" + recording.getDishName() + "\t" + recording.getAmount() + "份");
		System.out.println("送餐时间：" + recording.getTime() + "点");
		System.out.println("餐费：" + recording.getPrice() + "元，包含送餐费" + fee + "元");

	}

}
