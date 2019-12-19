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
		System.out.print("�����������Ӵ�����");
		int times = input.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			list.add(0);
		}
		for (int i = 0; i < times; i++) {
			dice = random.nextInt(6);// ����0-5�����ӵ���
			System.out.println(dice + 1);// ��ӡ�����������ӵ���
			int tem = list.get(dice);// ȡ��ԭ�������ӵ���
			list.set(dice, tem + 1);// ����+1
		}
		Iterator<Integer> it = list.iterator();
		int i = 1;
		while (it.hasNext()) {
			if (i == 6) {
				System.out.print(i + "��" + it.next() + "��");
				break;
			}
			System.out.print(i + "��" + it.next() + "��,");
			i++;
		}
	}
}
