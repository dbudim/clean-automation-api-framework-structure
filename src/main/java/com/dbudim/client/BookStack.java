package com.dbudim.client;

import com.dbudim.client.wrappers.BooksApi;
import com.dbudim.client.wrappers.ShelvesApi;

public class BookStack {

    public BooksApi books;
    public ShelvesApi shelves;

    public BookStack(BookStackRestClient client) {
        this.books = new BooksApi(client);
        this.shelves = new ShelvesApi(client);
    }
}
