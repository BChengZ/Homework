package rainbowColor;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;

public class Test {

	String favorColor;

	public void select(Color color) {
		switch (color) {
		case Blue:
			favorColor = "��ɫ";
			break;
		case Black:
			favorColor = "��ɫ";
			break;
		case White:
			favorColor = "��ɫ";
			break;
		case Pink:
			favorColor = "��ɫ";
			break;
		default:
			break;
		}
	}

	public void show(String favorColor) {
		System.out.println("����ϲ������ɫ�ǣ�" + favorColor);

	}

	public static void main(String[] args) {
		Test test = new Test();
		test.select(Color.Blue);
		test.show(test.favorColor);

	}
}
