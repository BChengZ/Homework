package view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import service.MovieService;
import service.PurchaseService;
import unity.Movie;

public class MoviesView {
	Scanner input = new Scanner(System.in);
	MovieService ms = new MovieService();
	PurchaseService ps = new PurchaseService();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		MoviesView mv = new MoviesView();
		mv.welcome();
	}

	public void welcome() throws FileNotFoundException, IOException {
		System.out.println("\n--院线在线选票系统--");
		System.out.println("1.浏览电影信息");
		System.out.println("2.在线选票");
		System.out.println("3.查看购买记录");
		System.out.println("4.退出系统");
		System.out.print("请输入编号：");
		int mainChoose = input.nextInt();
		switch (mainChoose) {
		case 1:
			showAll();
			break;
		case 2:
			purchaseMovie();
			break;
		case 3:
			readLedge();
			break;
		default:
			System.out.println("已退出！");
			System.exit(1);
		}

		welcome();
	}

	public void showAll() {
		List<Movie> list = ms.returnMovies();
		System.out.println("编号\t名称\t主演\t导演\t上映日期\t票价");
		for (Movie movie : list) {
			System.out.println(movie.getNum() + "\t" + movie.getName() + "\t" + movie.getActor() + "\t"
					+ movie.getDirector() + "\t" + movie.getDate() + "\t" + movie.getPrice());
		}
	}

	public void purchaseMovie() throws FileNotFoundException, IOException {
		showAll();
		System.out.print("请输入电影编号:");
		int choose = input.nextInt();
		Movie movie = ps.returnMovie(choose);
		ps.WriteLedege(choose);
		System.out.println("完成购买电影《" + movie.getName() + "》兑换券,可在上映日期的任意时段至我院观赏此片");
	}

	public void readLedge() throws IOException {
		FileReader fr = new FileReader("src/ledge.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
		fr.close();
	}

}
