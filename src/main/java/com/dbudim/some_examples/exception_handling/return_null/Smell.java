package com.dbudim.some_examples.exception_handling.return_null;

import com.dbudim.client.BookStackRestClient;
import com.dbudim.client.models.Book;
import com.dbudim.utils.ExecutionUtils;

import java.util.List;

public class Smell {

    private BookStackRestClient client;

    public Smell(BookStackRestClient client) {
        this.client = client;
    }

    public Book findBook(String name) {
        List<Book> books = ExecutionUtils.execute(client.booksService.getBooks()).body().data;

        for (var book : books) {
            if (book.name.equals(name)) {
                return book;
            }
        }

        return null;
    }

}
