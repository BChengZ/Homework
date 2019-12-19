package rainbowColor;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;

public class Test {

	String favorColor;

	public void select(Color color) {
		switch (color) {
		case Blue:
			favorColor = "蓝色";
			break;
		case Black:
			favorColor = "黑色";
			break;
		case White:
			favorColor = "白色";
			break;
		case Pink:
			favorColor = "粉色";
			break;
		default:
			break;
		}
	}

	public void show(String favorColor) {
		System.out.println("我最喜欢的颜色是：" + favorColor);

	}

	public static void main(String[] args) {
		Test test = new Test();
		test.select(Color.Blue);
		test.show(test.favorColor);

	}
}
