package com.dbudim.some_examples.chaining_exceptions_clear_report;

import com.dbudim.client.BookStackRestClient;
import com.dbudim.client.models.Book;
import com.dbudim.client.models.Shelve;
import com.dbudim.exceptions.BookNotFoundException;
import com.dbudim.exceptions.ShelveNotFoundException;
import com.dbudim.utils.ExecutionUtils;


public class Well {

    private BookStackRestClient client;

    public Well(BookStackRestClient client) {
        this.client = client;
    }

    public Book findBookInShelve(String shelveName, String bookName) {
        Shelve shelve = ExecutionUtils.execute(client.shelvesService.getShelves()).body()
                .data
                .stream()
                .filter(s -> s.name.equals(shelveName))
                .findFirst()
                .orElseThrow(() -> new ShelveNotFoundException(shelveName));

        Book book = ExecutionUtils.execute(client.booksService.getBooks()).body()
                .data
                .stream()
                .filter(b -> b.name.equals(bookName))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(bookName));

        return book;
    }
}
