package service;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import unity.Movie;

public class MovieService {
	public static Element root;
	public static Document doc;
	static {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read("src/movies.xml");
			root = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public List<Movie> returnMovies() {
		List<Movie> list = new ArrayList<Movie>();
		List<Element> moviList = root.elements("movie");
		Movie movie;
		for (Element element : moviList) {
			String name = element.attributeValue("name");
			String num = element.attributeValue("num");
			String actor = element.element("actor").getText();
			String director = element.element("director").getText();
			String price = element.element("price").getText();
			String date = element.element("date").getText();
			movie = new Movie(name, Integer.parseInt(num), actor, director, Double.parseDouble(price), date);
			list.add(movie);
		}
		return list;

	}

}
