package com.contribe.bookstore.Repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.contribe.bookstore.Model.Book;

public class BookListImpl implements BookList,Serializable
{
	final List <Book> storage = new ArrayList<Book>();
	final List <Integer> amountList = new ArrayList<Integer>();
	private static final long serialVersionUID = 1L;
	private BookListImpl() {
		if (SingletonHolder.INSTANCE != null)
		{
			throw new IllegalStateException("Cannot create second instance of this class");
		}
		Scanner sc = null;
		try {
			sc = new Scanner(new File("Bookstoredata.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			String aLong = sc.nextLine();
			Scanner scanner = new Scanner(aLong);
			scanner.useDelimiter(";");
			Book kg = new Book();
			String titleA = scanner.next();
			String authorA = scanner.next();
			String priceA = scanner.next();
			priceA = priceA.replace(",", "");
			int numA = scanner.nextInt();
			kg.setTitle(titleA);
			kg.setAuthor(authorA);
			kg.setPrice(new BigDecimal(priceA));
			int i = storage.indexOf(kg);
			if(i == -1) {
				storage.add(kg);
				amountList.add(numA);
			} else {
				BigDecimal gg = storage.get(i).getPrice();
				amountList.get(i);
				if(gg.compareTo(new BigDecimal(priceA)) == -1) {
					storage.get(i).setPrice(new BigDecimal(priceA));
				} else {
					storage.get(i).setPrice(gg);
				}
				int gfg = amountList.get(i);
				amountList.set(i, numA +  gfg);
			}
			scanner.close();
		}
	}

	private static class SingletonHolder {
		public static final BookListImpl INSTANCE = new BookListImpl();
	}

	public static BookListImpl getInstance() {
		return SingletonHolder.INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}

	private synchronized void add(Book book) {
		int num;
		int i = storage.indexOf(book);
		if(i == -1) {
			storage.add(book);
			amountList.add(1);
		} else {
			num = amountList.get(i);
			amountList.set(i,++num);
		}
	}

	public synchronized boolean delete(Book book) {
		int i = storage.indexOf(book);
		if(i == -1) {
			return false;
		} else {
			storage.remove(book);
			amountList.remove(i);
			return true;
		}
	}

	public synchronized int remove(Book book) {
		int num;
		int i = storage.indexOf(book);
		if(i == -1) {
			return 2;
		} else {
			if(amountList.get(i) == 0) {
				return 1;
			} else {
				num = amountList.get(i);
				amountList.set(i,--num);
			}
			return 0;
		}
	}

	public synchronized Book[] list(String searchString) {
		List <Book> ret = new ArrayList<Book>(); // length of array unknown
		storage.iterator();
		for(Book thi : storage) {
			if(thi.getAuthor().equals(searchString)) {
				ret.add(thi);
			}
			if(thi.getTitle().equals(searchString)) {
				ret.add(thi);
			}
		}
		Book[]  array = new Book[ret.size()];
		int index = 0;
		for (Book value : ret) {
			array[index] = value;
			index++;
		}	
		return array;
	}

	public synchronized Book[] list() {
		Book[]  array = new Book[storage.size()];
		int index = 0;
		for (Book value : storage) {
			array[index] = value;
			index++;
		}	
		return array;
	}

	public synchronized boolean add(Book book, int amount) {
		for(int i = 0;i< amount;i++) {
			this.add(book);
		}
		return true;
	}

	public synchronized int[] buy(Book... books) {
		List <Integer> res = new ArrayList<Integer>();
		for(Book thi : books) {
			res.add(remove(thi));
		}
		int[] array = new int[res.size()];
		int index = 0;
		for (Object value : res) {
			array[index] = (Integer) value;
			index++;
		}
		return array;
	} 

	public synchronized String toString()  {
		String acc = "";
		for(int i = 0;i< storage.size();i++) {
			acc = acc + "[" + storage.get(i).toString() + "," + amountList.get(i).toString() + "]\n";
		}
		return acc;
	}
}