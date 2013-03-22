/**
 * 
 */
package org.rest.bytes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author gouthami
 * 
 */
@XmlRootElement(name="book")
public class Book {

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + "]";
    }

    private String isbn;
    private String title;

    @XmlElement
    public String getTitle() {
        return title;
    }
    public void setISBN(String id) {
        this.setIsbn(id);

    }

    public void setTitle(String title2) {
        this.title = title2;

    }

    /**
     * @return the isbn
     */
    @XmlElement
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
