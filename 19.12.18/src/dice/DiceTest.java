package dice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DiceTest {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		int dice;
		System.out.print("请输入掷骰子次数：");
		int times = input.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			list.add(0);
		}
		for (int i = 0; i < times; i++) {
			dice = random.nextInt(6);// 产生0-5的骰子点数
			System.out.println(dice + 1);// 打印出真正的骰子点数
			int tem = list.get(dice);// 取出原来的骰子点数
			list.set(dice, tem + 1);// 次数+1
		}
		Iterator<Integer> it = list.iterator();
		int i = 1;
		while (it.hasNext()) {
			if (i == 6) {
				System.out.print(i + "是" + it.next() + "次");
				break;
			}
			System.out.print(i + "是" + it.next() + "次,");
			i++;
		}
	}
}
