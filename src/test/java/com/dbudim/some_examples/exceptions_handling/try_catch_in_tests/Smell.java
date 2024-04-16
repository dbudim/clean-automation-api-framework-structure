package com.dbudim.some_examples.exceptions_handling.try_catch_in_tests;

import com.dbudim.client.models.Book;
import com.dbudim.fixtures.FixtureSmoke;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Smell extends FixtureSmoke {

    @Test
    public void findActiveDragonsThrow() throws IOException {
        List<Book> books;
        books = client.booksService.getBooks().execute().body().data;

        List<Book> undefinedBooks = books.stream()
                .filter(book -> book.description.isEmpty())
                .collect(Collectors.toList());
        //....some assertions
    }

    @Test
    public void findActiveDragonsLog() {
        List<Book> books = null;
        try {
            if (true) {
                throw new IOException("I'm bad exception");
            }
            books = client.booksService.getBooks().execute().body().data;

        } catch (IOException e) {
            System.out.println("something went wrong...");
        }

        List<Book> undefinedBooks = books.stream()
                .filter(book -> book.description.isEmpty())
                .collect(Collectors.toList());

        //....some assertions
    }
}
