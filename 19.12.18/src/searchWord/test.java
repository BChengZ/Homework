package searchWord;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("������һ���ַ���");
		String str = input.next();
		System.out.print("������Ҫ��ѯ���ַ���");
		String word = input.next();
		ArrayList<Integer> list = new ArrayList();
		for (int i = 0; i < str.length(); i++) {
			String str2 = str.substring(i, i + 1);
			if (str2.contains(word)) {
				list.add(i);
			}
		}
		if (!list.isEmpty()) {
			System.out.print("\"" + word + "\"���ֵ�λ���ǣ�");
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				System.out.print((it.next() + 1) + "\t");
			}
		} else {
			System.out.println("δ�鵽���ַ�");
		}
	}
}
