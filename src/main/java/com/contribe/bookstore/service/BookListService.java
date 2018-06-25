/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contribe.bookstore.service;

import com.contribe.bookstore.Repo.BookListImpl;
import com.contribe.bookstore.Model.Book;
import javax.inject.Inject;
import javax.jws.WebService;

@WebService(serviceName="BookListService", endpointInterface="com.contribe.bookstore.service.BookList", portName="BookListPort")
public class BookListService implements BookList{

    @Inject
    private BookListImpl BL;
    
   
    @Override
    public Book[] list(String searchString) {
        return BL.list(searchString);
    }
    
    public Book[] list() {
        return BL.list();
    }

    /**
     *
     * @param book
     * @param quantity
     * @return
     */
   
    @Override
    public boolean add(Book book, int quantity) {
       return BL.add(book, quantity);
    }

    /**
     *
     * @param books
     * @return
     */
    
    @Override
    public int[] buy(Book... books) {
       int result[] = BL.buy(books);
       return result;
    }

    
    @Override
    public int remove(Book book) {
       return BL.remove(book);
    }

    
    @Override
    public boolean delete(Book book) {
        return BL.delete(book);
    }
    
}
