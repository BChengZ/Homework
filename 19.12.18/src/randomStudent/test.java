package randomStudent;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("������༶�����ѧ�ţ�");
		int LargestNum = input.nextInt();
		List students = new LinkedList<Integer>();
		// ��ֵ
		for (int i = 1; i <= LargestNum; i++) {
			students.add(i);
		}
		Random random = new Random();
		int num;// ÿ�������ȡ��ѧ�����еġ���š�
		for (int i = 0; i < LargestNum; i++) {
			num = random.nextInt(LargestNum - i);
			System.out.println("��" + students.get(num) + "��ѧ���ش����⣡");
			students.remove(num);
			if (i == LargestNum - 1) {
				System.out.println("����ͬѧ���ش�������ˣ�");
				break;
			}
			System.out.print("�Ƿ������(y/n):");
			String choose = input.next();
			if (choose.equals("n")) {
				break;
			}
		}
		System.out.println("���ʽ�����");

	}

}
