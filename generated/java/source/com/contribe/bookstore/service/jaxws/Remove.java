
package com.contribe.bookstore.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.contribe.bookstore.Model.Book;

@XmlRootElement(name = "remove", namespace = "http://service.bookstore.contribe.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remove", namespace = "http://service.bookstore.contribe.com/")
public class Remove {

    @XmlElement(name = "arg0", namespace = "")
    private Book arg0;

    /**
     * 
     * @return
     *     returns Book
     */
    public Book getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(Book arg0) {
        this.arg0 = arg0;
    }

}
