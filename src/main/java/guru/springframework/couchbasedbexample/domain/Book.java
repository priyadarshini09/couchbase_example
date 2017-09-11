/*
package guru.springframework.couchbasedbexample.domain;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Book {
    @Id
    private String bookId;
    @Field
    private String name;
    @Field
    private long isbnNumber;

    public Book() {
    }

    public Book(String bookId, String name, long isbnNumber) {
        this.bookId = bookId;
        this.name = name;
        this.isbnNumber = isbnNumber;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(long isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", isbnNumber=" + isbnNumber +
                '}';
    }
}
*/
