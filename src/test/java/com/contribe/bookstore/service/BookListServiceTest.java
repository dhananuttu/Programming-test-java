/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contribe.bookstore.service;

import com.contribe.bookstore.Model.Book;
import com.contribe.bookstore.Repo.BookListImpl;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chandru
 */
public class BookListServiceTest {
    
    public BookListServiceTest() {
    }
    
     @BeforeClass
	public static void setUpBeforeClass() throws Exception { 
	}
	/**
	 * Test the toString function.
	 */
	@Test
	public void toStringtest() {
		BookListImpl instance = BookListImpl.getInstance();
		String result = instance.toString();
		assertEquals("[Average Swede,Mastering åäö,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,21]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[Alfred Nobel,My book title,444,4]\n", result);
	}
	/**
	 * Test that no new instances are created.
	 */
	@Test
	public void instancesTest() {
		BookListImpl bookstore = BookListImpl.getInstance();
		BookListImpl bookstoremain = BookListImpl.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Alfred Nobel");
		testBook.setTitle("My book title");
		testBook.setPrice(new BigDecimal("444"));
		bookstoremain.add(testBook, 1);
		String result = bookstore.toString();
		assertEquals("[Average Swede,Mastering åäö,762.00,15]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,23]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[Alfred Nobel,My book title,444,1]\n", result);
	}
	/**
	 * Test to add book to the storage.
	 */
	@Test
	public void addTest() {
		BookListImpl book = BookListImpl.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Alfred Nobel");
		testBook.setTitle("My book title");
		testBook.setPrice(new BigDecimal("444"));
		book.add(testBook, 1);
		String result = book.toString();
		assertEquals("[Average Swede,Mastering åäö,762.00,15]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,23]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[Alfred Nobel,My book title,444,4]\n", result);
	}
	/**
	 * Test to add two books to the storage.
	 */
	@Test
	public void addTest1() {
		BookListImpl book = BookListImpl.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Alfred Nobel");
		testBook.setTitle("My book title");
		testBook.setPrice(new BigDecimal("444"));
		book.add(testBook, 1);
		book.add(testBook, 1);
		String result = book.toString();
		assertEquals("[Average Swede,Mastering åäö,762.00,15]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,23]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[Alfred Nobel,My book title,444,3]\n", result);
	}
	/**
	 * Test to list all book with the title "Generic Title".
	 */
	@Test
	public void listTest() {
		BookListImpl book = BookListImpl.getInstance();
		Book[] testBook;
		testBook = book.list("Generic Title");
		int i = 0;
		String stringNums = "";
		while (i < testBook.length) {
			stringNums += testBook[i++].toString();
		}
		assertEquals("First Author,Generic Title,185.50Second Author,Generic Title,1748.00", stringNums);
	}
	/**
	 * Test to delete a book in the storage. ( Also remove the definition of it. )
	 */
	@Test
	public void deleteTest() {
		BookListImpl book = BookListImpl.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Rich Bloke");
		testBook.setTitle("Desired");
		testBook.setPrice(new BigDecimal("444"));
		book.delete(testBook);
		String result = book.toString();
		assertEquals("[Average Swede,Mastering åäö,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,21]\n" +
				"[Alfred Nobel,My book title,444,4]\n", result);
	}
	/**
	 * Try to remove a book, although the definition say there 0 books left.
	 * ( out-off-stock )
	 */
	@Test
	public void removeTest() {
		BookListImpl book = BookListImpl.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Rich Bloke");
		testBook.setTitle("Desired");
		testBook.setPrice(new BigDecimal("444"));
		int res = book.remove(testBook);
		String result = book.toString();
		assertEquals("[Average Swede,Mastering åäö,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,21]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[Alfred Nobel,My book title,444,4]\n", result);
		assertEquals(1,res);
	}
	/**
	 * Remove a book, from the storage
	 */
	@Test
	public void removeTest1() {
		BookListImpl book = BookListImpl.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Cunning Bastard");
		testBook.setTitle("Random Sales");
		testBook.setPrice(new BigDecimal("999.00"));
		int res = book.remove(testBook);
		String result = book.toString();
		assertEquals("[Average Swede,Mastering åäö,762.00,14]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,22]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[Alfred Nobel,My book title,444,4]\n", result);
		assertEquals(0,res);
	}
	/**
	 * Test to buy several book from the storage, and control that the amount is is correctly reduced.
	 */
	@Test
	public void buyTest() {
		BookListImpl book = BookListImpl.getInstance();
		Book testBookOne = new Book();
		Book testBookTwo = new Book();
		testBookOne.setAuthor("Average Swede");
		testBookOne.setTitle("Mastering åäö");
		testBookOne.setPrice(new BigDecimal("999.00"));
		testBookTwo.setAuthor("Cunning Bastard");
		testBookTwo.setTitle("Random Sales");
		testBookTwo.setPrice(new BigDecimal("999.00"));
		Book[] listan = new Book[2];
		listan[0] = testBookOne;
		listan[1] = testBookTwo;
		book.buy(listan);
		String result = book.toString();
		assertEquals("[Average Swede,Mastering åäö,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,21]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[Alfred Nobel,My book title,444,4]\n", result);
	}
	/**
	 * Test to buy several book from the storage, and control that return status function correctly.
	 * 0 - Success.
	 * 1 - Out of stock.
	 * 2 - Does not exist.
	 */
	@Test
	public void buyTest1() {
		BookListImpl book = BookListImpl.getInstance();
		Book testBookOne = new Book();
		Book testBookTwo = new Book();
		Book testBookThree = new Book();
		testBookOne.setAuthor("Average Swede");
		testBookOne.setTitle("Mastering åäö");
		testBookOne.setPrice(new BigDecimal("999.00"));
		testBookTwo.setAuthor("Cunning Bastard3");
		testBookTwo.setTitle("Random Sales");
		testBookTwo.setPrice(new BigDecimal("999.00"));
		testBookThree.setAuthor("Rich Bloke");
		testBookThree.setTitle("Desired");
		testBookThree.setPrice(new BigDecimal("564.50"));
		Book[] listan = new Book[3];
		listan[0] = testBookOne;
		listan[1] = testBookTwo;
		listan[2] = testBookThree;
		book.toString();
		//System.out.println("Before " + store.toString());
		int[] result = book.buy(listan);
		//System.out.println("After " + store.toString());
		//Store aa = Store.getInstance();
		//System.out.println("After another " + aa.toString());
		int i = 0;
		String[] stringNums = {"","",""};
		while (i < result.length) {
			stringNums[i] = String.valueOf(result[i++]);
		}
		assertArrayEquals(new String[]{"0","2","1"}, stringNums);
	}
}
