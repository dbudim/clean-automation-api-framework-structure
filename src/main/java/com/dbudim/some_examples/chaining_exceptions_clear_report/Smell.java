package com.dbudim.some_examples.chaining_exceptions_clear_report;

import com.dbudim.client.BookStackRestClient;
import com.dbudim.client.models.Book;
import com.dbudim.utils.ExecutionUtils;


public class Smell {

    private BookStackRestClient client;

    public Smell(BookStackRestClient client) {
        this.client = client;
    }

    public Book findBookInShelve(String shelveName, String bookName) {
        return ExecutionUtils.execute(client.shelvesService.getShelves()).body()
                .data.stream()
                .filter(shelve -> shelve.name.equals(shelveName))
                .findFirst()
                .get()
                .books
                .stream()
                .filter(book -> book.name.equals(bookName))
                .findFirst()
                .get();
    }
}
