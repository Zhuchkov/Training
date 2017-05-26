package com.training.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import com.training.Item;
import com.training.UnmodifiableArrayList;

import static org.junit.Assert.*;

public class UnmodifiableArrayListTest {
	
	@Test
	public void getAndModify() {
		List<Item> list = new UnmodifiableArrayList<>();
		Item item = new Item(1);
		list.add(item);
		Item item1 = list.get(0);
		item1.setI(100);
		Item actual=list.get(0);
		Item expected= new Item(1);
		assertEquals(expected, actual);
	}
	@Test
	public void getSubListAndModify() {
		List<Item> list = new UnmodifiableArrayList<>();
		list.add(new Item(1));
		list.add(new Item(1));
		list.add(new Item(1));
		
		List<Item> subList = list.subList(0, 2);
		Item item1 = subList.get(0);
		item1.setI(100);
		
		Item actual=list.get(0);
		Item expected= new Item(1);
		assertEquals(expected, actual);
	}
	@Test
	public void toArrayAndModify() {
		List<Item> list = new UnmodifiableArrayList<>();
		list.add(new Item(1));
		list.add(new Item(1));
		list.add(new Item(1));
		
		Object[] array = list.toArray();
		Item item1 = (Item) array[0];
		item1.setI(100);
		
		Item actual=list.get(0);
		Item expected= new Item(1);
		assertEquals(expected, actual);
	}
	
	
	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveIndex() {
		List<Item> list = new UnmodifiableArrayList<>();
		list.add(new Item(1));
		list.remove(0);
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveObject() {
		List<Item> list = new UnmodifiableArrayList<>();
		Item item = new Item(1);
		list.add(item);
		list.remove(item);
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveAll() {
		List<Item> list = new UnmodifiableArrayList<>();
		list.add(new Item(1));
		list.removeAll(new ArrayList<Item>());
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testClear() {
		List<Item> list = new UnmodifiableArrayList<>();
		list.add(new Item(1));
		list.clear();
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testAddAllIntoPos() {
		List<Item> list = new UnmodifiableArrayList<>();
		list.add(new Item(1));
		list.addAll(0, new ArrayList<Item>());
		
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSetObject() {
		List<Item> list = new UnmodifiableArrayList<>();
		Item item = new Item(1);
		list.add(item);
		list.set(0,item);
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testAddObjectIntoPos() {
		List<Item> list = new UnmodifiableArrayList<>();
		Item item = new Item(1);
		list.add(item);
		list.add(0,item);
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testIteratorRemove() {
		List<Item> list = new UnmodifiableArrayList<>();
		Item item = new Item(1);
		list.add(item);
		Iterator<Item> iter = list.iterator();
		iter.next();
		iter.remove();
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testListIteratorAdd() {
		List<Item> list = new UnmodifiableArrayList<>();
		Item item = new Item(1);
		list.add(item);
		ListIterator<Item> iter = list.listIterator();
		iter.next();
		iter.add(new Item(2));
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testListIteratorSet() {
		List<Item> list = new UnmodifiableArrayList<>();
		Item item = new Item(1);
		list.add(item);
		ListIterator<Item> iter = list.listIterator();
		iter.next();
		iter.set(new Item(2));
		
	}


}
