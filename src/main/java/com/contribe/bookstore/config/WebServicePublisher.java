/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contribe.bookstore.config;

import com.contribe.bookstore.service.BookListService;
import javax.xml.ws.Endpoint;


public class WebServicePublisher {
     public static final String URI = "http://localhost:8080/BookStore/BookListService";

    public static void main(String[] args) {
    
        //Create instance of service implementation
        BookListService impl = new BookListService();

        //Make available
        Endpoint endpoint = Endpoint.publish(URI, impl);

        //Test that it is available
        boolean status = endpoint.isPublished();
        System.out.println("Web service status = " + status);
        Endpoint.publish("http://localhost:8080/BookStore/BookListService", new BookListService());
    }
    
}
