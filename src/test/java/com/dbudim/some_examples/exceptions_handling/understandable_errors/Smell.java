package com.dbudim.some_examples.exceptions_handling.understandable_errors;

import com.dbudim.client.models.Book;
import com.dbudim.exceptions.BookNotFoundException;
import com.dbudim.fixtures.FixtureSmoke;
import org.testng.annotations.Test;

import java.io.IOException;

public class Smell extends FixtureSmoke {

    @Test
    public void findBook() throws IOException {
        Book book = client.booksService.getBooks().execute().body().data
                .stream()
                .filter(b -> b.name.equals("***"))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book:" + "***" + "' not found"));
    }

}
