package service;

import java.util.ArrayList;
import java.util.List;

import entity.Gift;

public class GiftService {

	public List<Gift> gifts = new ArrayList();

	public GiftService() {
		// TODO Auto-generated constructor stub
		gifts.add(new Gift(1, "CD", 27.50));
		gifts.add(new Gift(2, "包装", 2.7));
		gifts.add(new Gift(3, "钢笔", 10.0));
	}

	public List<Gift> getGiftList() {
		return gifts;
	}

	public Gift getGiftById(int id) {
		for (Gift gift : gifts) {
			if (gift.getId() == id) {
				return gift;
			}
		}
		return null;
	}
}
