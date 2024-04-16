package com.dbudim.client.wrappers;

import com.dbudim.client.BookStackRestClient;
import com.dbudim.client.models.Book;

import java.util.List;

import static com.dbudim.utils.ExecutionUtils.execute;

/**
 * Note: This is a placeholder class and does not contain actual implementation.
 */

public class BooksApi {

    private BookStackRestClient client;

    public BooksApi(BookStackRestClient client) {
        this.client = client;
    }

    public Book createBook(String name) {
        return execute(client.booksService.createBook(new Book(name))).body();
    }

    public void removeAllBooks() {
        List<Book> books = execute(client.booksService.getBooks()).body().data;
        for (Book book : books) {
            execute(client.booksService.deleteBook(book.id));
        }
    }

    public void doSome() {
        System.out.printf("....");
    }

}
