
package guru.springframework.couchbasedbexample.domain;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Book {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private long isbnNumber;

    public Book() {
    }

    public Book(String id, String name, long isbnNumber) {
        this.id = id;
        this.name = name;
        this.isbnNumber = isbnNumber;
    }

    public String getBookId() {
        return id;
    }

    public void setBookId(String bookId) {
        this.id = id;
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
                "bookId='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isbnNumber=" + isbnNumber +
                '}';
    }
}

