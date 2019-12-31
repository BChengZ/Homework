package service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import unity.Movie;

public class PurchaseService {

	public Movie returnMovie(int choose) {
		MovieService ms = new MovieService();
		List<Movie> list = ms.returnMovies();
		for (Movie movie : list) {
			if (movie.getNum() == choose) {
				return movie;
			}
		}
		return null;
	}

	public void WriteLedege(int choose) throws FileNotFoundException, IOException {
		FileWriter fw = new FileWriter("src/ledge.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		Movie movie = returnMovie(choose);
		StringBuffer sb = new StringBuffer();
		sb.append("------小票-------\n");
		sb.append("电影名称:" + movie.getName() + "\n");
		sb.append("电影时间:" + movie.getDate() + "\n");
		sb.append("电影价格:" + movie.getPrice() + "\n");
		sb.append("祝您观影愉快" + "\n");
		bw.write(sb.toString());
		bw.close();
		fw.close();
	}

}
