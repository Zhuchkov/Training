package com.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Runner {

	public static void main(String... strings) {
		List<Item> list = new UnmodifiableArrayList<>();
		list.add(new Item(1));
		list.add(new Item(2));
		list.add(new Item(10));
		list.add(new Item(20));
		list.add(new Item(100));
		list.add(new Item(200));
		Item item =  list.get(0);
		item.setI(100);
		System.out.println(list.get(0));
		System.out.println(new Item(1).equals(list.get(0)));
		List<Item> newList = list.subList(1, 4);
		System.out.println(item = newList.get(1));
		item.setI(100500);
		System.out.println(list.get(2));
	}
}


