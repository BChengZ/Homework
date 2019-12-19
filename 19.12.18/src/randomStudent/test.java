package randomStudent;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入班级的最大学号：");
		int LargestNum = input.nextInt();
		List students = new LinkedList<Integer>();
		// 赋值
		for (int i = 1; i <= LargestNum; i++) {
			students.add(i);
		}
		Random random = new Random();
		int num;// 每次随机抽取的学生数列的“序号”
		for (int i = 0; i < LargestNum; i++) {
			num = random.nextInt(LargestNum - i);
			System.out.println("请" + students.get(num) + "号学生回答问题！");
			students.remove(num);
			if (i == LargestNum - 1) {
				System.out.println("所有同学都回答过问题了！");
				break;
			}
			System.out.print("是否继续？(y/n):");
			String choose = input.next();
			if (choose.equals("n")) {
				break;
			}
		}
		System.out.println("提问结束！");

	}

}
