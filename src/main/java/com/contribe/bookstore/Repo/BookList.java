/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contribe.bookstore.Repo;

import com.contribe.bookstore.Model.Book;


public interface BookList {
    
        public Book[] list(String searchString);

	public boolean add(Book book, int quantity);

	public int[] buy(Book... books);
        
        public int remove(Book book);
        
        public boolean delete(Book book);
    
}
