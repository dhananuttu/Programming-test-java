
package com.contribe.bookstore.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.contribe.bookstore.Model.Book;

@XmlRootElement(name = "listResponse", namespace = "http://service.bookstore.contribe.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listResponse", namespace = "http://service.bookstore.contribe.com/")
public class ListResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private Book[] _return;

    /**
     * 
     * @return
     *     returns Book[]
     */
    public Book[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Book[] _return) {
        this._return = _return;
    }

}
