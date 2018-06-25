/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contribe.bookstore.service;

import com.contribe.bookstore.Model.Book;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name="BookList")
public interface BookList {
    
        @WebMethod
        public Book[] list(String searchString);
        
        @WebMethod
	public boolean add(Book book, int quantity);
        
        @WebMethod
	public int[] buy(Book... books);
        
        @WebMethod 
        public int remove(Book book);
        
        @WebMethod 
        public boolean delete(Book book);
        
       }
