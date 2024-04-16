package com.dbudim.some_examples.exception_handling.return_null;

import com.dbudim.client.BookStackRestClient;
import com.dbudim.client.models.Book;
import com.dbudim.exceptions.BookNotFoundException;
import com.dbudim.utils.ExecutionUtils;

import java.util.Optional;

public class Well {

    private BookStackRestClient client;

    public Well(BookStackRestClient client) {
        this.client = client;
    }

    public Optional<Book> findBookOtional(String name) {
        return ExecutionUtils.execute(client.booksService.getBooks()).body().data
                .stream()
                .filter(book -> book.name.equals(name))
                .findFirst();
    }

    public Book findBookWithThrowException(String name) {
        return ExecutionUtils.execute(client.booksService.getBooks()).body().data
                .stream()
                .filter(book -> book.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(name));
    }
}
