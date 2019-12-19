package changeStr;

/*
 * 转变字符串
 */

public class test {

	public static void main(String[] args) {
		String str = "Who Masters My own Youth";
		System.out.println("转变前：" + str);
		str = str.replace(" ", "");
		System.out.println("转变后：" + str);

	}

}
